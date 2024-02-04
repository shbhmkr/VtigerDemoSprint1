package leads;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DataBaseUtility;
import genericUtility.IPathConstant;
import pomRepository.CreatingNewLeadsPage;
import pomRepository.HomePage;
import pomRepository.LeadInformationPage;
import pomRepository.LeadsPage;

@Listeners(genericUtility.ListenerImplementationClass.class)
public class ToCreateALeadTest extends BaseClass {
	
	@Test(retryAnalyzer=genericUtility.RetryImplementationClass.class)
	public void toCreatALeadAndVerifyTheLeadDetailsTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//Testdata
		
		String leadSalutation = eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 17, 2);
		String leadFirstName=eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 18, 2);
		String leadLastName=eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 19, 2);
		String leadCompanyName=eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 20, 2);
		String leadIndustryDropdown=eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 21, 2);
		String leadAssignedTo=eUtils.fetchStringDataFromExcel(IPathConstant.LEAD_SHEET_NAME, 23, 2);
		
		//Creating object of pom classes required
		
		HomePage home=new HomePage(driver);
		LeadsPage lead=new LeadsPage(driver);
		CreatingNewLeadsPage createLead=new CreatingNewLeadsPage(driver);
		LeadInformationPage leadInfo=new LeadInformationPage(driver);
		
		home.clickOnLeadsModule();
		//Assert.fail();
		lead.clickOnLeadsPlusButton();
		createLead.selectLeadSalutationDropdown(leadSalutation);
		createLead.enterFirstName(leadFirstName);
		createLead.enterLastName(leadLastName);
		createLead.enterCompanyName(leadCompanyName);
		createLead.selectGroupRadioButton();
		createLead.selectIndustryDropdown(leadIndustryDropdown);
		Thread.sleep(2000);
		createLead.selectAssignTo(leadAssignedTo);;
		createLead.clickOnSaveButton();
		String actualLeadInfo=leadInfo.verifyLeadInfo(leadLastName);
		
		Assert.assertTrue(actualLeadInfo.contains(leadLastName));
		System.out.println("pass: The lead has been generated");
	
		
	/*	String dataFromDataBase = dbUtils.fetchDataFromDataBase(connection, "select * from lead", 1);
	     System.out.println(dataFromDataBase);  */
	}

}
