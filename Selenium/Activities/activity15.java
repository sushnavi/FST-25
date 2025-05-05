package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		driver.manage().window().maximize();
		//page title
		System.out.println("Current title is " +driver.getTitle());
		
		WebElement fullName = driver.findElement(By.xpath("//input[starts-with(@id, 'full-name-')]"));
        WebElement email = driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
        WebElement eventDate = driver.findElement(By.xpath("//label[contains(text(), 'event?')]/following-sibling::input[@type='date']"));
        WebElement details = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));
        // Enter the details
        
        fullName.sendKeys("Madhu");
        email.sendKeys("madhu@abc.com");
        eventDate.sendKeys("2025-03-10");
        details.sendKeys("End of course");
        
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        String msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(msg);
        
        
        
	}

}
