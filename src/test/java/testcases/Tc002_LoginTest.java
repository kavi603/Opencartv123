package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class Tc002_LoginTest extends BaseClass{

	
	
	@Test(groups={"sanity","Master"})
public void verify_login()
{
	logger.info("*******starting Tc0002_LoginTest");
try
{
	Homepage hp = new Homepage(driver);
	hp.clickMyAccount();
	hp.clicklogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));		
	lp.clickLogin();
			
	//my account page
	
	MyAccountPage macc=new MyAccountPage(driver);
boolean	targetpage=macc.isMyAccountPageExist();
  Assert.assertEquals(targetpage, true,"Login failed");	
}
catch(Exception e)
{
	Assert.fail();
}
  
  
  logger.info("********* finished Tc_002_LoginTest*****");

   















	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
}
