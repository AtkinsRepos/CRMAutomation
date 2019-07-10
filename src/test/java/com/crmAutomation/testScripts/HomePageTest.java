package com.crmAutomation.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.pageObjects.ContactsPage;
import com.crmAutomation.pageObjects.HomePage;
import com.crmAutomation.pageObjects.LoginPage;
import com.crmAutomation.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		ContactsPage contactspage = new ContactsPage();
		

	}
	@AfterMethod
	public void tearDown() {
		driver.close();	
	}
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		test=extent.createTest("verifyHomePageTitleTest");
		String HomePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitle,"CRMPRO" );//- CRM software for customer relationship management, sales, and support.",
				//"Home page title is not thesame");
		System.out.println(HomePageTitle);
	}

	@Test(priority = 1)
	public void verifyLoggedInUserNameTest() {
		test=extent.createTest("verifyLoggedInUserNameTest");
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyLoggedInUserName());

	}

	@Test(priority = 2)
	public void verifyclickOnContactsPgLinkTest() {
		test=extent.createTest("verifyclickOnContactsPgLinkTest");
		testutil.switchToFrame();
		homepage.clickOnContactsPgLink();

	}

	@Test(priority = 3)
	public void VerifylogOutOfApplication() {
		test=extent.createTest("VerifylogOutOfApplication");
		testutil.switchToFrame();
		homepage.clicklogOut();

	}

//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//	}
}