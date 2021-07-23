package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Swipe {
	
	public static void main(String[]args) throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		//Common Desired Capabilities
		dc.setCapability("deviceName", "Galaxy M30s");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "11");
		dc.setCapability("UDID", "RZ8M83ZJH2W");
		//Desire Capabilities for Android
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", ".TouchScreenTestActivity");
		
		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		//Vertical Swipe
		driver.swipe(500, 594, 500, 1747, 500);
		
		//Horizontal Swipe
		driver.swipe(100, 850, 900, 850, 500);
		
		//Inclined Swipe
		driver.swipe(100, 1400, 750, 530, 500);*/
		
		Dimension size=driver.manage().window().getSize();
		int ht=size.getHeight();
		int wd=size.getWidth();
		System.out.println("Height or Length of the phone ="+ ht);
		System.out.println("Width of the Phone ="+ wd);
		
		//Vertical Swipe
		driver.swipe(wd/2, (int)(ht*0.75) , wd/2, (int)(ht*0.25), 1000);
		
		//Horizontal Swipe
		driver.swipe((int)(wd*0.20), ht/2, (int)(wd*0.80), ht/2, 1000);
		
	}

}
