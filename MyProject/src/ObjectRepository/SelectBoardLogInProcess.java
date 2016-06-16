package ObjectRepository;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testingFiles.Constant;

public class SelectBoardLogInProcess {
WebDriver driver;
	
	public SelectBoardLogInProcess(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	  public void LoginTestScenario() throws InterruptedException, IOException 
	  {
		
//		  System.setProperty("webdriver.chrome.driver","C:/Users/skashem/Desktop/selenium-2.48.2/chromedriver.exe");
//		  driver = new ChromeDriver();
//		  System.out.println("Started Test on Chrome");	
		  
		  //String workUnit = "Staten Island Boro";
		  String workUnit = "Brooklyn South Boro";
		  //String workLocation = "Staten Island Boro";
		  String workLocation = "Brooklyn South Dist 10";
		  
		  //Open Browser 
		  driver.get(Constant.URL);	
		  driver.manage().window().setPosition(new Point(1900, 0));
		  driver.manage().window().maximize();
	    //Log In
	    driver.findElement(By.xpath("//*[@id='username']")).sendKeys(Constant.UserName);
	    driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Constant.Password);
	    driver.findElement(By.xpath("/html/body/div/form/button")).click(); 
	    
	    Thread.sleep(10000);
	    
	    //click and select a work unit
	    driver.findElement(By.xpath("//*[contains(@id,'workunit')]")).click();         
	    //driver.findElement(By.xpath("//*[contains(@id,'s2id_autogen1']/a/span[2]/b")).click();         
	      
		  //new Select(driver.findElement(By.id("workunit"))).selectByVisibleText(workUnit);
		  
		  List <WebElement> a = driver.findElements(By.xpath("//*[contains(@id,'workunit')]"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(a.get(0));
		  actions.sendKeys(workUnit).click().perform();
		  //Thread.sleep(100);
		  //driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li")).click();
		  
	      
		 // Thread.sleep(1000);
		  
		  //click and select a location
		      driver.findElement(By.xpath("//*[contains(@id,'location')]")).click();         
	     
		      System.out.println("Location selected is " + workLocation);
			  List <WebElement> b = driver.findElements(By.xpath("//*[contains(@id,'location')]"));
			  actions.moveToElement(b.get(0));
			  actions.sendKeys(workLocation).click().perform();

		  
		  Thread.sleep(300);
	      
	    //click on select board button 
		  driver.findElement(By.xpath("//*[contains(@value,'Continue')]")).click();
		  //driver.findElement(By.xpath("//*[@id='selectBoard']/div[4]/button")).click();

	}
}
