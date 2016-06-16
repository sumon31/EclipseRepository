package Basics;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.interactions.Action;
 
import org.openqa.selenium.interactions.Actions;

import ObjectRepository.OpsBoardLogin;
import testingFiles.Constant;
 
public class DragAndDrop {
 
	public static void main(String[] args) throws InterruptedException {
 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
    	 //open chrome browser and ops-board url
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //WebDriver driver = new FirefoxDriver();
	   	 driver.get(Constant.URL + Constant.Location + "/" + Constant.GetDateAndformat(0) + "#/"  );	
	   	 driver.manage().window().maximize();
	   	 //log in
	   	 OpsBoardLogin ops = new OpsBoardLogin(driver);
	   	 ops.opsBoardId().sendKeys(Constant.UserName);
	   	 ops.Password().sendKeys(Constant.Password);
	   	 ops.Submit().click();
	   	 //Thread.sleep(5000);
	   	  Thread.sleep(5000);	   	 
		    
		  WebElement From = driver.findElement(By.xpath("//span[contains(@class,'piece-of-equipment') and contains(text(),'25DC-025')]"));
		  
		  WebElement To = driver.findElement(By.xpath("//div[contains(@class,'task supervision') and contains(@data-automation,'2200-0600') and contains(@data-automation,'Supervision') and contains(@data-automation,'Executive Officer') and contains(@data-automation,'taskno: 1')]/span[3]"));
        
		  Actions actions=new Actions(driver);			
		  actions.dragAndDrop(From, To).perform();
 
	}
 
}



//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class DragAndDrop 
//{
//public static void main(String[] args) throws InterruptedException
//	{
//		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/");
//		driver.manage().window().maximize();
//		Thread.sleep(1000);
//		String xp1="//h1[text()='Block 1']";
//		WebElement source = driver.findElement(By.xpath(xp1));
//		String xp2="//h1[text()='Block 3']";
//		WebElement target = driver.findElement(By.xpath(xp2));
//		
//		
//		Actions actions=new Actions(driver);
//		actions.dragAndDrop(source, target).build().perform();
//	}
//
//}