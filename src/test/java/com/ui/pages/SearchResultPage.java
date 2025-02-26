package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility
{
	
	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LIST_NAME_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
	

	public SearchResultPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public String getSearchProductTitle()
	{
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchTermPrsentInProductList(String searchTerm)
	{
		List<String> keyWords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		
		List<String> productNameList = getALLVisibleText(ALL_PRODUCT_LIST_NAME_LOCATOR);
		
		boolean result = productNameList.stream().anyMatch(name -> (keyWords.stream().anyMatch(name.toLowerCase()::contains)));
		
		return result;
	}
	
	public ProductDetailsPage clickOnTheProduct(int index)
	{
		clickOn(getALLElements(ALL_PRODUCT_LIST_NAME_LOCATOR).get(index));
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
		
		return productDetailsPage;
	}
	
	
	
	
}
