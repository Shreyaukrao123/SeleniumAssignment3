package SeleniumBootstrap3.Assignment3;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;


public class screenshot {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {
		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 

	    //Open browser instance
	    driver = new FirefoxDriver();

	       driver.manage().window().maximize();
	    // start the application
	       driver.get("https://api.jquery.com/dblclick/");
	}
	@Test
	public void test() {
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File demo = new File("D:\\Screenshot\\screenshot.jpg");
			Files.copy(screenshot,demo);
		}catch (IOException e) {
			System.out.println("Message : "+e.getMessage());
		}
		}
		
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	
	}
	

}
