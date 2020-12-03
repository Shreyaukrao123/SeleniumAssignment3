package SeleniumBootstrap3.Assignment3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class linkBroken {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {

		//Set the key/value property according to the browser you are using.
	      System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe"); 

	    //Open browser instance
	    driver = new FirefoxDriver();

	    driver.manage().window().maximize();
	    driver.get("http://www.zlti.com");
		
		
	}
	@Test
	public void test() throws IOException {
		List<WebElement> links=driver.findElements(By.tagName("link"));
		System.out.println("Number of link present in the web page:"+links.size());
		
		for(int i=0;i<links.size();i++) {
			WebElement ele=links.get(i);
			String url=ele.getAttribute("href");
			URL li=new URL(url);
			HttpURLConnection httpCon=(HttpURLConnection) li.openConnection();
			httpCon.connect();
			int responseCode=httpCon.getResponseCode();
			if(responseCode>=400) {
				System.out.println("Broken link:"+url);
			}
			else {
				System.out.println("Valid link:"+url);
			}
			
		}
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
