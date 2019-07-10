package com.crmAutomation.testScripts;

import java.util.List;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.pageObjects.SignUpPage;
import com.crmAutomation.util.AssertionHelper;
import com.crmAutomation.util.DataProviderTesting;
import com.crmAutomation.util.TestUtil;
import com.crmAutomation.util.XLUtils;

public class InValidSignUpCredentials extends TestBase {

	TestUtil testutil;
	SignUpPage signuppage;

	  XLUtils utils=new XLUtils();
	public InValidSignUpCredentials() {
		super();

	}

	@BeforeMethod
	public void setup() {
		signuppage = new SignUpPage(driver);
		initialization();
		testutil = new TestUtil();
	}

	
	//re-ordering the excel sheet to create constants of variable columns. Worked like a cham
	//	below is a working code

@Test(priority = 1, dataProvider = "test", dataProviderClass = DataProviderTesting.class)
public void signUpWithINvalidCredentialsTest(List testarray) throws Exception {
	String flag="FAIL";
	try {
	signuppage = new SignUpPage(driver);
	System.out.println(testarray);
	logger.info("SignUpPageTest Test started and running");
	Thread.sleep(5000);
	signuppage.clickonSignUpLink();
	signuppage.selectCRMEdition(testarray.get(5).toString());
signuppage.setFirstName(testarray.get(6).toString());
	signuppage.setLastName(testarray.get(7).toString());
	signuppage.setEmailNormal(testarray.get(8).toString());
	signuppage.setConfirmemailNormal(testarray.get(9).toString());
	signuppage.setUsernameNormal(testarray.get(10).toString());
	signuppage.setpassword(testarray.get(11).toString());
	signuppage.setConfirmPassword(testarray.get(12).toString());
	signuppage.clickOnagreementBox();
	signuppage.clickOnsubmitButton();
	String ActResult = AssertionHelper.validateTextPresentOnElement(driver, "xpath","//small[contains(.,'"+testarray.get(2).toString()+"')]");
	
 
    if(ActResult.equals(testarray.get(2).toString()))
    {
    	
    	flag="PASS";
    	System.out.println(flag);
    	 utils.updateResult("Test.xlsx", "INvalidSignUp", testarray.get(1).toString(), flag, 4);
         utils.updateResult("Test.xlsx", "INvalidSignUp", testarray.get(1).toString(), ActResult, 3);
    	Assert.assertEquals(ActResult, testarray.get(2).toString(),"[Actual text Matched with expected text]");
		System.out.println("[This is the Actual result message]" + " " + ActResult);
        signuppage.clickonHomepage();
    }
    else
    {
    	 utils.updateResult("Test.xlsx", "INvalidSignUp", testarray.get(1).toString(), flag, 4);
         utils.updateResult("Test.xlsx", "INvalidSignUp", testarray.get(1).toString(), ActResult, 3);
         signuppage.clickonHomepage();
    	Assert.assertEquals(ActResult, testarray.get(2).toString(),"[Error-Actual text does not Match with expected text]");
		System.out.println("[This is the Actual result message]" + " " + ActResult);	       	
    	
    }
    
    System.out.println("***********************"+flag);
  
	}
	catch(Exception e)
{
		
		System.out.println(e.getMessage());
		
	}
    
   
}
 
	


	@Test(priority = 2, dataProvider = "test3", dataProviderClass = DataProviderTesting.class)
	public void InvalidSignupContinuation(List testarray) throws Exception {
		String flag="FAIL";
		try {
		signuppage = new SignUpPage(driver);
		System.out.println(testarray);
		logger.info("SignUpPageTest Test started and running");
		Thread.sleep(500);
		signuppage.clickonSignUpLink();
		signuppage.selectCRMEdition(testarray.get(5).toString());
		signuppage.setFirstName(testarray.get(6).toString());
		signuppage.setLastName(testarray.get(7).toString());
		signuppage.setEmailandConfirmEmailRandom();
		signuppage.setUsernameRandom();
		signuppage.setpassword(testarray.get(8).toString());
		signuppage.setConfirmPassword(testarray.get(9).toString());
		signuppage.clickOnagreementBox();
		signuppage.clickOnsubmitButton();
		signuppage.setCompanyName(testarray.get(10).toString());
		signuppage.setPhoneNumber(testarray.get(11).toString());
		signuppage.setCompEmail(testarray.get(12).toString());
		signuppage.selectCountryName(testarray.get(13).toString());
		signuppage.setbillingaddressconfirm();
		signuppage.clickPnContinueButton();
		//Thread.sleep(300);
	
		String ActResult = AssertionHelper.validateTextPresentOnElement(driver, "xpath","//small[contains(.,'"+testarray.get(2).toString().trim()+"')]");
		
	  
	    if(ActResult.trim().equals(testarray.get(2).toString().trim()))
	    {
	    	
	    	flag="PASS";
	    	System.out.println(flag);
	    	 utils.updateResult("Test.xlsx", "INvalidContinuationData", testarray.get(1).toString(), flag, 4);
	         utils.updateResult("Test.xlsx", "INvalidContinuationData", testarray.get(1).toString(), ActResult, 3);
	    	Assert.assertEquals(ActResult.trim(), testarray.get(2).toString().trim(),"[Actual text Matched with expected text]");
			System.out.println("[This is the Actual result message]" + " " + ActResult);
	        signuppage.clickonHomepage();
	    }
	    else
	    {
	    	 utils.updateResult("Test.xlsx", "INvalidContinuationData", testarray.get(1).toString(), flag, 4);
	         utils.updateResult("Test.xlsx", "INvalidContinuationData", testarray.get(1).toString(), ActResult, 3);
	         signuppage.clickonHomepage();
	    	Assert.assertEquals(ActResult, testarray.get(2).toString(),"[Error-Actual text does not Match with expected text]");
			System.out.println("[This is the Actual result message]" + " " + ActResult);
			  
	       	
	    	
	    }
	    
	    System.out.println("***********************"+flag);
	  
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			
		}
	    
	    
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();	
	}



}











