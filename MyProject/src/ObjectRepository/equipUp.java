package ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import testingFiles.Constant;

public class equipUp {
		
	WebDriver driver;
	
	public equipUp(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	   public void TestScenario() throws InterruptedException, IOException 
	   
	  {
		  		   
		    System.out.println("Starting Execution on location " + Constant.Location + " to Up Equipment");
  
	        //driver.manage().window().setPosition(new Point(1900, 0)); 
	        driver.manage().window().maximize();
	        //driver.manage().window().setPosition(new Point(1900, 0)); 
	       
	        driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[3]/div[2]")).click(); //click on Personnel menu
	        driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[4]/div[2]")).click(); //click on tasks menu
		                
	        //driver.manage().window().setPosition(new Point(-1900, 0));
	        List<String> equipmentCategory = new ArrayList<String>();
	        equipmentCategory.add("Down");

	        for(int itrCategory = 0; itrCategory < equipmentCategory.size(); itrCategory++)
	        {
	        	//equipmentCategory.get(itrCategory) 	        	
	        	//this.j = j;		
	        	for(int j = 0;j < Constant.equipIteration;j++) //number of equipment to be down
		        	//this.j = j;
		        	
		        {
	        		
	        		//Thread.sleep(300);
	        		Boolean isEquipmentsPresent = driver.findElements(By.xpath("//*[@id='equip"+ equipmentCategory.get(itrCategory) +"']")).size()!= 0;
	        		System.out.println("Equipment from category " + equipmentCategory.get(itrCategory) + " present: " + isEquipmentsPresent);
	        		//if(driver.findElement(By.xpath("//*[@id='equip"+ equipmentCategory.get(itrCategory) +"']")).isDisplayed())
	        		Thread.sleep(300);
	        		if(isEquipmentsPresent = true)
	        				
			       {
			    	    String equipInnertext =  driver.findElement(By.xpath("//*[@id='equip"+ equipmentCategory.get(itrCategory) +"']")).getText();                       
		        		//this.variableName can be used if two elements have similar functionality and you want to split it and call the element from a specific category. That variable can be used outside of if statement and loop statement
		        		
			        	if(equipInnertext.length() > 3)
			        	{
					        String[] Innertext = equipInnertext.split("\n");
						 
					        int i = Constant.GetAllEquipmentCount(Innertext);
					        
					            
							//@SuppressWarnings("unchecked")
							  List<String> equpNames = Constant.GetAllEquipmentNames(Innertext);
							  	
							  
							  
							 // String random = (equpNames[new Random().nextInt(equpNames.length)]);
							  Random rn = new Random();
						      int randomEqup = rn.nextInt(i);
						      						     
						      System.out.println("number of total equipment in " +  equipmentCategory.get(itrCategory) + " Before Up is " + i);
						     
						     driver.findElement(By.xpath("//span[contains(@class,'piece-of-equipment') and contains(text(),'"+ equpNames.get(randomEqup) +"')]")).click();
                             
						     driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/button[2]")).click(); //click on action drop down
						     if(driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/ul/li[6]")).isDisplayed()) //if down action button is displayed
						     {
						    	 driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/ul/li[6]")).click();
						     
						     	Thread.sleep(1000);
						     	
						     	driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset/div[1]/div/input")).sendKeys("UPequipMechanic");
						     	driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset/div[2]/div/input")).clear();
						     	driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset/div[2]/div/input")).sendKeys("UPequipReporter");
						    	driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click();
						    	
						    	Thread.sleep(2000);
						    	
						    	try
						    	{
						    		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/div"));
						    	} 
						    	catch(NoSuchElementException e)
						    	{
						    	    //;
						    	} 
						    	
						    	Boolean isErrMsgpresent = driver.findElements(By.xpath("//*[@id='modal']/div[2]/div[4]/div/div")).size()!= 0;
						    	System.out.println("Error message Present: " + isErrMsgpresent);
						    	
						    	if(isErrMsgpresent == true){
						    	
						    		String errMessage = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/div")).getText();
							    	
							    	if(errMessage != null){
							    		driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[1]")).click();
							    		Thread.sleep(500);
							    		System.out.println("number of total equipment in " +  equipmentCategory.get(itrCategory) + " After Up is " + i);
							    	} else {
							    		System.out.println("number of total equipment in " +  equipmentCategory.get(itrCategory) + " After Up is " + (i-1));
							    	}
						    	}
						      	
						     	
			        	     }//end of if up action button is displayed		
						     
						     
			        	} else {
			        		break;
			        	}// if equipment greater than 3
			       }// if Equipment is displayed
		        }//Equipment Iteration
	        	    
	        }//down Category
	        
	        				 driver.close(); 
	        				 
	  } //end of test scenario

}//equip up
						     


