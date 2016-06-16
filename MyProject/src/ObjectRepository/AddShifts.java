	package ObjectRepository;


	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import testingFiles.Constant;

	import org.openqa.selenium.NoSuchElementException;

	import java.awt.Desktop.Action;
	import java.io.IOException;
	import java.util.List;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.service.*;
	import org.openqa.selenium.support.PageFactory;

	public class AddShifts {
		
		WebDriver driver;
		
		public AddShifts(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		   public void TestScenario() throws InterruptedException, IOException 
		  {
					  		   
					  //driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[2]/div[2]")).click(); //click on equipment menu
					// driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[3]/div[2]")).click(); //click on personnel menu
			   		 driver.findElement(By.xpath("//div[text()='Task Settings']")).click(); //click on Task Settings
					 
			   		// Try-catch block ensures element is visible on page 
			   		try {
			   			WebElement element = driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/button[1]"));
			   			while(element.isDisplayed()){
			   		    	String shiftText = driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/button[1]")).getText();
			   	   			System.out.println("Available Shift to be deleted: " + shiftText);
			   	   			driver.findElement(By.xpath("//task-item[div[contains(text(),'"+ shiftText +"')]]/div[2]")).click();
			   	   			Thread.sleep(700);
			   	   			driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click();
			   	   			Thread.sleep(600);
		   		       }
			   		}catch(Exception e){}
					 
			   		Thread.sleep(300);
					 
					 for(int intShiftSelection = 0;intShiftSelection <= Constant.shiftIteration - 1;intShiftSelection++) //number of shifts added
			         {						 
						  
						 driver.findElement(By.xpath("//*[@type='button' and contains(@ng-click,'addShift')]")).click(); //click on add shift
						 Thread.sleep(1000);
						 driver.findElement(By.xpath("//*[contains(text(),'Select a Shift')]")).click(); //click on select shift dropdown

						 String allShifts =  driver.findElement(By.xpath("//*[@id='select2-drop']")).getText();
						 String[] Innertext = allShifts.split("\n");
						 
						 int i = Constant.GetAllDropDownCount(Innertext);
						
						//@SuppressWarnings("unchecked")
						 List<String> listShifts = Constant.GetAllDropDowns(Innertext);
				         Random rn = new Random();
				         int randomShift = rn.nextInt(i);
				         
				         System.out.println("number of shifts available are " + i);
				         System.out.println("selected shift is  " + listShifts.get(randomShift));
				         
				         List <WebElement> a = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
						 Actions actions = new Actions(driver);
						 actions.moveToElement(a.get(0));
						 actions.click();
						 actions.sendKeys(listShifts.get(randomShift)).perform();
			        	 driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[1]")).click(); //click on the selected Shift from drop down
			        	 driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click(); //click on OK
			        	 
			        	 Thread.sleep(1100);
				         
			         }
					 
					 for(int intShiftClick= 0;intShiftClick <= Constant.shiftIteration - 1;intShiftClick++) //number of category and subcategory added per shift
					 {	 
						 driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/button["+ (intShiftClick + 1) +"]")).click(); //click on shift button 
						 Thread.sleep(400);
					     
						 for(int shiftCategories = 0;shiftCategories <= Constant.shiftCategory - 1;shiftCategories++)
						 {
					 		driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/accordion/div/div/div[2]/div/div[1]/div[2]/button")).click(); //click on Add category			
					 		Thread.sleep(300);
					 		int subCat = 1;
					 		for(int shiftSubcategory = 0;shiftSubcategory <= Constant.shiftSubCategory - 1;shiftSubcategory++)
							 {
							   driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/accordion/div/div/div[2]/div/div["+ (shiftCategories + 3) +"]/form/div/div[2]/div/div/div[2]/span/button")).click(); //click on subcategory dropdown 
							   driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/accordion/div/div/div[2]/div/div["+ (shiftCategories + 3) +"]/form/div/div[2]/div/div/div[2]/span/div/form/div[2]/div["+ subCat +"]/div/label/span")).click();
							   driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/accordion/div/div/div[2]/div/div["+ (shiftCategories + 3) +"]/form/div/div[2]/div/div/div[2]/span/button")).click(); //close subcategory dropdown  
							   driver.findElement(By.cssSelector("#tasksSettings div:nth-child(1) > div.task-settings-container.ng-scope > accordion > div > div > div.panel-collapse.collapse.in > div > div:nth-child("+ (shiftCategories + 3) +") > form > div > div.panel-collapse.collapse.in > div > div:nth-child("+ (subCat + 2) +") > div [id^=s2id_autogen] a span.select2-arrow b")).click();
							   String strSection = driver.findElement(By.cssSelector("#tasksSettings div:nth-child(1) > div.task-settings-container.ng-scope > accordion > div > div > div.panel-collapse.collapse.in > div > div:nth-child("+ (shiftCategories + 3) +") > form > div > div.panel-collapse.collapse.in > div > div:nth-child("+ (subCat + 2) +") > div [id^=s2id_autogen] a span.select2-arrow b")).getText();	
							   int secIndex = strSection.indexOf("Section");  
							   int randomTask = 3;
							   
							   Random randomN = new Random();
							   int randomTASK = randomN.nextInt(randomTask);
							   
							   if(secIndex > 1){
								   driver.findElement(By.cssSelector("[id^=select2-results-] li:nth-child("+ (randomTASK + 3) +")")).click();	
							   } else {
								   driver.findElement(By.cssSelector("[id^=select2-results-] li:nth-child("+ (randomTASK + 2) +")")).click();	
							   }
							      
							   Thread.sleep(850);
							   
							   subCat = subCat + 1;
							   
							 
							 } //end of subcategory selection
							   driver.findElement(By.xpath("//*[@id='tasksSettings']/div[4]/div[1]/div[2]/accordion/div/div/div[2]/div/div["+ (shiftCategories + 3) +"]/form/div/div[1]/h4/a/i")).click(); //close subcategories per category 
						 } //end of category selection
						 
						 
						 
						
						 
			         }//end of clicking on add shift button 
						 driver.close();
				 
	  }
		   

}





