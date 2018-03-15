import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class raagaradiotest extends base {

	public static void main(String[] args) throws MalformedURLException {
		//open Raaga app, click Done, click Skip to Raaga, click World Music, click Raaga Live Radio
		//click hamburger menu, click Settings, click Notifications, toggle Music Notifications on and off using x and y tap methods
		AndroidDriver<AndroidElement> driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		driver.findElementById("android:id/button2").click();
		driver.findElementById("com.raaga.android:id/skip_text").click();
		driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
		driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
		//this is a way of storing elements in their own container and calling them
		MobileElement element1 = driver.findElement(By.xpath("//android.widget.TextView[@text='New Releases']"));
		MobileElement element2 = driver.findElement(By.xpath("//android.widget.TextView[@text='Vocal']"));
		t.press(element2).waitAction(Duration.ofSeconds(2)).moveTo(element1).release().perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"));");
		driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();
		driver.findElementById("com.raaga.android:id/toolbar_logo").click();
		driver.findElementById("com.raaga.android:id/menu_settings_btn").click();
		driver.findElementById("com.raaga.android:id/app_push").click();
		//set the location of the toggle element
		Point point = driver.findElementById("com.raaga.android:id/toggle_notifyrecommend").getLocation();
		//toggle on
		t.tap(point.x+20, point.y+30).perform();
		//toggle off
		t.tap(point.x+100, point.y+30).perform();
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
	}
}
