package com.appium.GenericUtils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class PropertyFileUtility {
	
    
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream("./Data/commonData.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value=prop.getProperty(key);
		return value;
			
	}

}
