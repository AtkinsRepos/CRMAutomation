package com.crmAutomation.testScripts;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.util.List;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.pageObjects.ContactsPage;
import com.crmAutomation.pageObjects.HomePage;
import com.crmAutomation.pageObjects.LoginPage;
import com.crmAutomation.util.DataProviderTesting;
import com.crmAutomation.util.ExcelDataConfig;
import com.crmAutomation.util.TestUtil;

public class ContactsPgTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;

	public ContactsPgTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		// contactspage = homepage.clickOnContactsPgLink();

	}

//	@Test(priority = 1)
//	public void VerifyContactsLableTest() {
//		test=extent.createTest("VerifyContactsLableTest");
//		
//		Assert.assertTrue(contactspage.verifyContactsPgLabel());
//	}

	@Test(priority = 1, dataProvider = "test5", dataProviderClass = DataProviderTesting.class)
	public void validateCreateNewContactTest(List testarray) {
		test = extent.createTest("validateCreateNewContactTest");
		homepage.clickOnNewContactsPgLink();
		contactspage.createNewContact(testarray);

		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();	
	}
}
