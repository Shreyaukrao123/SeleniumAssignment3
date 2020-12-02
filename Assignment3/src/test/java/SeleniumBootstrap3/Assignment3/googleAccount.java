package SeleniumBootstrap3.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleAccount {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup");
	}
	@Test
	public void test() {
		driver.findElement(By.id("firstName")).sendKeys("Shreya");

		//Checking First Name text field
		driver.findElement(By.id("lastName")).sendKeys("UK Duplicate");
		
		//Checking Username text field
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("sshreyauukdupli2353");
		System.out.println("Username : "+username.getAttribute("value"));

		//Checking Password text field
		driver.findElement(By.name("Passwd")).sendKeys("Shrey@12334");

		//Checking Confirm password text field
		driver.findElement(By.name("ConfirmPasswd")).sendKeys("Shrey@12334");
	
		//Clicking on Next Button
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
		
		//Checking whether next page is coming
		String Heading =driver.findElement(By.id("headingText")).getText();
		Assert.assertTrue(Heading.equals("Verify your phone number"));
		System.out.println(" Heading is : "+Heading);
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}

}
