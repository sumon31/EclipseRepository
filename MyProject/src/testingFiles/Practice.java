package testingFiles;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice {
	
		public static void main(String[] args) throws IOException, InterruptedException {
		   
		  WebDriver driver;
		  
		  String workUnit = "Staten Island Boro";
		  String workLocation = "Staten Island Dist 1";
		
		  System.setProperty("webdriver.chrome.driver","C:/Users/skashem/Desktop/selenium-2.48.2/chromedriver.exe");
		  driver = new ChromeDriver();
		  System.out.println("Started Test on Chrome");	         
		  //Open Browser 
		  driver.get(Constant.URL);	
		  driver.manage().window().setPosition(new Point(1900, 0));
		  driver.manage().window().maximize();
		        
          //Log In
          driver.findElement(By.xpath("//*[@id='username']")).sendKeys(Constant.UserName);
          driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Constant.Password);
          driver.findElement(By.xpath("//*[@id='Login']")).click();
          
          Thread.sleep(1000);
          
  	    
  	       //click and select a work unit
  	      driver.findElement(By.xpath("//*[@id='s2id_autogen1']/a/span[2]/b")).click();         
  	      Thread.sleep(100);          
  	      //String workUnitInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
  		  //String[] arrayWorkUnitInnertext = workUnitInnertext.split("\n");
  		  //List<String> workUnitName = Constant.GetAllDropDowns(arrayWorkUnitInnertext);
  		  //int j1 = Constant.GetAllDropDownCount(arrayWorkUnitInnertext);
  		  //Random rn = new Random();
  		  //int randomWorkUnit = rn.nextInt(j1);
  		  //System.out.println("Work Unit selected is " + workUnitName.get(randomWorkUnit));	      
  		  System.out.println("Work Unit selected is " + workUnit);
  		  List <WebElement> a = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
  		  Actions actions = new Actions(driver);
  		  actions.moveToElement(a.get(0));
  		  actions.click();
  		  //actions.sendKeys(workUnitName.get(randomWorkUnit)).perform();
  		  actions.sendKeys("Staten Island Boro").perform();
  		  Thread.sleep(100);
  		  driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li")).click();
  	    
  		  
  		  //click and select a location
  	      driver.findElement(By.xpath("//*[@id='s2id_autogen3']/a/span[2]/b")).click();                   
  	      Thread.sleep(100);          
  	      //String locationInnertext =  driver.findElement(By.xpath("//div[@id='select2-drop']")).getText();	 
  		  //String[] arrayLocationInnertext = locationInnertext.split("\n");
  		  //List<String> locationName = Constant.GetAllDropDowns(arrayLocationInnertext);
  		  //int j2 = Constant.GetAllDropDownCount(arrayLocationInnertext);
  		  //int randomLocation = rn.nextInt(j2);
  		 // System.out.println("Location selected is " + locationName.get(randomLocation));
  	     
  		  System.out.println("Location selected is " + workLocation);
  		  List <WebElement> b = driver.findElements(By.xpath("//input[contains(@id,'s2id_autogen') and contains(@id,'search')]"));
  		  actions.moveToElement(b.get(0));
  		  actions.click();
  		  //actions.sendKeys(locationName.get(randomLocation)).perform();
  		  actions.sendKeys("Staten Island Dist 1").perform();
  		  Thread.sleep(100);
  		  driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li")).click();
  	    
  		  Thread.sleep(100);
  	    
  	    //click on select board button 
  		  driver.findElement(By.xpath("//*[@id='selectBoard']/div[4]/button")).click();
          
  		  Thread.sleep(7000);
  		  
  		  driver.findElement(By.xpath("//*[contains(text(),'20AY-407')]")).click();
  		  //Thread.sleep(200);
  		  //driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/button[2]")).click();
  		  driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/button[1]")).click();
  		  //Thread.sleep(200);
  		  driver.findElement(By.xpath("//li[contains(@ng-click,'detachEquipment')]")).click();
  		 //driver.findElement(By.xpath("//li[contains(@ng-click,'downEquipment')]")).click();
  		  
	   }

}
