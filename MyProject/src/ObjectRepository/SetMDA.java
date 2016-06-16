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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetMDA {
	
	WebDriver driver;
	
	public SetMDA(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	   public void TestScenario() throws InterruptedException, IOException 
	  {
				  		   
				  
		   
		   		  WebDriverWait wait = new WebDriverWait(driver, 45);
		   		  
		   		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav']/div[2]/div[1]/div[2]/div[2]"))); //click on equipment menu
		   		   
		   		  //driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[2]/div[2]")).click(); //click on equipment menu
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
			         
			         System.out.println("number of total supervisors & san-workers are " + i);
			         System.out.println("person set to MDA is  " + personNames.get(randomPerson));
			         
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
			         //String mda1L = driver.findElement(By.xpath("//*[@id='sanitationWorkers']/div[2]/div/div/span[contains(text(),'"+ personNames.get(randomPerson) +"')]/span")).getText();
			         driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/button[2]")).click(); //click on action drop down
			         if(driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/ul/li[2]")).isDisplayed()) 
			         {
			        	driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[3]/div/ul/li[2]")).click(); //clicking on Set MDA action
			       
			        	Thread.sleep(1500);
			        	//click and enter a MDA Code from drop down
			        	 driver.findElement(By.xpath("//*[@id='s2id_subType']/a/span[2]/b")).click(); //click on MDA type drop down
				     	 String mdaCodesInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
				     	 String[] arrayMDACodeInnertext = mdaCodesInnertext.split("\n");
						 List<String> mdaCodes = Constant.GetAllDropDowns(arrayMDACodeInnertext);
						 int j1 = Constant.GetAllDropDownCount(arrayMDACodeInnertext);
						 int randomMDACode = rn.nextInt(j1);
						 System.out.println("MDA Code selected for person " + personNames.get(randomPerson) + " is " + mdaCodes.get(randomMDACode));
						 List <WebElement> a = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
						 Actions actions = new Actions(driver);
						 actions.moveToElement(a.get(0));
						 actions.click();
						 actions.sendKeys(mdaCodes.get(randomMDACode)).perform();
			        	 driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[1]")).click(); //select MDA code from drop down
			             Constant.GetDateForMDA(k,driver); //start and end date for MDA
			           
			            k = k + 1; //Set MDA scenario number
			            
			            if(k > 5){
			              k = 1;
			            }
			            
			            Thread.sleep(1000);
			            driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click(); //click on Add button
			            Thread.sleep(2300);
			                
			            	try
					    	{
			            		String strErrMessage = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[7]/div/div")).getText();
				            	System.out.println("Error Message Appeared: " + strErrMessage);
				            	driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[1]")).click();
					    	} 
					    	catch(NoSuchElementException e)
					    	{
					    		System.out.println("Error Message doesn't exist");
					    	} 
		                    Thread.sleep(500);
			            	driver.findElement(By.xpath("//div[contains(text(),'Recent Activity')]")).click(); //clicking on recent activity
			            	Thread.sleep(1000);
			            	String recentActivityInfo = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div[1]/div[1]/div[2]")).getText();
			            	System.out.println("Recent Activity Message: " + recentActivityInfo);
			            	Thread.sleep(300);
			            	driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[1]/div/div/div[3]/a/i")).click(); //closing recent activity panel
			            	driver.findElement(By.xpath("//*[@id='screen1Pane1']/div[2]/div[1]/div/div/span[2]/i")).click(); //closing the employee detail window
			            	
		             } else {
		            	 System.out.println("Person " + personNames.get(randomPerson) + " has a MDA code of 1L");
		            	 j--;
		                 continue;
		             }
			  
			          
		         }	 
				 		driver.close();
			 
			  }
	   

}
