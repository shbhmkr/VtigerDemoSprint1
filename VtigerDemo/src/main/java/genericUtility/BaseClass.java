package genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mysql.jdbc.Driver;

import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public WebDriverUtility wUtils=new WebDriverUtility();
	public FileUtility fUtils=new FileUtility();
	public ExcelUtility eUtils=new ExcelUtility();
	public static WebDriver sDriver;
	public Connection connection;
	public DataBaseUtility dbUtils = new DataBaseUtility();
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		//1.Creating an object of driver of mysql vendor
				Driver dataBaseDriver = new Driver();
				//2.registering driver to jdbc api
				DriverManager.registerDriver(dataBaseDriver);
				//3.Establishing connection with the database
			     connection = DriverManager.getConnection(IPathConstant.DATABASE_URL, IPathConstant.DATABASE_USERNAME, IPathConstant.DATABASE_PASSWORD);
			
		System.out.println("Database connection has been established");
	}
	
	@BeforeTest
	public void btConfig() {
		System.out.println("parallel execution has been started");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException {
		
		String browser= fUtils.fetchDataFromPropertFile("browser");
		String url=fUtils.fetchDataFromPropertFile("url");
		
		if(browser.equals("chrome")){
		driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else
			System.out.println("browser is not present");
		
		sDriver=driver;
		wUtils.maximizeTheWindow(driver);
		wUtils.implicitlyWait(driver);
		driver.get(url);
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		String username=fUtils.fetchDataFromPropertFile("username");
		String password=fUtils.fetchDataFromPropertFile("password");
		
		LoginPage login=new LoginPage(driver);
		login.loginAction(username, password);
		
		System.out.println("login is successfull");
	}
	
	@AfterMethod
	public void afMethod() {
		HomePage home=new HomePage(driver);
		home.logoutAction();
		
	}
	
	 @AfterClass
     public void acConfig() {
   	  driver.quit();
     }
     
     @AfterTest
     public void atConfig() {
   	  System.out.println("close the parallel execution");
     }
     
     @AfterSuite
     public void asConfig() throws SQLException{
    	 connection.close();
   	  System.out.println("The data base has been closed");
     }
	
}
