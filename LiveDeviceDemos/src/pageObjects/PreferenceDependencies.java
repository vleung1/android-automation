package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependencies {
	
	public PreferenceDependencies(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement WiFi;
	@AndroidFindBy(xpath="(//android.widget.TextView)[4]")
	public WebElement WiFiSettings;
	@AndroidFindBy(id="android:id/edit")
	public WebElement EditField;
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> OK;

}
