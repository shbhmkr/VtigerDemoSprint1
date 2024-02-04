package pomRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class CreatingNewProductsPage {

	WebDriver driver;
	public CreatingNewProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTextField;

	@FindBy(name = "sales_start_date")
	private WebElement salesStartDateCalender;

	@FindBy(name = "sales_end_date")
	private WebElement salesEndDateCalender;

	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement vendorLookUpButton;

	@FindBy(id = "search_txt")
	private WebElement vendorSearchBox;

	@FindBy(name = "search")
	private WebElement searchNowButton;

	@FindBy(id = "my_file_element")
	private WebElement prductImageUploadButton;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSalesStartDateCalender() {
		return salesStartDateCalender;
	}

	public WebElement getSalesEndDateCalender() {
		return salesEndDateCalender;
	}

	public WebElement getVendorLookUpButton() {
		return vendorLookUpButton;
	}

	public WebElement getVendorSearchBox() {
		return vendorSearchBox;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public WebElement getPrductImageUploadButton() {
		return prductImageUploadButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public void enterProductName(String productName) {
		productNameTextField.sendKeys(productName);
	}
	
	public void enterSalesStartDate() throws EncryptedDocumentException, IOException {
		
		JavaUtility jUtils=new JavaUtility();
	String saleStartDate = jUtils.generateStartDataInYYYY_MM_DDFormat();
		salesStartDateCalender.sendKeys(saleStartDate);
	}
	
	public void enterSalesEndDate() throws EncryptedDocumentException, IOException {
		JavaUtility jUtils=new JavaUtility();
		String saleEndDate = jUtils.generateEndDataInYYYY_MM_DDFormat();
			salesEndDateCalender.sendKeys(saleEndDate);
	}
	
	public void clickOnVendorNameFromLookUpPage(String vendor) {
		driver.findElement(By.xpath("//a[text()='"+vendor+"']")).click();
	}
	
	public void handleVendorLookUpButton(String vendorLookUpPageTitle, String vendorName, String creatingNewProductPageTitle) {
		
         vendorLookUpButton.click();
		
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, vendorLookUpPageTitle);
		  
		vendorSearchBox.sendKeys(vendorName);
		searchNowButton.click();
		
		clickOnVendorNameFromLookUpPage(vendorName);
		
		wUtils.switchToWindow(driver,creatingNewProductPageTitle );
		
	}
	
	public void uploadProductImage(String fileName) {
		
		String projectPath = System.getProperty("user.dir");
		prductImageUploadButton.sendKeys(projectPath+fileName);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
}
