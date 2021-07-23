package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LaunchCalculator {
	
	public static void main(String[]args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		//Common Desired Capabilities
		dc.setCapability("deviceName", "Galaxy M30s");
		dc.setCapability("automationName", "appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "11");
		dc.setCapability("UDID", "RZ8M83ZJH2W");
		//Desire Capabilities for Android
		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity", ".Calculator");
		
		//Appium server URL
		URL url=new URL("http://localhost:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Procedure=1
		/*driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Plus").click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equal\"]")).click();
		Thread.sleep(1000);
		String result=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Result preview\"]")).getText();
		Thread.sleep(1000);
		System.out.println(result);*/
		
		MobileElement five=(MobileElement)driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
		driver.tap(1, five, 500);
	
		WebElement plus=driver.findElementByAccessibilityId("Plus");
		driver.tap(1, plus, 300);
		
		MobileElement three=(MobileElement)driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
		driver.tap(1, three , 500);
		
		WebElement equals=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equal\"]"));
		driver.tap(1, equals, 500);
		
		String result=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Result preview\"]")).getText();
		Thread.sleep(1000);
		System.out.println(result);
	}

}
