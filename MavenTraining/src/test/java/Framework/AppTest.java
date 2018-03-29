package Framework;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest {

	@Test
	public void test() throws MalformedURLException {
		
		//set the path for the app to use and make sure .apk is copied into src folder
		File f = new File("src");
		File fs = new File(f, "ApiDemos-debug.apk");

		//this is config for automating on Android emulator
		//set the class
		DesiredCapabilities cap = new DesiredCapabilities();
		//set the device type, in this case, emulator
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5XTest");
		//set the app name and path, using the above path
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		//create driver and set the connection to the appium server
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		//Wait for 10 seconds if object is not displayed. If it displayed in less than 10 seconds then resume the execution
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}
