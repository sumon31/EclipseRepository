package ObjectRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class updateLoad {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Started Testing using Chrome Browser");
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
    	 //open chrome browser and ops-board url
		 WebDriver driver = new ChromeDriver();
		 
		 //select board
		 ObjectRepository.SelectBoardLogInProcess loginSelectBoard = new ObjectRepository.SelectBoardLogInProcess(driver);
		 loginSelectBoard.LoginTestScenario();
		 
    	 Thread.sleep(7000);	
    	 
    	 driver.findElement(By.xpath("//*[contains(text(),'25DC-034')]")).click(); //click on an available equipment from available category
    	 driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/button[1]")).click(); //click on action drop down
    	 //Thread.sleep(1000);
    	 driver.findElement(By.xpath("//*[@id='screen1Pane2']/div[2]/div[1]/div/div/span[3]/div/ul/li[1]")).click(); //click on Update Load button
    	 
    	 Thread.sleep(2000);
    	 
    	 //driver.findElement(By.xpath("//*[@id='s2id_loadStatus1']/a")).click();
    	 //driver.findElement(By.xpath("//*[@id='s2id_loadStatus1']/a/span[2]/b")).click();
    	 
		  List <WebElement> a = driver.findElements(By.xpath("//span[contains(@class,'select2-arrow')]")); // i clicked on drop down icon to the right and its under span with class select2arrow both dropdowns are same
		  Actions actions = new Actions(driver);
		  actions.moveToElement(a.get(0)); //o for new status drop down and 1 for material drop down 
		  actions.click();
		  actions.perform();
		  
		  //Thread.sleep(400);
		  
		  driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[2]")).click();
		  
		  Thread.sleep(1000);
		  
		  actions.moveToElement(a.get(1)); //o for new status drop down and 1 for material drop down 
		  actions.click();
		  actions.perform(); 
		  
		  driver.findElement(By.xpath("//*[contains(@id,'select2-results-')]/li[1]")).click();

	}

}
