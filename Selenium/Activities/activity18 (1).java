package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
        // Open the browser
        driver.get("https://training-support.net/webelements/alerts");

        // Verify page title
        System.out.println("Page title is: " + driver.getTitle());
        
        driver.findElement(By.id("simple")).click();
        
        //switch focus to alert
        Alert simplAlert = driver.switchTo().alert();
        
        System.out.println(simplAlert.getText());
        
        //To click Ok to alert
        simplAlert.accept();
        
        System.out.println("Message : "+ driver.findElement(By.id("result")).getText());
        //closing
        driver.quit();

	}

}
