package testcases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.Homepage;

public class Tc001_AccountRegistrationTest  extends BaseClass{

	@Test (groups={"Regression","Master"})
  public void verfiy_account_registration()
	{
		
		logger.info("******* Starting Tc001_AccountRegistrationTest* ");
		try
		{
		
		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link* ");

		hp.clickregister();
		logger.info("clicked on my register link* ");

		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("providing customer details ");

		
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com"); // randomly generated text
		regpage.setTelephone(randomeNumber());
		
		//String password=randomAlphaNumeric();
		String password=randomeAlpaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("validating expected message ");

		
		String confmsg=  regpage.getConfirmationMsg();
	
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		logger.info("******* Finished Tc001_AccountRegistrationTest* ");
	
		
	}	
		
		
  
 
 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
