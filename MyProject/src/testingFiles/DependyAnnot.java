package testingFiles;

import java.io.IOException;

import org.testng.annotations.Test;

public class DependyAnnot extends TestBase {
	
	@Test
	public void OpeningBrowser() throws IOException
	
	{
		//This Opens the Browser
		Login();
		System.out.println("Executing opening Browser");		
	}
		
	@Test(dependsOnMethods = {"OpeningBrowser"},alwaysRun = true)
	public void FlightBooking() throws IOException
	{
		Login();
		System.out.println("Executing Flightbooking");
	}
    
	@Test(timeOut = 4500)
	public void TimeRelated()
	{
		System.out.println("wait statement");
	}
	
	
	@Test(enabled = false)
	public void Payment()
	{
		System.out.println("New Testcase");
	}

}
