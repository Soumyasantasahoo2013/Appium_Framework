package com.driver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.GenericUtils.PropertyFileUtility;
import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;

public class Screenshot {
	
	@Test
	public void screenshot() throws Throwable
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
		
		Thread.sleep(4000);
		takeScreenShot(driver, "generalstore");
	}
	
	public static void takeScreenShot(WebDriver driver, String screenshotName) throws Throwable
    {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst = new File("./Screenshot/"+screenshotName+".PNG");
    
    	try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
