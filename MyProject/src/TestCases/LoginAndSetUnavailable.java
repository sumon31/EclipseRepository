package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

import ObjectRepository.OpsBoardLogin;
import testingFiles.Constant;

public class LoginAndSetUnavailable {
	
	
	@Test
	public void LoginAndSetPersonUnavailableChrome() throws InterruptedException, IOException
	
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
    	 Thread.sleep(7000);
		 
		 //select board
/*		 ObjectRepository.SelectBoardLogInProcess loginSelectBoard = new ObjectRepository.SelectBoardLogInProcess(driver);
		 loginSelectBoard.LoginTestScenario();*/
		 
    	 Thread.sleep(7000);	 
          
    	 //set equipment up
	      ObjectRepository.SetUnavailable opsUnavailable = new ObjectRepository.SetUnavailable(driver);
	      opsUnavailable.TestScenario();
          
	      System.out.println("End of Testing using Chrome Browser");
	 }	
	
    
}



