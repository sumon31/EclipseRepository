package testingFiles;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class EquipDown {
	
	
	public WebDriver driver;
	 	 

	 
	   
	   @Test
	    public void FireFoxTesting() throws Exception {
			//Thread.sleep(300);
	    	driver = new FirefoxDriver();
	    	System.out.println("Started Test on FireFox");
	    	//Thread.sleep(650);
	    	TestScenario();
	        System.out.println("Completed Test on FireFox");	       
	        
	    }
		
	    @Test
	    public void ChromeTesting() throws Exception {
	    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
	    	 driver = new ChromeDriver();
			 System.out.println("Started Test on Chrome");
			 TestScenario();
	         System.out.println("Completed Test on Chrome");

	    }
	    
//	    @Test
//	    public void InternetExplorerTesting() throws Exception {
//			 //Thread.sleep(600);
//	    	 System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
//	    	 driver = new InternetExplorerDriver();
//			 System.out.println("Started Test on IE");
//			 TestScenario();         
//	         System.out.println("Completed Test on IE");
//	    }
	    
      
	   public void TestScenario() throws InterruptedException 
	  {
		  		   
		   System.out.println("Starting Execution on location " + Constant.Location + " to Down Equipment");
	         
	        //Open Browser 
	        driver.get(Constant.URL + Constant.Location + "/" + Constant.GetDateAndformat(0) + "#/"  );	
	       // driver.manage().window().maximize();
	        driver.manage().window().setPosition(new Point(1900, 0));
	        driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        //Log In
	       driver.findElement(By.xpath("//*[@id='username']")).sendKeys(Constant.UserName);
	       driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Constant.Password);
	       driver.findElement(By.xpath("//*[@id='Login']")).click();
	       
	       //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	       Thread.sleep(5000);    
	       
		  driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[3]/div[2]")).click(); //click on Personnel menu
		  driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[4]/div[2]")).click(); //click on tasks menu
		  
		  Thread.sleep(600);
		  
		  String equipInnertext =  driver.findElement(By.xpath("//*[@id='equipRearLoaders']/div[2]/div")).getText();
		  
		  //driver.manage().window().setPosition(new Point(-1900, 0));
		 
		  String[] Innertext = equipInnertext.split("\n");
		 
		  int i = Constant.GetAllEquipmentCount(Innertext);
		  
		 
		  
		//@SuppressWarnings("unchecked")
		  List<String> equpNames = Constant.GetAllEquipmentNames(Innertext);
		
         Random rn = new Random();
         int randomEqup = rn.nextInt(i)-1;
        
        System.out.println("number of total equipment in RearLoaders Category is " + i);
        System.out.println("Equipment to down is " + equpNames.get(randomEqup));
        
        driver.findElement(By.xpath("//span[contains(@class,'piece-of-equipment') and contains(text(),'"+ equpNames.get(randomEqup) +"')]")).click();
        driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/button[2]")).click(); //click on action drop down
        driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/ul/li[5]")).click(); //clicking on Down action
        
        Thread.sleep(2000);
         
        //click and enter a down code 1 from drop down
        driver.findElement(By.xpath("//*[@id='s2id_downCode1']")).click(); 
		 String downCodesInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
		 String[] arrayDownCodeInnertext = downCodesInnertext.split("\n");
		 //System.out.println("Down code " + arrayDownCodeInnertext[0]);		
		// @SuppressWarnings("unchecked")
		 List<String> downCodes = Constant.GetAllDropDowns(arrayDownCodeInnertext);
		 //System.out.println("Down code " + downCodes.get(0));
		 int j = Constant.GetAllDropDownCount(arrayDownCodeInnertext);
		 int randomDownCode = rn.nextInt(j)-1;
		 System.out.println("Down code selected for down code 1 is " + downCodes.get(randomDownCode));
		 driver.findElement(By.xpath("//*[@id='s2id_autogen1_search']")).sendKeys(downCodes.get(randomDownCode));
		 driver.findElement(By.xpath("//*[@id='select2-results-1']/li[1]")).click();
		
		 //click and enter a Repair Location from drop down
        driver.findElement(By.xpath("//*[@id='s2id_repairLocation1']")).click(); 
		 String repairLocationInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
		 String[] arrayRepairLocation = repairLocationInnertext.split("\n");
		// @SuppressWarnings("unchecked")
		 List<String> repairLocation = Constant.GetAllDropDowns(arrayRepairLocation);
		 //System.out.println("Down code " + repairLocation.get(0));
		 int k = Constant.GetAllDropDownCount(arrayRepairLocation);
		 int randomRepairLocation = rn.nextInt(k)-1;
		 System.out.println("Repair Location selected for down code 1 is " + repairLocation.get(randomRepairLocation));
		 driver.findElement(By.xpath("//*[@id='s2id_autogen2_search']")).sendKeys(repairLocation.get(randomRepairLocation));
		 driver.findElement(By.xpath("//*[@id='select2-results-2']/li[1]")).click();
		 
		 
		//Enter Reporter
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset[1]/div[2]/div[1]/input")).sendKeys("Reporter1");
		//Enter Mechanic
		driver.findElement(By.xpath("//*[@id='modal']/div[2]/fieldset[1]/div[2]/div[2]/input")).sendKeys("Mechanic1");
		
		Thread.sleep(300);
		
		driver.close();
		
	  }
	  
      
}
