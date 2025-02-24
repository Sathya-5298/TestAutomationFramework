package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.constants.Browser;
import static com.qa.constants.Enviornment.*;
import com.qa.utility.BrowserUtility;
import com.qa.utility.JsonUtility;
import com.qa.utility.LoggerUtility;

import static com.qa.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility
{
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browserName, boolean isHeadless) 
	{
		super(browserName,isHeadless); //calls parent class constructor from child class constructor
		// goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JsonUtility.readJson(QA).getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver); // To Call the Parent Class constructor from the child constructor
		goToWebsite(JsonUtility.readJson(QA).getUrl());
	}
	
	public LoginPage goToLoginPage()
	{
		logger.info("Navigating to Sign in Page after clicking on Sign In button");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	
	
	
}
