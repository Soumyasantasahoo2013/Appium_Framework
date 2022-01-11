package com.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.GenericUtils.PropertyFileUtility;
import com.gargoylesoftware.htmlunit.javascript.host.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;

public class Orientation {
	
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
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		org.openqa.selenium.ScreenOrientation currentscreenorientation=driver.getOrientation();
		System.out.println(currentscreenorientation);
		Thread.sleep(2000);
		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		
		System.out.println(driver.getOrientation());
		Thread.sleep(2000);
		
		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		
		System.out.println(driver.getOrientation());
	}

}
