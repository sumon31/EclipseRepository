package TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.OpsBoardLogin;
import testingFiles.Constant;

public class LoginAndDragnDropEquipment {
	
	@Test
	public void LoginAndEquipDownChrome() throws InterruptedException, IOException, AWTException
	
	{
		 System.out.println("Started Testing using Chrome Browser");
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
     	 //open chrome browser and ops-board url
		 WebDriver driver = new ChromeDriver();
		 //WebDriver driver = new FirefoxDriver();
		 
		 //select board
		 ObjectRepository.SelectBoardLogInProcess loginSelectBoard = new ObjectRepository.SelectBoardLogInProcess(driver);
		 loginSelectBoard.LoginTestScenario();
		 
    	 Thread.sleep(7000);
         
    	 //set equipment up
	      ObjectRepository.DragnDropEquipment opsDragnDrop = new ObjectRepository.DragnDropEquipment(driver);
	      opsDragnDrop.TestScenario();
    	 
	      System.out.println("End of Testing using Chrome Browser");
	}	

}
