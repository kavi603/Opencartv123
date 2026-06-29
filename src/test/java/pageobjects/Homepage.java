package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	@FindBy(linkText="Login")
	WebElement  linkLogin;
	
	
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	
	public void clickregister()
	{
		lnkRegister.click();
	}
	
	public void clicklogin()
	{
		linkLogin.click();
	}
	
	
	
	
	
}
