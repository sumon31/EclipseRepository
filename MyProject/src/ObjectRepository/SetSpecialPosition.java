
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

	public class SetSpecialPosition {
		
		WebDriver driver;
		
		public SetSpecialPosition(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		   public void TestScenario() throws InterruptedException, IOException 
		  {
					  		   
					  driver.findElement(By.xpath("//*[@id='mainmenu']/div[1]/div[3]")).click(); //click on equipment menu
					  driver.findElement(By.xpath("//*[@id='mainmenu']/div[1]/div[5]")).click(); //click on tasks menu
					 
					 Thread.sleep(1000);
					 
					 
					 int k = 1;
					 for(int j = 0;j <= Constant.equipIteration - 1;j++) //number of equipment to be down
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
				         
				         /* List <WebElement> alist = driver.findElements(By.xpath("//div[contains(@class,'SanitationWorkersAvailable')]/div/personnel-card/div[2]/div/div[contains(text(),'" + personNames.get(randomPerson) +"')]"));
						  Actions actions = new Actions(driver);
						  actions.moveToElement(alist.get(0));
						  actions.sendKeys(personNames.get(randomPerson)).click().perform(); */
				         
//				         int found = personNames.get(randomPerson).indexOf("'");
//				         if(found != -1)
//				         {
//				        	 String[] arrayPerson = personNames.get(randomPerson).split("'");
//				        	 driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(normalize-space(text()),'" + arrayPerson[0] + "') and contains(normalize-space(text()),'" + arrayPerson[1] + "')]")).click();			         
//				         } else {
				       //*[@id="personnel-list"]/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div[1]/personnel-card/div/div[1]/div[2]/span	 
				       //*[@id="personnel-list"]/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div[13]/personnel-card/div/div[1]/div[2]/span
				       //*[@id="personnel-list"]/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div[1]/personnel-card/div/div[1]/div[2]/text()
				         driver.findElement(By.xpath(" //*[@id='personnel-list']/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div["+ (randomPerson + 1) + "]/personnel-card/div/div[1]/div[2]")).click();
				        // driver.findElements(By.xpath("//div[contains(@class,'SanitationWorkersAvailable')]/div/personnel-card/div[2]/div/div[contains(text(),'" + personNames.get(randomPerson) +"')]")).c
				         //*[@id="personnel-list"]/div/div[2]/div[2]/div[1]/personnel-list-section/div/div[5]/div/div[2]/div[1]/personnel-card/div/div[1]/div[2]/span
                              // driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(normalize-space(text()),'"+ personNames.get(randomPerson) +"')]")).click();
		        		      //driver.findElement(By.xpath("//*[contains(text(),'"+ personNames.get(randomPerson) +"')]")).click();

			//	         }
				         Thread.sleep(800);
				         //driver.findElement(By.xpath("/html/body/smart/opsboard/board/main/div[2]/div/personnel/personnel-details/div/div/div[1]/div[2]/div/span")).click(); //click on action drop down
				         Actions action = new Actions(driver);
				         List <WebElement> arrow = driver.findElements(By.xpath("//*[contains(@class,'fa fa-arrow-down')]"));
				         action.moveToElement(arrow.get(1)).click().perform();
				         Thread.sleep(800);
				         //driver.findElement(By.xpath("//*[contains(@class,'fa fa-arrow-down')]")).click();
				        // if(driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/ul/li[3]")).isDisplayed()) 
				         if(driver.findElement(By.xpath("//*[contains(@class,'auActionAddSpecialPosition')]")).isDisplayed()) 
				         {
				        	driver.findElement(By.xpath("//*[contains(@class,'auActionAddSpecialPosition')]")).click(); //clicking on Set SpecialPosition action
				       
				        	Thread.sleep(1500);
				        	//click and enter a SpecialPosition Code from drop down
				        	 //driver.findElement(By.xpath("//*[@id='s2id_specialPosition']/a/span[2]/b")).click(); //click on SpecialPosition type drop down
				        	 // driver.findElement(By.xpath("//*[contains(@id,'specialPosition')]")).click(); //click on SpecialPosition type drop down
				        	 // Thread.sleep(1000);
				        	  Select dropdown = new Select(driver.findElement(By.id("specialPosition")));
				        	  dropdown.selectByValue("BOA");
				        	  
					     	 //String SpecialPositionCodesInnertext =  driver.findElement(By.xpath("//*[contains(@id,'specialPosition']")).getText();	 
					     	// String[] arraySpecialPositionCodeInnertext = SpecialPositionCodesInnertext.split("\n");
							 /*List<String> SpecialPositionCodes = Constant.GetAllDropDowns(arraySpecialPositionCodeInnertext);
							 int j1 = Constant.GetAllDropDownCount(arraySpecialPositionCodeInnertext);
							 int randomSpecialPositionCode = rn.nextInt(j1);*/
							 //if(SpecialPositionCodes.get(randomSpecialPositionCode) != "CHART") //&& (SpecialPositionCodes.get(randomSpecialPositionCode) != "JURY DUTY"))
				            // {
								// System.out.println("SpecialPosition Code selected for person " + personNames.get(randomPerson) + " is " + SpecialPositionCodes.get(randomSpecialPositionCode));
								/* List <WebElement> a = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
								 Actions actions = new Actions(driver);
								 actions.moveToElement(a.get(0));
								 actions.click();*/
					     	 
								// actions.sendKeys(SpecialPositionCodes.get(randomSpecialPositionCode)).perform();
					        //	 driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[1]")).click(); //select SpecialPosition code from drop down
					        	
					             Constant.GetDateForMinervaSpecialPosition(k,driver); //start and end date for SpecialPosition				          				  
					            
					            Thread.sleep(1000);
					            driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click(); //click on Add button
					            Thread.sleep(2100);
					                
					            	try
							    	{
					            		String strErrMessage = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/div")).getText();
						            	System.out.println("Error Message Appeared: " + strErrMessage);
						            	driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[1]")).click();
						            	Thread.sleep(400);
						            	 j--;
						                 continue;
							    	} 
							    	catch(NoSuchElementException e)
							    	{
							    		System.out.println("Error Message doesn't exist");
							    		Thread.sleep(500);
						            	driver.findElement(By.xpath("//div[contains(text(),'Recent Activity')]")).click(); //clicking on recent activity
						            	Thread.sleep(1000);
						            	String recentActivityInfo = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div[1]/div[1]/div[2]")).getText();
						            	System.out.println("Recent Activity Message: " + recentActivityInfo);
						            	Thread.sleep(300);
						            	driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[1]/div/div/div[3]/a/i")).click(); //closing recent activity panel
							    	} 
				                    
				           //  } else {
				           // 	 driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[1]")).click();

					        //	 System.out.println("Person " + personNames.get(randomPerson) + "SpecialPosition code CHART is selected and skipped");
				            	 
				            	
				           //  }
							 Thread.sleep(300);	
							  driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[2]/i")).click(); //closing the employee detail window
							  
					          k = k + 1; //Set SpecialPosition scenario number
					            
					            if(k > 5){
					              k = 1;
					            }
				        }// if SpecialPosition action displayed
				  
				          
			         }	 
					 		driver.close();
				 
				  }
		   

}



