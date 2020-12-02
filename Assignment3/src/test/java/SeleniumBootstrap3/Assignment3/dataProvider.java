package SeleniumBootstrap3.Assignment3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	@Test(dataProvider="authors")
	public void test(String author,String book) {
		System.out.println("Author name:"+author);
		System.out.println("Book:"+book);
		
		
	}
	@DataProvider(name="authors")
	public Object[][] getData(){
		Object[][] data=new Object[2][2];
		data[0][0]="J K Rowling";
		data[0][1]="Harry Potter";
		data[1][0]="Amish Tripati";
		data[1][1]="Shiva Trilogy";
		return data;
	}
	

}
