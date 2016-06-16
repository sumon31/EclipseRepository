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

public class gmailRegistration {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException, RowsExceededException, WriteException{
		// TODO Auto-generated method stub
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
    	 WebDriver driver = new ChromeDriver();
		 System.out.println("Started Test on Chrome");
		 
		//opening existing excel file call Data
		// File excelPath = new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\gmailRegistration.xlsx");  
		  Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\gmailRegistration.xls"));
		  WritableWorkbook workbookCopy;
		  workbookCopy = Workbook.createWorkbook(new File("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\gmailRegistrationVerficationResult.xls"), workbook);
		  
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
		 
	     driver.get("https://accounts.google.com/SignUp");	
	     
	     for(int i = 1; i <= numberOfRows - 1; i++){
	    	 
	    	 driver.navigate().to("https://accounts.google.com/SignUp");
	         driver.manage().window().setPosition(new Point(1900, 0));
	         driver.manage().window().maximize();
	         
	         Thread.sleep(1000);
	         String firstName = sheet.getCell(0,i).getContents();
	         String lastName = sheet.getCell(1,i).getContents();
	         String userName = sheet.getCell(2,i).getContents();
	         String birthMonth = sheet.getCell(3,i).getContents();
	         String birthDay = sheet.getCell(4,i).getContents();
	         String birthYear = sheet.getCell(5,i).getContents();
	         String genderType = sheet.getCell(6,i).getContents();
	         String userPhoneNumber = sheet.getCell(7,i).getContents();
	         
	         //Thread.sleep(1200);
	         
	         Actions actions = new Actions(driver); 

	         driver.findElement(By.xpath("//*[contains(@id,'FirstName')]")).sendKeys(firstName);	         
	         driver.findElement(By.xpath("//*[contains(@id,'LastName')]")).sendKeys(lastName);
	         driver.findElement(By.xpath("//*[contains(@id,'GmailAddress')]")).sendKeys(userName);
	         driver.findElement(By.xpath("//*[contains(@id,'Passwd')]")).sendKeys("qatester11");
	         driver.findElement(By.xpath("//*[contains(@id,'PasswdAgain')]")).sendKeys("qatester11");
	         driver.findElement(By.xpath("//*[@id='BirthMonth']/div[1]/div[2]")).click();
	         	         
	         driver.findElement(By.xpath("//div[contains(@class,'goog-menuitem') and contains(@id,':')]/div[contains(text(),'"+ birthMonth +"')]")).click();
	         //goog-menuitem-content
			 	         
			 driver.findElement(By.xpath("//*[contains(@id,'BirthDay')]")).sendKeys(birthDay);
	         driver.findElement(By.xpath("//*[contains(@id,'BirthYear')]")).sendKeys(birthYear);

	         driver.findElement(By.xpath("//*[contains(@id,'Gender')]/div")).click(); 
	        // Thread.sleep(600);
	         driver.findElement(By.xpath("//div[contains(@class,'goog-menuitem') and contains(@id,':')]/div[contains(text(),'"+ genderType +"')]")).click();
	         
	         /* List <WebElement> genderList = driver.findElements(By.xpath("//div[contains(@class,'goog-menuitem') and contains(@id,':')]"));
	         actions.moveToElement(genderList.get(2));
	         actions.click().perform();	*/
	         
	         Thread.sleep(600);
	         
	         WebElement phoneNumber = driver.findElement(By.xpath("//*[contains(@id,'RecoveryPhoneNumber')]"));
	         actions.moveToElement(phoneNumber);
	         actions.click();
	        // Thread.sleep(600);
	         actions.sendKeys(userPhoneNumber);
	         actions.perform(); 
	         
	         //driver.findElement(By.xpath("//*[contains(@id,'RecoveryPhoneNumber')]")).click();
	         //driver.findElement(By.xpath("//*[contains(@id,'RecoveryPhoneNumber')]")).clear();
	        // driver.findElement(By.xpath("//*[contains(@id,'RecoveryPhoneNumber')]")).sendKeys(userPhoneNumber);
	         
	         driver.findElement(By.xpath("//*[contains(@id,'SkipCaptcha')]")).click();
	         driver.findElement(By.xpath("//*[contains(@id,'TermsOfService')]")).click();
	         driver.findElement(By.xpath("//*[contains(@id,'submitbutton')]")).click();
	         
	         
	         Thread.sleep(1000);
	         
	         String strVerification = driver.findElement(By.xpath("//*[@id='signupidv']")).getText();
	         String[] arrayStrVerification = strVerification.split("ex:");
	         System.out.println("verfication message is " + arrayStrVerification[0]);
	        
	         WritableSheet wshTemp = workbookCopy.getSheet(0);
	         wshTemp.addCell(new Label(8, i, arrayStrVerification[0]));

	         
	         List <WebElement> deliverMethod = driver.findElements(By.xpath("//*[contains(@name,'deliveryMethod')]"));
	         actions.moveToElement(deliverMethod.get(1));
	         actions.click();
	         actions.perform();
	         
	         Thread.sleep(650);
	     }
	     
	     workbookCopy.write();
	     workbookCopy.close();
         
         driver.close();
	}

}
