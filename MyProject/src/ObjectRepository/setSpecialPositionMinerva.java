
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
import org.openqa.selenium.support.ui.Select;

	public class setSpecialPositionMinerva {
		
		WebDriver driver;
		
		public setSpecialPositionMinerva(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		   public void TestScenario() throws InterruptedException, IOException 
		  {
					  		   
					 // driver.findElement(By.xpath("//*[@id='mainmenu']/div[1]/div[3]")).click(); //click on equipment menu
					 // driver.findElement(By.xpath("//*[@id='mainmenu']/div[1]/div[5]")).click(); //click on tasks menu
					 
					 Thread.sleep(1000);
					 
					 
					 int k = 1;
					 for(int j = 1;j <= Constant.equipIteration - 1;j++) //number of equipment to be down
			         {						 
						 //String personSanWorkers =  driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div")).getText();
						 String personSanWorkers =  driver.findElement(By.xpath("//*[contains(@class,'SanitationWorkersAvailable')]")).getText();
						 String[] Innertext = personSanWorkers.split("\n");
						 
						 
						 
						 int i = Constant.GetAllPersonCategoryCount(Innertext);
						
						//@SuppressWarnings("unchecked")
						 List<String> personNames = Constant.GetAllPersonnelNames(Innertext);
				         Random rn = new Random();
				         int randomPerson = rn.nextInt(i);
				         
				         System.out.println("number of total san-workers are " + i);
				         System.out.println("person set to SpecialPosition is  " + personNames.get(randomPerson));

				         driver.findElement(By.xpath(" //*[@id='personnel-list']/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div["+ (randomPerson + 1) + "]/personnel-card/div/div[1]/div[2]")).click();
				                                      //*[@id="personnel-list"]/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div[5]/personnel-card/div/div[3]/div[5]
				                                     //*[@id="personnel-list"]/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div[13]/personnel-card/div/div[3]/div[5]
				         Thread.sleep(800);
				         
				         Actions action = new Actions(driver);
				         List <WebElement> arrow = driver.findElements(By.xpath("//*[contains(@class,'fa fa-arrow-down')]"));
				         action.moveToElement(arrow.get(1)).click().perform();
				         Thread.sleep(800);
                         
				         if(driver.findElement(By.xpath("//*[contains(@class,'auActionAddSpecialPosition')]")).isDisplayed()) 
				         {  
				        	driver.findElement(By.xpath("//*[contains(@class,'auActionAddSpecialPosition')]")).click(); //clicking on Set SpecialPosition action
				            
				        	Thread.sleep(1500);
				        	  
				        	  driver.findElement(By.xpath("//*[contains(@id,'specialPosition')]")).click();
							  List <WebElement> b = driver.findElements(By.id("specialPosition"));
							  Actions actions = new Actions(driver);
							  actions.moveToElement(b.get(0));
							  actions.sendKeys("Borough Set up Assistant - BSA").click().perform();
				       		  		        	  
				        	  //driver.findElement(By.id("startDate")).sendKeys("05152016"); //enter start date
				        	 // driver.findElement(By.id("endDate")).sendKeys("05152016");  //enter end date
							  
							  Constant.GetDateForMinervaSpecialPosition(k, driver);
							  
				        	  driver.findElement(By.id("comments")).sendKeys("edit SP");  //enter comments
				        	  
				        	  driver.findElement(By.xpath("//*[contains(@class,'Submit')]")).click(); //click on submit button
				        	  
				        	  Thread.sleep(2000);
				        	  
				        	  try
						    	{
				            		String strErrMessage = driver.findElement(By.xpath("//*[contains(text(),'There is a Special Position that overlaps')]")).getText();
					            	System.out.println("Error Message Appeared: " + strErrMessage);
						        	driver.findElement(By.xpath("//*[contains(@class,'Cancel')]")).click(); //click on cancel button
					            	Thread.sleep(400);
					            	 j--;
					                 continue;
						    	} 
						    	catch(NoSuchElementException e)
						    	{
						    		System.out.println("Error Message doesn't exist");
						    	} 
				        	  
				        	  
				        	  k = k + 1; //Set SpecialPosition scenario number
					            
					            if(k > 5){
					              k = 1;
					            }
                              
				         }
			         }// for loop
					 
					 		    driver.close();
				 
				  }
		   

}



