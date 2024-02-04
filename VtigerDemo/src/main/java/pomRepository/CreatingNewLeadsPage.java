package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadsPage {
	
	public CreatingNewLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="salutationtype")
	private WebElement salutationDropdown;  
	
	@FindBy(name="firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name="company")
	private WebElement companyNameTextField;
	
	@FindBy(name="leadsource")  
	private WebElement leadSourceDropdown;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="leadstatus")
	private WebElement leadStatusDropdown;
	
	@FindBy(name="rating")
	private WebElement ratingDropdown;
	
	@FindBy(xpath="//input[@value=\"T\"]")    
	private WebElement groupRadioButton;

	@FindBy(name="assigned_group_id")
	private WebElement assignToDropdown;
	
	@FindBy(xpath="//input[@value=\"  Save  \"]")
	private WebElement saveButton;

	
	
	public WebElement getSalutationDropdown() {
		return salutationDropdown;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getLeadStatusDropdown() {
		return leadStatusDropdown;
	}

	public WebElement getRatingDropdown() {
		return ratingDropdown;
	}

	public WebElement getGroupDropdown() {
		return groupRadioButton;
	}

	public WebElement getAssignToDropdown() {
		return assignToDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public void enterLeadsMandatoryInfo(String lastName, String companyName) {
		lastNameTextField.sendKeys(lastName);
		companyNameTextField.sendKeys(companyName);
		saveButton.click();
	}
	
	public void selectLeadSalutationDropdown(String option) {
		new Select(salutationDropdown).selectByVisibleText(option);
		
	}
	public void enterFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}
	
	public void enterCompanyName(String companyName) {
		companyNameTextField.sendKeys(companyName);
	}
	
	public void selectLeadSourceButton(String option) {
		new Select(leadSourceDropdown).selectByVisibleText(option);
	}
	
	public void selectIndustryDropdown(String option) {
		new Select(industryDropdown).selectByVisibleText(option);
	}
	
	public void selectLeadStatusDropdown(String option) {
		new Select(leadStatusDropdown).selectByVisibleText(option);
	}
	
	public void selectRatingDropdown(String option) {
		new Select(ratingDropdown).selectByVisibleText(option);
	}
	
	public void selectGroupRadioButton() {
		groupRadioButton.click();
	}
	
	public void selectAssignTo(String option) {
		new Select(assignToDropdown).selectByVisibleText(option);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	
	
}
