package com.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.qa.constants.Browser;

public abstract class BrowserUtility 
{
	private WebDriver driver;

	public WebDriver getDriver() 
	{
		return driver;
	}

	public BrowserUtility(WebDriver driver) 
	{
		super();
		this.driver = driver; // Initialize the instance variable
	}
	
	public BrowserUtility(String browserName) 
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver(); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver(); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else
		{
			System.err.println("Selected Invalid Browser!!");
		}
	}
	
	public BrowserUtility(Browser browserName) 
	{
		if(browserName == Browser.CHROME)
		{
			driver = new ChromeDriver(); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else if(browserName == Browser.EDGE)
		{
			driver = new EdgeDriver(); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else
		{
			System.err.println("Selected Invalid Browser!!");
		}
	}
	
	public void goToWebsite(String url)
	{
		driver.get(url);
	}
	
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		WebElement element = driver.findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String text)
	{
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}
	
	public String getVisibleText(By locator)
	{
		WebElement element = driver.findElement(locator);
		return element.getText();
		
	}
	
	
	
	
}
