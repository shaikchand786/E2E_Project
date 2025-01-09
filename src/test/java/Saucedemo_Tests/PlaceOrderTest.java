package Saucedemo_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import SaucedemoPages.CartPage;
import SaucedemoPages.CheckOutInfoPage;
import SaucedemoPages.CheckOutViewPage;
import SaucedemoPages.ConfirmPage;
import SaucedemoPages.ProductsPage;
import Utilities.BaseTest;

public class PlaceOrderTest extends BaseTest{
	
	@Test
	public void E2E_Application()
	{

		ProductsPage dashBoard = loginPage.LoginApplication();
		
		CartPage cartPage = dashBoard.addToCart();
		CheckOutInfoPage infoPage = cartPage.cartPageDetails();
		CheckOutViewPage viewPage = infoPage.checkoutInfoDetails();
		ConfirmPage cnfPage = viewPage.checkoutPageDetails();
		String finalMsg = cnfPage.confirmationMsg();
		Assert.assertEquals(finalMsg, "Thank you for your order!!");
		
	}
}
