package testingFiles;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UPS {

			public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				
				
				  System.setProperty("webdriver.chrome.driver","C:/Users/skashem/Desktop/selenium-2.48.2/chromedriver.exe");
				  WebDriver browser = new ChromeDriver();
				  System.out.println("Started Test on Chrome");	  
				  
				 
				  
				  //array of states
//				  String[] usaStates = new String[3];
//				  usaStates[0] = "New York";
//				  usaStates[1] = "San Francisco";
//				  usaStates[2] = "Los Angeles";
				    
			        List <String> usaStates = new ArrayList <String>();
			        usaStates.add("New York");
			        usaStates.add("San Francisco");
			        usaStates.add("Los Angeles");
			        usaStates.add("Las Vegas");
			        usaStates.add("Chicago");
				  
				 // browser.get("https://www.yahoo.com/");	
				  
				  //iterating through series of states in yahoo search field
				 // for(int i = 0; i <= usaStates.size() - 1; i++){
					  
//					  System.setProperty("webdriver.chrome.driver","C:/Users/skashem/Desktop/selenium-2.48.2/chromedriver.exe");
//					  WebDriver browser = new ChromeDriver();
					  
					  //Open Browser 
			          WebDriverWait wait = new WebDriverWait(browser, 5);			   		  
			   		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body"))); // home page 
			   		  			   		  
					  browser.get("https://www.usps.com");	
					  //browser.navigate().to("https://www.yahoo.com/");
					  browser.manage().window().setPosition(new Point(1900, 0));
					  browser.manage().window().maximize();
					  Thread.sleep(1000);
					  
					  WebElement strTab = browser.findElement(By.xpath("//*[@id='global-menu']/div/nav/ol/li[1]/a"));
					  Actions mouseHover = new Actions(browser); 
					  mouseHover.moveToElement(strTab).perform();
					  Thread.sleep(1000);
					  //WebElement strSelectionList = browser.findElement(By.xpath("//*[@id='global-menu']/div/nav/ol/li[1]/ol/li[1]"));
					  List <WebElement>  strSelectionList = browser.findElements(By.xpath("//*[contains(@class,'menu--tier-two-link')]"));
					  //mouseHover.moveToElement(strSelectionList).click().perform();
					  mouseHover.moveToElement(strSelectionList.get(2)).click().perform();
					  
					  
			   		  try{
			   			  
			   			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'page')]"))); 
			   			System.out.println("page loaded successfully");
			   			
			   		  } catch(Exception e) {
			   			  
			   			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'aspnetForm')]")));  
			   			System.out.println("page loaded successfully");
			   		  }
					  
			   		  //String headerText = browser.findElement(By.xpath("//*[contains(@id,'head')]")).getText();

			   		  //System.out.println("header text for the selected element is ");
					  
					  //*[@id="headcontainer"]/header
					  
				  	  
				  //	  browser.close();
			}



}
