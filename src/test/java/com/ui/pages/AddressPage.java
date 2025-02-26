package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utility.BrowserUtility;
import com.ui.pojo.AddressPojo;

public class AddressPage extends BrowserUtility
{
	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS_TEXTBOX_LOCATOR = By.xpath("//input[@id='address1']");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By ZIPCODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOMEPHONE_TEXTBOX_LOCATOR = By.xpath("//input[@id='phone']");
	private static final By MOBILEPHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_TEXTAREA_LOCATOR = By.id("other");
	private static final By MYADDRESS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");
	
	
	public AddressPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public String saveAddress(AddressPojo addressPojo)
	{
		enterText(COMPANY_TEXTBOX_LOCATOR, addressPojo.getCompanyName());
		enterText(ADDRESS_TEXTBOX_LOCATOR, addressPojo.getAddressLine1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPojo.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPojo.getCity());
		enterText(ZIPCODE_TEXTBOX_LOCATOR, addressPojo.getPostCode());
		enterText(HOMEPHONE_TEXTBOX_LOCATOR, addressPojo.getHomePhoneNumber());
		enterText(MOBILEPHONE_TEXTBOX_LOCATOR, addressPojo.getMobileNumber());
		enterText(ADDITIONAL_TEXTAREA_LOCATOR, addressPojo.getAdditionalInformation());
		clearText(MYADDRESS_TEXTBOX_LOCATOR);
		enterText(MYADDRESS_TEXTBOX_LOCATOR, addressPojo.getMyAddress());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR,addressPojo.getState());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		
		 String newAddress = getVisibleText(ADDRESS_HEADING);
		 
		 return newAddress;
	}

}
