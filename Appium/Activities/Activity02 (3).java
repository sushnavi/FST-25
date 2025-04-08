package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.options.XCUITestOptions;

public class Activity2 {
	// Driver declaration
	AppiumDriver androidDriver;
	AppiumDriver iosDriver;

	WebDriverWait wait;

	// Setup function
	@BeforeClass
	public void androidSetUp() throws MalformedURLException, URISyntaxException {
		// Set desired capabilities
		UiAutomator2Options options = new UiAutomator2Options().setPlatformName("android")
				.setAutomationName("UiAutomator2").setAppPackage("com.android.chrome")
				.setAppActivity("com.google.android.apps.chrome.Main").noReset();

		// Set Appium server url ( http://127.0.0.1:4723/ )
		URL serverURL = new URI("http://127.0.0.1:4723/").toURL();

		// Initialize driver
		androidDriver = new AndroidDriver(serverURL, options);

		wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10));

		androidDriver.get("https://training-support.net");
	}

	@Test
	public void chromeTest() { // Make sure to open the app in the emulator before starting the test else it
								// will fail
		// Find page heading

		String pageHeading = wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Training Support\"]")))
				.getText();
		System.out.println(pageHeading);
		
		//Find About Us botton, click to go to next page and assert page heading of next page
	}

	@AfterClass
	public void tearDown() {
		// Close the app
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
