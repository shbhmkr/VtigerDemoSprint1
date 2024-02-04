package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInformationPage {

	WebDriver driver;

	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyProductInfo(String productName) {
		return driver.findElement(By.xpath("//span[contains(text(), '" + productName + "')]")).getText();
	}

}
