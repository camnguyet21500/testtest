package test.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

import java.util.List;

public class TestNG_DeleteProduct {
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
	public void testDeleteProduct() throws InterruptedException {
		boolean check = true;
		String idProduct_Before = driver.findElement(By.id("productCode86")).getText();
		WebElement delete = driver.findElement(By.id("delete86"));
		delete.click();
		Thread.sleep(1000);
		
		List<WebElement> list = driver.findElements(By.className("idProduct"));
		for (WebElement e : list) {
			
			String id = e.getText();

			if(idProduct_Before.equals(id) ) {
				check = false;
			}
		}
		
		assertTrue(check);
	}	
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
