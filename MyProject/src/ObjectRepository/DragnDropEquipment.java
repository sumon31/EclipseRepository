	package ObjectRepository;


	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import testingFiles.Constant;

	import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.io.IOException;
	import java.util.List;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.service.*;
	import org.openqa.selenium.support.PageFactory;

	public class DragnDropEquipment {
		
		WebDriver driver;
		
		public DragnDropEquipment(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		   public void TestScenario() throws InterruptedException, IOException, AWTException 
		  {
			   
			     
			   driver.findElement(By.xpath("//*[@id='nav']/div[2]/div[1]/div[3]/div[2]")).click(); //click on personnel menu

			   Thread.sleep(600);
			  
			   
			   //String destinationElementText = driver.findElement(By.xpath("//div[contains(@data-automation,'2300-0700') and contains(@data-automation,'Supervision') and contains(@data-automation,'District Superintendent') and contains(@data-automation,'taskno: 1')]/span[3]")).getText();
               
			   //System.out.println(destinationElementText);
			   WebElement sourceElement = driver.findElement(By.xpath("//span[contains(@class,'piece-of-equipment') and contains(text(),'25DC-034')]"));			       
			   WebElement destinationElement = driver.findElement(By.xpath("//div[contains(@data-automation,'1100-1900') and contains(@data-automation,'Supervision') and contains(@data-automation,'District Superintendent') and contains(@data-automation,'taskno: 1')]/span[3]"));
			  // WebElement destinationElement = driver.findElement(By.xpath("//span[contains(text(),'sup01')]/span[contains(text(),'E')]"));

			   Actions builder = new Actions(driver);
			    builder.keyDown(Keys.CONTROL)
			        .click(sourceElement)
			        .dragAndDrop(sourceElement, sourceElement)
			        .keyUp(Keys.CONTROL);

			        org.openqa.selenium.interactions.Action selected = builder.build();

			        selected.perform();
			   			   
			   Thread.sleep(500);

			   
			
	  }
       
}
