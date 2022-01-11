package com.driver;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.GenericUtils.PropertyFileUtility;

import io.appium.java_client.android.AndroidDriver;

public class Switch_App2 {

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

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Soumya");

		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']").click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(4000);
		
		Set<String> windows=driver.getContextHandles();
		
		for(String window: windows)
		{
			System.out.println("Active Applications :"+window);
		}
		
		Thread.sleep(1000);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("TYSS");
		
		
		
	}
}