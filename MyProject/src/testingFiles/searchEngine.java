package testingFiles;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class searchEngine {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		  System.setProperty("webdriver.chrome.driver","C:/Users/skashem/Desktop/selenium-2.48.2/chromedriver.exe");
		  WebDriver browser = new ChromeDriver();
		  System.out.println("Started Test on Chrome");	  
		  
		 
		  
		  //array of states
//		  String[] usaStates = new String[3];
//		  usaStates[0] = "New York";
//		  usaStates[1] = "San Francisco";
//		  usaStates[2] = "Los Angeles";
		    
	        List <String> usaStates = new ArrayList <String>();
	        usaStates.add("New York");
	        usaStates.add("San Francisco");
	        usaStates.add("Los Angeles");
	        usaStates.add("Las Vegas");
	        usaStates.add("Chicago");
		  
		 // browser.get("https://www.yahoo.com/");	
		  
		  //iterating through series of states in yahoo search field
		  for(int i = 0; i <= usaStates.size() - 1; i++){
			  
//			  System.setProperty("webdriver.chrome.driver","C:/Users/skashem/Desktop/selenium-2.48.2/chromedriver.exe");
//			  WebDriver browser = new ChromeDriver();
			  
			  //Open Browser 
			  browser.get("https://www.yahoo.com/");	
			  //browser.navigate().to("https://www.yahoo.com/");
			  browser.manage().window().setPosition(new Point(1900, 0));
			  browser.manage().window().maximize();
			  Thread.sleep(1000);
			  browser.findElement(By.xpath("//*[@id='uh-search-box']")).sendKeys(usaStates.get(i));
			  browser.findElement(By.xpath("//*[@id='uh-search-button']")).click();
			  Thread.sleep(1500);
			  
			  JavascriptExecutor js = (JavascriptExecutor)browser; 
			  js.executeScript("window.scroll(0,3000)");
			  Thread.sleep(1000);
			  js.executeScript("window.scroll(0,-3000)");
			  
//			  Actions actions = new Actions(browser);
//			  actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//			  Thread.sleep(1000);
			  
			  String searchResult = browser.findElement(By.xpath("//span[contains(text(),'results')]")).getText();
			  String[] arraySearchResult = searchResult.split(" ");
			 // System.out.println("number of search result for " + usaStates[i] + " is " + arraySearchResult[0]);
			  System.out.println("number of search result for " + usaStates.get(i) + " is " + arraySearchResult[0]);
			  Thread.sleep(1500);
			  
			  
		  }
		  	  
		  	  browser.quit();
	}

}
