package com.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.GenericUtils.PropertyFileUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class NetworkConnection {
	
	public static void main(String[]args) throws Throwable
	{
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String devName=pUtil.readDataFromPropertyFile("deviceName");
		String autoName=pUtil.readDataFromPropertyFile("automationName");
		String platName=pUtil.readDataFromPropertyFile("platformName");
		String platVersion=pUtil.readDataFromPropertyFile("platformVersion");
		String udid=pUtil.readDataFromPropertyFile("UDID");
		
		DesiredCapabilities dc=new DesiredCapabilities();
		//Common Desired Capabilities
		dc.setCapability("deviceName", devName);
		dc.setCapability("automationName", autoName);
		dc.setCapability("platformName", platName);
		dc.setCapability("platformVersion", platVersion);
		dc.setCapability("UDID", udid);
		//Desire Capabilities for Android
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");
		
		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Connection currentstate = driver.getConnection();
		System.out.println(currentstate);
		driver.setConnection(Connection.WIFI);
		System.out.println(driver.getConnection());
		
		driver.setConnection(Connection.DATA);
		System.out.println(driver.getConnection());
		
		driver.setConnection(Connection.AIRPLANE);
		System.out.println(driver.getConnection());
	}

}
