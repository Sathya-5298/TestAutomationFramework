package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.constants.Browser;

public abstract class BrowserUtility 
{
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() 
	{
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) 
	{
		super();
		this.driver.set(driver); // Initialize the instance variable
		wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
	}
	
	public BrowserUtility(String browserName) 
	{
		logger.info("Launching the Browser for " + browserName);
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver.set(new ChromeDriver()); // Launch a browser window or Browser session is created
			maximizeWindow();
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver.set(new EdgeDriver()); // Launch a browser window or Browser session is created
			maximizeWindow();
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
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
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
		}
		else if(browserName == Browser.EDGE)
		{
			driver.set(new EdgeDriver()); // Launch a browser window or Browser session is created
			maximizeWindow();
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
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
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
			}
			else
			{
				driver.set(new ChromeDriver()); // Launch a browser window or Browser session is created
				maximizeWindow();
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
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
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
			}
			else
			{
				driver.set(new EdgeDriver()); // Launch a browser window or Browser session is created
				maximizeWindow();
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(25L));
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
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckBox(By locator)
	{
		logger.info("Clicking on the CheckBox " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}
	
	public void clickOn(WebElement element)
	{
		logger.info("Clicking on the element " + element);
		element.click();
	}
	
	
	public void enterText(By locator, String text)
	{
		logger.info("Entering Text for " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	
	public void clearText(By locator)
	{
		logger.info("Clearing Text for " + locator);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
	}
	
	public void selectFromDropdown(By dropdownLocator, String textToSelect)
	{
		logger.info("Selecting dropdown " + dropdownLocator);
		WebElement element = driver.get().findElement(dropdownLocator);
		Select select = new Select(element);
		logger.info("Selecting dropdown value " + textToSelect);
		select.selectByVisibleText(textToSelect);
	}
	
	public void enterSpecialKey(By locator, Keys keyToEnter)
	{
		logger.info("Entering Special Keys " + keyToEnter);
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);
	}
	
	public String getVisibleText(By locator)
	{
		logger.info("Finding element with " + locator);
		
		// WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Returing Visible Text " + locator);
		return element.getText();
		
	}
	
	public List<String> getALLVisibleText(By locator)
	{
		
		logger.info("Finding all element with " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		
		logger.info("Returing Visible Texts Lists");
		
		List<String> visibleTextList = new ArrayList<String>();
		
		for(WebElement element:elementList) 
		{
			visibleTextList.add(getVisibleText(element));
		}
		
		return visibleTextList;
	}
	
	public List<WebElement> getALLElements(By locator)
	{
		
		logger.info("Finding all element with " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		
		logger.info("Returing Visible Texts Lists");
		return elementList;
	}
	
	public String getVisibleText(WebElement element)
	{
		logger.info("Returing Visible Text " + element.getText());
		return element.getText();
		
	}
	
	public String takeScreenShot(String name)
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver.get();
		
		 File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
		 Date date = new Date();
		 SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		 String timeStamp = format.format(date);
		 String path = System.getProperty("user.dir") + ".//screenshots//" + name + "-" + timeStamp + ".png";
		 File screenShotFile = new File(path);
		 
		try 
		{
			FileUtils.copyFile(screenShotData, screenShotFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return path;
	}
	
	public void quit()
	{
		driver.get().quit();
	}
}
