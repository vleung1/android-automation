import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browserTests extends baseChrome {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		TouchAction t = new TouchAction(driver);
		
		/* facebook test
		driver.get("http://www.facebook.com");
		driver.findElementByXPath("//*[@id='m_login_email']").sendKeys("qwwerty");
		driver.findElementByName("pass").sendKeys("123456");
		driver.findElementByXPath("//button[@name='login']").click();
		*/
		
		/* scrolling test
		driver.get("http://cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,480)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		Assert.assertTrue(driver.findElementByXPath("//h4[@text()='Top Stories']").getAttribute("class").contains("header"));
		*/
		
		/*
		//go to ebay on mobile browser, search for books, and output first 2 listings
		driver.get("http://ebay.com");
		driver.findElementByXPath("//input[@type='search']").sendKeys("books");
		driver.findElementByXPath("//input[@type='submit']").click();
		System.out.println(driver.findElementsByClassName("s-item__title").get(0).getAttribute("textContent"));
		System.out.println(driver.findElementsByClassName("s-item__title").get(1).getAttribute("textContent"));
		*/
		
		//explicit wait
		WebDriverWait wd = new WebDriverWait(driver, 5);
		
		
		//handling iframes using CAPTCHA for testing
		driver.get("https://www.google.com/recaptcha/api2/demo");
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.id("recaptcha-demo-form")));
		int number = findFrameNumber(driver, By.xpath(".//*[@id='recaptcha-anchor']/div[5]"));
		driver.switchTo().frame(number);
		driver.findElementByXPath(".//*[@id='recaptcha-anchor']/div[5]").click();
		driver.switchTo().defaultContent();
		
		int number1 = findFrameNumber(driver, By.xpath("//*[@id='recaptcha-verify-button']"));
		driver.switchTo().frame(number1);
		driver.findElementByXPath("//*[@id='recaptcha-verify-button']").click();
	
		
	
	}
	
	//create a method to reuse for handling iframes in web pages-- this is just a utility to return the number of the frame where the element is found-- the action will take place in the test script itself
	public static int findFrameNumber(AndroidDriver<AndroidElement> driver, By by) {
		int i;
		//create count of how many frames on page
		int framecount = (driver.findElementsByTagName("iframe")).size();
		//for each of the frames, switch to the frame and search for the element and click
		for(i=0; i<framecount; i++) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
		//this approach identifies if the element exists by setting a list to 1 and then clicking on it if so, which is more reliable than using isDisplayed() function, which is buggy on appium
		int count = driver.findElements(by).size();
		if (count > 0) {
			//if looking for just this 1 element and found, click and exit the loop-- if this is not here, loop will continue for all frames 
			break;
		}
		else {
			System.out.println("Element not found in this frame, looping to next frame");
		}
		}
		//must revert back to default frame (original web page) after this is complete, or test script cannot continue to work
		driver.switchTo().defaultContent();
		return i;
	}

}
