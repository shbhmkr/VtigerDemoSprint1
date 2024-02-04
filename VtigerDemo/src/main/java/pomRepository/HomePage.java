package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorButton;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutButton;
	
	@FindBy(linkText="Leads")
	 private WebElement leadsButton;

	@FindBy(linkText="Organizations")
	 private WebElement organizationsButton;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesButton;
	
	@FindBy(linkText="Contacts")
	 private WebElement contactsButton;
	
	@FindBy(linkText="Products")
	 private WebElement productsButton;
	
	@FindBy(linkText="More")
	 private WebElement moreDropdown;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsButton;
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsButton;
	
	@FindBy(linkText="Invoice")
	private WebElement invoiceButton;
	
	@FindBy(linkText="Quotes")
	private WebElement quotesButton;
	
	
	
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getAdministratorButton() {
		return administratorButton;
	}


	public WebElement getSignOutButton() {
		return signOutButton;
	}


	public WebElement getLeadsButton() {
		return leadsButton;
	}



	public WebElement getOrganizationsButton() {
		return organizationsButton;
	}



	public WebElement getContactsButton() {
		return contactsButton;
	}


	public WebElement getProductsButton() {
		return productsButton;
	}


	public WebElement getMoreDropdown() {
		return moreDropdown;
	}



	public WebElement getCampaignsButton() {
		return campaignsButton;
	}



	public WebElement getVendorsButton() {
		return vendorsButton;
	}



	public WebElement getInvoiceButton() {
		return invoiceButton;
	}


	public WebElement getQuotesButton() {
		return quotesButton;
	}


	
	public void clickOnLeadsModule() {
		leadsButton.click();
	}
	
	public void clickOnOrganizationModule() {
		organizationsButton.click();
	}
	
	public void clickOnContactsModule() {
		contactsButton.click();
	}
	
	public void clickOnProductsModule() {
		productsButton.click();
	}
	
	public void clickOnOpportunitiesModule() {
		opportunitiesButton.click();
	}
	
	
	public void mouseHoverToMore() {
		new Actions(driver).moveToElement(moreDropdown).perform();
	}
	
	public void clickOnCampaignModule() {
		mouseHoverToMore();
		campaignsButton.click();
	}
	
	public void clickOnVendorModule() {
		mouseHoverToMore();
		vendorsButton.click();
	}
	
	public void clickOnInvoiceModule() {
		mouseHoverToMore();
		invoiceButton.click();
	}
	
	public void clickOnQuotesModule() {
		mouseHoverToMore();
		quotesButton.click();
		
	}

	public void logoutAction() {
		new Actions(driver).moveToElement(administratorButton).perform();
		signOutButton.click();
	}
}
