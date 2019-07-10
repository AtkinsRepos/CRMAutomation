//package com.crmAutomation.pageObjects;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.crmAutomation.base.TestBase;
//
//public class CompaniesPage extends TestBase{
//	
//	@FindBy(xpath = "//a[@title='Companies']")
//	WebElement CompaniesPgLink;
//	
//	@FindBy(xpath = "//a[@title='New Company']")
//	WebElement NewCompanyPgLink;
//
//	@FindBy(xpath = "//legend[contains(.,'Create New  Company')]")
//	WebElement CreateCompanyPgLabel;
//
//	@FindBy(xpath = "//input[@id='company_name']")
//	WebElement Company_name;
//
//	@FindBy(xpath = "//input[@name='industry']")
//	WebElement Industry_Type;
//
//	@FindBy(xpath = "//input[@id='annual_revenue']")
//	WebElement Annual_Revenue;
//
//	@FindBy(xpath = "//input[@name='num_of_employees']")
//	WebElement Num_of_Employees;
//
//
//	@FindBy(xpath = "//select[@name='category']")
//	WebElement Select_Comp_Category;
//
//	@FindBy(xpath = "//select[@name='status']")
//	WebElement Select_Company_Status;
//	
//	@FindBy(xpath = "//select[@name='priority']")
//	WebElement Select_Priority_Importance;
//	
//
//	@FindBy(xpath = "//select[@name='source']")
//	WebElement Select_SourceOf_Information;
//
//	@FindBy(xpath = "//input[@name='identifier']")
//	WebElement Company_Identifier;
//
//	@FindBy(xpath = "//input[@id='vat_number']")
//	WebElement VAT_Number;
//
//	@FindBy(xpath = "//input[@name='address_title']")
//	WebElement Company_Address_Title;
//	
//	
//	@FindBy(xpath = "//select[@name='type']")
//	WebElement Company_Address_Type;
//	
//
//	@FindBy(xpath = "//textarea[@name='address'] ")
//	WebElement Address;
//	
//	@FindBy(xpath = "//input[@name='city']")
//	WebElement City_Name;
//
//	@FindBy(xpath = "//input[@name='state']")
//	WebElement State_Or_Province;
//
//	@FindBy(xpath = "//input[@name='postcode']")
//	WebElement Post_Code;
//
//	@FindBy(xpath = "//input[@name='country']")
//	WebElement Name_of_Country;
//	
//	
//	
//	@FindBy(xpath = "//textarea[@name='service']")
//	WebElement Company_Description;
//	
//	@FindBy(xpath = "//input[@id='phone']")
//	WebElement PhoneNumber;
//
//	@FindBy(xpath = "//input[@id='fax']")
//	WebElement FaxNumber;
//
//	@FindBy(xpath = "//input[@id='website']")
//	WebElement Website;
//
//	@FindBy(xpath = "//input[@id='email']")
//	WebElement EmailAddress;
//	
//	
//	@FindBy(xpath = "//input[@id='symbol']")
//	WebElement CompSymbol;
//	
//	@FindBy(xpath = "//input[@name='client_lookup']")
//	WebElement NameOfParentComp;
//
//	@FindBy(xpath = "//select[@id='owner_user_id']")
//	WebElement SelectOwner;
//	
//	@FindBy(xpath = "//input[contains(@value,'Save')]")
//	WebElement SaveBtn;
//
//	
//	public CompaniesPage() {
//		PageFactory.initElements(driver, this);
//		
//	}
//	public boolean verifyCreateCompanyLabel() {
//
//		return CreateCompanyPgLabel.isDisplayed();
//
//	}
//	public void clickOnNewCompanyPgLink() {
//		Actions actions=new Actions(driver);
//		actions.moveToElement(CompaniesPgLink).build().perform();
//		NewCompanyPgLink.click();
//	}
//	
//	public void clickOnSaveButtonLink() {
//		SaveBtn.click();
//		}
//	
//	public void CreateNewCompany(String CompanyName, String IndustryType, String AnnualRevenue, String NumberOfEmployees,
//			String CompanyStatus, String CompanyCategory, String PriorityOfImportance, String SourceOFInfo, String CompIdentifier, String VAT_Or_Tax,
//			String AddressTitle,   String AddressType, String DefaultAddress, String CityName, String StateOrProvince, 
//			String PostalCode, String CountryName, String CompDescription, String Phone,String Fax,  String WebsiteAddress, String Email,
//			String CompanySym, String NameOfParentCom,String OwnerName) {
//		
//		Company_name.sendKeys(CompanyName);
//		Industry_Type.sendKeys(IndustryType);
//		Annual_Revenue.sendKeys(AnnualRevenue);
//		Num_of_Employees.sendKeys(NumberOfEmployees);
//		
//		Select selectstat = new Select(Select_Company_Status);
//		selectstat.selectByVisibleText(CompanyStatus);
//		
//		Select selectCat = new Select(Select_Comp_Category);
//		selectCat.selectByVisibleText(CompanyCategory);
//		
//		Select selectPriority = new Select(Select_Priority_Importance);
//		selectPriority.selectByVisibleText(PriorityOfImportance);
//				
//		Select selectSource = new Select(Select_SourceOf_Information);
//		selectSource.selectByVisibleText(SourceOFInfo);
//		
//		Company_Identifier.sendKeys(CompIdentifier);
//		
//		VAT_Number.sendKeys(VAT_Or_Tax);
//
//		Company_Address_Title.sendKeys(AddressTitle);
//		Company_Address_Type.sendKeys(AddressType);
//		Address.sendKeys(DefaultAddress);
//		City_Name.sendKeys(CityName);
//		State_Or_Province.sendKeys(StateOrProvince);
//		Post_Code.sendKeys(PostalCode);
//		Name_of_Country.sendKeys(CountryName);
//		Company_Description.sendKeys(CompDescription);
//
//		PhoneNumber.sendKeys(Phone);
//		FaxNumber.sendKeys(Fax);
//		Website.sendKeys(WebsiteAddress);
//		EmailAddress.sendKeys(Email);
//		CompSymbol.sendKeys(CompanySym);
//		NameOfParentComp.sendKeys(NameOfParentCom);
//		
//		Select selectOwner = new Select(Select_Comp_Category);
//		selectOwner.selectByVisibleText(CompanyCategory);
//		
//		SelectOwner.sendKeys(OwnerName);
//		
//		try {
//	        WebDriverWait wait = new WebDriverWait(driver, 1);
//	        wait.until(ExpectedConditions.alertIsPresent());
//	        Alert alert = driver.switchTo().alert();
//	        alert.accept();
//	    } catch (Exception e) {
//	        //exception handling
//	    }
//	
//		SaveBtn.click();		
//			
//			
//	}
//	
//}
//
