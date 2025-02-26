package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckOutTest extends TestBase
{
	
	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;
	
	
	@BeforeMethod(description = "User logs into application and search for product")
	public void setUp()
	{
		searchResultPage = homePage.goToLoginPage().doLoginWith("xefixo5258@bitflirt.com", "Password").searchForProduct(SEARCH_TERM);
	}
	
	@Test(description = "Verify logged user able to make product purchase", groups = {"e2e","sanity","smoke"}) 
	public void checkOutTest()
	{
		String result = searchResultPage.clickOnTheProduct(0).changeSize(L).addProductToCart().proceedToCheckOut().goToConfirmAddressPage()
		.goToShipmentPage().goToPaymentPage().makePaymentByWire();
		
		Assert.assertTrue(result.contains("order on My Shop"));
		
	}
}
