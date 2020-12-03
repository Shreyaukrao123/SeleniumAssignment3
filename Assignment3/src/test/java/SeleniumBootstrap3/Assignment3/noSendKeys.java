package SeleniumBootstrap3.Assignment3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class noSendKeys {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {

		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 

	    //Open browser instance
	    driver = new FirefoxDriver();

	    driver.manage().window().maximize();
	    driver.get("https://www.google.com");
	  
		
	}
	@Test
	public void test() {
		driver.get("http://www.google.com");
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("document.getElementsByName('q')[0].value='Cricket'");
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
