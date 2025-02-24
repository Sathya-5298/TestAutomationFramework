package com.qa.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.qa.constants.Enviornment;
import com.ui.pojo.Config;
import com.ui.pojo.Environments;

public class JsonUtility 
{
	public static Environments readJson(Enviornment env)
	{
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + "//Config//config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config =  gson.fromJson(fileReader, Config.class);
		Environments environment = config.getEnvironments().get("QA");
		return environment;
	}
}
