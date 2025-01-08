package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Components.AbstractComp;
import Utilities.BaseTest;

public class ConfirmPage extends AbstractComp {
	
	WebDriver driver;
	public ConfirmPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement confMsg;
	@FindBy(xpath = "//button[contains(text(),'Back Home')]")
	WebElement BackHome;
	
	
	public String confirmationMsg() 
	{
	//Checkout Page
	WaitForElementToAppear(confMsg);
	String FinalConfMsg = confMsg.getText();
	System.out.println(FinalConfMsg);
	
	BackHome.click();
	return FinalConfMsg;
		
	}

}
