package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.qa.constants.Browser;

public abstract class BrowserUtility 
{
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() 
	{
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) 
	{
		super();
		this.driver.set(driver); // Initialize the instance variable
	}
	
	public BrowserUtility(String browserName) 
	{
		logger.info("Launching the Browser for " + browserName);
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver.set(new ChromeDriver()); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver.set(new EdgeDriver()); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else
		{
			logger.error("Selected Invalid Browser!!");
			System.err.println("Selected Invalid Browser!!");
		}
	}
	
	public BrowserUtility(Browser browserName) 
	{
		logger.info("Launching the Browser for " + browserName);
		if(browserName == Browser.CHROME)
		{
			driver.set(new ChromeDriver()); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else if(browserName == Browser.EDGE)
		{
			driver.set(new EdgeDriver()); // Launch a browser window or Browser session is created
			maximizeWindow();
		}
		else
		{
			logger.error("Selected Invalid Browser!!");
			System.err.println("Selected Invalid Browser!!");
		}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) 
	{
		logger.info("Launching the Browser for " + browserName);
		if(browserName == Browser.CHROME)
		{
			if(isHeadless)
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless"); //headless mode
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options)); // Launch a browser window or Browser session is created
				maximizeWindow();
			}
			else
			{
				driver.set(new ChromeDriver()); // Launch a browser window or Browser session is created
				maximizeWindow();
			}
		}
		else if(browserName == Browser.EDGE)
		{
			if(isHeadless)
			{
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old"); //headless mode
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(options)); // Launch a browser window or Browser session is created
				maximizeWindow();
			}
			else
			{
				driver.set(new EdgeDriver()); // Launch a browser window or Browser session is created
				maximizeWindow();
			}
		}
		else
		{
			logger.error("Selected Invalid Browser!!");
			System.err.println("Selected Invalid Browser!!");
		}
	}
	
	public void goToWebsite(String url)
	{
		logger.info("Launching the Website " + url);
		driver.get().get(url);
	}
	
	public void maximizeWindow()
	{
		logger.info("Maximizing the Browser");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		logger.info("Clicking on the Locator " + locator);
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String text)
	{
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
	}
	
	public String getVisibleText(By locator)
	{
		WebElement element = driver.get().findElement(locator);
		return element.getText();
		
	}
	
	public String takeScreenShot(String name)
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver.get();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir" + "//Screenshots//" + name +" - "+ timeStamp + ".png");
		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	public void quit()
	{
		driver.get().quit();
	}
}
