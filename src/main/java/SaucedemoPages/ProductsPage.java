package SaucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.AbstractComp;

public class ProductsPage extends AbstractComp{

	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	WebElement addCart;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cartBtn;
	
	public CartPage addToCart()
	{
		addCart.click();
		cartBtn.click();
		return new CartPage(driver);
	}
}
