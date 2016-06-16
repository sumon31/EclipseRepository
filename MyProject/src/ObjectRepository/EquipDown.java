package ObjectRepository;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.bcel.verifier.Verifier;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.util.log.Log;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import testingFiles.Constant;

public class EquipDown {
	
	WebDriver driver;
	
	public EquipDown(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	   public void TestScenario() throws InterruptedException, IOException 
	  {
		  		   
		    
		    System.out.println("Starting Execution on location " + Constant.Location + " to Down Equipment");
  
	        //driver.manage().window().setPosition(new Point(1900, 0)); 
	        driver.manage().window().maximize();
	        //driver.manage().window().setPosition(new Point(1900, 0)); 
	       
	        driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[3]/div[2]")).click(); //click on Personnel menu
	        driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[4]/div[2]")).click(); //click on tasks menu
		                
	        //driver.manage().window().setPosition(new Point(-1900, 0));
//	        List<String> equipmentCategory = new ArrayList<String>();
//	        equipmentCategory.add("RearLoaders");
//	        equipmentCategory.add("DualBins");
//	        equipmentCategory.add("MechanicalBrooms");
//	        equipmentCategory.add("RoRos");
//	        equipmentCategory.add("EzPacks");
//	        equipmentCategory.add("Miscellaneous");
//	        equipmentCategory.add("Snow");
	        
	        String[] equipmentCategory = new String[8];
	        equipmentCategory[0] = ("RearLoaders");
	        equipmentCategory[1] = ("DualBins");
	        equipmentCategory[2] = ("MechanicalBrooms");
	        equipmentCategory[3] = ("AlleyTrucks");	        
	        equipmentCategory[4] = ("RoRos");
	        equipmentCategory[5] = ("EzPacks");
	        equipmentCategory[6] = ("Miscellaneous");
	        equipmentCategory[7] = ("Snow");
	        
	      //opening existing excel file call Data
	        FileInputStream file = new FileInputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\431_Down_Equipment.xlsx");
				    
	        @SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        XSSFRow row = null;
	        int n = 1;	
	        SoftAssert softassert = new SoftAssert();

	        for(int itrCategory = 0; itrCategory < equipmentCategory.length; itrCategory++)
	        {
	        	//equipmentCategory.get(itrCategory) 	        	
	        	//this.j = j;		
	        	for(int j = 0;j <= Constant.equipIteration - 1;j++) //number of equipment to be down
		        	//this.j = j;
		        	
		        {
	        		
	        		//Thread.sleep(300);
	        		
	        		if(driver.findElement(By.xpath("//*[@id='equip"+ equipmentCategory[itrCategory] +"']/div[2]/div")).isDisplayed())
	        				
			       {
			    	    String equipInnertext =  driver.findElement(By.xpath("//*[@id='equip"+ equipmentCategory[itrCategory] +"']/div[2]/div")).getText();                       
		        		//this.variableName can be used if two elements have similar functioanlity and you want to split it and call the element from a specific category. That variable can be used outside of if statement and loop statement
		        		
			    	    //String equipInnertext =  driver.findElement(By.xpath("//*[@id='equipRearLoaders']/div[2]/div")).getText();
			        	if(equipInnertext.length() > 3)
			        	{
					        String[] Innertext = equipInnertext.split("\n");
						 
					        int i = Constant.GetAllEquipmentCount(Innertext);
					        
					            
							//@SuppressWarnings("unchecked")
							  List<String> equpNames = Constant.GetAllEquipmentNames(Innertext);
								
							  
							  
							 // String random = (equpNames[new Random().nextInt(equpNames.length)]);
							  Random rn = new Random();
						      int randomEqup = rn.nextInt(i);
						      
						      row = sheet.createRow(n);
						     
						     System.out.println("number of total equipment in " +  equipmentCategory[itrCategory] + " Before Down is " + i);
						     
						     
						     
						     row.createCell(0).setCellValue(Constant.Location); //location
						     sheet.autoSizeColumn(0);
						     row.createCell(1).setCellValue(Constant.GetDateAndformat(0)); //date
						     sheet.autoSizeColumn(1);
						     
						     String strEquipCount = driver.findElement(By.xpath("//*[@id='equip"+ equipmentCategory[itrCategory] +"']/div[1]/h4/a/span[2]")).getText();
						     String intEquipCount = Constant.EquipmentCount(strEquipCount);
						     int intEquipCountBeforeDown = Double.valueOf(intEquipCount).intValue();
						     
						     System.out.println("Equipment to down is " + equpNames.get(randomEqup)); 
						     row.createCell(2).setCellValue(equpNames.get(randomEqup)); //Equipment name from ops-board
						     sheet.autoSizeColumn(2);
						     row.createCell(3).setCellValue(equipmentCategory[itrCategory]); //Equipment category name
						     sheet.autoSizeColumn(3);
						     
						     if(intEquipCountBeforeDown == i ){
						       row.createCell(4).setCellValue(i); //number of equipment within a category
						       Reporter.log("Passed-Correct number of Equipment displayed on OPS Before down for category " + equipmentCategory[itrCategory] + " is " + i + " for iteration " + (j + 1)); //number of equipment within a category);
						       sheet.autoSizeColumn(4);
						     }else{
						       row.createCell(4).setCellValue("Ops-Board category displays Count as: " + intEquipCountBeforeDown + " but actual equipment count is " + i); //number of equipment within a category 
						       //Assert.fail("Failed- InCorrect number of Equipment displayed on OPS after down for category " + equipmentCategory.get(itrCategory) + " is " + i + " for iteration " + (j + 1));
						       Reporter.log("Failed- InCorrect number of Equipment displayed on OPS before down for category " + equipmentCategory[itrCategory] + " is " + intEquipCountBeforeDown + " for iteration " + (j + 1));
						       softassert.assertEquals("Equipment count before down should be " + i," But equipment count before down is " + intEquipCountBeforeDown);
						       sheet.autoSizeColumn(4);
						       //driver.close();
						     }
						     
						     
						     
						     
						     String downEquipInnertext =  driver.findElement(By.xpath("//*[@id='equipDown']")).getText();                       				        		
					         String[] downInnertext = downEquipInnertext.split("\n");
								 
					         int downItr = Constant.GetAllEquipmentCount(downInnertext);
							        						     
						     String strDownCount = driver.findElement(By.xpath("//*[@id='allUnavailableEquipment']/div[3]/a/div/span[2]")).getText();
						     String intDownCount = Constant.EquipmentCount(strDownCount);
						     int intDownCountBeforeDown = Double.valueOf(intDownCount).intValue();
						     
						     if(intDownCountBeforeDown == downItr ){
							       row.createCell(5).setCellValue(downItr); //number of equipment within a down category
							       Reporter.log("Passed-Correct number of Equipment displayed on OPS Before down for Down Category is " + downItr + " for iteration " + (j + 1)); //number of equipment within Down category);
							       System.out.println("Passed-Correct number of Equipment displayed on OPS Before down for Down Category is " + downItr + " for iteration " + (j + 1)); //number of equipment within Down category);

							       sheet.autoSizeColumn(5);
							     }else{
						    	   System.out.println("Failed-Incorrect number of Equipment displayed on OPS Before down for Down Category is " + intDownCountBeforeDown + " for iteration " + (j + 1));
						    	   row.createCell(5).setCellValue("Ops-Board category displays Count as: " + intDownCountBeforeDown + " but actual equipment count is " + downItr); //number of equipment within Down category 
							       Reporter.log("Failed- InCorrect number of Equipment displayed on OPS before down for Down category is " + intDownCountBeforeDown + " for iteration " + (j + 1));
							       softassert.assertEquals("Equipment count before down in down category should be " + downItr," But equipment count before down in Down category is " + intDownCountBeforeDown);
							       sheet.autoSizeColumn(5);
							       //driver.close();
							     }
						     
						     driver.findElement(By.xpath("//span[contains(@class,'piece-of-equipment') and contains(text(),'"+ equpNames.get(randomEqup) +"')]")).click();
						     
						     String equipDown = driver.findElement(By.xpath("//*[@id='details']/div[1]/div/table/tbody/tr[1]/td[1]/h4")).getText();
						     row.createCell(6).setCellValue(equipDown); //Equipment condition before down
						     
						     System.out.println("Equipment Condition is " + equipDown);
						     
						     if(equipDown == "Down"){
				            	 	//j--;
				            	 	//continue;
						    	   row.createCell(6).setCellValue("Down"); //Equipment condition before down						    					    		 
						    	   sheet.autoSizeColumn(6);
						     } else {
						         						    		 
								    // Thread.sleep(350);
								     
								     driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/button[2]")).click(); //click on action drop down
								     if(driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/ul/li[5]")).isDisplayed()) //if down action button is displayed
								     {
										     driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/ul/li[5]")).click(); //clicking on Down action
										     
										     Thread.sleep(1800);
									         
										     String strEquipmentType = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div[1]")).getText();	//equipment type modal window
										     row.createCell(7).setCellValue(strEquipmentType); //Equipment Repair Location 
											 sheet.autoSizeColumn(7);
										     String strEquipmentOwner = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div[2]")).getText();	//equipment Owner modal window
										     row.createCell(8).setCellValue(strEquipmentOwner); //Equipment Repair Location 
											 sheet.autoSizeColumn(8);
										     String strEquipmentCurrentLocation = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/div[1]")).getText();	//equipment Current Location modal window
										     row.createCell(9).setCellValue(strEquipmentCurrentLocation); //Equipment Repair Location modal window
											 sheet.autoSizeColumn(9);
										     String strEquipmentLicense = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/div[2]")).getText();	//equipment License modal window
											 row.createCell(10).setCellValue(strEquipmentLicense); //Equipment Repair Location 
											 sheet.autoSizeColumn(10);
                                                
										    		
									         //click and enter a down code 1 from drop down
									     	 driver.findElement(By.xpath("//*[@id='s2id_downCode1']")).click(); 
									     	 String downCodesInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
									     	 String[] arrayDownCodeInnertext = downCodesInnertext.split("\n");
											 List<String> downCodes = Constant.GetAllDropDowns(arrayDownCodeInnertext);
											 int j1 = Constant.GetAllDropDownCount(arrayDownCodeInnertext);
											 int randomDownCode = rn.nextInt(j1);
											 System.out.println("Down code selected for down code 1 is " + downCodes.get(randomDownCode));
											 row.createCell(11).setCellValue(downCodes.get(randomDownCode)); //Equipment down code
											 sheet.autoSizeColumn(11);
											 List <WebElement> a = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
											 Actions actions = new Actions(driver);
											 actions.moveToElement(a.get(0));
											 actions.click();
											 actions.sendKeys(downCodes.get(randomDownCode)).perform();
											 driver.findElement(By.xpath("//*[contains(@id,'select2-results')]/li[1]")).click();
											 
											 //click and enter a Repair Location from drop down
											 driver.findElement(By.xpath("//*[@id='s2id_repairLocation1']")).click(); 
											 String repairLocationInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
											 String[] arrayRepairLocation = repairLocationInnertext.split("\n");
											 List<String> repairLocation = Constant.GetAllDropDowns(arrayRepairLocation);
											 //System.out.println("Down code " + repairLocation.get(0));
											 int k = Constant.GetAllDropDownCount(arrayRepairLocation);
											 int randomRepairLocation = rn.nextInt(k);
											 System.out.println("Repair Location selected for down code 1 is " + repairLocation.get(randomRepairLocation));
											 row.createCell(12).setCellValue((repairLocation.get(randomRepairLocation))); //Equipment Repair Location 
											 sheet.autoSizeColumn(12);
											 actions.moveToElement(a.get(1));
											 actions.click();
											 actions.sendKeys(repairLocation.get(randomRepairLocation)).perform();				
											 driver.findElement(By.xpath("//*[contains(@id,'select2-results')]/li[1]")).click();
							                 
											 
											//Enter Reporter
											driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset[1]/div[2]/div[1]/input")).sendKeys("Reporter1");
											row.createCell(13).setCellValue("Reporter1"); //Equipment Reporter 
											sheet.autoSizeColumn(13);
											//Thread.sleep(300);
											//Enter Mechanic
											driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset[1]/div[2]/div[2]/input")).sendKeys("Mechanic1");
											row.createCell(14).setCellValue("Mechanic1"); //Equipment Mechanic
											sheet.autoSizeColumn(14);
											//Enter Remarks
											driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset[1]/div[2]/div[3]/input")).sendKeys("Test");
											//Click on Down Button 
											driver.findElement(By.xpath("//*[@id='modal']/div[3]/button[2]")).click();
											
											Thread.sleep(4000);																						
										     
											driver.findElement(By.xpath("//*[contains(@ng-click,'closeEquipmentDetailsPane')]")).click();
											
	
											//Thread.sleep(1200);																					
									        
								     } // end of if down action button is displayed 
								
						     } // if equipment is down 
						     
						     //Thread.sleep(500);	
						         
						         driver.findElement(By.xpath("//span[contains(@class,'piece-of-equipment') and contains(text(),'"+ equpNames.get(randomEqup) +"')]")).click();
						         Thread.sleep(300);
						         String equipAfterDown = driver.findElement(By.xpath("//*[@id='details']/div[1]/div/table/tbody/tr[1]/td[1]/h4")).getText();
						         row.createCell(17).setCellValue(equipAfterDown); //Equipment condition after down
						         driver.findElement(By.xpath("//*[contains(@ng-click,'closeEquipmentDetailsPane')]")).click();
						     	
						     	 driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[12]/div[2]")).click();
						     	 
						     	 Thread.sleep(1000);
						     	 						     	 
						     	 String strDownRecentActivity0 = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div[1]/div[1]/div[2]/span[1]")).getText();
						         String strDownRecentActivity1 = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div[1]/div[1]/div[2]/span[2]")).getText();
						         String strDownRecentActivity2 = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div[1]/div[1]/div[2]/span[3]")).getText();
						         String strDownRecentActivity3 = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div[1]/div[1]/div[2]/span[4]")).getText();
						         String strDownRecentActivity4 = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/div[2]/div[1]/div[1]/div[2]/span[6]")).getText();

		         				 String strDownActivity = strDownRecentActivity0 + " " + strDownRecentActivity1 + " " + strDownRecentActivity2 + " " + strDownRecentActivity3 + " on " + strDownRecentActivity4;
		         				 //System.out.println(strDownActivity);
							     										     
							     if(strDownActivity.matches("(?i).*Downed Equipment.*"+ equpNames.get(randomEqup) +".*")){
							        System.out.println("Equipment displays in recent activity for iteration " + (j + 1) + " after Down: " + strDownActivity); 
							         row.createCell(18).setCellValue(strDownActivity); //Recent Activity after down
							         sheet.autoSizeColumn(18);
							     } else {
							    	
							        System.out.println("no records for Equipment appears in recent acitivity for iteration " + (j + 1) + " after Down"); 
							        row.createCell(18).setCellValue("No records for Equipment appears in recent acitivity for iteration "); //Recent Activity after down
							        sheet.autoSizeColumn(18);
							     }
							     
							     Thread.sleep(200);
							     driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[12]/div[2]")).click();
						     
						        String equipInnertextAfter =  driver.findElement(By.xpath("//*[@id='equip"+ equipmentCategory[itrCategory] +"']/div[2]/div")).getText();                       
					    	    String[] InnertextAfter = equipInnertextAfter.split("\n");
						        int iAfter = Constant.GetAllEquipmentCount(InnertextAfter);
						        System.out.println("number of total equipment in " + equipmentCategory[itrCategory] + " After Down is " + iAfter);
						        
						         String strEquipCountAfterDown = driver.findElement(By.xpath("//*[@id='equip"+ equipmentCategory[itrCategory] +"']/div[1]/h4/a/span[2]")).getText();
							     String intEquipCountAfterDown = Constant.EquipmentCount(strEquipCountAfterDown);
							     int intEquipCountAfter = Double.valueOf(intEquipCountAfterDown).intValue();
							     
							     
							     if(intEquipCountAfter != iAfter ){
							        row.createCell(15).setCellValue("Ops-Board category displays Count as: " + intEquipCountAfter + " but actual equipment count is " + iAfter); //number of equipment within a category 
							        sheet.autoSizeColumn(15);
							        //Assert.fail("Failed- InCorrect number of Equipment displayed on OPS after down for category " + equipmentCategory.get(itrCategory) + " is " + intEquipCountAfter + " for iteration " + (j + 1));
							        //driver.close();
							       // try
							     //   {
							       // Softassert.assertTrue(false);
							        softassert.assertEquals("Equipment count after down should be " + iAfter," But equipment count after down is " + intEquipCountAfter); //intEquipCountAfter
							      //  catch(AssertionError e)
								    //    {
							    	Reporter.log("Failed- incorrect number of Equipment displayed on OPS after down for category " + equipmentCategory[itrCategory] + " is " + intEquipCountAfter + " for iteration " + (j + 1)); //number of equipment within a category;
								    //    }
							     
							       }else{
							        row.createCell(15).setCellValue(iAfter); //number of equipment within a category 
							    	Reporter.log("Passed- correct number of Equipment displayed on OPS after down for category " + equipmentCategory[itrCategory] + " is " + iAfter + " for iteration " + (j + 1)); //number of equipment within a category;
							        sheet.autoSizeColumn(15);
							        
							     }
							     
							     
							     String downEquipInnertextAfter =  driver.findElement(By.xpath("//*[@id='equipDown']")).getText();                       				        		
						         String[] downInnertextAfter = downEquipInnertextAfter.split("\n");
									 
						         int downItrAfter = Constant.GetAllEquipmentCount(downInnertextAfter);
								        						     
							     String strDownCountAfter = driver.findElement(By.xpath("//*[@id='allUnavailableEquipment']/div[3]/a/div/span[2]")).getText();
							     String intDownCountAfter = Constant.EquipmentCount(strDownCountAfter);
							     int intDownCountBeforeDownAfter = Double.valueOf(intDownCountAfter).intValue();
							     
							     if(intDownCountBeforeDownAfter == downItrAfter ){
								       row.createCell(16).setCellValue(downItrAfter); //number of equipment within a down category
								       Reporter.log("Passed-Correct number of Equipment displayed on OPS After down for Down Category is " + downItrAfter + " for iteration " + (j + 1)); //number of equipment within Down category);
								       System.out.println("Passed-Correct number of Equipment displayed on OPS After down for Down Category is " + downItrAfter + " for iteration " + (j + 1)); //number of equipment within Down category);

								       sheet.autoSizeColumn(16);
								     }else{
							    	   System.out.println("Failed-Incorrect number of Equipment displayed on OPS After down for Down Category is " + intDownCountBeforeDownAfter + " for iteration " + (j + 1));
							    	   row.createCell(16).setCellValue("Ops-Board category displays Count as: " + intDownCountBeforeDownAfter + " but actual equipment count is " + downItrAfter); //number of equipment within Down category 
								       Reporter.log("Failed- InCorrect number of Equipment displayed on OPS After down for Down category is " + intDownCountBeforeDownAfter + " for iteration " + (j + 1));
								       softassert.assertEquals("Equipment count After down in down category should be " + downItrAfter," But equipment count After down in Down category is " + intDownCountBeforeDownAfter);
								       sheet.autoSizeColumn(16);
								       //driver.close();
								     }
							     
							     
							    
							    	 
							     Thread.sleep(500);
							     											        
						            n = n + 1;
			        	} else {
			        		break;
			        	} // end of equipment greater than 3 if
			       } // end of is displayed 
		  } // End of number of equipment per category loop	
		        
	  } // End of Category loop
		        	driver.close();
		        	file.close();
                    
					//saving the file as different name
			        FileOutputStream outFile =new FileOutputStream("C:\\Users\\skashem\\Desktop\\Excel_Selenium_Framework\\431_Down_Equipment_"+ Constant.Location +"_"+ Constant.GetDateAndformat(0) +".xlsx");
			        workbook.write(outFile);
			        outFile.close(); 	
		
	  }

	  
}
