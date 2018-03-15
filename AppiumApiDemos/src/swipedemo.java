import java.net.MalformedURLException;
import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class swipedemo extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Views']")).perform();
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']")).perform();
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']")).perform();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		//use the swipe functionality
		t.press(driver.findElementByXPath("//*[@content-desc='15']")).waitAction(Duration.ofSeconds(10)).moveTo(driver.findElementByXPath("//*[@content-desc='45']")).release().perform();
		
		
	}

}
