package test.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestNG_Title {
	public String baseUrl = "http://localhost:8080/ps11038_VoThiCamNguyet_FINAL/";
	String path = System.getProperty("user.dir");
	String driverPath= path + "\\driver\\chromedriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void testTitle() throws InterruptedException {
		String expectedTitle = "Login";
		
		String actualTitle = driver.getTitle();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
	
}
