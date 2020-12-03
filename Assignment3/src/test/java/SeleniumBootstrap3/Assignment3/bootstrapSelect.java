package SeleniumBootstrap3.Assignment3;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class bootstrapSelect {
	FirefoxDriver driver;
	 
	 @BeforeMethod
	 public  void setup(){
	   
		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 

	    //Open browser instance
	    driver = new FirefoxDriver();

	       driver.manage().window().maximize();
	  
	        //implicit wait for 5 seconds
	       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    // start the application
	       driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	  
	 }
	 
	 @Test
	 public void testBootStrap() throws Exception
	 {
	        // First we have to click on menu item then only dropdown items will display
	  
	       driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).click();

	        // elements and findElements will return list of WebElements
	       List<WebElement> list1=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
	       //Deslect Html and css option
	       for (WebElement elem : list1)
	      	  
	        {
	  
	         if(elem.getText().contains("HTML")|| elem.getText().contains("CSS")) {
	        	 elem.click();
	         }
	        
	          
	          
	  
	           }
	       List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
	       
	       // We are using enhanced for loop to get the elements
	        //Select all the elements in the bootstrap
	  
	        for (WebElement ele : list)
	  
	        {
	        	System.out.println(ele.getText());
	  
	         ele.click();
	          
	          
	  
	           }
	    
	        System.out.println("Elements selected:"+driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).getText());
	        }
	  
	        // here you can write rest piece of code
	  
	    
	 
	@AfterMethod
	public void tearDown()
	{ 
	 driver.quit();
	}
	

}
