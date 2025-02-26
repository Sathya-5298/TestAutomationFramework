package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.constants.Size;
import com.qa.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility
{
	private static final By SIZE_SELECTION_DROPDOWN = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[@title='Proceed to checkout']");
	
	public ProductDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public ProductDetailsPage changeSize(Size size)
	{
		selectFromDropdown(SIZE_SELECTION_DROPDOWN, size.toString());
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage addProductToCart()
	{
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}
	
	public ShoppingCartPage proceedToCheckOut()
	{
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		return new ShoppingCartPage(getDriver());
	}
	
	
}
