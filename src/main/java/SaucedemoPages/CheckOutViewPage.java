package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Components.AbstractComp;

public class CheckOutViewPage extends AbstractComp {
	
	WebDriver driver;
	public CheckOutViewPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='summary_total_label']")
	WebElement prodPrice;
	@FindBy(id = "finish")
	WebElement Finish;
	
	
	public ConfirmPage checkoutPageDetails() 
	{
	//Checkout Page
	WaitForElementToAppear(prodPrice);
	String TotalPrice = prodPrice.getText();
	
	System.out.println(TotalPrice);
	Finish.click();
	return new ConfirmPage(driver);
	
	}

}
