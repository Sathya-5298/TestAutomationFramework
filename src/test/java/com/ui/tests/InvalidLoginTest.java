package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.utility.LoggerUtility;
import com.ui.pojo.User;


@Listeners({com.ui.listeners.TestListener.class})
public class InvalidLoginTest extends TestBase {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private static final String INVALID_EMAIL_ADDRESS = "sadfre@gmail.com";
	private static final String INVALID_PASSWORD = "sapoouu12";
	
	@Test(description = "Verifies Login with InValid Credentails and proper error message should be displayed", groups = {"e2e","sanity"})
	public void loginTest()
	{
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentails(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(), "Authentication failed.");
	}
}
