package com.ui.tests;

import com.ui.pages.HomePage;
import static com.qa.constants.Browser.*;
import com.ui.pages.LoginPage;

public class LoginTestOld {

	public static void main(String[] args) 
	{
		HomePage homePage = new HomePage(EDGE);
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("xefixo5258@bitflirt.com", "Password");
		

	}
}
