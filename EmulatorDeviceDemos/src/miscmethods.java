import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class miscmethods extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities();
		
		//get the activity that is running in the app
		System.out.println(driver.currentActivity());
		
		//get context
		System.out.println(driver.getContext());
		
		//get orientation
		System.out.println(driver.getOrientation());

		//show if app is locked or not
		System.out.println(driver.isLocked());

		//hide keyboard
		//driver.hideKeyboard();
		
		//click the Android back button
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}

}
