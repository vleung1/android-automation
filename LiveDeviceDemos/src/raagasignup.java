import java.net.MalformedURLException;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class raagasignup extends base {

	public static void main(String[] args) throws MalformedURLException {
		/*
		 * swipe splash screen 2x to see cards, select Done, select Sign Up
		 * fill full name, fill username, fill email, fill password, print out text above year of birth
		 * fill year of birth, fill gender, click Create
		 */
		AndroidDriver<AndroidElement> driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int startx = (int)(size.width * 0.80);
		int endx = (int)(size.width * 0.10);
		int starty = (int) (size.height / 2);

		driver.findElementById("android:id/button2").click();
		//Without this line, the swipe fails. My guess is that by locating an element, it focuses back on the screen again correctly after the previous step
		driver.findElementById("com.raaga.android:id/helpscreen_image");
		t.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(endx, starty).release().perform();
		t.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(endx, starty).release().perform();
		t.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(endx, starty).release().perform();
		t.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(endx, starty).release().perform();
		t.tap(driver.findElementById("com.raaga.android:id/skip_text")).perform();		
		t.tap(driver.findElementById("com.raaga.android:id/landing_signup_btn")).perform();
		driver.findElementById("com.raaga.android:id/signup_name").sendKeys("John Smith");
		driver.findElementById("com.raaga.android:id/signup_user_name").sendKeys("jsmith");
		driver.findElementById("com.raaga.android:id/signup_email").sendKeys("email" + generateString() + "@email.com");
		driver.findElementById("com.raaga.android:id/signup_password").sendKeys("Testing1234!");
		System.out.println(driver.findElementById("com.raaga.android:id/signup_need_btn").getText());
		t.tap(driver.findElementByAndroidUIAutomator("resourceId(\"com.raaga.android:id/signup_year\")")).perform();
		t.tap(driver.findElementByAndroidUIAutomator("resourceId(\"com.raaga.android:id/signup_year\")")).perform();
		int x=1;
		for(x=1; x<=20; x++) {
			t.tap(driver.findElementByXPath("//android.widget.Button[@resource-id='com.raaga.android:id/year_minus']")).perform();
		}
		t.tap(driver.findElementById("com.raaga.android:id/SetDateTime")).perform();
		t.tap(driver.findElementById("com.raaga.android:id/signup_gender")).perform();		
		t.tap(driver.findElementById("com.raaga.android:id/signup_gender")).perform();	
		t.tap(driver.findElementByAndroidUIAutomator("resourceId(\"com.raaga.android:id/custom_alert_male\")")).perform();
		t.tap(driver.findElementById("com.raaga.android:id/signup_submit_btn")).perform();
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='World Music']")).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"));");
		System.out.println("Sign up test complete");
	}
	
	public static String generateString() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("uuid = " + uuid);
		return uuid;
    }

}
