package testingFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.*; 

public class ymailRegistration {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, RowsExceededException, WriteException{
		// TODO Auto-generated method stub
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
    	 WebDriver driver = new ChromeDriver();
		 System.out.println("Started Test on Chrome");
		 
		//opening existing excel file call Data
		// File excelPath = new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\gmailRegistration.xlsx");  
		  Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\ymailRegistration.xls"));
		  WritableWorkbook workbookCopy;
		  workbookCopy = Workbook.createWorkbook(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\ymailRegistrationVerficationResult.xls"), workbook);
		  
	      Sheet sheet = workbook.getSheet(0);
	     // row row = null;
	        
	      int numberOfRows = sheet.getRows();
	      System.out.println("Number of rows " + numberOfRows);
		  
	      
	      
	     /*
		 List <String> birthMonth = new ArrayList();
		 birthMonth.add("January");
		 birthMonth.add("February");
		 birthMonth.add("June");
		 birthMonth.add("July");
		 
		 List <String> genderType = new ArrayList();
		 genderType.add("Male");
		 genderType.add("Female");
		 genderType.add("Other");
		 genderType.add("Male");
		 
		 List <String> firstName = new ArrayList();
		 firstName.add("John");
		 firstName.add("Tracey");
		 firstName.add("Don");
		 firstName.add("Morgan");
		 
		 List <String> lastName = new ArrayList();
		 lastName.add("Doe");
		 lastName.add("Bigham");
		 lastName.add("Jay");
		 lastName.add("Freedman");
		 
		 List <String> userEmail = new ArrayList();
		 userEmail.add("jhonDoeNY137");
		 userEmail.add("traceBighamNY137");
		 userEmail.add("donJayNY137");
		 userEmail.add("morganFreedmanNY137");
		 
		 List <String> userPhoneNumber = new ArrayList();
		 userPhoneNumber.add("212-333-4444");
		 userPhoneNumber.add("646-222-2323");
		 userPhoneNumber.add("718-222-3333");
		 userPhoneNumber.add("917-444-5555");
		 
		 List <String> birthDay = new ArrayList();
		 birthDay.add("06");
		 birthDay.add("22");
		 birthDay.add("19");
		 birthDay.add("05");
		 
		 List <String> birthYear = new ArrayList();
		 birthYear.add("1970");
		 birthYear.add("1980");
		 birthYear.add("1990");
		 birthYear.add("2000");
		 
		 */
		 
	      
	     driver.get("https://www.yahoo.com/");	     
	     driver.manage().window().setPosition(new Point(1900, 0));
	     driver.manage().window().maximize();
	     
	     for(int i = 1; i <= numberOfRows - 1; i++){
	    	 
	    	 driver.navigate().to("https://edit.yahoo.com/registration");
	    	 //driver.navigate().to("https://login.yahoo.com/account/create");
	    	 	    	          
	    	 //Thread.sleep(2000);
	    	 
	    	 //driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
	    	 
	    	// Thread.sleep(1200);
	    	// driver.findElement(By.xpath("//*[@id='login-signup']")).click();
             
	    	 Thread.sleep(2000);
	         
	         String firstName = sheet.getCell(0,i).getContents();
	         String lastName = sheet.getCell(1,i).getContents();
	         String userName = sheet.getCell(2,i).getContents();
	         String password = sheet.getCell(3,i).getContents();
	         String userPhoneNumber = sheet.getCell(4,i).getContents();
	         String birthMonth = sheet.getCell(5,i).getContents();
	         String birthDay = sheet.getCell(6,i).getContents();
	         String birthYear = sheet.getCell(7,i).getContents();
	         String genderType = sheet.getCell(8,i).getContents();
	         
	       //*[@id="first-name"]
	         //Thread.sleep(1200);
	         
	         Actions actions = new Actions(driver); 
	         
	         //driver.findElement(By.xpath("//*[contains(text(),'Sign Up')]")).click(); //click on sign up 
             try{
    	         driver.findElement(By.xpath("//*[contains(@title,'First name')]")).sendKeys(firstName);
             } catch(Exception e) {
    	         driver.findElement(By.xpath("//*[@id='usernamereg-firstName']")).sendKeys(firstName); 
             }
           
             try{
            	 driver.findElement(By.xpath("//*[contains(@title,'Last name')]")).sendKeys(lastName);
             } catch(Exception e) {
    	         driver.findElement(By.xpath("//*[@id='usernamereg-lastName']")).sendKeys(lastName); 
             }
              
	         	         
	         try{
	        	 driver.findElement(By.xpath("//*[contains(@placeholder,'Yahoo username')]")).sendKeys(userName);
	         } catch(Exception e) {
	        	 driver.findElement(By.xpath("//*[@id='usernamereg-yid']")).sendKeys(userName);
	         }
	         
             try{
            	 driver.findElement(By.xpath("//*[contains(@title,'Last name')]")).click();
            	 driver.findElement(By.xpath("//*[contains(@title,'Last name')]")).sendKeys(Keys.TAB);
            	 Thread.sleep(600);
	        	 driver.findElement(By.xpath("//*[contains(@placeholder,'Yahoo username')]")).click();
	        	 driver.findElement(By.xpath("//*[contains(@placeholder,'Yahoo username')]")).sendKeys(Keys.TAB);

             } catch(Exception e) {
    	         //driver.findElement(By.xpath("//*[@id='usernamereg-lastName']")).click();
    	         //driver.findElement(By.xpath("//*[@id='usernamereg-lastName']")).sendKeys(Keys.TAB);
             }
	         
             Thread.sleep(400);
	         /*try{
		         driver.findElement(By.xpath("//*[contains(@id,'submitbtn')]")).click(); 
	         } catch(Exception e) {
		         driver.findElement(By.xpath("//*[contains(@id,'reg-submit-button')]")).click(); 
	         }*/
	         
	         //Thread.sleep(1200);
	         //driver.findElement(By.xpath("//*[contains(@id,'password')]")).click();
	         driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys(password);
             
	         try{
	        	 driver.findElement(By.xpath("//*[contains(@placeholder,'Mobile number')]")).click();
	        	 driver.findElement(By.xpath("//*[contains(@placeholder,'Mobile number')]")).sendKeys(userPhoneNumber);
	         } catch(Exception e) {
	        	 driver.findElement(By.xpath("//*[@id='usernamereg-phone']")).click();
	        	 driver.findElement(By.xpath("//*[@id='usernamereg-phone']")).sendKeys(userPhoneNumber);	        	 
	         }
	         
	         /* WebElement phoneNumber = driver.findElement(By.xpath("//*[contains(@placeholder,'Mobile number')]"));
	         actions.moveToElement(phoneNumber);
	         actions.click();
	         actions.sendKeys(userPhoneNumber);
	         actions.perform(); */
	         
	         driver.findElement(By.xpath("//*[contains(@id,'month')]")).click();
	         driver.findElement(By.xpath("//option[contains(text(),'"+ birthMonth +"')]")).click();
       
			 driver.findElement(By.xpath("//*[contains(@id,'day')]")).sendKeys(birthDay);
	         driver.findElement(By.xpath("//*[contains(@id,'year')]")).sendKeys(birthYear);
	         
	         System.out.println(genderType);
	         try{
	        	 List <WebElement> RadButtonList= driver.findElements(By.xpath("//*[contains(@name,'gender')]"));
	        	 
	        	 if(genderType.equals("Male")) {
	        		 //System.out.println("It's Male");
	        		 actions.moveToElement(RadButtonList.get(0));
	        		 actions.click().perform();
	        		// driver.findElement(By.xpath("//*[@id='gender-wrapper']/fieldset/div/label[1]/text()")).click();
	        		 //driver.findElement(By.xpath("//*[@value='m']")).click();
	        		 //RadButtonList.get(0).click();
	        	 } else {
	        		 //System.out.println("It's Female");
	        		 actions.moveToElement(RadButtonList.get(1));
	        		 actions.click().perform();
	        		 //driver.findElement(By.xpath("//input[@value='f']")).click();
	        		 //driver.findElement(By.xpath("//*[@id='gender-wrapper']/fieldset/div/label[2]/text()")).click();
	        		 //RadButtonList.get(1).click(); 
	        	 }
	        	// driver.findElement(By.xpath("//*[contains(text(),'"+ genderType +"')]")).click(); 
	         } catch(Exception e) {
	        	 driver.findElement(By.xpath("//*[@id='usernamereg-gender']")).click();
	        	 driver.findElement(By.xpath("//option[contains(text(),'"+ genderType +"')]")).click();  
	         }
	         
	         try{
		         driver.findElement(By.xpath("//*[contains(@id,'submitbtn')]")).click(); 
	         } catch(Exception e) {
		         driver.findElement(By.xpath("//*[contains(@id,'reg-submit-button')]")).click(); 
	         }
	         	         
	         Thread.sleep(1000);
	       
	         try{
		         String strVerification = driver.findElement(By.xpath("//*[@id='phone-verify-challenge']/form/p")).getText();
		         System.out.println("verfication message is " + strVerification);		        
		         WritableSheet wshTemp = workbookCopy.getSheet(0);
		         wshTemp.addCell(new Label(9, i, strVerification));
	         } catch(Exception e) {
	        	 String strVerification = driver.findElement(By.xpath("//*[@id='captchaV5Instructions']")).getText();
	        	 System.out.println("verfication message is " + strVerification);
	        	 WritableSheet wshTemp = workbookCopy.getSheet(0);
		         wshTemp.addCell(new Label(9, i, strVerification));
	         }

	         
	         //Thread.sleep(650);
	         //driver.navigate().to("https://www.yahoo.com/");
	         
	     }
	     
	     workbookCopy.write();
	     workbookCopy.close();
         
         driver.close();
	}

}
