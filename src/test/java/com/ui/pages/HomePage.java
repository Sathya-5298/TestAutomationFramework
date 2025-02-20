package com.ui.pages;

import org.openqa.selenium.By;

import com.qa.constants.Browser;
import static com.qa.constants.Enviornment.*;
import com.qa.utility.BrowserUtility;
import com.qa.utility.JsonUtility;

import static com.qa.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility
{
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");
	
	public HomePage(Browser browserName) 
	{
		super(browserName); //calls parent class constructor from child class constructor
		// goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JsonUtility.readJson(QA));
	}
	
	public LoginPage goToLoginPage()
	{
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	
	
	
}
