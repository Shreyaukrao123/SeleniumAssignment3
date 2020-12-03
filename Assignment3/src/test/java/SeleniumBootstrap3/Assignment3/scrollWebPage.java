package SeleniumBootstrap3.Assignment3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scrollWebPage {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {
		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 

	    //Open browser instance
	    driver = new FirefoxDriver();

	    driver.manage().window().maximize();
	    driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		
	}
	@Test
	public void test() {
		//scrolling web page
				JavascriptExecutor javascriptexecutor = (JavascriptExecutor) driver; 
				javascriptexecutor.executeScript("window.scrollBy(0,1000)");
		
	}
	@AfterMethod
	public void breakdown() {
		driver.quit();
		
	}
}
