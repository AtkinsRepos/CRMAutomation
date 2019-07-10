package com.crmAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crmAutomation.base.TestBase;
import com.crmAutomation.util.RandomString;
import com.crmAutomation.util.XLUtils;

public class SignUpPage extends TestBase
{
	// WebDriver driver;

		public SignUpPage(WebDriver driver) {
			TestBase.driver = driver;
		}

		public void clickonSignUpLink() {
			WebElement clickonSignUpLink = driver.findElement(By.linkText("Sign Up"));
			clickonSignUpLink.click();
		}

		public String getSignUpCurrentUrl() {
			return driver.getCurrentUrl();
		}

		// SELECT EDITION
		public void selectCRMEdition(String editionplan) {
			Select selectEdition = new Select(driver.findElement(By.id("payment_plan_id")));
			selectEdition.selectByVisibleText(editionplan);
		}

		// SELECT EDITION Error MESSAGE
//		public boolean getSelectEditionError() {
//			String selectEditionError = driver
//					.findElement(By.xpath("//small[contains(.,'Please select one Edition mode')]")).getText();
//			boolean result = false;
//			try {
//				selectEditionError = "Please select one Edition mode";
//				result = true;
//				System.out.println(result + " " + "ACtual Result Equals Expected result");
	//
//			} catch (Exception e) {
//			}
//			return result;
	//
//		}
		// SELECT EDITION Error MESSAGE
			public void getSelectEditionError() throws Exception {
				String path = System.getProperty("user.dir") + "//src//test//resources//TestData//NwComp_3.xlsx";
				//String ActualRest =
				driver.findElement(By.xpath("//small[contains(.,'Please select one Edition mode')]")).getText();
				//String expectedselectEditionError = "Pleases select one Edition mode";
				if (driver.findElement(By.xpath("//small[contains(.,'Please select one Edition mode')]")).getText().equalsIgnoreCase("Please select one Edition mode")) {
					System.out.println("Test PASSED");
					XLUtils.setCellData(path, "InvalidSignUp", 1, 8, "PASSED");
//					System.out.println(expectedselectEditionError);
//					XLUtils.setCellData(path, "InvalidSignUp", 1, 9, expectedselectEditionError);
//					System.out.println(ActualRest);
//					XLUtils.setCellData(path, "InvalidSignUp", 1, 10, ActualRest);
				} else

				{
					XLUtils.setCellData(path, "InvalidSignUp", 1, 8, "FAILED");
					System.out.println("Test FAILED");
			}
			
			}
		
		

		// SET FIRSTName ERROR MESSAGE
		public boolean getErrorMsgSetFirstname() {
			String ErrorSetFirstname = driver.findElement(By.xpath("//small[contains(.,'Please enter your first name')]"))
					.getText();
			boolean result = false;
			try {
				ErrorSetFirstname = "Please enter your first name";
				result = true;
				System.out.println(result + " " + "ACtual Result Equals Expected result");
	
			} catch (Exception e) {
			}
			return result;
		}
		
//		public void getErrorMsgSetFirstname() throws Exception {
//			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\NwComp_3.xlsx";
//			String ActualRest = driver.findElement(By.xpath("//small[contains(.,'Please enter your first name')]"))	.getText();
//			String expectedselectEditionError = "Pleases select one Edition mode";
//			if (driver.findElement(By.xpath("//small[contains(.,'Please enter your first name')]")).getText().equalsIgnoreCase("Please enter your first name"))
//				{
//				System.out.println("Test PASSED");
//				XLUtils.setCellData(path, "InvalidSignUp", 1, 8, "PASSED");
//				System.out.println(expectedselectEditionError);
//				XLUtils.setCellData(path, "InvalidSignUp", 1, 9, expectedselectEditionError);
//				System.out.println(ActualRest);
//				XLUtils.setCellData(path, "InvalidSignUp", 1, 10, ActualRest);
//				
//			}else
//
//			{
//				XLUtils.setCellData(path, "InvalidSignUp", 1, 8, "FAILED");
//				System.out.println("Test FAILED");
//			}
//		}
		

//			signuppage.getErrorMsgSetFirstname();
//			
//			String ActFNResult=AssertionHelper.validateTextPresentOnElement(driver, "xpath", "//small[contains(.,'Please enter your first name')]");
//		  Assert.assertEquals(ActFNResult, "Please enter your first name", "[Error-Actual text does not Match with expected text]");
//		  System.out.println("[This is the Actual result message]" + " " + ActFNResult);
//			}
//			// SET FIRSTName
			public void setFirstName(String firstname) {
				WebElement enterFirstName = driver.findElement(By.name("first_name"));
				enterFirstName.clear();
				enterFirstName.sendKeys(firstname);
			}


		// SET LastName/SurName
		public void setLastName(String surname) {
			WebElement enterSurName = driver.findElement(By.name("surname"));
			enterSurName.clear();
			enterSurName.sendKeys(surname);
		}

		// SET LastName/SurName ErrorMessage
		public boolean getErrorMsgSetLastName() {
			String ErrorMsgSetLastName = driver.findElement(By.xpath("//small[contains(.,'Please enter your surname')]"))
					.getText();
			boolean result = false;
			try {
				ErrorMsgSetLastName = "Please enter your surname";
				result = true;
				System.out.println(result + " " + "Actual Result Equals Expected result");
				System.out.println(ErrorMsgSetLastName + " " + "Please enter your surname");

			} catch (Exception e) {
			}
			return result;

		}

		public void setEmailandConfirmEmailRandom() {
			WebElement enterEmail = driver.findElement(By.name("email"));
			enterEmail.clear();
			String email = RandomString.randomestring()+ "@email.com";
			WebElement enterConfirmEmail = driver.findElement(By.name("email_confirm"));
			enterEmail.sendKeys(email);
			enterConfirmEmail.sendKeys(email);
			// enterEmail.sendKeys(email);

		}

		// SET EMAIL ADDRESS
		public void setEmail(String email) {
			WebElement enterEmail = driver.findElement(By.name("email"));
			enterEmail.clear();
			enterEmail.sendKeys(email);
		}

		// SET EMAIL ADDRESS ERRORS
		public boolean getErrorMsgSetEmailAddrEmailFieldEmpty() {
			String ErrorSetEmailAddr = driver
					.findElement(By.xpath("//small[contains(.,'Please enter your email address')]")).getText();
			boolean result = false;
			try {
				ErrorSetEmailAddr = "Please enter your email address";
				result = true;
				System.out.println(result + " " + "Actual Result Equals Expected result");
				System.out.println(ErrorSetEmailAddr + " " + "Please enter your email address");
			} catch (Exception e) {
			}
			return result;
		}

		// SET EMAIL ADDRESS2
		public void setEmailNormal(String email) {
			WebElement enterEmail = driver.findElement(By.name("email"));
		enterEmail.clear();
		enterEmail.sendKeys(email);
		}
		
		// SET CONFIRM EMAIL ADDRESS1
		public void setConfirmemail(String confmemail) {
			WebElement enterConfirmEmail = driver.findElement(By.name("email_confirm"));
			enterConfirmEmail.clear();
			enterConfirmEmail.sendKeys(confmemail);
		}
		
		// SET CONFIRM EMAIL ADDRESS2
	public void setConfirmemailNormal(String confmemail) {
		WebElement enterConfirmEmail = driver.findElement(By.name("email_confirm"));
			enterConfirmEmail.clear();
			enterConfirmEmail.sendKeys(confmemail);
	}

		// SET CONFIRM EMAIL ADDRESS ERRORS Both Fields are Empty
		public boolean getErrorMsgConfEmailAddrrBothFieldsEmpty() {
			String ErrorConfEmailAddrr = driver.findElement(By.xpath("//small[contains(.,'Invalid Email Address')]"))
					.getText();
			boolean result = false;
			try {
				ErrorConfEmailAddrr = "Invalid Email Address";
				result = true;
				System.out.println(result + " " + "Actual Result Equals Expected result");
				System.out.println(ErrorConfEmailAddrr + " " + "Invalid Email Address");
			} catch (Exception e) {
			}
			return result;
		}

		public boolean getEmailErrorMsgMismatch() {
			String EmailErrorMsgMismatch = driver.findElement(By.xpath("//small[contains(.,'The mail and its confirm must be the same')]")).getText();
			boolean result = false;
			try {
				EmailErrorMsgMismatch = "The mail and its confirm must be the same";
				result = true;
				System.out.println(result + " " + "Actual Result Equals Expected result");
				System.out.println(EmailErrorMsgMismatch + " " + "The mail and its confirm must be the same");
			} catch (Exception e) {
			}
			return result;
		}

		public void getEmailErrorMsgInvalidXterLength() {
//		driver.findElement(By.xpath("//input[@name='email']"));
	String EmailErrorMsgInvalidXterLength=	driver.findElement(By.xpath("//small[contains(.,'Invalid Email Address')]")).getText();
			Assert.assertEquals(EmailErrorMsgInvalidXterLength, "The mail and its confirm must be the same"); 
			System.out.println(EmailErrorMsgInvalidXterLength + " " + "The mail and its confirm must be the same");
	}
		
		public void setUsernameNormal(String username) {
			WebElement enterUserName = driver.findElement(By.name("username"));
			enterUserName.clear();
			enterUserName.sendKeys(username);
		}

		public void setUsernameRandom() {
			WebElement enterUserName = driver.findElement(By.name("username"));
			enterUserName.clear();
			String username = RandomString.randomeAlphaNumeral();
			enterUserName.sendKeys(username);
		}
		public void setUsernamebydata(String username) {
			WebElement enterUserName = driver.findElement(By.name("username"));
			enterUserName.clear();
			enterUserName.sendKeys(username);
		}

		// User password
		public void setpassword(String pwd) {
			WebElement enterPassword = driver.findElement(By.name("password"));
			enterPassword.clear();
			enterPassword.sendKeys(pwd);
		}

		public void setConfirmPassword(String cnfpwd) {
			WebElement enterConfirmPassword = driver.findElement(By.name("passwordconfirm"));
			enterConfirmPassword.clear();
			enterConfirmPassword.sendKeys(cnfpwd);
		}

		public void clickOnagreementBox() {
			WebElement clickOnagreementBox = driver.findElement(By.name("agreeTerms"));
			clickOnagreementBox.click();
		}

		public void clickOnsubmitButton() {
			WebElement clickOnsubmitButton = driver.findElement(By.id("submitButton"));
			clickOnsubmitButton.click();
		}

		public void setCompanyName(String Compname) {
			WebElement entercompanyname = driver.findElement(By.id("company_name"));
			entercompanyname.clear();
			entercompanyname.sendKeys(Compname);
		}

		public void setPhoneNumber(String phone) {
			WebElement enterPhoneNumber = driver.findElement(By.id("phone"));
			enterPhoneNumber.sendKeys(phone);
		}

		public void setfaxnumber(String faxnum) {
			WebElement enterfaxnumber = driver.findElement(By.id("fax"));
			enterfaxnumber.sendKeys(faxnum);
		}

		public void setWebSiteName(String websitenm) {
			WebElement WebSiteName = driver.findElement(By.id("website"));
			WebSiteName.sendKeys(websitenm);
		}

		public void setCompEmail(String compemail) {
			WebElement CompEmail = driver.findElement(By.id("company_email"));
			CompEmail.sendKeys(compemail);
		}

		public void setCompDescription(String descption) {
			WebElement enterCompDescription = driver.findElement(By.id("service"));
			enterCompDescription.sendKeys(descption);
		}

		public void setCompAddress(String Addrs) {
			WebElement enterCompAddress = driver.findElement(By.id("address"));
			enterCompAddress.sendKeys(Addrs);
		}

		public void setCityName(String cityy) {
			WebElement enterCityName = driver.findElement(By.id("city"));
			enterCityName.sendKeys(cityy);
		}

		public void setStatename(String statenm) {
			WebElement enterStatename = driver.findElement(By.id("state"));
			enterStatename.sendKeys(statenm);
		}

		public void setpostCode(String pcode) {
			WebElement enterpostCode = driver.findElement(By.id("postcode"));
			enterpostCode.sendKeys(pcode);
		}

		public void selectCountryName(String countrynm) {
			Select selectCountryName = new Select(driver.findElement(By.name("country")));
			selectCountryName.selectByVisibleText(countrynm);
		}

		public void setcopyaddress(String copy_Address) {
			WebElement entercopyaddress = driver.findElement(By.name("copy_address"));
			entercopyaddress.sendKeys(copy_Address);
		}

		public void setbillingaddressconfirm() {
			WebElement ThisisBillingAddressalsoCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
			ThisisBillingAddressalsoCheckbox.click();
		}

		public void clickPnContinueButton() {
			WebElement clickPnContinueButton = driver.findElement(By.xpath("//button[@type='submit']"));
			clickPnContinueButton.click();
		}

//		public void clickOnSubmit() {
//			WebElement clickOnSubmit = driver.findElement(By.name("btnSubmit"));
//			clickOnSubmit.click();
//		}

		public void clickonfinish() {
			WebElement clickonfinish = driver.findElement(By.name("finish"));
			clickonfinish.click();
		}

	//ERROR MESSAGES-//ERROR MESSAGES-//ERROR MESSAGES-//ERROR MESSAGES-//ERROR MESSAGES
//		public String  getErrorMsgSetFirstname() {
//			WebElement ErrorSetFirstname = driver.findElement(By.xpath("//small[contains(.,'Please enter your first name')]"));
//			
//			return ErrorSetFirstname.getText();	
//		}

//		public String getErrorMsgSetLastName() {
//			WebElement ErrorMsgSetLastName = driver.findElement(By.xpath("//small[contains(.,'Please enter your surname')]"));
//			return ErrorMsgSetLastName.getText();
//		}

	//	
//		public String getErrorMsgSetEmailAddr() {
//			WebElement ErrorSetEmailAddr = driver.findElement(By.xpath("//small[contains(.,'Please enter your email address')]"));
//			return ErrorSetEmailAddr.getText();
//		}
//		public String getErrorMsgSetConfirmEmailAddr() {
	//
//			WebElement ErrorConfirmEmailAddr = driver.findElement(By.xpath("//small[contains(.,'Please confirm your email address')]"));
//			return ErrorConfirmEmailAddr.getText();
//		}
//		public String getErrorMsgInvalidemail () {
//			WebElement ErrorInvalidemail = driver.findElement(By.xpath("//small[contains(.,'Invalid Email Address')]"));
//			return  ErrorInvalidemail.getText();
//		}
//		public String getErrorMsgMismatch() {
//			WebElement ErrorEmailandmismatch = driver.findElement(By.xpath("//small[contains(.,'The mail and its confirm must be the same')]"));
//			return  ErrorEmailandmismatch.getText();
//		}
		public String getErrorMsgSetUserName() {
			WebElement ErrorSetUserName = driver.findElement(By.xpath("//small[contains(.,'You must select a username')]"));
			return ErrorSetUserName.getText();
		}

		public String getErrorMsgSetUsernamelenght() {
			WebElement ErrorUsernamelenght = driver
					.findElement(By.xpath("//small[contains(.,'Username must be at least 6 characters long')]"));
			return ErrorUsernamelenght.getText();
		}

		public String getErrorMsgSetpassword() {
			WebElement ErrorSetpassword = driver.findElement(By.xpath("//small[contains(.,'You must select a password')]"));
			return ErrorSetpassword.getText();
		}

		public String getErrorMsgSetConfirmpassword() {
			WebElement ErrorMsg_Confirmpassword = driver
					.findElement(By.xpath("//small[contains(.,'You must confirm your password')]"));
			return ErrorMsg_Confirmpassword.getText();
		}

		public String getErrorMsgSetTermsandCondCheckBox() {
			WebElement ErrorMsg_TermsandCondCheckBox = driver
					.findElement(By.xpath("//small[@data-bv-validator-for='agreeTerms']"));
			return ErrorMsg_TermsandCondCheckBox.getText();
		}

		public String getErrorMsgSetCompanyProfilePageLabel() {
			WebElement CompanyProfilePageLabel = driver.findElement(By.xpath("//div[@class='text_orange']"));
			return CompanyProfilePageLabel.getText();
		}

		public String getErrorMsgSetCompanyName() {
			WebElement ErrorMsgCompanyName = driver.findElement(By.xpath("//small[@data-bv-validator-for='company_name']"));
			return ErrorMsgCompanyName.getText();
		}

		public String getErrorMsgSetCompanyPhone() {
			WebElement ErrorMsgCompanyPhone = driver.findElement(By.xpath("//small[@data-bv-validator-for='phone']"));
			return ErrorMsgCompanyPhone.getText();
		}
		
		public void clickonHomepage()
		{
			
			WebElement clickonHomeLink = driver.findElement(By.xpath("//a[contains(.,'Home')]"));
			clickonHomeLink.click();	
			
		}
		
		
		

//		public void getErrorMsgSetCompanyname(String ExpectedErrorMsg) {
	//
//			WebElement Companyname = driver.findElement(By.xpath("//input[@id='company_name']"));
//		}

//		public void getErrorMsgSet(String ExpectedErrorMsg) {
	//WebElement ErrorMsg_TermsandCondCheckBox = driver
//				.findElement(By.xpath("//small[@data-bv-validator-for='agreeTerms']"));
//		}

//		public void getErrorMsgSet(String ExpectedErrorMsg) {
	//WebElement ErrorMsg_ValidaCompany_name = driver
//				.findElement(By.xpath("//small[@data-bv-validator-for='company_name']"));
//		}
	//
//		public void getErrorMsgSet(String ExpectedErrorMsg) {
	//WebElement ErrorMsg_CompanyPhone = driver.findElement(By.xpath("//small[@data-bv-validator-for='phone']"));
//		}

//		WebElement CompanyInfoAndpProfilePageLabel = driver.findElement(By.xpath("//div[@class='text_orange']"));
	//
//		WebElement SignUpUser_Companyname = driver.findElement(By.xpath("//input[@id='company_name']"));

	}

	
	

