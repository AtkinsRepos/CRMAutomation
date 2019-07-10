package com.crmAutomation.pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crmAutomation.base.TestBase;

public class CompaniesPage extends TestBase{
	
	@FindBy(xpath = "//a[@title='Companies']")
	WebElement CompaniesPgLink;
	
	@FindBy(xpath = "//a[@title='New Company']")
	WebElement NewCompanyPgLink;

	@FindBy(xpath = "//legend[contains(.,'Create New  Company')]")
	WebElement CreateCompanyPgLabel;

	@FindBy(xpath = "//input[@id='company_name']")
	WebElement Company_name;

	@FindBy(xpath = "//input[@name='industry']")
	WebElement Industry_Type;

	@FindBy(xpath = "//input[@id='annual_revenue']")
	WebElement Annual_Revenue;

	@FindBy(xpath = "//input[@name='num_of_employees']")
	WebElement Num_of_Employees;


	@FindBy(xpath = "//select[@name='category']")
	WebElement Select_Comp_Category;

	@FindBy(xpath = "//select[@name='status']")
	WebElement Select_Company_Status;
	
	@FindBy(xpath = "//select[@name='priority']")
	WebElement Select_Priority_Importance;
	

	@FindBy(xpath = "//select[@name='source']")
	WebElement Select_SourceOf_Information;

	@FindBy(xpath = "//input[@name='identifier']")
	WebElement Company_Identifier;

	@FindBy(xpath = "//input[@id='vat_number']")
	WebElement VAT_Number;

	@FindBy(xpath = "//input[@name='address_title']")
	WebElement Company_Address_Title;
	
	
	@FindBy(xpath = "//select[@name='type']")
	WebElement Company_Address_Type;
	

	@FindBy(xpath = "//textarea[@name='address'] ")
	WebElement Address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement City_Name;

	@FindBy(xpath = "//input[@name='state']")
	WebElement State_Or_Province;

	@FindBy(xpath = "//input[@name='postcode']")
	WebElement Post_Code;

	@FindBy(xpath = "//input[@name='country']")
	WebElement Name_of_Country;
	
	
	
	@FindBy(xpath = "//textarea[@name='service']")
	WebElement Company_Description;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement PhoneNumber;

	@FindBy(xpath = "//input[@id='fax']")
	WebElement FaxNumber;

	@FindBy(xpath = "//input[@id='website']")
	WebElement Website;

	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailAddress;
	
	
	@FindBy(xpath = "//input[@id='symbol']")
	WebElement CompSymbol;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement NameOfParentComp;

	@FindBy(xpath = "//select[@id='owner_user_id']")
	WebElement SelectOwner;
	
	@FindBy(xpath = "//input[contains(@value,'Save')]")
	WebElement SaveBtn;

	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
		
	}
	public boolean verifyCreateCompanyLabel() {

		return CreateCompanyPgLabel.isDisplayed();

	}
	public void clickOnNewCompanyPgLink() {
		Actions actions=new Actions(driver);
		actions.moveToElement(CompaniesPgLink).build().perform();
		NewCompanyPgLink.click();
	}
	
	public void clickOnSaveButtonLink() {
		SaveBtn.click();
		}
	
	public void CreateNewCompany(List testarray) {
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Company_name.sendKeys(testarray.get(3).toString());
		Industry_Type.sendKeys(testarray.get(4).toString());
		Annual_Revenue.sendKeys(testarray.get(5).toString());
		Num_of_Employees.sendKeys(testarray.get(6).toString());
		
		Select selectstat = new Select(Select_Company_Status);
		selectstat.selectByVisibleText(testarray.get(7).toString());
		
		Select selectCat = new Select(Select_Comp_Category);
		selectCat.selectByVisibleText(testarray.get(8).toString());
		
		Select selectPriority = new Select(Select_Priority_Importance);
		selectPriority.selectByVisibleText(testarray.get(9).toString());
				
		Select selectSource = new Select(Select_SourceOf_Information);
		selectSource.selectByVisibleText(testarray.get(10).toString());
		
		Company_Identifier.sendKeys(testarray.get(11).toString());
		
		VAT_Number.sendKeys(testarray.get(12).toString());

		Company_Address_Title.sendKeys(testarray.get(13).toString());
		Company_Address_Type.sendKeys(testarray.get(14).toString());
		Address.sendKeys(testarray.get(15).toString());
		City_Name.sendKeys(testarray.get(16).toString());
		State_Or_Province.sendKeys(testarray.get(17).toString());
		Post_Code.sendKeys(testarray.get(18).toString());
		Name_of_Country.sendKeys(testarray.get(19).toString());
		Company_Description.sendKeys(testarray.get(20).toString());

		PhoneNumber.sendKeys(testarray.get(21).toString());
		FaxNumber.sendKeys(testarray.get(22).toString());
		Website.sendKeys(testarray.get(23).toString());
		EmailAddress.sendKeys(testarray.get(24).toString());
		CompSymbol.sendKeys(testarray.get(25).toString());
		NameOfParentComp.sendKeys(testarray.get(26).toString());
		
		Select selectOwner = new Select(SelectOwner);
		selectOwner.selectByVisibleText(testarray.get(27).toString());
		
		
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 1);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	        //exception handling
	    }
	
		SaveBtn.click();		
			
			
	}
	
}

