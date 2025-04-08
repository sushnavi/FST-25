package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.options.XCUITestOptions;

public class Activity1 {
	// Driver declaration
	AppiumDriver androidDriver;
	AppiumDriver iosDriver;

	// Setup function
	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {
		// Set desired capabilities
		UiAutomator2Options options = new UiAutomator2Options().setPlatformName("android")
				.setAutomationName("UiAutomator2").
				setAppPackage("com.google.android.calculator").
				setAppActivity("com.android.calculator2.Calculator").
				noReset();
		
		// Set Appium server url (  http://127.0.0.1:4723/ )
		URL serverURL = new URI("http://127.0.0.1:4723/").toURL();
		
		// Initialize driver
		androidDriver = new AndroidDriver(serverURL, options);
	}
	
	@Test
	public void calculatorTest() { //Make sure to open the app in the emulator before starting the test else it will fail
		//Find and tap digit 8
		androidDriver.findElement(AppiumBy.id("digit_8")).click();//com.google.android.calculator:id/ is prefixed at runtime
		//Find and tap mult symbol
		androidDriver.findElement(AppiumBy.accessibilityId("multiply")).click();
		//Find and tap digit 3
		androidDriver.findElement(AppiumBy.id("digit_3")).click();
		//Find and tap symbol =
		androidDriver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		//Find and get the result text
		String result = androidDriver.findElement(AppiumBy.id("result_final")).getText();
		
		//Assertion
		assertEquals(result, "24");
		
	}
	
	@AfterClass
	public void tearDown() {
		//Close the app
		androidDriver.quit();
	}
	

//	@BeforeClass
//	public void iosSetUp() throws MalformedURLException, URISyntaxException {
//		// Set desired capabilities
//		XCUITestOptions options = new XCUITestOptions().
//				setPlatformName("ios").
//				setAutomationName("XCUITest").
//				setApp("path/to/file.ipa").
//				noReset();
//
//		// Set Appium server url (  http://127.0.0.1:4723/ )
//		URL serverURL = new URI("http://127.0.0.1:4723/").toURL();
//		// Initialize driver
//		iosDriver = new IOSDriver(serverURL, options);
//
//	}
}
