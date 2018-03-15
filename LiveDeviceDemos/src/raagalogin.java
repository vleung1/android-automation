import java.net.MalformedURLException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class raagalogin extends base {

	public static void main(String[] args) throws MalformedURLException {
		/*
		 * swipe splash screen 2x to see cards, select Done, select Sign In
		 * enter email, enter password, click Log in
		 */
		AndroidDriver<AndroidElement> driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		t.tap(driver.findElementById("android:id/button2")).perform();
		t.tap(driver.findElementById("com.raaga.android:id/skip_text")).perform();		
		t.tap(driver.findElementById("com.raaga.android:id/landing_signin_btn")).perform();
		driver.findElementById("com.raaga.android:id/signin_email").sendKeys("jsmith8888@gmail.com");
		driver.findElementById("com.raaga.android:id/signin_password").sendKeys("Testing1234!");
		t.tap(driver.findElementById("com.raaga.android:id/signin_submit_btn")).perform();
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='World Music']")).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"));");
		System.out.println("Sign in test complete");
	}
}
