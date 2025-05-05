package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://www.training-support.net/webelements/dynamic-content");

        // Verify page title
        System.out.println("Page title is: " + driver.getTitle());
        
        driver.findElement(By.id("genButton")).click();
        
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));
        
        System.out.println("Word found : " +driver.findElement(By.id("word")).getText());
        
        driver.quit();
	}

}
