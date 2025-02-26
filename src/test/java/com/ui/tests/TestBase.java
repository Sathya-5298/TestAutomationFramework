package com.ui.tests;

import static com.qa.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.constants.Browser;
import com.qa.utility.BrowserUtility;
import com.qa.utility.LambdaTestUtility;
import com.qa.utility.LoggerUtility;
import com.ui.pages.HomePage;

public class TestBase 
{
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Invokes Browser and Loads the homepage of website")
	public void setUp(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,@Optional("false") boolean isHeadless, ITestResult result)
	{
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest)
		{
			lambdaDriver = LambdaTestUtility.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
			
		}
		else
		{
			logger.info("Invokes Browser and Loads the homepage of website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	
	public BrowserUtility getInstance()
	{
		return homePage;
	}
	
	@AfterMethod(description = "Tear Down the browser")
	public void tearDown()
	{
		if(isLambdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else
		{
			homePage.quit();
		}
	}
}
