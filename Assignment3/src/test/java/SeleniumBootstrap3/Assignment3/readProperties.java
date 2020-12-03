package SeleniumBootstrap3.Assignment3;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class readProperties {
	configReader propreader;
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp() throws Exception {
		propreader = new configReader();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 
		driver= new FirefoxDriver();
		driver.get(propreader.getUrl());
		driver.manage().window().maximize();
	}
	@Test
	public void test() {
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}
