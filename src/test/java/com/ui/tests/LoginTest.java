package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.utility.LoggerUtility;
import com.ui.pojo.User;


@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
//	@Test(description = "Verifies Login with Valid Credentails", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestJsonDataProvider")
//	public void loginTest(User user)
//	{
//		
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Suresh K");
//
//	}
//	
//	@Test(description = "Verifies Login with Valid Credentails", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
//			dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginCSVTest(User user)
//	{
//		
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Suresh K");
//
//	}
	
	@Test(description = "Verifies Login with Valid Credentails", groups = {"e2e","sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void loginExcelTest(User user)
	{
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Suresh K");

	}
}
