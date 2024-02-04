package genericUtility;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;

/**
 * This class uses java library
 * @author SHUBHAM
 *
 */
public class JavaUtility {
	
	/**
	 * this method generates random number
	 * @param limit
	 * @return
	 */
	public int generateRandomNo(int limit) {
		return new Random().nextInt(limit);
		
	}
	
	/**
	 * This method generates system date and time
	 * @return
	 */
	public String generateSysDateTime() {
		return new Date().toString();
	}
	
	
	/**
	 * This method presses and hold enter button
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException{
		new Robot().keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method release enter button
	 * @throws AWTException
	 */
	public void releaseEnter() throws AWTException {
		new Robot().keyRelease(KeyEvent.VK_ENTER);
	}
	
	public String generateStartDataInYYYY_MM_DDFormat() throws EncryptedDocumentException, IOException {

		ExcelUtility eUtility = new ExcelUtility();

		Date date = eUtility.fetchDateDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 22, 2);

		String day = date.toString().substring(8, 10);
		String year = date.toString().substring(24);

		int month = date.getMonth() + 1;
		String newMonth = "";

		if (month < 10) {
			newMonth = "0" + month;
                  return year + "-" + newMonth + "-" + day;
		}else

		return year + "-" + month + "-" + day;
	}
	
	public String generateEndDataInYYYY_MM_DDFormat() throws EncryptedDocumentException, IOException {

		ExcelUtility eUtility = new ExcelUtility();

		Date date = eUtility.fetchDateDataFromExcel(IPathConstant.PRODUCT_SHEET_NAME, 23, 2);

		String day = date.toString().substring(8, 10);
		String year = date.toString().substring(24);

		int month = date.getMonth() + 1;
		String newMonth = "";

		if (month < 10) {
			newMonth = "0" + month;
                 return year + "-" + newMonth + "-" + day;

		}else

		return year + "-" + month + "-" + day;
	}

	
	

}
