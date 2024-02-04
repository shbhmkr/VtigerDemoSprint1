import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CreatingNewProductsPage;
import pomRepository.CreatingNewVendorPage;
import pomRepository.HomePage;
import pomRepository.ProductInformationPage;
import pomRepository.ProductsPage;
import pomRepository.VendorInfoPage;
import pomRepository.VendorsPage;

public class CreateProductTest extends BaseClass {
	
	@Test
	public void createProductAndVerifyProductInformationTest () throws EncryptedDocumentException, IOException {
		
		String vendorName = eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 18, 2);
		String productName=eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 21, 2);
	    //String saleStartDate=eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 22, 2);
		//String saleEndDate=eUtils.fetchStringDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 23, 2);
		
		
		HomePage home=new HomePage(driver);
		VendorsPage vendor=new VendorsPage(driver);
		CreatingNewVendorPage createVendor=new CreatingNewVendorPage(driver);
		VendorInfoPage vendorInfo=new VendorInfoPage(driver);
		ProductsPage product=new ProductsPage(driver);
		CreatingNewProductsPage createProduct=new CreatingNewProductsPage(driver);
		ProductInformationPage productInfo=new ProductInformationPage(driver);
		
		home.mouseHoverToMore();
		home.clickOnVendorModule();
		vendor.clickOnVendorsPlusButton();
		createVendor.enterVendorName(vendorName);
		createVendor.clickOnSaveButton();
		
		String actualVendorName = vendorInfo.verifyVendorInfo(vendorName);
		Assert.assertTrue(actualVendorName.contains(vendorName));
		
		System.out.println("pass: the vendor has been created");
		
		home.clickOnProductsModule();
		product.clickOnProductPlusButton();
		createProduct.enterProductName(productName);
		createProduct.enterSalesStartDate();
		createProduct.enterSalesEndDate();
		createProduct.handleVendorLookUpButton("Vendors&action", vendorName, "Products&action");;
		
		createProduct.uploadProductImage("\\src\\test\\resources\\cap1.PNG");
		createProduct.clickOnSaveButton();
		
		String actualProductName=productInfo.verifyProductInfo(productName);
		
		Assert.assertTrue(actualProductName.contains(productName));
		
		System.out.println("pass:product has been created");
		
		
		
		
		
		
	
	}

}
