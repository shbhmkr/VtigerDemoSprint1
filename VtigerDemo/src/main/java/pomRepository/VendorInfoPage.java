package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	
	WebDriver driver;
	public VendorInfoPage(WebDriver driver) {
	  PageFactory.initElements(driver,this);
	  this.driver=driver;
	}

	public String verifyVendorInfo(String vendor) {
		
		 return driver.findElement(By.xpath("//span[contains(text(),'"+vendor+" ')]")).getText();
		
	}
	
}
