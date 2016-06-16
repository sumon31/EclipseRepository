package testingFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class mortgageCalc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sumon\\Documents\\selenium-2.53.0\\chromedriver.exe");

	    //WebDriver driver = new ChromeDriver();
	    WebDriver driver = new FirefoxDriver();

	    
	    driver.get("http://www.mortgagecalculator.org/"); // going to that url
	    driver.manage().window().maximize(); // maximizing chrome browser window
	    Thread.sleep(2000);
	    
	    //JavascriptExecutor command allows you to scroll down on a page
	    //line below allows you to use javascriptexecutor command on the browser you are using
	    // to scroll up/down
	    JavascriptExecutor scrolling = (JavascriptExecutor)driver;
	    //scrolling.executeScript("window.scrollBy(0,250)");*/
	    
	    WebElement element = driver.findElement(By.name("param[homevalue]"));	    
	    scrolling.executeScript("arguments[0].scrollIntoView(true);",element);
	    
	    //driver.findElement(By.xpath("//*[@name=param[homevalue]]")).sendKeys("400000");;

	    
	    //to select an element from dropdown we can use built in command called Actions 
	    //Actions selectElement = new Actions(driver);
	    
	    //select command allows you click on any dropdown long as you define the element 
	    // property and value
	    Select startMonth = new Select(driver.findElement(By.name("param[start_month]")));
	    // line below will allow you to choose the dropdown value
	    //selectByVisibleText will allow you to choose a value from the dropdown
	    startMonth.selectByVisibleText("Sep");
	    
	    //three ways you can select the value, selectBYVisibleText, selectByIndex, and
	    // selectByValue
	    
	    Thread.sleep(1200);
	    
	    //Select startYear = new Select(driver.findElement(By.name("param[start_year]")));
	    //startYear.selectByValue("2017");
	    
	    //xpath is concept off identifying an element property and value within a page 
	    // in a unique code style 
	    //xpath value always starts with two forward slashes followed by asterisk which
	    //represents the panel the value is in 
	    //driver.findElement(By.xpath("//*[@name=param[homevalue]]")).sendKeys("400000");;
	    //xpath contains is a dynamic expression which is used with xpath property and 
	    // long as a keyword within a value matches will perform an action 
	    //driver.findelement(By.xpath(//*[contains("")]))
	    driver.findElement(By.xpath("//*[contains(@name,'home')]")).clear();
	    driver.findElement(By.xpath("//*[contains(@name,'home')]")).sendKeys("400000");
        
	    driver.findElement(By.xpath("//*[contains(@value,'Calculate')]")).click();
	    Thread.sleep(2000);
	    WebElement element2 = driver.findElement(By.xpath("//*[contains(@value,'Calculate')]"));	    
	    scrolling.executeScript("arguments[0].scrollIntoView(true);",element2);
	    
	    //System.out.println(driver.findElement(By.xpath("//*[contains(@class,'repayment-block')]")).getText());
	    String monthlyPayment = driver.findElement(By.xpath("//*[contains(@class,'repayment-block')]")).getText();
	    String[] arrayMonthlyPayment = monthlyPayment.split("Monthly Payment");
	    System.out.println("my monthly payment is " + arrayMonthlyPayment[1]);

	    
	   // String monthlyPayment = driver.findElement(By.xpath("//*[@id='calc']/form/section/section[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div[1]/div[1]/h3")).getText();
	    //System.out.println("my monthly payment is " + monthlyPayment);
	    	    
	   /* Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.name("param[start_year]"))).click().perform();*/
		

	}

}
