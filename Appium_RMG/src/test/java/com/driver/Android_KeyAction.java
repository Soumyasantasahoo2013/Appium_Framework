package com.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.GenericUtils.PropertyFileUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Android_KeyAction {
	
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
		dc.setCapability("noRest", true);
		//Desire Capabilities for Android
		dc.setCapability("appPackage", "com.sec.android.app.camera");
		dc.setCapability("appActivity", ".Camera");
		
		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		//System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		//System.out.println(AndroidKeyCode.BACK);
		//System.out.println(AndroidKeyCode.ENTER);
		//System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		//System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		//System.out.println(AndroidKeyCode.KEYCODE_CAMERA);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		//driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		//Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		Thread.sleep(2000);
		driver.openNotifications();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		
	}

}
