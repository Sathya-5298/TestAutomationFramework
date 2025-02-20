package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.qa.utility.CSVReaderUtility;
import com.qa.utility.ExcelReaderUtility;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class LoginDataProvider 
{
	
	@DataProvider(name = "LoginTestJsonDataProvider")
	public Iterator<Object[]> logInDataProvider()
	{
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "\\TestData\\LoginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(testDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		TestData testData = gson.fromJson(fileReader, TestData.class); //deserialization
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		
		for(User user:testData.getData())
		{
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> logInCSVDataProvider()
	{
		return CSVReaderUtility.readCSVFile("LoginData.csv");
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> logInExcelDataProvider()
	{
		return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
	}
}
