package com.crmAutomation.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmAutomation.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[contains(@name,'username')]")
	WebElement UserName;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[contains(.,'Sign Up')]")
	WebElement SignUpLink;

	@FindBy(xpath = "//td[contains(.,'CRMPRO')]")
	WebElement CRMlogo;

	@FindBy(xpath = "//a[contains(.,'Pricing')]")
	WebElement PricingPgLink;

	@FindBy(xpath = "//a[contains(.,'Features')]")
	WebElement FeatureLink;

	@FindBy(xpath = "//a[contains(.,'Customers')]")
	WebElement CustomersLink;

	@FindBy(xpath = "//a[contains(.,'Contact')]")
	WebElement ContactUsLinks;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public String ValidateCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String verifyHomepageTitle() {
		return driver.getTitle();
	}

//	public boolean validateCRMlogoImage() {
//		driver.switchTo().frame("mainpanel");
//		return CRMlogo.isDisplayed();
//
//	}
	public HomePage Login(String username, String password) {
//	Alert alrt = driver.switchTo().alert();
//	System.out.println(alrt.getText());
//	alrt.dismiss();

	UserName.sendKeys(username);
	Password.sendKeys(password);
	//LoginBtn.click();
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", LoginBtn);
	return new HomePage();
	
	
//////
//	public HomePage Login(String username, String password) {
////		Alert alrt = driver.switchTo().alert();
////		System.out.println(alrt.getText());
////		alrt.dismiss();
//
//		UserName.sendKeys(username);
//		Password.sendKeys(password);
//		LoginBtn.click();
////		JavascriptExecutor js = (JavascriptExecutor)driver;
////    	js.executeScript("arguments[0].click();", LoginBtn);
//
//		
//		return new HomePage();
		
	}

//	public void setUserName(String username) {
//		UserName.clear();
//		UserName.sendKeys(username);
//
//	}
//
//	public void setPassword(String password) {
//
//		Password.clear();
//		Password.sendKeys(password);
//		LoginBtn.click();
//	}
//
//	public void clickONLoginBtn() {
//		LoginBtn.click();
//	}

	public void clickOnSignUpLink() {
		SignUpLink.click();
	}

	public void CheckCRMLogo() {
		CRMlogo.isDisplayed();

	}

	public void clickOnPricingPgLink() {
		PricingPgLink.click();
	}

	public void clickOnFeaturePgLink() {
		FeatureLink.click();

	}

	public void clickOnCustomersPgLink() {
		CustomersLink.click();
	}

	public void clickOnContactUsPgLink() {
		ContactUsLinks.click();
	}

}
