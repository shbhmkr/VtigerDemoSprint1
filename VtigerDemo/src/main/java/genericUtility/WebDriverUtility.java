package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author SHUBHAM
 *
 */
public class WebDriverUtility {
	
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to wait for an element
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT));
	}
	
	/**
	 * this method waits for title of a webpage
	 * @param driver
	 * @param title
	 */
	public void waitForTitleOfWebPage(WebDriver driver, String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void waitForElementToCustom(WebDriver driver, WebElement element) {
		FluentWait wait= new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while (count<10) {
			try {
				element.click();
			}catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	public void switchToWindow(WebDriver driver, String childWindowTitle) {
		Set<String> allIds=driver.getWindowHandles();
		Iterator<String> itr = allIds.iterator();
		while (itr.hasNext()) {
			String wTle = itr.next();
			driver.switchTo().window(wTle);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.contains(childWindowTitle)) {
				break;
			}
		}
		
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * switch from one frame to another frame by using id_attribute
	 * 
	 * @param driver
	 * @param id_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_attribute) {
		driver.switchTo().frame(id_attribute);
	}

	/**
	 * switch from one frame to another frame by using absolute_path
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchtoFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * its used to switch back from one child frame to parent frame
	 * 
	 * @param driver
	 */
	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * its used to switch to alert pop up and accept
	 * 
	 * @param driver
	 */
	public void switchToAlertPopUpWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * ts used to switch to alert pop up and dismiss
	 * 
	 * @param driver
	 */
	public void switchToAlertPopUpWindowAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * it is used switch to select dropdown by using index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * it is used switch to select dropdown by using value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * it is used switch to select dropdown by using visible_text
	 * 
	 * @param element
	 * @param visible_text
	 */
	public void selectDropDownByVtext(WebElement element, String visible_text) {
		Select select = new Select(element);
		select.selectByVisibleText(visible_text);
	}

	/**
	 * it is used to mouse over an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * it is used to right click on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * it is used to click on enter button using keyboard actions
	 * 
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * it is used to take screenShot
	 * 
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public static String takeScreenShot(WebDriver driver, String screenShotName)throws IOException  {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshots/" + screenShotName + ".png");
		Files.copy(src, dst);
		return screenShotName;
	}

	/**
	 * it is used to perform scrollBar Actions
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("window.scrollBy(0,500)");
	}
	

}
