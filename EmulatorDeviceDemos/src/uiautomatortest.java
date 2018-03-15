import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class uiautomatortest extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities();

		//use the AndroidUIAutomator locator strategy, for both attribute and property
		
		//click Views
		//driver.findElementByAndroidUIAutomator("attribute(\"value\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//check and print out the number of properties on the screen that are clickable, in this case, zero
		//driver.findElementByAndroidUIAutomator("new UiSelector().property(value)");
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)"));
		
	}

}
