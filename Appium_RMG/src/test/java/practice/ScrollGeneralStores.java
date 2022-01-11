package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.GenericUtils.JSONFileUtility;

import io.appium.java_client.android.AndroidDriver;

public class ScrollGeneralStores {

	@Test
	public void scrollGeneralStores() throws Throwable
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
		dc.setCapability("appPackage", "com.androidsample.generalstore");
		dc.setCapability("appActivity", ".SplashActivity");

		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");

	    AndroidDriver driver=new AndroidDriver(url,dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();
		scrollToElement(driver, "text", "India");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		
	}
	
	public static void scrollToElement(AndroidDriver driver,String an,String av)
	 {
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
	 }
}
