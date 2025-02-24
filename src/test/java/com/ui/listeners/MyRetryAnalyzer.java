package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.qa.constants.Enviornment;
import com.qa.utility.JsonUtility;
import com.qa.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer
{
	// private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Enviornment.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	
	private static final int MAX_NUMBER_OF_ATTEMPTS = JsonUtility.readJson(Enviornment.QA).getMAX_NUMBER_OF_ATTEMPTS();
	
	private static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}	
		return false;
	}
}
