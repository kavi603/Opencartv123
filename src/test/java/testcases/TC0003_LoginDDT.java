package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

public class TC0003_LoginDDT extends BaseClass {

	@Test  (dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadrivan")
  public void verify_loginDDT(String email, String pwd, String exp)
  {
	logger.info("*****starting TC0003_LoginDDT*****");
	try
	{
	
	Homepage hp=new Homepage(driver);
	  hp.clickMyAccount();
	  hp.clicklogin();
	  
	  
	 LoginPage lp = new LoginPage(driver);
	 lp.setEmail(email);
	 lp.setPassword(pwd);
	 lp.clickLogin();
	 
	 MyAccountPage macc=new MyAccountPage(driver);
	 boolean targetPage=macc.isMyAccountPageExist();
	 
	 if(exp.equalsIgnoreCase("valid"))
	 {
		 if(targetPage==true)
		 {
			 macc.clickLogout();
              Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }
	 }
	
	 if(exp.equalsIgnoreCase("Invalid"))
	 {
		 if(targetPage==true)
		 {
			 macc.clickLogout();
			 Assert.assertTrue(false);
		 }
		 else
		 {
			 Assert.assertTrue(true);
		 }
	 }
	}catch(Exception e)
	{
	  Assert.fail();	
	}
	 
		logger.info("*****Finished TC0003_LoginDDT*****");
 
	 
	  
  }
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
}
