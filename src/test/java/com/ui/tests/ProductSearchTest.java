package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listeners.TestListener.class})
public class ProductSearchTest extends TestBase
{
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "printed summer dress";
	
	@BeforeMethod(description = "Login into application with valid credentials")
	public void setUp()
	{
		myAccountPage = homePage.goToLoginPage().doLoginWith("xefixo5258@bitflirt.com", "Password");
	}
	
	
	@Test(description = "Verify as a logged user able to search for a product and correct products search result are displayed",
			groups = {"e2e","sanity","smoke"})
	public void verifySearchProductTest()
	{
		boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPrsentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}
}
