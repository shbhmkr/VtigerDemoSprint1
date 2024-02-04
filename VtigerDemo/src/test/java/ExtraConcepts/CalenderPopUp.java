package ExtraConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPopUp {

	public static void main(String[] args) {

		int date= 5;
		String month="august";
		int year=2024;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
		
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+""+ year+"']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+date+"']")).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
				
			}
			
		}
		
	}

}
