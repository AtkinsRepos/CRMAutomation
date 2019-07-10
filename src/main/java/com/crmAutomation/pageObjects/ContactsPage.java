package com.crmAutomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmAutomation.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement NewContactPgLink;

	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement ContactsPgLabel;

	@FindBy(xpath = "//select[@name='title']")
	WebElement SelectContactByTitle;

	@FindBy(id = "first_name")
	WebElement FirstNameOfNewContact;

	@FindBy(id = "middle_initial")
	WebElement MiddleNameOfNewContact;

	@FindBy(id = "surname")
	WebElement lastNameOfNewContact;

	@FindBy(name = "nickname")
	WebElement NickNameOfNewContact;

	@FindBy(name = "client_lookup")
	WebElement companyNameOfNewContact;

	@FindBy(name = "company_position")
	WebElement PositionNameOfNewContact;
	
	@FindBy(xpath = "//input[@id='department']")
	WebElement DeptNameOfNewContact;
	

	@FindBy(name = "contact_lookup_sup")
	WebElement SupervisorNameOfNewContact;

	@FindBy(name = "contact_lookup_ass")
	WebElement AssistantNameOfNewContact;

	@FindBy(name = "contact_lookup_ref")
	WebElement RefererNameOfNewContact;

	@FindBy(xpath = "//*[@id=\"owner_user_id\"]")
	WebElement OwnerNameOfNewContact;
	
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement ClickOnSaveBtn;
	

	@FindBy(xpath = "//a[contains(@href,'https://classic.crmpro.com/system/index.cfm?action=contact&sub=search')] ")
	WebElement FullSearChForm;

	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactsPgLabel() {

		return ContactsPgLabel.isDisplayed();	

	}
	public void clickOnNewContactPgLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(NewContactPgLink).build().perform();
		NewContactPgLink.click();
	}

	public void createNewContact(List testarray) {
//	try {
//		Thread.sleep(300);
//	} catch (InterruptedException e1) {
//		e1.printStackTrace();
//	}
		FirstNameOfNewContact.sendKeys(testarray.get(2).toString());
		MiddleNameOfNewContact.sendKeys(testarray.get(3).toString());
		lastNameOfNewContact.sendKeys(testarray.get(4).toString());
		NickNameOfNewContact.sendKeys(testarray.get(5).toString());
		companyNameOfNewContact.sendKeys(testarray.get(6).toString());

		PositionNameOfNewContact.sendKeys(testarray.get(7).toString());

		 DeptNameOfNewContact.sendKeys(testarray.get(8).toString());

		SupervisorNameOfNewContact.sendKeys(testarray.get(9).toString());

		AssistantNameOfNewContact.sendKeys(testarray.get(10).toString());

		RefererNameOfNewContact.sendKeys(testarray.get(11).toString());

		//OwnerNameOfNewContact.sendKeys(Owner);
		ClickOnSaveBtn.click();

	}

	public void clickOnSaveButtonLink() {
		ClickOnSaveBtn.click();
		}

	public void t() {

	}

	public void d() {
	}

	public void c() {

	}

	public void b() {
	}

	public void a() {

	}

}
