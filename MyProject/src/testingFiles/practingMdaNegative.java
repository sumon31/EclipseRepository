package testingFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class practingMdaNegative {
	
	
	//@Test
	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
			FileInputStream file = new FileInputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\setMda_Negative.xlsx");

			//@SuppressWarnings("resource")
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.getSheet("SetMdaNegative");
	        @SuppressWarnings("unused")
			XSSFRow row = null;
	        
	        int numberOfRows = sheet.getPhysicalNumberOfRows();
	        
	        System.out.println("number of rows " + numberOfRows);
	}        

}
