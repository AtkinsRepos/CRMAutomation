package com.crmAutomation.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.pageObjects.HomePage;
import com.crmAutomation.pageObjects.LoginPage;
import com.crmAutomation.util.TestUtil;

public class LoginTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;

	public LoginTest() {
		super();

	}
   @BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
	}

	
	@Test(priority = 1)
	public void LoginToApplication() throws Throwable {
		logger.info("Login To Application method started running");
		test=extent.createTest("LoginToApplication");
		loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("username and password entered and submited");
		Thread.sleep(5000);
		logger.info("LoginToApplication method ended*********************");
		logger.info("Login PASSED");
		
	}
	
	@Test(priority = 2)
	public void verifyHomepageTitleTest() {
		logger.info("verify Homepage Title Test started and running********************");
		test=extent.createTest("verifyHomepageTitleTest");
		String title = loginpage.verifyHomepageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		//CRMPRO - CRM software for customer relationship management, sales, and support.
		logger.info("Verify Homepage Title Test completed********************");
	}
	@Test(priority = 3)
	public void validatecurrentUrlTest() {
		logger.info("Validate current Url Test started and running********************");
		test=extent.createTest("validatecurrentUrlTest");
		String CurrentUrl = loginpage.ValidateCurrentUrl();
		Assert.assertEquals(CurrentUrl, "https://classic.crmpro.com/index.html", "current URL Not matched");
		logger.info("Validate current Url Test completed********************");
// also consider using Assertion with log4j to get pass or fail info log
		/*
		 
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login Passed");//logger msg
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");//logger msg
		}

		 */
	}

//	@Test(priority = 4)
//	public void VerifyCRMlogoTest() {
//		
//		boolean flag = loginpage.validateCRMlogoImage();
//		Assert.assertTrue(flag);
//	}

	

	

//	@AfterMethod
//	public void teardownTest() {
//		
//}
	@AfterMethod
	public void tearDown() {
		driver.close();	
	}
}
