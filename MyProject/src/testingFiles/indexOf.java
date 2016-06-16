package testingFiles;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class indexOf {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		List <String> mailNShipLinks = new java.util.ArrayList <String> ();
		mailNShipLinks.add("Calculate a Price");
		mailNShipLinks.add("Order Stamps & Supplies");
		mailNShipLinks.add("Click-N-Ship");		
		
		for(int i = 0; i <= mailNShipLinks.size() -1; i++){
			
			WebDriver browser = new FirefoxDriver();
			browser.get("https://www.usps.com/");
			browser.manage().window().maximize();
			
			Thread.sleep(2400);
			
			// Actions method can be created to perform mouse hover and click on a dropdown element 
			Actions mouseHover = new Actions(browser);		
			WebElement tab1 = browser.findElement(By.xpath("//*[contains(text(),'Mail & Ship')]"));
			mouseHover.moveToElement(tab1).perform();
			
			Thread.sleep(2600);

				if(browser.findElement(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'"+ mailNShipLinks.get(i) +"')]")).isEnabled()){
					System.out.print("Link name is " + mailNShipLinks.get(i) + "  ");
					//line below allows you to click on a link from Mail & Ship tab by passing on array variable with iteration 'i' during each executioin 
					browser.findElement(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'"+ mailNShipLinks.get(i) +"')]")).click();
				}
				
			//}
			
			
			/*try{
				if(mailNShipLinks.get(i) == "Click-N-Ship"){
					System.out.print("Link name is " + mailNShipLinks.get(i));
					//line below allows you to click on a link from Mail & Ship tab by passing on array variable with iteration 'i' during each executioin 
					browser.findElement(By.xpath("//*[contains(@class,'menu--tier-two-link') and contains(text(),'"+ mailNShipLinks.get(i) +"') and contains()]")).click();
				}
			}catch(Exception e){
					System.out.print("no link name appeared");
			}*/
			
			

			
			browser.close();
			
			
		}// end of for loop
		
	
				
	}

}
