package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import qa.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long Page_Load_Timeout = 20;
	public static long ImplicitlyWait = 10;
	
	public static String TestSheetPath = "C:\\Users\\User\\Documents\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	static Workbook book=null;	
	static Sheet sheet=null;
	static InputStream fis;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetname) throws Exception {

		File file = new File(TestSheetPath);
		fis= new FileInputStream(file);
		//book = new XSSFWorkbook(fis);
		 book= WorkbookFactory.create(fis);
		sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];


		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

				 System.out.println(data[i][k]);

			}

	}

		return data;

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
			
		FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.getenv(currentDir) + ".png"));
			
			}

	
}
	
