package testingFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {
	
	public WebDriver driver = null;
	
	@Test
	public void Login() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\skashem\\workspace\\Users\\src\\testingFiles\\datadriven.properties");
		
		prop.load(fis);
				
		System.out.println(prop.getProperty("username"));	
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
		
		if(prop.getProperty("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("chrome"))	
		{
			driver = new ChromeDriver();
		}
		
		driver.get(prop.getProperty("url"));
		
		
	}
	


}
