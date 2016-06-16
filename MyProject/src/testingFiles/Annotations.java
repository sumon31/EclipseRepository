package testingFiles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;



public class Annotations {

	@BeforeMethod
	public void UseridGeneration()
	{
		System.out.println("This block executes before each test");
	}
	
	@BeforeTest	
	public void Cookies()
	
	{
		System.out.println("This block executes before all  Testcases");		
		//delete cookies
	}
	
	@AfterTest
	public void CookiesClose()
	
	{
		System.out.println("This block executes after all Testcases");	
		//close the browsers
	}
	
		
	
	@AfterMethod
	public void Reportadding()
	{
		System.out.println("This block executes after each Test");
	}
	
	
	@Test
	public void OpeningBrowser()
	
	{
		System.out.println("Executing Test 2");		
	}
		
	@Test
	public void FlightBooking()
	{
		System.out.println("Executing Test 1");
	}


			
	
}

