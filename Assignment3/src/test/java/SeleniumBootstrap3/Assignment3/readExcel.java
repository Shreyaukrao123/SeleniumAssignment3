package SeleniumBootstrap3.Assignment3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class readExcel {
	@Test
	public void test() throws IOException {
		String path = "D:\\ExcelFile.xlsx";
		FileInputStream FileStream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(FileStream);    
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		
		for(int i=1;i<=rowcount;i++) {
			String actor = sheet.getRow(i).getCell(0).getStringCellValue();
			String movie =  sheet.getRow(i).getCell(1).getStringCellValue();
			
			Assert.assertNotNull(actor);
			
			System.out.print(actor);
			System.out.print("  ");
			System.out.println(movie);
		
	}

}
}

