package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	
	public CheckOutInfoPage cartPageDetails() {
		
		checkoutBtn.click();
		return new CheckOutInfoPage(driver);
	}
}
