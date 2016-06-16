package CrossBrowsers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
 
import org.testng.annotations.Parameters;
 
import org.testng.annotations.Test;
 
public class GoogleOutPut{
 
    static WebDriver driver;
 
     
 
    /**
 
     * This function will execute before each Test tag in testng.xml
 
     * @param browser
 
     * @throws Exception
 
     */
 
@BeforeTest
 
    @Parameters("browser")
 
    public void setup(String browser) throws Exception{
 
        //Check if parameter passed from TestNG is 'firefox'
 
        if(browser.equals("Firefox")){
 
        //create firefox instance
            Thread.sleep(4000);
            driver = new FirefoxDriver();
            
            
 
        }
 
        //Check if parameter passed as 'chrome'
 
        else if(browser.equals("Chrome")){
 
            //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver
 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
 
            //create chrome instance
 
            driver = new ChromeDriver();
 
        }
 
else if(browser.equals("IE")){
 
            //set path to IEdriver.exe You may need to download it from
 
     // 32 bits http://selenium-release.storage.googleapis.com/2.42/IEDriverServer_Win32_2.42.0.zip
 
     // 64 bits http://selenium-release.storage.googleapis.com/2.42/IEDriverServer_x64_2.42.0.zip
 
			System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
 
            //create chrome instance
            Thread.sleep(7000);
            driver = new InternetExplorerDriver();
 
        }
 
        else{
 
            //If no browser passed throw exception
 
            throw new Exception("Browser is not correct");
 
        }
 
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
    }
 
     
 
    @Test
 
    public void testParameterWithXML() throws InterruptedException{
 
    	//Thread.sleep(400);
    	
    	driver.get("http://google.com");
               
		//driver.manage().window().maximize();
		
		//Thread.sleep(1000);
		////*[@id="sb_ifc0"]
		driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("USA");
		//driver.findElement(By.xpath("//*[@id='sb_ifc0']")).sendKeys("USA");
		
		///driver.findElement(By.xpath("//*[@id='sblsbb']/button")).click();
		
		//driver.close();
       
    }

}