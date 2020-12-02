package SeleniumBootstrap3.Assignment3;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class extentReport {
	static ExtentTest test;
	static ExtentReports report;
	
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("extentReport");
		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 
		  driver=new FirefoxDriver();
		  driver.get("https://www.google.co.in");
		
		 
	}
	@Test
	public void test() {
		if(driver.getTitle().equals("Google"))
		{
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
		
	}
	@AfterMethod
	public void taerdown() {
		report.endTest(test);
		report.flush();
		driver.quit();
		
	}
}
