package SeleniumBootstrap3.Assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dragAndDrop {
	FirefoxDriver driver;
	 
	 @BeforeMethod
	 public  void setup(){
	   
		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 

	    //Open browser instance
	    driver = new FirefoxDriver();

	       driver.manage().window().maximize();
	    // start the application
	       driver.get("https://jqueryui.com/droppable/");
	  
	 }
	 @Test
	 public void test() throws InterruptedException {
		 driver.switchTo().frame(0);
		 //Element to be dragged
		 WebElement DragElement = driver.findElement(By.id("draggable"));
			WebElement DroppingPlace = driver.findElement(By.id("droppable"));
		 Actions a=new Actions(driver);
		 a.dragAndDrop(DragElement, DroppingPlace).perform();
		 System.out.println("After dropping:"+driver.findElement(By.id("droppable")).getText());
		 
			
		 
	 }
	 @AfterMethod
		public void tearDown()
		{ 
		 driver.quit();
		}

}
