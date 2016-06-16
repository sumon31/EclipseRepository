package testingFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ObjectRepository.OpsBoardLogin;

public class setMda_Negative {

	//	@SuppressWarnings("unused")
	@Test
	public static void TestScenario() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
			FileInputStream file = new FileInputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\setMda_Negative.xlsx");

			//@SuppressWarnings("resource")
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet("SetMdaNegative");
	        XSSFRow row = null;
	        
	        int numberOfRows = sheet.getPhysicalNumberOfRows();
	        System.out.println("number of executable rows in excel is " + (numberOfRows - 1));
	        
			System.setProperty("webdriver.chrome.driver","C:/Users/skashem/Desktop/selenium-2.48.2/chromedriver.exe");
			//System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
			
			 WebDriver driver = new ChromeDriver();
			 //WebDriver driver = new FirefoxDriver();
	    	 driver.get(Constant.URL + Constant.Location + "/" + Constant.GetDateAndformat(0) + "#/"  );	
	    	 driver.manage().window().setPosition(new Point(1900, 0));
	    	 driver.manage().window().maximize();
	    	 //log in
	    	 OpsBoardLogin ops = new OpsBoardLogin(driver);
	    	 ops.opsBoardId().sendKeys(Constant.UserName);
	    	 ops.Password().sendKeys(Constant.Password);
	    	 ops.Submit().click();
	    	 Thread.sleep(7000);	 
			 
			 //row = sheet.getRow(1);
			 String personSupervisors =  driver.findElement(By.xpath("//*[@id='supervisors']/div[2]/div")).getText();
			 String personSanWorkers =  driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div")).getText();
			 String personAvailability = personSupervisors + personSanWorkers;
			 String[] Innertext = personAvailability.split("\n");
			 List<String> personNames = Constant.GetAllPersonnelNames(Innertext);
			 int found = personNames.get(1).indexOf("'");
	         if(found != -1)
	         {
	        	 String[] arrayPerson = personNames.get(1).split("'");
	        	 driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(normalize-space(text()),'" + arrayPerson[0] + "') and contains(normalize-space(text()),'" + arrayPerson[1] + "')]")).click();			         
	         } else {
	        	 
	        	 try
		    	 {
	        		 driver.findElement(By.xpath("//*[@id='supervisors']/div[2]/div/div/span[contains(normalize-space(text()),'"+ personNames.get(0) +"')]")).click();
		    	 } 
		    	 catch(NoSuchElementException f)
		    	 {
		    		 driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(normalize-space(text()),'"+ personNames.get(0) +"')]")).click();
		    	 }
	        	 
	         }
			 
	         	driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/button[2]")).click(); //click on action drop down
	        	driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/ul/li[2]")).click(); //clicking on Set MDA action
	    	 
	        	
	        	for(int i = 1; i <= numberOfRows - 1; i++)	
				
			{
				 
		        	 Thread.sleep(1500);
		        	//click and enter a MDA Code from drop down
		        	 driver.findElement(By.xpath("//*[@id='s2id_subType']/a/span[2]/b")).click(); //click on MDA type drop down
			     	 String mdaCodesInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
			     	 String[] arrayMDACodeInnertext = mdaCodesInnertext.split("\n");
					 List<String> mdaCodes = Constant.GetAllDropDowns(arrayMDACodeInnertext);
					 List <WebElement> a = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
					 Actions actions = new Actions(driver);
					 actions.moveToElement(a.get(0));
					 actions.click();
					 String mdaType = sheet.getRow(i).getCell(1).getStringCellValue();
					 int intMdaType = Double.valueOf(mdaType).intValue();
					 actions.sendKeys(mdaCodes.get(intMdaType));
		        	 driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[1]")).click(); //select MDA code from drop down
		        	 
		        	 driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/span/button[1]")).click(); //click on start date button
		        	 String startDate = sheet.getRow(i).getCell(2).getStringCellValue();
		        	 //System.out.println(startDate);
		        	 if(startDate.equals("Current Day")){
		        		
	        	    	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
		        	 
		        	 }
		        	 
		         	 if(startDate.equals("")){
			        		
		        	    	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/ul/li[2]/span/button[2]")).click(); //click on clear button for start date
			        	 
		        	 }
                     
		        	  // System.out.println("end hour is " + sheet.getRow(i).getCell(5).getStringCellValue());
		        	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[5]/div/table[1]/tbody/tr[2]/td[1]/input")).clear();
		        	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[5]/div/table[1]/tbody/tr[2]/td[1]/input")).sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
		        	   //Thread.sleep(300);
		        	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[5]/div/table[1]/tbody/tr[2]/td[3]/input")).clear();
		        	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[5]/div/table[1]/tbody/tr[2]/td[3]/input")).sendKeys(sheet.getRow(i).getCell(6).getStringCellValue());
		        	   
		        	   //Thread.sleep(1000);
			           driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click(); //click on Add button
			           
			           Thread.sleep(1000);
			           
			           String strErrMessage = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[7]/div/div")).getText();
			           
			           if(strErrMessage.equals(sheet.getRow(i).getCell(8).getStringCellValue())){
			        	   
			        	   System.out.println("For Scenario " + i + " Error Message matches expected error message: " + strErrMessage);
			        	   
			           }
			           
			
		}	
	        	 driver.close();
	        	
	        	//file.close();
           //saving the file as different name
		    //FileOutputStream outFile =new FileOutputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results.xlsx");

//	        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\Google_Search_Results.xlsx"));
//	        workbook.write(outFile);
//	        outFile.close(); 
	}
	 
}
