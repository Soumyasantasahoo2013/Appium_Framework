package practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.GenericUtils.JSONFileUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ZoomAction {

	@Test
	public void zoomAction() throws Throwable
	{
		
		AppiumDriverLocalService server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.usingPort(4723)
				.withLogFile(new File("../AppiumSDET17/Logs.txt")));
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
		dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");

		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver=new AndroidDriver(url,dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Image display']")).click();
		driver.zoom(driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView")));
		Thread.sleep(3000);
		driver.pinch(driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView")));
	}
}
