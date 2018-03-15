import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.PreferenceDependencies;
import pageObjects.Preferences;

public class pageObjFactoryTests extends basePoConfig {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		//create an object for each page
		HomePage h = new HomePage(driver);
		Preferences p = new Preferences(driver);
		PreferenceDependencies pd = new PreferenceDependencies(driver);
		//call each page to interact with the elements on the page
		h.Preferences.click();		
		p.PreferenceDependencies.click();
		pd.WiFi.click();
		pd.WiFiSettings.click();
		pd.EditField.sendKeys("hello");
		pd.OK.get(1).click();
	}

}
