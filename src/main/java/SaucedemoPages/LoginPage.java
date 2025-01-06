package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.AbstractComp;

public class LoginPage extends AbstractComp{

	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='login_credentials']")
	WebElement UN;
	@FindBy(id = "user-name")
	WebElement uName;
	@FindBy(xpath ="//div[@class='login_password']")
	WebElement PW;
	@FindBy(id = "password")
	WebElement PassWord;
	@FindBy(id = "login-button")
	WebElement btn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize elements
	}


	public ProductsPage LoginApplication() {
//	WaitForElementToAppear(UN);
	System.out.println(UN);
	String allText = UN.getText();
	String userName="";
	String[] probUsers = allText.split("\\r?\\n");
	for(String probUser : probUsers) 
	{
		if(probUser.trim().equalsIgnoreCase("standard_user")) {
			userName = probUser;
		}
	}
	
//	WaitForElementToAppear(uName);
	uName.sendKeys(userName);
//	uName.
	
	String allPW = PW.getText();
	String passWord="";
	String[] probPWs = allPW.split("\\r?\n");
	for(String probPW : probPWs) {
		if(probPW.trim().equalsIgnoreCase("secret_sauce")) {
			passWord = probPW;
		}
	}
	PassWord.sendKeys(passWord);
	
	WaitForElementToAppear(btn);
	btn.click();
	
	return new ProductsPage(driver);
	}
	
	public void enterURL() {
		driver.get("https://www.saucedemo.com");
	}
}
