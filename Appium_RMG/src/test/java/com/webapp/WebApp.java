package com.webapp;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.GenericUtils.PropertyFileUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebApp {

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
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, devName);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, autoName);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platName);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platVersion);
		dc.setCapability(MobileCapabilityType.UDID, udid);
		dc.setCapability(MobileCapabilityType.NO_RESET, true);

		//Launch the browser
		dc.setCapability("browserName", "chrome");

		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver=new AndroidDriver(url,dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://m.facebook.com");
		
		driver.findElement(By.xpath("//input[@id='m_login_email']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@id='m_login_password']")).sendKeys("1234");
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

}
