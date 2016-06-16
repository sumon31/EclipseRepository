package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.ArrayList;
import java.util.List;

public class Hello {

	 public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//google search for city in bangladesh
		List<String> countryName = new ArrayList<String>();
		countryName.add("Bangladesh");
		countryName.add("India");
		countryName.add("Pakistan");
		countryName.add("Dubai");
		countryName.add("North America");
		countryName.add("United Kingdom");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\IEDriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("http://google.com");
		driver.manage().window().maximize();
		
		for(int i = 0; i < countryName.size(); i++){
			
			driver.navigate().to("http://google.com");	
			
			Thread.sleep(500);
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(countryName.get(i));
			
			driver.findElement(By.xpath("//*[@id='sblsbb']/button")).click();
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			
			String searchResult = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
			
			String[] arrSplit = searchResult.split(" ");
			
			System.out.println("The number of search result in " + countryName.get(i) + " is " + arrSplit[1]);
					
			
		}
			
			driver.close();
				
	}

}
