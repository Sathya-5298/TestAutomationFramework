package com.ui.tests;

import static com.qa.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {
	
	HomePage homePage;
	
	@BeforeMethod(description = "Invokes Browser and Loads the homepage of website")
	public void setUp()
	{
		homePage = new HomePage(CHROME);
	}

	@Test(description = "Verifies Login with Valid Credentails", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestJsonDataProvider")
	public void loginTest(User user)
	{
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Suresh K");

	}
	
	@Test(description = "Verifies Login with Valid Credentails", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user)
	{
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Suresh K");

	}
	
	@Test(description = "Verifies Login with Valid Credentails", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void loginExcelTest(User user)
	{
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Suresh K");

	}
}
