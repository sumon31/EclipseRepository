package testingFiles;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Praice2016 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
 		
//		  ArrayList <String> zipcode = new ArrayList<String>();
//		
//		
//			  zipcode.add ( "11218" );             
//			  zipcode.add ( "11219");
//			  zipcode.add ( "11210");
//		      
//		      System.out.print(zipcode.get(0) + " " + zipcode.get(1));
		      
		      
		      
		      String[] zipCode = new String[4];
		      
		      zipCode[0] = "11218";
		      zipCode[1] = "11219";
		      zipCode[2] = "11210";
		      zipCode[3] = "11211";
		      
//		      System.out.print("zipcode is " + zipCode[0] + " zipcode is " + zipCode[1]);
//		      
//		      int[] number = {1, 2, 3, 4, 5};
//		      
//		      String[] fruitName = {"Apple", "Orange", "Banana", "Pineapple", "Srawberry"};
//		      
//		      System.out.print(" number is " + number[0] + " number is " + number[1]);
//		      
//		      System.out.print(" fruit name is " + fruitName[0] + " fruit name is " + fruitName[1]);
		      
		      System.setProperty("webdriver.chrome.driver","C:\\Users\\skashem\\Desktop\\selenium-2.48.2\\chromedriver.exe");
		      
		      WebDriver driver = new ChromeDriver();
		      
		     		     		      
		      driver.get("https://www.google.com");
		      
		      for(int i = 0;i < zipCode.length; i++)
		      {

		    	  
			      Thread.sleep(500);
			      
			      driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(zipCode[i]);
			      Thread.sleep(500);
			      driver.findElement(By.xpath("//*[@id='sblsbb']/button/span")).click();
			      Thread.sleep(600);
			      
			      String searchResult = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
			      String[] arraySearchResult = searchResult.split(" ");
			      System.out.print("search result number for zip code " + zipCode[i] + " is " + arraySearchResult[1] + " ");
			      
			      Thread.sleep(500);
			      
			      driver.navigate().to("https://www.google.com");
			      
		      }
		    
                 driver.close();
                 
	}

}
