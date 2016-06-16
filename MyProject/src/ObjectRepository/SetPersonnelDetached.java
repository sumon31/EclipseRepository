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

public class SetPersonnelDetached {
	
	WebDriver driver;
	
	public SetPersonnelDetached(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	   public void TestScenario() throws InterruptedException, IOException 
	  {
				  		   
				  driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[2]/div[2]")).click(); //click on equipment menu
				  driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[4]/div[2]")).click(); //click on tasks menu
				 
				 Thread.sleep(1000);
				 
				 
				 int k = 1;
				 for(int j = 0;j <= Constant.equipIteration - 1;j++) //number of equipment to be down
		         {
					 
					 String personSupervisors =  driver.findElement(By.xpath("//*[@id='supervisors']/div[2]/div")).getText();
					 String personSanWorkers =  driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div")).getText();
					 String personAvailability = personSupervisors + personSanWorkers;
					 String[] Innertext = personAvailability.split("\n");
					 
					 
					 
					 int i = Constant.GetAllPersonCategoryCount(Innertext);
					
					//@SuppressWarnings("unchecked")
					 List<String> personNames = Constant.GetAllPersonnelNames(Innertext);
			         Random rn = new Random();
			         int randomPerson = rn.nextInt(i);
			         
			         System.out.println("number of total supervisors & san-wrokers are " + i);
			         System.out.println("person set to Detached is  " + personNames.get(randomPerson));
			         
			         int found = personNames.get(randomPerson).indexOf("'");
			         if(found != -1)
			         {
			        	 String[] arrayPerson = personNames.get(randomPerson).split("'");
			        	 driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(normalize-space(text()),'" + arrayPerson[0] + "') and contains(normalize-space(text()),'" + arrayPerson[1] + "')]")).click();			         
			         } else {
			        	 
			        	 try
				    	 {
			        		 driver.findElement(By.xpath("//*[@id='supervisors']/div[2]/div/div/span[contains(normalize-space(text()),'"+ personNames.get(randomPerson) +"')]")).click();
				    	 } 
				    	 catch(NoSuchElementException f)
				    	 {
				    		 driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(normalize-space(text()),'"+ personNames.get(randomPerson) +"')]")).click();
				    	 }
			        	 
			         }
			         //String Detach1L = driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(text(),'"+ personNames.get(randomPerson) +"')]/span")).getText();
			         driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/button[2]")).click(); //click on action drop down
			         if(driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/ul/li[1]")).isDisplayed()) 
			         {
			        	driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/ul/li[1]")).click(); //clicking on Set Detach action
			       
			        	Thread.sleep(1500);
			        	//click and enter a Target Location from drop down
			        	 //driver.findElement(By.xpath("//*[contains(@id,'s2id_autogen')]/a/span[2]/b")).click(); //click on Target Location drop down
			        	 driver.findElement(By.xpath("//*[contains(text(),'Select a Target Location')]")).click(); //click on Shift drop down

						 String randomTargetLocation = Constant.strDetachTo; //"BKS14";

						 
							 //System.out.println("Target Location selected for person " + personNames.get(randomPerson) + " is " + DetachCodes.get(randomTargetLocation));
						 	 System.out.println("Target Location selected for person " + personNames.get(randomPerson) + " is " + randomTargetLocation);

							 List <WebElement> a = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
							 Actions actions = new Actions(driver);
							 actions.moveToElement(a.get(0));
							 actions.click();
							 actions.sendKeys(randomTargetLocation).perform();
				        	 driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[1]")).click(); //select Target Location from drop down
				        	 
				        	//click and enter a Shift from drop down
				        	try
				        	{
				        	 driver.findElement(By.xpath("//span[@class='select2-chosen' and text()='0600-1400']")).click(); //click on Shift drop down
				        	}
				        	catch(NoSuchElementException g)
				        	{
					         driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(text(),'Select a Shift')]")).click(); //click on Shift drop down
				        	}
				        	
					     	 String shiftInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
					     	 String[] arrayShiftInnertext = shiftInnertext.split("\n");
							 List<String> shiftCodes = Constant.GetAllDropDowns(arrayShiftInnertext);
							 int j1 = Constant.GetAllDropDownCount(arrayShiftInnertext);
							 int randomShift = rn.nextInt(j1);
							 
								 System.out.println("Shift selected for person " + personNames.get(randomPerson) + " is " + shiftCodes.get(randomShift));
								 //List <WebElement> b = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
								 actions.moveToElement(a.get(1));
								 actions.click();
								 actions.sendKeys(shiftCodes.get(randomShift)).perform();
					        	 driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[1]")).click(); //select shift from drop down
				        	
				                 Constant.GetDateForDetached(k,driver); //start and end date for Detach		
				                 
    				            driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click(); //click on Add button
    				            Thread.sleep(2100);
				            
				            	try
						    	{
				            		String strErrMessage = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[7]/div/div")).getText();
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

				        //	 System.out.println("Person " + personNames.get(randomPerson) + "Detach code CHART is selected and skipped");
			            	 
			            	
			           //  }
						 Thread.sleep(300);	
						  driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[2]/i")).click(); //closing the employee detail window
						  
				          k = k + 1; //Set Detach scenario number
				            
				            if(k > 5){
				              k = 1;
				            }
			        }// if Detach action displayed
			  
			          
		         }	 
				 		driver.close();
			 
			  }
	   

}
