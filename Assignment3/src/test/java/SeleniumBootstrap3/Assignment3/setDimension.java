package SeleniumBootstrap3.Assignment3;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class setDimension {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	@Test
	public void test() {
		driver.get("https://www.google.com");
		System.out.println(driver.manage().window().getSize());
		Dimension d = new Dimension(420,600);
		//Resize the current window to the given dimension
		driver.manage().window().setSize(d);
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}

}
