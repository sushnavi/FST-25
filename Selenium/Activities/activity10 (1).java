package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
        
		Actions builder = new Actions(driver);

        // Open the browser
        driver.get("https://training-support.net/webelements/drag-drop");

        // Verify page title
        System.out.println("Page title is: " + driver.getTitle());
        
        WebElement ball = driver.findElement(By.xpath("//img[@id='ball']"));
        WebElement zone1 = driver.findElement(By.xpath("//div[@id='dropzone1']"));
        WebElement zone2 = driver.findElement(By.id("dropzone2"));
        //Task
        /*
         * 
    	Find the ball and simulate a click and drag to move it into "Dropzone 1".
    	Verify that the ball has entered Dropzone 1.
    	Once verified, move the ball into "Dropzone 2".
    	Verify that the ball has entered Dropzone 2.

         */
        //using drag and drop
        builder.dragAndDrop(ball, zone1).build().perform();
        if (zone1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball dropped in dropzone1");
        }
        
        //using click and hold
        builder.clickAndHold(ball).moveToElement(zone2).release().build().perform();
        if (zone2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball dropped in dropzone2");
        }
	}

}
