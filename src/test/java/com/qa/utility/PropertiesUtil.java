package com.qa.utility;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.qa.constants.Enviornment;

public class PropertiesUtil 
{
	public static String readProperty(Enviornment env, String propertyName)
	{
		System.out.println(System.getProperty("user.dir"));
		File propFile = new File(System.getProperty("user.dir") + "\\Config\\" + env + ".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;
		
		
	}
}
