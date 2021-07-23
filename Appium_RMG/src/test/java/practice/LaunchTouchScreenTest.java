package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.GenericUtils.JSONFileUtility;

import io.appium.java_client.android.AndroidDriver;

public class LaunchTouchScreenTest {
	
	public static void main(String[]args) throws Throwable
	{
		JSONFileUtility jUtil=new JSONFileUtility();
		String devName=jUtil.readDataFromJSON("deviceName");
		String autoName=jUtil.readDataFromJSON("automationName");
		String platName=jUtil.readDataFromJSON("platformName");
		String platVersion=jUtil.readDataFromJSON("platformVersion");
		String udid=jUtil.readDataFromJSON("UDID");
		
		DesiredCapabilities dc=new DesiredCapabilities();
		//Common Desired Capabilities
		dc.setCapability("deviceName", devName);
		dc.setCapability("automationName", autoName);
		dc.setCapability("platformName", platName);
		dc.setCapability("platformVersion", platVersion);
		dc.setCapability("UDID", udid);
		//Desire Capabilities for Android
		dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
		dc.setCapability("appActivity", ".TouchScreenTestActivity");
		
		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
