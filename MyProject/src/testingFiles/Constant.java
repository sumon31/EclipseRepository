package testingFiles;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.jna.platform.win32.OaIdl.DATE;

public class Constant {
	
	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value
	public static WebDriver driver;
	//public static String URL = "http://10.155.208.31/ui/#"; //Minerva QA2
	  public static String URL = "http://mstlva-dsnysmt1.csc.nycnet/smart-opsboard/"; //QA1
	//public static String URL = "http://msslva-dsnysmt24.csc.nycnet/smart-opsboard/";
	//public static final String URL = "http://msslvv-dsnsmt11.csc.nycnet/smart-opsboard/"; //Stage
	//public static final String URL = "http://mstlvv-dsnsmt03.csc.nycnet/smart-opsboard/"; //UAT
    public static String Location = "SI02";
    public static int equipIteration = 5;
    public static int shiftIteration = 3;
    public static int shiftCategory = 4;
    public static int shiftSubCategory = 2;


   // public static final String Date = "20151207";
    public static String strDetachTo = "BKS10";	//"BKS14"
    public static String UserName = "smartojtstg76";
    public static String Password = "Change4dsny";
    //public static String UserName = "admin";
    //public static String Password = "admin";
    
    public static String EquipmentCount(String equipCount){
  	  StringBuffer sBuffer = new StringBuffer();
  	  Pattern p = Pattern.compile("(\\d+)");
  	  Matcher m = p.matcher(equipCount);
  	  while (m.find()) {
  	    sBuffer.append(m.group());
  	  }
  	  return sBuffer.toString();
  }
   
                           
    public static String GetDateAndformat(int DateNumber) 
    {
    	 // Create object of SimpleDateFormat class and decide the format
    	 DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    	 
    	 //get current/past/future date time with Date()
         Calendar cal = Calendar.getInstance();
         cal.add(Calendar.DATE, DateNumber);  
         
         // Now format the date
         String date1= dateFormat.format(cal.getTime());
    	
    	 // Print the Date
    	 System.out.println("The date is '" + date1 + "'");
    	 
    	// return  
		return date1;
    }
    
    public static String GetNewDateAndformat(int DateNumber) 
    {
    	 // Create object of SimpleDateFormat class and decide the format
    	 DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
    	 
    	 //get current/past/future date time with Date()
         Calendar cal = Calendar.getInstance();
         cal.add(Calendar.DATE, DateNumber);  
         
         // Now format the date
         String date1= dateFormat.format(cal.getTime());
    	
    	 // Print the Date
    	 System.out.println("The date is '" + date1 + "'");
    	 
    	// return  
		return date1;
    }
     
    public static String GetDateAndformat1(int DateNumber) 
    {
    	 // Create object of SimpleDateFormat class and decide the format
    	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	 
    	 //get current/past/future date time with Date()
         Calendar cal = Calendar.getInstance();
         cal.add(Calendar.DATE, DateNumber);  
         
         // Now format the date
         String date1= dateFormat.format(cal.getTime());
    	
    	 // Print the Date
    	 //System.out.println("The date is '" + date1 + "'");
    	 
    	// return  
		return date1;
    }
    
    public static int GetAllEquipmentCount(String[] innertext)
	{
    	 int i = 0;
		 for (String Equip : innertext) {
			 
			 if(Equip.contains("-")){
				//System.out.println("Equipment " + Equip );
				i++;
			 }
			 
			
		}
		return i;
	}
    
    public static List<String> GetAllEquipmentNames(String[] innertext)
	{
    	
     	
    	List<String> eqipNames = new ArrayList<String>(); 
		 for (String Equip : innertext) {
			 
			 if(Equip.contains("-")){
				System.out.println("Equipment " + Equip );
				eqipNames.add(Equip);
				
			 }
			 
			
		}
		return eqipNames;
	}
    
    public static List<String> GetAllDropDowns(String[] innertext)
	{
    	List<String> listNames = new ArrayList<String>(); ;
		 for (String dropdown : innertext) {
			 				//System.out.println("All DropDowns " + Equip );
			 //if(dropdown.contains("-")){
					//System.out.println("Equipment " + Equip );
				 listNames.add(dropdown);	
			 //}
			
		}
		return listNames;
	}
    
    
    public static int GetAllDropDownCount(String[] innertext)
   	{
       	 int i = 0;
   		 for (String DropDownCount : innertext) {
   			 
   				i++;   			 
   			
   		}
   		return i;
   	}
    
    
    
    public static int GetAllPersonCategoryCount(String[] innertext)
	{
    	 int i = 0;
		 for (String Person : innertext) {
			 
			 if(Person.length() > 3){
				//System.out.println("Equipment " + Equip );
				i++;
			 }
			 
			
		}
		return i;
	}
    
    public static List<String> GetAllPersonnelNames(String[] innertext)
	{
    	
    	
    	List<String> personNames = new ArrayList<String>(); ;
		 for (String person : innertext) {
			 
			 if(person.length() > 3){
				//System.out.println("Person " + person );
				personNames.add(person);
				
			 }
			 
			
		}
		return personNames;
	}
    
    
    public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		try {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
		}
	}
	
    
    public static boolean isElementPresent(String xpathExpression) {
    	boolean present;
    	try {
    		driver.findElement(By.xpath(xpathExpression));
    		present = true;
    	} catch(NoSuchElementException e) {
    		present = false;
    	}
    	return present;
    }
    

public static String GetDateForMDA(int Iteration,WebDriver driver) throws InterruptedException {

     String dateString = null;
     String startDate = null;
     String endDate = null;
	 //String startDate1 = null;
    switch (Iteration) {
        case 1: // present to present date for MDA
        								  //*[@id='modal']/div[2]/div[1]/div/p/span/button[1]
        String strEndDateCase1 = Constant.GetDateAndformat1(0);	
        
    	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/span/button[1]")).click(); //click on start date button
    	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
        //startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date
        
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button[1]")).click(); //click on End date button
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for End date
        						    
        //endDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/input")).getText(); //getting value for End date
        
    	dateString = "Start-Date:" + strEndDateCase1 + " End-Date:" + strEndDateCase1;
 	    break;
 	    
        case 2: // present to future date for MDA
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/span/button[1]")).click(); //click on start date button
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
        	//startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date        	 
            String strEndDate = Constant.GetDateAndformat1(0);
            String[] arrayEndDate = strEndDate.split("/"); //current month
            //System.out.println("arrayEndDate Month is  " + arrayEndDate[0]);
            String strEndDate1 = Constant.GetDateAndformat1(7);
            String[] arrayEndDate1 = strEndDate1.split("/");
           // System.out.println("arrayEndDate1 Month is  " + arrayEndDate1[0]);
            driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button[1]")).click(); //click on End date button
            
            //Thread.sleep(200);
            
            if(arrayEndDate[0].equals(arrayEndDate1[0])){
            	//System.out.println("the month is same " + arrayEndDate1[0]);
            	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
              //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));    
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate1[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDate1[1]))
                   {
                      cell.click();
                      break;
                   }
                }
    			 
            } else {
            	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
            	                             
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));    
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate1[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDate1[1]))
                   {
                      cell.click();
                      break;
                   }
                }

            }
            
        	dateString = "Start-Date:" + strEndDate + " End-Date:" + strEndDate1;
        	
     	    break;
     	    
        case 3: // present to empty date for MDA
			  //*[@id='modal']/div[2]/div[1]/div/p/span/button[1]
        	String strEndDateCase3 = Constant.GetDateAndformat1(0);	
			driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/span/button[1]")).click(); //click on start date button
	    	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
			//startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date
			
			//driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button[1]")).click(); //click on End date button
			//driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for End date
			//endDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/input")).getText(); //getting value for End date
			endDate = "Empty";
			dateString = "Start-Date:" + strEndDateCase3 + " End-Date:" + endDate;
			break;
     	    
        case 4: // future to future date for MDA
        	    	 
            String strEndDate2 = Constant.GetDateAndformat1(0);
            String[] arrayEndDate2 = strEndDate2.split("/"); //current month
            
            String strEndDate3 = Constant.GetDateAndformat1(7);
            String[] arrayEndDate3 = strEndDate3.split("/"); //current month
            driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/span/button[1]")).click(); //click on start date button 
            
            if(arrayEndDate2[0].equals(arrayEndDate3[0])){
            	//System.out.println("the month is same " + arrayEndDate3[0]);
            	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]"));     
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDate3[1]))
                   {
                      cell.click();
                      break;
                   }
                }
    			 
            } else {
            	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]"));     
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDate3[1]))
                   {
                      cell.click();
                      break;
                   }
                }

            }
            //-----------------------------------------------------------------------------------------------------------------------
            //-----------------------------------------------------------------------------------------------------------------------
            
            String strEndDate4 = Constant.GetDateAndformat1(7);
            String[] arrayEndDate4 = strEndDate4.split("/"); //current month
            driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button[1]")).click(); //click on End date button
            if(arrayEndDate2[0].equals(arrayEndDate4[0])){
            	//System.out.println("the month is same " + arrayEndDate3[0]);
            	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]"));     
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDate3[1]))
                   {
                      cell.click();
                      break;
                   }
                }
    			 
            } else {
            	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
              //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]"));     
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDate3[1]))
                   {
                      cell.click();
                      break;
                   }
                }

            }
            
        	dateString = "Start-Date:" + strEndDate3 + " End-Date:" + strEndDate4;
        	
     	    break;
     	    
        case 5: // Future to Empty date for MDA
        	//startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date        	 
            String strEndDateCase5_1 = Constant.GetDateAndformat1(0);
            String[] arrayEndDateCase5_1 = strEndDateCase5_1.split("/"); //current month
            //System.out.println("arrayEndDate Month is  " + arrayEndDate[0]);
            String strEndDateCase5_2 = Constant.GetDateAndformat1(18);
            String[] arrayEndDateCase5_2 = strEndDateCase5_2.split("/");
           // System.out.println("arrayEndDate1 Month is  " + arrayEndDate1[0]);
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/span/button[1]")).click(); //click on start date button
            
            //Thread.sleep(200);
            
            if(arrayEndDateCase5_1[0].equals(arrayEndDateCase5_2[0])){
            	//System.out.println("the month is same " + arrayEndDateCase5_2[0]);
            	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //   List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));     
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDateCase5_2[1]))
                   {
                      cell.click();
                      break;
                   }
                }
    			 
            } else {
            	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
            	
            	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));     
                List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

                
                //comparing the text of cell with future date and clicking it.
                for (WebElement cell : columns)
                {
                   if (cell.getText().equals(arrayEndDateCase5_2[1]))
                   {
                      cell.click();
                      break;
                   }
                }

            }
            String strStartDateCase5_2 = "Empty";
        	dateString = "Start-Date:" + strEndDateCase5_2 + " End-Date:" + strStartDateCase5_2;
        	
     	    break;
 	    
        default: 
    	dateString = "Invalid Date";
        break;
    }
    System.out.println(dateString);
    return dateString;    
}

public static String GetDateForUnavailable(int Iteration,WebDriver driver) throws InterruptedException {

    String dateString = null;
    String startDate = null;
    String endDate = null;
	 //String startDate1 = null;
   switch (Iteration) {
       case 1: // present to present date for MDA
       								  //*[@id='modal']/div[2]/div[1]/div/p/span/button[1]
       String strEndDateCase1 = Constant.GetDateAndformat1(0);	
       
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button
   								 
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
       //startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date
       
       driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[4]/div/p/span/button")).click(); //click on End date button
       driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[4]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for End date
       //endDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/input")).getText(); //getting value for End date
       
   	dateString = "Start-Date:" + strEndDateCase1 + " End-Date:" + strEndDateCase1;
	    break;
	    
       case 2: // present to future date for MDA
	   	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button
    	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
       	//startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date        	 
           String strEndDate = Constant.GetDateAndformat1(0);
           String[] arrayEndDate = strEndDate.split("/"); //current month
           //System.out.println("arrayEndDate Month is  " + arrayEndDate[0]);
           String strEndDate1 = Constant.GetDateAndformat1(7);
           String[] arrayEndDate1 = strEndDate1.split("/");
          // System.out.println("arrayEndDate1 Month is  " + arrayEndDate1[0]);
           driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[4]/div/p/span/button")).click(); //click on End date button
           
           //Thread.sleep(200);
           
           if(arrayEndDate[0].equals(arrayEndDate1[0])){
           	//System.out.println("the month is same " + arrayEndDate1[0]);
           	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));    
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate1[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate1[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	 
        	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[4]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
        	                                
           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
              // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));    
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate1[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate1[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           
       	dateString = "Start-Date:" + strEndDate + " End-Date:" + strEndDate1;
       	
    	    break;
    	    
       case 3: // present to empty date for MDA
			  //*[@id='modal']/div[2]/div[1]/div/p/span/button[1]
       	String strEndDateCase3 = Constant.GetDateAndformat1(0);	
       		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
			//startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date
			endDate = "Empty";
			dateString = "Start-Date:" + strEndDateCase3 + " End-Date:" + endDate;
			break;
    	    
       case 4: // future to future date for MDA
       	    	 
           String strEndDate2 = Constant.GetDateAndformat1(0);
           String[] arrayEndDate2 = strEndDate2.split("/"); //current month
           
           String strEndDate3 = Constant.GetDateAndformat1(7);
           String[] arrayEndDate3 = strEndDate3.split("/"); //current month
      	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button
           
           if(arrayEndDate2[0].equals(arrayEndDate3[0])){
           	//System.out.println("the month is same " + arrayEndDate3[0]);
           	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
              // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]"));     
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]"));    
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           //-----------------------------------------------------------------------------------------------------------------------
           //-----------------------------------------------------------------------------------------------------------------------
           
           String strEndDate4 = Constant.GetDateAndformat1(7);
           String[] arrayEndDate4 = strEndDate4.split("/"); //current month
           driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[4]/div/p/span/button")).click(); //click on End date button
           if(arrayEndDate2[0].equals(arrayEndDate4[0])){
           	//System.out.println("the month is same " + arrayEndDate3[0]);
           	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]"));     
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[4]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]")); 
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           
       	dateString = "Start-Date:" + strEndDate3 + " End-Date:" + strEndDate4;
       	
    	    break;
    	    
       case 5: // Future to Empty date for MDA
       	//startDate = driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/div/p/input")).getText(); //getting value for start date        	 
           String strEndDateCase5_1 = Constant.GetDateAndformat1(0);
           String[] arrayEndDateCase5_1 = strEndDateCase5_1.split("/"); //current month
           //System.out.println("arrayEndDate Month is  " + arrayEndDate[0]);
           String strEndDateCase5_2 = Constant.GetDateAndformat1(18);
           String[] arrayEndDateCase5_2 = strEndDateCase5_2.split("/");
          // System.out.println("arrayEndDate1 Month is  " + arrayEndDate1[0]);
          driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button
           
           //Thread.sleep(200);
           
           if(arrayEndDateCase5_1[0].equals(arrayEndDateCase5_2[0])){
           	//System.out.println("the month is same " + arrayEndDateCase5_2[0]);
           	 //WebElement intEndDate = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm btn-info active']//span[contains(text(),'"+ arrayEndDate1[1] +"')]"));
           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));    
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDateCase5_2[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[2]/fieldset/div[2]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
              // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));     
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDateCase5_2[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           String strStartDateCase5_2 = "Empty";
       	dateString = "Start-Date:" + strEndDateCase5_2 + " End-Date:" + strStartDateCase5_2;
       	
    	    break;
	    
       default: 
   	dateString = "Invalid Date";
       break;
   }
   System.out.println(dateString);
   return dateString;    
}


public static String GetDateForDetached(int Iteration,WebDriver driver) throws InterruptedException {

    String dateString = null;
    String startDate = null;
    String endDate = null;
    
   switch (Iteration) {
       case 1: // present to present date for Detach
    	   
       String strEndDateCase1 = Constant.GetDateAndformat1(0);	
       
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/span/button")).click(); //click on start date button
   								 
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
       
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button")).click(); //click on End date button
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for End date
       
        dateString = "Start-Date:" + strEndDateCase1 + " End-Date:" + strEndDateCase1;
	    break;
	    
       case 2: // present to future date for Detach
  		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/span/button")).click(); //click on start date button
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
        String strEndDateDetach = Constant.GetDateAndformat1(0);
        String[] arrayEndDateDetach = strEndDateDetach.split("/"); //current month
        String strEndDate1Detach = Constant.GetDateAndformat1(7);
        String[] arrayEndDate1Detach = strEndDate1Detach.split("/");
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button")).click(); //click on End date button
                      
           if(arrayEndDateDetach[0].equals(arrayEndDate1Detach[0])){
           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate1Detach[1] +"']"));     
               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate1Detach[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	 
        	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
           	  Thread.sleep(500);
               WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate1Detach[1] +"')]"));     
               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate1Detach[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           
       	dateString = "Start-Date:" + strEndDateDetach + " End-Date:" + strEndDate1Detach;
       	
    	    break;
    	    
       case 3: // present to empty date for Detach
       	    String strEndDateCase3 = Constant.GetDateAndformat1(0);	
    		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/span/button")).click(); //click on start date button
       		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
            driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button")).click(); //click on End date button
       		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[2]/span/button[2]")).click(); //click on Clear button for End date
			endDate = "Empty";
			dateString = "Start-Date:" + strEndDateCase3 + " End-Date:" + endDate;
			break;
    	    
       case 4: // future to future date for Detach
       	    	 
           String strEndDate2 = Constant.GetDateAndformat1(0);
           String[] arrayEndDate2 = strEndDate2.split("/"); //current month
           
           String strEndDate3 = Constant.GetDateAndformat1(7);
           String[] arrayEndDate3 = strEndDate3.split("/"); //current month
   		   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/span/button")).click(); //click on start date button
           
           if(arrayEndDate2[0].equals(arrayEndDate3[0])){
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
            //List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]"));   
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();  
        	Thread.sleep(500);
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               //List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]")); 
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           //-----------------------------------------------------------------------------------------------------------------------
           //-----------------------------------------------------------------------------------------------------------------------
           
           String strEndDate4 = Constant.GetDateAndformat1(7);
           String[] arrayEndDate4 = strEndDate4.split("/"); //current month
           driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button")).click(); //click on End date button
           if(arrayEndDate2[0].equals(arrayEndDate4[0])){
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
              // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]"));  
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
    	    driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
    	    Thread.sleep(500);
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]"));   
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           
       	dateString = "Start-Date:" + strEndDate3 + " End-Date:" + strEndDate4;
       	
    	    break;
    	    
       case 5: // Future to Empty date for MDA
           String strEndDateCase5_1 = Constant.GetDateAndformat1(0);
           String[] arrayEndDateCase5_1 = strEndDateCase5_1.split("/"); //current month
           String strEndDateCase5_2 = Constant.GetDateAndformat1(18);
           String[] arrayEndDateCase5_2 = strEndDateCase5_2.split("/");
   		   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/span/button")).click(); //click on start date button
                      
           if(arrayEndDateCase5_1[0].equals(arrayEndDateCase5_2[0])){           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));     
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDateCase5_2[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
           	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
            //   List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));    
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDateCase5_2[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           String strStartDateCase5_2 = "Empty";
           driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/span/button")).click(); //click on End date button
      	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[4]/div/p/ul/li[2]/span/button[2]")).click(); //click on Clear button for End date
       	dateString = "Start-Date:" + strEndDateCase5_2 + " End-Date:" + strStartDateCase5_2;
       	
    	    break;
	    
       default: 
   	dateString = "Invalid Date";
       break;
   }
   System.out.println(dateString);
   return dateString;    
}


public static String GetDateForSpecialPosition(int Iteration,WebDriver driver) throws InterruptedException {

    String dateString = null;
    String startDate = null;
    String endDate = null;
    
   switch (Iteration) {
       case 1: // present to present date for Special Position
    	   
       String strEndDateCase1 = Constant.GetDateAndformat1(0);	
       
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button   								 
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
     
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/span/button")).click(); //click on End date button
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for End date
       
        dateString = "Start-Date:" + strEndDateCase1 + " End-Date:" + strEndDateCase1;
	    break;
	    
       case 2: // present to future date for Special Position
  		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button   								 
   		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
        String strEndDateDetach = Constant.GetDateAndformat1(0);
        String[] arrayEndDateDetach = strEndDateDetach.split("/"); //current month
        String strEndDate1Detach = Constant.GetDateAndformat1(7);
        String[] arrayEndDate1Detach = strEndDate1Detach.split("/");
        driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/span/button")).click(); //click on End date button
                      
           if(arrayEndDateDetach[0].equals(arrayEndDate1Detach[0])){
           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate1Detach[1] +"']"));     
               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate1Detach[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	 
        	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
        	                               
           	  Thread.sleep(500);
               WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate1Detach[1] +"')]"));     
               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate1Detach[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           
       	dateString = "Start-Date:" + strEndDateDetach + " End-Date:" + strEndDate1Detach;
       	
    	    break;
    	    
       case 3: // present to empty date for Special Position
       	    String strEndDateCase3 = Constant.GetDateAndformat1(0);	
       	    driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button   								 
    		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/ul/li[2]/span/button[1]")).click(); //click on today button for start date
            driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/span/button")).click(); //click on End date button
       		driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/ul/li[2]/span/button[2]")).click(); //click on Clear button for End date
			endDate = "Empty";
			dateString = "Start-Date:" + strEndDateCase3 + " End-Date:" + endDate;
			break;
    	    
       case 4: // future to future date for Special Position
       	    	 
           String strEndDate2 = Constant.GetDateAndformat1(0);
           String[] arrayEndDate2 = strEndDate2.split("/"); //current month
           
           String strEndDate3 = Constant.GetDateAndformat1(7);
           String[] arrayEndDate3 = strEndDate3.split("/"); //current month
      	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button   								 
           
           if(arrayEndDate2[0].equals(arrayEndDate3[0])){
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
            //List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]"));   
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
        	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();  
        	Thread.sleep(500);
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
               //List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate3[1] +"')]")); 
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate3[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           //-----------------------------------------------------------------------------------------------------------------------
           //-----------------------------------------------------------------------------------------------------------------------
           
           String strEndDate4 = Constant.GetDateAndformat1(7);
           String[] arrayEndDate4 = strEndDate4.split("/"); //current month
           driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/span/button")).click(); //click on End date button
           if(arrayEndDate2[0].equals(arrayEndDate4[0])){
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
              // List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]"));  
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
    	    driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();
    	    Thread.sleep(500);
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDate4[1] +"')]"));   
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDate4[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDate3[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           
       	dateString = "Start-Date:" + strEndDate3 + " End-Date:" + strEndDate4;
       	
    	    break;
    	    
       case 5: // Future to Empty date for Special Position
           String strEndDateCase5_1 = Constant.GetDateAndformat1(0);
           String[] arrayEndDateCase5_1 = strEndDateCase5_1.split("/"); //current month
           String strEndDateCase5_2 = Constant.GetDateAndformat1(18);
           String[] arrayEndDateCase5_2 = strEndDateCase5_2.split("/");
      	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/span/button")).click(); //click on start date button   								 
                      
           if(arrayEndDateCase5_1[0].equals(arrayEndDateCase5_2[0])){           	
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
             //  List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));     
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDateCase5_2[1]))
                  {
                     cell.click();
                     break;
                  }
               }
   			 
           } else {
           	driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[2]/div/p/ul/li[1]/div/table/thead/tr[1]/th[3]/button/i")).click();  
           	WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,'datepicker')]"));  
            //   List<WebElement> columns=dateWidget.findElements(By.xpath("//span[contains(text(),'"+ arrayEndDateCase5_2[1] +"')]"));    
            List<WebElement> columns=dateWidget.findElements(By.xpath("//span[@class='ng-binding' and text()='"+ arrayEndDateCase5_2[1] +"']"));     

               
               //comparing the text of cell with future date and clicking it.
               for (WebElement cell : columns)
               {
                  if (cell.getText().equals(arrayEndDateCase5_2[1]))
                  {
                     cell.click();
                     break;
                  }
               }

           }
           String strStartDateCase5_2 = "Empty";
           driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/span/button")).click(); //click on End date button
      	   driver.findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/fieldset/div[3]/div/p/ul/li[2]/span/button[2]")).click(); //click on Clear button for End date
       	dateString = "Start-Date:" + strEndDateCase5_2 + " End-Date:" + strStartDateCase5_2;
       	
    	    break;
	    
       default: 
   	dateString = "Invalid Date";
       break;
   }
   System.out.println(dateString);
   return dateString;    
}

public static int GetAllShiftCount(String[] innertext)
	{
 	 int i = 0;
		 for (String Shift : innertext) {
			 
			 if(Shift.contains("-")){
				i++;
			 }
			 
			
		}
		return i;
	}
 
 public static List<String> GetAllShiftNames(String[] innertext)
	{
 	
  	
 	List<String> shiftNames = new ArrayList<String>(); ;
		 for (String Shift : innertext) {
			 
			 if(Shift.contains("-")){
				if(Shift.length() <= 9){
				System.out.println("Shift " + Shift );
				shiftNames.add(Shift);
			 	}
			 }
			 
			
		}
		return shiftNames;
	}
 
 
 
 
 public static String GetDateForMinervaSpecialPosition(int Iteration,WebDriver driver) throws InterruptedException {

	    String dateString = null;
	    String startDate = null;
	    String endDate = null;
	    
	   switch (Iteration) {
	       case 1: // present to present date for Special Position
	    	   
	        String strEndDateCase1 = Constant.GetNewDateAndformat(0);		     
	        driver.findElement(By.id("startDate")).sendKeys(strEndDateCase1); //enter start date
      	    driver.findElement(By.id("endDate")).sendKeys(strEndDateCase1);  //enter end date
	       
	        dateString = "Start-Date:" + strEndDateCase1 + " End-Date:" + strEndDateCase1;
		    break;
		    
	       case 2: // present to future date for Special Position
	        String strEndDateDetach = Constant.GetNewDateAndformat(0);
	        String strEndDate1Detach = Constant.GetNewDateAndformat(7);
	        driver.findElement(By.id("startDate")).sendKeys(strEndDateDetach); //enter start date
      	    driver.findElement(By.id("endDate")).sendKeys(strEndDate1Detach);  //enter end date              
	        	           
	       	dateString = "Start-Date:" + strEndDateDetach + " End-Date:" + strEndDate1Detach;
	       	
	    	break;
	    	    
	       case 3: // present to empty date for Special Position
	       	    String strEndDateCase3 = Constant.GetNewDateAndformat(0);	
	       	    
	       	    driver.findElement(By.id("startDate")).sendKeys(strEndDateCase3); //enter start date
	      	    //driver.findElement(By.id("endDate")).sendKeys();  //enter end date
				dateString = "Start-Date:" + strEndDateCase3 + " End-Date is empty";
				break;
	    	    
	       case 4: // future to future date for Special Position
	       	    	 
	           String strEndDate2 = Constant.GetNewDateAndformat(7);	           
	           String strEndDate3 = Constant.GetNewDateAndformat(7);
	           
	           driver.findElement(By.id("startDate")).sendKeys(strEndDate2); //enter start date
	      	   driver.findElement(By.id("endDate")).sendKeys(strEndDate3);  //enter end date 
	           
	           dateString = "Start-Date:" + strEndDate2 + " End-Date:" + strEndDate3;
	       	
	    	    break;
	    	    
	       case 5: // Future to Empty date for Special Position
	           String strEndDateCase5_1 = Constant.GetNewDateAndformat(2);
	           driver.findElement(By.id("startDate")).sendKeys(strEndDateCase5_1); //enter start date
	      	   //driver.findElement(By.id("endDate")).sendKeys(strEndDate3);  //enter end date 
	           
	           dateString = "Start-Date:" + strEndDateCase5_1 + " End-Date is empty";

	           
	   }
	   System.out.println(dateString);
	   return dateString;    
	}


}//end of constant class 

