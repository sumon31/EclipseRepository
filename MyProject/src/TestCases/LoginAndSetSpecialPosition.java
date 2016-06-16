package TestCases;

import java.io.IOException;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.OpsBoardLogin;
import testingFiles.Constant;

public class LoginAndSetSpecialPosition {
	
	@Test
	public void LoginAndSetSpecialPositionChrome() throws InterruptedException, IOException
	
	{
		 System.out.println("Started Testing using Chrome Browser");
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
     	 //open chrome browser and ops-board url
		 WebDriver driver = new ChromeDriver();
		 //WebDriver driver = new FirefoxDriver();
    	 driver.get(Constant.URL + "SI01/" + Constant.GetDateAndformat(0) + "#/"  );	
   	     driver.manage().window().setPosition(new Point(1900, 0));
    	 driver.manage().window().maximize();
    	 //log in
    	 OpsBoardLogin ops = new OpsBoardLogin(driver);
    	 ops.opsBoardId().sendKeys(Constant.UserName);
    	 ops.Password().sendKeys(Constant.Password);
    	 ops.Submit().click(); 
		 
//		 //select board
//		 ObjectRepository.SelectBoardLogInProcess loginSelectBoard = new ObjectRepository.SelectBoardLogInProcess(driver);
//		 loginSelectBoard.LoginTestScenario();
		 
    	 Thread.sleep(13000);	 
          
    	 //set special position
	     // ObjectRepository.SetSpecialPosition opsSpecialPosition = new ObjectRepository.SetSpecialPosition(driver);
    	  ObjectRepository.setSpecialPositionMinerva opsSpecialPosition = new ObjectRepository.setSpecialPositionMinerva(driver);
	      opsSpecialPosition.TestScenario();
          
	      System.out.println("End of Testing using Chrome Browser");
	}

}
