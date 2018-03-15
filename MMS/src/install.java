import java.net.MalformedURLException;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class install extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int starty = (int)(size.height * 0.50);
		int endy = (int)(size.height * 0.05);
		int startx = (int) (size.width / 2);
		
		t.tap(driver.findElementById("com.voicefive.mymobilesecure:id/beginButton")).perform();
		t.tap(driver.findElementByXPath("//*[@text='Allow']")).perform();
		t.tap(driver.findElementByXPath("//android.widget.Button[@text='I Agree']")).perform();
		driver.findElementsByClassName("android.widget.EditText").get(0).sendKeys("email" + generateString() + "@email.com");
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(0)).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"18\"));");
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='18']")).perform();
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(1)).perform();
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='Female']")).perform();
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(2)).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"$250,000 or more\"));");
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='$250,000 or more']")).perform();
		driver.findElementsByClassName("android.widget.EditText").get(1).sendKeys("11111");
		driver.hideKeyboard();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"HOUSEHOLD SIZE *\"));");
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(3)).perform();
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='5']")).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"CHILDREN UNDER 18 IN HOME? *\"));");
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(4)).perform();
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='Yes']")).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"RACE *\"));");
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(5)).perform();
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='Asian/Pacific Islander']")).perform();
		//Without this line, the vertical swipe fails. My guess is that by locating an element, it focuses back on the screen again correctly after the previous step of choosing from the dropdown choices
		driver.findElementByXPath("//android.view.View[@text='CHILDREN UNDER 18 IN HOME? *']");
		//need to scroll down twice for the next findelement to work for on larger screen sizes-- for example, one scroll was working on S5, but not for Nexus 6 
		t.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(startx, endy).release().perform();
		t.press(startx, starty).waitAction(Duration.ofMillis(1000)).moveTo(startx, endy).release().perform();
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(6)).perform();
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='not Spanish, Hispanic, or Latino']")).perform();
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(7)).perform();
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='English all or most of the time']")).perform();
		t.tap(driver.findElementsByClassName("android.widget.Spinner").get(8)).perform();
		t.tap(driver.findElementByXPath("//android.widget.CheckedTextView[@text='English']")).perform();
		t.tap(driver.findElementById("submit")).perform();
		t.tap(driver.findElementById("submitButton")).perform();
		t.tap(driver.findElementByXPath("//android.widget.Button[@text='OK']")).perform();
		t.tap(driver.findElementByXPath("//android.widget.Button[@text='Enable Accessibility']")).perform();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"MyMobileSecure\"));");
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='MyMobileSecure']")).perform();
		t.tap(driver.findElementByXPath("//android.widget.Switch[@text='OFF']")).perform();
		t.tap(driver.findElementByXPath("//*[@text='OK']")).perform();
		//able to enable Accessibility option, but does not automatically return to MMS app afterwards like during manual install-- must have something to do with appium running, maybe cannot execute this concurrently?
		//when this happens, i_installed stays at 0
		//interesting behavior seen-- if left at this screen, the next time Accessibility settings are open, all other Services have disappeared from the menu and need to restart the phone
		//t.tap(driver.findElementByXPath("//android.widget.Button[@text='Done']")).perform();

	}
	
	public static String generateString() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("uuid = " + uuid);
		return uuid;
    }

}
