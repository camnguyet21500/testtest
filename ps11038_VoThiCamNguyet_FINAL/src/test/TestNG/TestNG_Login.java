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

public class TestNG_Login {
	public String baseUrl = "http://localhost:8080/ps11038_VoThiCamNguyet_FINAL/";
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
	public void tesCasetLogin1() throws InterruptedException {
		WebElement username = driver.findElement(By.name("txtUsername"));
		WebElement password = driver.findElement(By.name("txtPassword"));
		username.sendKeys("admin");
		password.sendKeys("123");
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Thread.sleep(1000);
		
		String expectedTitle = "Home page";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void testCaseLogin2() throws InterruptedException {
		WebElement username = driver.findElement(By.name("txtUsername"));
		WebElement password = driver.findElement(By.name("txtPassword"));
		username.sendKeys("admin");
		password.sendKeys("");
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Thread.sleep(1000);
		
		String expectedTitle = "Home page";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod(description = "Refresh page again")
	public void refeshPageAfter() {
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
