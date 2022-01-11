package com.webapp;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ShopPage {
	public AndroidDriver driver;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")
	private MobileElement addToCartBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private MobileElement cartBtn;

	/**
	 * @return the addToCartBtn
	 */
	public MobileElement getAddToCartBtn() {
		return addToCartBtn;
	}

	/**
	 * @return the cartBtn
	 */
	public MobileElement getCartBtn() {
		return cartBtn;
	}
	
	public ShopPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void addProductToCart()
	{
		addToCartBtn.click();
		cartBtn.click();
	}

}
