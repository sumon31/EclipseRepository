package testingFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class USPS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		
		List <String> mailNShipLinks = new java.util.ArrayList <String> ();
		mailNShipLinks.add("Calculate a Price");
		mailNShipLinks.add("Order Stamps & Supplies");
		mailNShipLinks.add("Click-N-Ship");
	    
		for(int i = 0; i <= mailNShipLinks.size() -1; i++) {
			
				System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
				System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\iedriver.exe");

				//WebDriver browser = new ChromeDriver();
				WebDriver browser = new InternetExplorerDriver();
				//WebDriver browser = new FirefoxDriver();
				
				browser.get("https://www.usps.com/");
				browser.manage().window().maximize();
				
				Thread.sleep(2500);	
				// Actions method can be created to perform mouse hover and click on a dropdown element 
				Actions mouseHover = new Actions(browser);		
				WebElement tab1 = browser.findElement(By.xpath("//*[contains(text(),'Mail & Ship')]"));
				mouseHover.moveToElement(tab1).perform();
				
				
				///html/body
				Thread.sleep(2000);
				//*[@id="ctl00_Image1"]
				//*[@id="logo--main"]
				//List <WebElement> myElements = browser.findElements(By.xpath("//*[contains(@class,'menu--tier-two-link')]"));
				//mouseHover.moveToElement(myElements.get(0));
				//String calculateAPriceLink = "Calculate a Price";
				//mouseHover.click().perform();
				//mouseHover.sendKeys(""+ mailNShipLinks.get(i) +"").click().perform();
				
				//lines below allows you to check if an element exist on a page using boolean which will define if element is true or false. size refers to element being greater then 0 which means if it exist
				Boolean linkName1 = browser.findElements(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'slow')]")).size() > 0;
				Boolean linkName2 = browser.findElements(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'down')]")).size() > 0;
				//System.out.println(" is it present " + isPresent);
				
				if(linkName1 == true){
					
					browser.findElement(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'slow')]")).click();
					
				} else if(linkName2 == true) {
					
					browser.findElement(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'down')]")).click();
				
				}else {
					browser.findElement(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'"+ mailNShipLinks.get(i) +"')]")).click();
				}
				
				
				Thread.sleep(6000);
				
				// if condition allows you to check if an element or value exist within a page. if it does exist then do something 
				if(browser.findElement(By.xpath("/html/body")).isDisplayed()){
					
					System.out.println(mailNShipLinks.get(i) + " Page loaded successfully");
				}
				browser.close();
		}
	}

}