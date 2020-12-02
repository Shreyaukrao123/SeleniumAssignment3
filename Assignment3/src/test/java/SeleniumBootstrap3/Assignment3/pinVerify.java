package SeleniumBootstrap3.Assignment3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class pinVerify {
	FirefoxDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\shreya.ukrao\\Downloads\\Selenium Jars and Drivers\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://chennaiiq.com/chennai/pincode-by-name.php");
	}
	@Test
	public void test() {WebElement table=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
	List<WebElement> rows=table.findElements(By.tagName("tr"));
	for(int i=3;i<rows.size();i++){
		List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
		String pinCode1 = cols.get(2).getText(); 
		for(int j=i;j<rows.size();j++) {
			List<WebElement> cols2=rows.get(j).findElements(By.tagName("td"));
			String pinCode2 = cols.get(2).getText();
			Assert.assertFalse(pinCode1==pinCode2);  //accertion logic
		}
		//checking for only 15 states pincodes
		if(i==18) {
			break;  
		}
	}

		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}


