package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.GenericUtils.BaseClass;
import com.appium.GenericUtils.PropertyFileUtility;

import io.appium.java_client.android.AndroidDriver;

public class APIDemosTestScript extends BaseClass {
	
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
		
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);
		//driver.findElementByAccessibilityId("Views").click();
		
		/*List<WebElement> options=driver.findElementsByXPath("//android.widget.TextView[@resource-id='android:id/text1']");
		List<WebElement> options=driver.findElementsByClassName("android.widget.TextView");
		for(int i=1;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}*/
		
	}

}
