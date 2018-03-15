import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabilities();
	
		//use different locator strategies, and use clicking and entering text functionalities
		
		//click Preference using xpath
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//click 3. Preference dependencies using xpath
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		//check the checkbox using ID
		driver.findElementById("android:id/checkbox").click();
		//click Wifi Settings by using index
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		//enter "hello" into text field
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		//click OK by using index
		driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
