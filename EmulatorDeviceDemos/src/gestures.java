import java.net.MalformedURLException;
import java.time.Duration;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class gestures extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		//use the tap, press and hold, and get text functionalities
		
		//click Views
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		//click Expandable Lists using tap method instead of click
		TouchAction t = new TouchAction(driver);
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")).perform();
		//click 1. Custom Adapter
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		//press and hold People Names
		t.press(driver.findElementByXPath("//android.widget.TextView[@text='People Names']")).waitAction(Duration.ofSeconds(10)).release().perform();
		//get text of Sample menu popup and print out, try finding by both xpath and id
		System.out.println(driver.findElementByXPath("(//android.widget.TextView)[1]").getText());
		System.out.println(driver.findElementsById("android:id/title").get(0).getText());	
	}

}
