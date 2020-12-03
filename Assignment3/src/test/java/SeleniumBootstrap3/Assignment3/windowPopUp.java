package SeleniumBootstrap3.Assignment3;

import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowPopUp {
	FirefoxDriver driver;
	 
	 @BeforeMethod
	 public  void setup(){
	   
		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 

	    //Open browser instance
	    driver = new FirefoxDriver();

	       driver.manage().window().maximize();
	  
	    // start the application
	       driver.get("http://popuptest.com/goodpopups.html");
	  
	 }
	 @Test
	 public void test() {
		 //opening Good PopUp #2
		 
		 driver.findElementByXPath("/html/body/table[2]/tbody/tr/td/font/b/a[2]").click();
		 // Multiple pages that the current window contains
		 String parent=driver.getWindowHandle();
		 System.out.println("Parent page Title"+driver.switchTo().window(parent).getTitle());
		 
		 Set<String>windowHandles=driver.getWindowHandles();
		 
		 Iterator<String>s=windowHandles.iterator();
		 while(s.hasNext())
		 {

		 String child_window=s.next();


		 if(!parent.equals(child_window))
		 {
		 driver.switchTo().window(child_window);

		 System.out.println("Child page title"+driver.switchTo().window(child_window).getTitle());

		 }
		 driver.switchTo().window(parent);
		 }
	

		 
	 }
	 @AfterMethod
	 public void tearDown()
		{ 
		 driver.quit();
		}
		
	 

}
