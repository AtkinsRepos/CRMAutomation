package com.crmAutomation.testScripts;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.pageObjects.CompaniesPage;
import com.crmAutomation.pageObjects.HomePage;
import com.crmAutomation.pageObjects.LoginPage;
import com.crmAutomation.util.DataProviderTesting;
import com.crmAutomation.util.TestUtil;

public class CompaniesPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	CompaniesPage companiespage;

	public CompaniesPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		companiespage = new CompaniesPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();

	}

	
//	@Test(priority = 1, dataProvider = "test4", dataProviderClass = DataProviderTesting.class)
//	public void SignOutAfterLoginTest() {
//		test = extent.createTest("SignOutAfterLoginTest");
//		logger.info("SignOutAfterLoginTest Test started and running");
//		homepage.verifyHomePageTitle();
//		logger.info("SignOutAfterLoginTest verifying Homepage title");
//		homepage.verifyLoggedInUserName();
//		logger.info("SignOutAfterLoginTest verifying currently logged user");
//		homepage.clicklogOut();
//		logger.info("Sign Out AfterLoginTest clicking on logout button");
//		logger.info("Sign Out AfterLoginTest Test completed");
//	}

	@Test(priority = 1, dataProvider = "test4", dataProviderClass = DataProviderTesting.class)
	public void validateCreateCreateCompanyTest(List testarray) {
		test = extent.createTest("validateCreateCreateCompanyTest");
		companiespage.clickOnNewCompanyPgLink();
		logger.info("clicked on OnNewCompanyPgLink");
		logger.info("Starting new company account creation process ...running");

		companiespage.CreateNewCompany(testarray);
		
		logger.info("new company account creation process ...Ended");

	}

	
	@AfterMethod
	public void tearDown() {
		driver.close();	
	}


}
