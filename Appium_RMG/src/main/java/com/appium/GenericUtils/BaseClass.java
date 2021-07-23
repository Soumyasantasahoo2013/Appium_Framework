package com.appium.GenericUtils;

public class BaseClass {
	
	public static void main(String[]args) throws Throwable
	{
	PropertyFileUtility pUtil=new PropertyFileUtility();
	String devName=pUtil.readDataFromPropertyFile("deviceName");
	String autoName=pUtil.readDataFromPropertyFile("automationName");
	String platName=pUtil.readDataFromPropertyFile("platformName");
	String platVersion=pUtil.readDataFromPropertyFile("platformVersion");
	String udid=pUtil.readDataFromPropertyFile("UDID");
	}
}
