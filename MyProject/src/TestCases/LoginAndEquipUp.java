package TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.OpsBoardLogin;
import testingFiles.Constant;

public class LoginAndEquipUp {
	//private static final LoginApplication ObjectRepository = null;
	//public static WebDriver driver;
	
	
	@Test
	public void LoginAndEquipDownChrome() throws InterruptedException, IOException
	
	{
		 System.out.println("Started Testing using Chrome Browser");
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
     	 //open chrome browser and ops-board url
		 WebDriver driver = new ChromeDriver();
		 //WebDriver driver = new FirefoxDriver();
//    	 driver.get(Constant.URL + Constant.Location + "/" + Constant.GetDateAndformat(0) + "#/"  );	
//    	 driver.manage().window().setPosition(new Point(1900, 0));
//    	 driver.manage().window().maximize();
//    	 //log in
//    	 OpsBoardLogin ops = new OpsBoardLogin(driver);
//    	 ops.opsBoardId().sendKeys(Constant.UserName);
//    	 ops.Password().sendKeys(Constant.Password);
//    	 ops.Submit().click();
//    	 Thread.sleep(5000);
		 
		 //select board
		 ObjectRepository.SelectBoardLogInProcess loginSelectBoard = new ObjectRepository.SelectBoardLogInProcess(driver);
		 loginSelectBoard.LoginTestScenario();
		 
    	 Thread.sleep(7000);	
          
    	 //set equipment up
	      ObjectRepository.equipUp opsUp = new ObjectRepository.equipUp(driver);
	      opsUp.TestScenario();
          
	      System.out.println("End of Testing using Chrome Browser");
	}	
	
	
	
	
//	@Test
//	public void LoginAndEquipDownFireFox() throws InterruptedException, IOException
//	
//	{
//    	 System.out.println("Started Testing using FireFox Browser");
//    	 
//		 //open firefox browser and ops-board url
//		 WebDriver driver = new FirefoxDriver();
//    	 driver.get(Constant.URL + Constant.Location + "/" + Constant.GetDateAndformat(0) + "#/"  );	
//    	 
//    	 //log in
//    	 OpsBoardLogin ops = new OpsBoardLogin(driver);
//    	 ops.opsBoardId().sendKeys(Constant.UserName);
//    	 ops.Password().sendKeys(Constant.Password);
//    	 ops.Submit().click();
//    	 Thread.sleep(5000);	 
//          
//    	 //set equipment up
//	      ObjectRepository.equipUp opsUp = new ObjectRepository.equipUp(driver);
//	      opsUp.TestScenario();
//	      
//	      System.out.println("End of Testing using FireFox Browser");
//          
//	}	

}

