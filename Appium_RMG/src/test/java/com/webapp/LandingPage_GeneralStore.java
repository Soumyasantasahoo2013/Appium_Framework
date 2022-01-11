package com.webapp;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage_GeneralStore {
	
	public AndroidDriver driver;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1']")
	private MobileElement countrydd;
	
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement name;

	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement gender;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement shopBtn;

	/**
	 * @return the countrydd
	 */
	public MobileElement getCountrydd() {
		return countrydd;
	}

	/**
	 * @return the name
	 */
	public MobileElement getName() {
		return name;
	}

	/**
	 * @return the gender
	 */
	public MobileElement getGender() {
		return gender;
	}

	/**
	 * @return the shopBtn
	 */
	public MobileElement getShopBtn() {
		return shopBtn;
	}
	
	public LandingPage_GeneralStore(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void setLogin(String username)
	{
		countrydd.click();
		name.sendKeys(username);
		gender.click();
		shopBtn.click();
	}
	
}
