package SeleniumBootstrap3.Assignment3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleSearch {
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
	public void test() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("corona");;
		List<WebElement> lis=driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		for(int i=0;i<lis.size();i++) {
			
			String val = lis.get(i).getText();
			if(val.equals("coronavirus india")) {
				lis.get(i).click();
				
			
				break;
			}
		}
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}
