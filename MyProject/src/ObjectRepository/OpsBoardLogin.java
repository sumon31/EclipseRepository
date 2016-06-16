package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpsBoardLogin {
	
	WebDriver driver;
	
	public OpsBoardLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='Login']")
	WebElement Login;
	
	public WebElement opsBoardId()
	{
		return username;
	}
	
	public WebElement Password()
	{
		return password;
	}
	
	public WebElement Submit()
	{
		return Login;
	}
	
    
}
