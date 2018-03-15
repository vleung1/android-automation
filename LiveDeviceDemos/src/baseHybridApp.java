import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class baseHybridApp {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability("appPackage", "com.snc.test.webview2");
		cap.setCapability("appActivity", "com.snc.test.webview.activity.MainActivity");		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wd = new WebDriverWait(driver, 10);
		System.out.println(driver.getContext());
		driver.findElement(By.id("com.snc.test.webview2:id/action_go_website")).click();
		driver.findElement(By.id("com.snc.test.webview2:id/input_url")).sendKeys("http://yahoo.com");
		driver.findElement(By.id("android:id/button1")).click();
		Set<String> s = driver.getContextHandles();
		for(String handle : s) {
		System.out.println(handle);
		}
		driver.context("WEBVIEW_com.snc.test.webview2");
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("uh-search-ph")));
		driver.findElement(By.id("uh-search-ph")).sendKeys("Handling Handling hybrid app Handling");
	}

}
