package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Components.AbstractComp;

public class CheckOutInfoPage extends AbstractComp {
	
	WebDriver driver;
	public CheckOutInfoPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	WebElement fName;
	@FindBy(id = "last-name")
	WebElement lName;
	@FindBy(id = "postal-code")
	WebElement postalCode;
	@FindBy(id = "continue")
	WebElement continueBtn;
	
	
	public CheckOutViewPage checkoutInfoDetails() 
	{
		fName.sendKeys("abc");
		lName.sendKeys("xyz");
		postalCode.sendKeys("500035");
		continueBtn.click();
		return new CheckOutViewPage(driver);
	
	}

}
