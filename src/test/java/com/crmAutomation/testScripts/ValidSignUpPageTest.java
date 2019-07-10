package com.crmAutomation.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.pageObjects.SignUpPage;
import com.crmAutomation.util.DataProviderGenerator;
import com.crmAutomation.util.TestUtil;

public class ValidSignUpPageTest extends TestBase {
	TestUtil testutil;
	SignUpPage signuppage;

	public ValidSignUpPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		signuppage = new SignUpPage(driver);
		initialization();
		testutil = new TestUtil();
	}

	@Test(priority = 1)
	public void VerifySignUpPageURL() {

		logger.info("navigating to SignUpPageTest page link");
		try {
			driver.switchTo().frame("intercom-borderless-frame");
			driver.switchTo().defaultContent();
			
		} catch (Exception e) {
			
		}
		signuppage.clickonSignUpLink();
		logger.info("SignUpPageTest page clicked");
		logger.info("getting current  SignUpPage URL");
		String actualurl = signuppage.getSignUpCurrentUrl();
		logger.info("comparing actual signup url to one provided");
		String expectedUrl = "https://classic.crmpro.com/register/";
		Assert.assertEquals(actualurl, expectedUrl);
		logger.info("printing result");
		System.out.println("Result, actual url=" + actualurl);
		System.out.println("Result, Expected url=" + expectedUrl);

	}

	@Test(priority=2,dataProvider = "SignUpData", dataProviderClass = DataProviderGenerator.class)
	public void validateSignUpTest(String Edition, String FirstName, String Lastname, String Email,
			String ConfirmEmail, String UserName, String Password, String Confirmpassword,
			String CompanyName, String Companyphone, String CompanyFax, String Companywebsite, String CompanyEmail,
			String CompDesc, String CompAddrs, String SelectCity, String StateName, String PostCode,
			String SelectCountry, String CopyAddress)  {
		signuppage = new SignUpPage(driver);
		try {
			driver.switchTo().frame("intercom-borderless-frame");
			driver.switchTo().defaultContent();
			
		} catch (Exception e) {
			
		}
		logger.info("SignUpPageTest Test started and running");
		signuppage.clickonSignUpLink();
		signuppage.selectCRMEdition(Edition);
		signuppage.setFirstName(FirstName);
		signuppage.setLastName(Lastname);
		signuppage.setEmailandConfirmEmailRandom();
		signuppage.setUsernameRandom();
		signuppage.setpassword(Password);
		signuppage.setConfirmPassword(Confirmpassword);
		signuppage.clickOnagreementBox();
		signuppage.clickOnsubmitButton();	
		signuppage.setCompanyName(CompanyName);
		signuppage.setPhoneNumber(Companyphone);
		signuppage.setfaxnumber(CompanyFax);
		signuppage.setWebSiteName(Companywebsite);
		signuppage.setCompEmail(CompanyEmail);
		signuppage.setCompDescription(CompDesc);
		signuppage.setCompAddress(CompAddrs);
		signuppage.setCityName(SelectCity);
		signuppage.setStatename(StateName);
		signuppage.setpostCode(PostCode);
		signuppage.selectCountryName(SelectCountry);
		signuppage.setcopyaddress(CopyAddress);
		signuppage.clickPnContinueButton();
		signuppage.clickonfinish();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();	
	}
}