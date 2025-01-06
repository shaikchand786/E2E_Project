package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SaucedemoPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;
//	public String url;

	//Webdriver initialization
	public WebDriver initDriver() throws IOException  
	{
		//properties class
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\GlobalData.properties");
		prop.load(fis);
//		Tribrowser - Java Ternary Operator(Conditional Operator) : It takes three operands (Syntax: condition ? argument1 : argument2;)
		String BrowserName = System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(BrowserName.contains("chrome"))
		{
			//chrome
			WebDriverManager.chromedriver().setup();		
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			//firefox
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("MSEdge")) {
			//Microsoft Edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeMethod
	public LoginPage launchApp() throws IOException 
	{	
		driver = initDriver();
		loginPage = new LoginPage(driver);
		loginPage.enterURL();
		return new LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDownApp()
	{
		driver.close();
	}
}