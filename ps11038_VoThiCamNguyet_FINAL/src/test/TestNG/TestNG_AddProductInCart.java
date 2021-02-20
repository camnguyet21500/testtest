package test.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_AddProductInCart {
	public String baseUrl = "http://localhost:8080/ps11038_VoThiCamNguyet_FINAL/showSanPham.jsp";
	String path = System.getProperty("user.dir");
	String driverPath= path + "\\driver\\chromedriver.exe";
	public WebDriver driver;
	
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
	}
	
	@Test
	public void testBuyNow() throws InterruptedException {
		
		String idProduct_Before = driver.findElement(By.id("productCode1")).getText();
		WebElement buyNow = driver.findElement(By.id("buynow1"));
		buyNow.click();
		Thread.sleep(1000);
		
		String idProduct_After = driver.findElement(By.id("productCode1")).getText();
		
		Assert.assertEquals(idProduct_After, idProduct_Before);
	}	
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
