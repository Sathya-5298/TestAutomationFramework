package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.utility.FakeAddressUtility;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPojo;

public class AddNewFirstAddressTest extends TestBase
{
	
	private MyAccountPage myAccountPage;
	
	private AddressPojo address;
	
	@BeforeMethod(description = "Login into application with valid credentials for first time")
	public void setUp()
	{
		myAccountPage = homePage.goToLoginPage().doLoginWith("xefixo5258@bitflirt.com", "Password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress()
	{
		 String newAddress = myAccountPage.goToAddAddressPage().saveAddress(address);
		 Assert.assertEquals(newAddress, address.getMyAddress().toUpperCase());
	}
	
}
