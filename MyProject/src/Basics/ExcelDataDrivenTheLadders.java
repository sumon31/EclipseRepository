package Basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import testingFiles.Constant;

public class ExcelDataDrivenTheLadders {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//opening existing excel file call Data
		  FileInputStream file = new FileInputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\TheLaddersSignUp.xlsx");
			    
			        @SuppressWarnings("resource")
					XSSFWorkbook workbook = new XSSFWorkbook(file);
			        XSSFSheet sheet = workbook.getSheetAt(0);
			        XSSFRow row = null;
			        
			        int numberOfRows = sheet.getPhysicalNumberOfRows();
			        System.out.println("Number of rows " + numberOfRows);
			        System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
					System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
					
					//WebDriver driver = new ChromeDriver();
					WebDriver driver = new FirefoxDriver();
					//WebDriver driver = new InternetExplorerDriver();
					
					driver.get("http://theladders.com");
					//driver.manage().window().maximize();
					
					for(int i = 1; i <= numberOfRows; i++)			//numberOfRows
						
					{
						   
						   Thread.sleep(700);
						   
						   driver.navigate().to("http://theladders.com");	

				    	   String FirstName = sheet.getRow(i).getCell(0).getStringCellValue();
				    	   String LastName = sheet.getRow(i).getCell(1).getStringCellValue();
				    	   String Email = sheet.getRow(i).getCell(2).getStringCellValue();
				    	   Cell cellZipCode = sheet.getRow(i).getCell(3);
				    	   cellZipCode.setCellType ( Cell.CELL_TYPE_STRING );
				    	   String ZipCode = cellZipCode.getStringCellValue();
				    	   String Compensation = sheet.getRow(i).getCell(4).getStringCellValue();
				    	   String JobField = sheet.getRow(i).getCell(5).getStringCellValue();
				    	  // String Confirmation = sheet.getRow(i).getCell(6).getStringCellValue();
				    	   
				    	   Thread.sleep(1500);
				           
				    	   driver.findElement(By.xpath("//*[contains(text(),'Sign Up')]")).click();
				    	   driver.findElement(By.xpath("//*[@id='firstNameField']")).sendKeys(FirstName);
				    	   driver.findElement(By.xpath("//*[@id='lastNameField']")).sendKeys(LastName);
				    	   driver.findElement(By.xpath("//*[@id='emailField']")).sendKeys(Email);
				    	   Thread.sleep(200);
				    	   driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("ABC123##");
				    	   driver.findElement(By.xpath("//*[@id='zipcodeField']")).sendKeys(ZipCode);;
				    	   driver.findElement(By.xpath("//*[@id='compensationRankField']")).click();
				    	   driver.findElement(By.xpath("//*[@id='compensationRankField']/option[contains(text(),'"+ Compensation +"')]")).click();
				    	   driver.findElement(By.xpath("//*[@id='jobFunctionField']")).click();
				    	   driver.findElement(By.xpath("//*[@id='jobFunctionField']/option[contains(text(),'"+ JobField +"')]")).click();
				    	   
				    	   driver.findElement(By.xpath("//*[@id='ptRadioButton0']")).click();
				    	   driver.findElement(By.xpath("//*[@id='signupForm']/div[2]/div/div/div[4]/input")).click();
				    	   
				    	   Thread.sleep(600);
				    	   String confirmationMsg = driver.findElement(By.xpath("//*[@id='body_container']/div[2]/div[3]/div/h1")).getText();
				    	   Thread.sleep(600);
				    	   driver.findElement(By.xpath("//*[@id='body_container']/div[2]/div[1]/div[1]/ul/li[3]/a")).click();
				    	   
				    	   row = sheet.createRow(i);
				    	   row.createCell(6).setCellValue(confirmationMsg);

				    	   sheet.autoSizeColumn(1);
				    	   
				    	   //Thread.sleep(1000);

					}
					
							driver.close();			     
			       
							file.close();
		           //saving the file as different name
			        FileOutputStream outFile =new FileOutputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\TheLaddersSignUp.xlsx");
			        workbook.write(outFile);
			        outFile.close(); 

	}

}


