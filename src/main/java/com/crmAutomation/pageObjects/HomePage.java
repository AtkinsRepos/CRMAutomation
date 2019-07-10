package com.crmAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmAutomation.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@title='Home']")
	WebElement HomePgLink;

	@FindBy(xpath = "//a[@title='Calendar']")
	WebElement CalendarPgLink;

	@FindBy(xpath = "//a[@title='Companies']")
	WebElement CompaniesPgLink;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactspgLink;

	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement NewContactPgLink;

	@FindBy(xpath = "//a[contains(.,'Deals')] ")
	WebElement DealsPgLink;

	@FindBy(xpath = " //a[contains(.,'Tasks')] ")
	WebElement TasksPglink;

	@FindBy(xpath = "//a[contains(.,'Cases')] ")
	WebElement CasesPgLink;

	@FindBy(xpath = "//a[@title='Call'] ")
	WebElement CallPgLink;

	@FindBy(xpath = " //a[@title='Email'] ")
	WebElement EmailPgLink;

	@FindBy(xpath = "//a[@title='Text/SMS'] ")
	WebElement TextAndSMSPgLink;

	@FindBy(xpath = "//a[@title='Print'] ")
	WebElement PrintPgLink;

	@FindBy(xpath = "//a[@title='Campaigns']")
	WebElement CampaignsPgLink;

	@FindBy(xpath = " //a[@title='Docs'] ")
	WebElement DocsPgLink;

	@FindBy(xpath = " //a[contains(.,'Forms')] ")
	WebElement FormsPgLink;

	@FindBy(xpath = "//td[@class='headertext'][contains(.,'User: Agnesia bolt')]")
	WebElement LoggedInUserName;

	@FindBy(xpath = " //a[@title='Reports'] ")
	WebElement ReportsPgLink;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement LogoutBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyLoggedInUserName() {
		return LoggedInUserName.isDisplayed();

	}

	public ContactsPage clickOnContactsPgLink() {
		ContactspgLink.click();

		return new ContactsPage();

	}

	public void clickOnNewContactsPgLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(ContactspgLink).build().perform();
		NewContactPgLink.click();
		
	}
	
	

//	public DealsPage clickOnDealsPgLink() {
//
//		DealsPgLink.click();
//		return new DealsPage();
//
//	}
//
//	public CompaniesPage clickOnCompaniesPgLink() {
//		CompaniesPgLink.click();
//
//		return new CompaniesPage();
//
//	}
//
//	public TasksPage clickOnTasksPglink() {
//		TasksPglink.click();
//
//		return new TasksPage();
//	}
//
//	public CampaignsPage clickOnCampaignsPgLink() {
//		CampaignsPgLink.click();
//		return new CampaignsPage();
//
//	}
//
//	public FormsPage clickOnFormsPgLink() {
//		FormsPgLink.click();
//		return new FormsPage();
//	}
//
//	public ReportsPage clickOnReportsPgLink() {
//		ReportsPgLink.click();
//		return new ReportsPage();
//
//	}
//
//	public TextandSMSPage clickOnTextAndSMSPgLink() {
//		TextAndSMSPgLink.click();
//		return new TextandSMSPage();
//
//	}
//
//	public CallsPage clickOnCallPgLink() {
//		CallPgLink.click();
//		return new CallsPage();
//
//	}
//
//	public DocsPage clickOnDocsPgLink() {
//		DocsPgLink.click();
//		return new DocsPage();
//
//	}
//
//	public PrintPage clickOnPrintPgLink() {
//		PrintPgLink.click();
//		return new PrintPage();
//
//	}
//
//	public EmailsPage clickOnEmailPgLink() {
//		EmailPgLink.click();
//		return new EmailsPage();
//
//	}
//
//	public CasesPage clickOnCasesPgLink() {
//		CasesPgLink.click();
//		return new CasesPage();
//
//	}
//
//	public CalendarPage clickOnCalendarPgLink() {
//		CalendarPgLink.click();
//		return new CalendarPage();
//
//	}

	public void clicklogOut() {
		LogoutBtn.click();
	}

}
