package testingFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class Excel_Data_Driven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//opening existing excel file call Data
		FileInputStream file = new FileInputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Data.xlsx");
	    
	        @SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        
	           //getting the count of non empty rows in existing excel sheet 
	           int numberOfRows = sheet.getPhysicalNumberOfRows();
	           System.out.println(numberOfRows);
	     
	       for(int i = 1; i <= numberOfRows - 1; i++ )
	       {
	    	   String cellA = sheet.getRow(i).getCell(0).getStringCellValue();
	    	   System.out.println(cellA);
	    	   
	       }

	        
	       
	       file.close();
           //saving the file as different name
	      // FileOutputStream outFile =new FileOutputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Data_Result.xlsx");
	      //  workbook.write(outFile);
	      //  outFile.close(); 
	}

}
