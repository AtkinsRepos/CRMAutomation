//package com.crmAutomation.testScripts;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.crmAutomation.base.TestBase;
//import com.crmAutomation.pageObjects.CompaniesPage;
//import com.crmAutomation.pageObjects.ContactsPage;
//import com.crmAutomation.pageObjects.HomePage;
//import com.crmAutomation.pageObjects.LoginPage;
//import com.crmAutomation.util.TestUtil;
//import com.crmAutomation.util.XLUtils;
//
//public class CompaniesPageTest extends TestBase {
//
//	HomePage homepage;
//	LoginPage loginpage;
//	TestUtil testutil;
//	CompaniesPage companiespage;
//
//	public CompaniesPageTest() {
//		super();
//
//	}
//
//	@BeforeMethod
//	public void setup() {
//		//initialization();
//		testutil = new TestUtil();
//		loginpage = new LoginPage();
//		companiespage = new CompaniesPage();
//		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
//		testutil.switchToFrame();
//		//companiespage = homepage.clickOnCompaniesPgLink();
//
//	}
//
//	@Test(priority = 1)
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
//
//	@Test(dataProvider = "CompData")
//	public void validateCreateCreateCompanyTest(String CompanyName, String IndustryType, String AnnualRevenue,
//			String NumberOfEmployees, String CompanyStatus, String CompanyCategory, String PriorityOfImportance,
//			String SourceOFInfo, String CompIdentifier, String VAT_Or_Tax, String AddressTitle, String AddressType,
//			String DefaultAddress, String CityName, String StateOrProvince, String PostalCode, String CountryName,
//			String CompDescription, String Phone, String Fax, String WebsiteAddress, String Email, String CompanySym,
//			String NameOfParentCom, String OwnerName) {
//		test = extent.createTest("validateCreateCreateCompanyTest");
//		companiespage.clickOnNewCompanyPgLink();
//		logger.info("clicked on OnNewCompanyPgLink");
//		logger.info("Starting new company account creation process ...running");
//
//		companiespage.CreateNewCompany(CompanyName, IndustryType, AnnualRevenue, NumberOfEmployees, CompanyStatus,
//				CompanyCategory, PriorityOfImportance, SourceOFInfo, CompIdentifier, VAT_Or_Tax, AddressTitle,
//				AddressType, DefaultAddress, CityName, StateOrProvince, PostalCode, CountryName, CompDescription, Phone,
//				Fax, WebsiteAddress, Email, CompanySym, NameOfParentCom, OwnerName);
//		
//		logger.info("new company account creation process ...Ended");
//
//	}
//
//	@DataProvider(name = "CompData")
//	public String[][] getCompanyData() throws IOException {
//		String path = (System.getProperty("user.dir")+"//src//test//resources//TestData//NwComp_3.xlsx");
//
//		int rownum = XLUtils.getRowCount(path, "NewCompny");
//		int colcount = XLUtils.getCellCount(path, "NewCompny", 1);
//		
//		String compData[][] = new String[rownum][colcount];
//
//		for (int i = 1; i <= rownum; i++) {
//			for (int j = 0; j < colcount; j++) {
//				compData[i - 1][j] = XLUtils.getCellData(path, "NewCompny", i, j);
//			}
//		}
//
//		return compData;
//
//	}
//
//
////
////	@AfterMethod
////	public void teardown() {
////		driver.quit();
////	}
//
//}
