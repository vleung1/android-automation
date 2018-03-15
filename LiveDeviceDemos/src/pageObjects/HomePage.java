package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//all the objects belonging to one page will be defined in a java class
public class HomePage {
	
	//this concatenates the driver
	public HomePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//set the locators for each element on the page
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	//set a name for the element-- when the element is called in the test case, it is same as calling driver.findelement()
	public WebElement Preferences;
}
