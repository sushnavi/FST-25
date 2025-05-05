package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
        		
        // Open the browser
        driver.get("https://training-support.net/webelements/selects");

        // Verify page title
        System.out.println("Page title is: " + driver.getTitle());
        
        WebElement selectEle = driver.findElement(By.cssSelector("select.h-10"));
     // Pass the WebElement to the Select object
        Select dropdown = new Select(selectEle);
        
        //select by visible text
        dropdown.selectByVisibleText("One");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        //select by index
        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        //select by using value
        dropdown.selectByValue("three");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        
        //print all options
        System.out.println("Options in select are : ");
        for (WebElement options : dropdown.getOptions() ) {
        	System.out.println(options.getText());
        }
        
        driver.quit();
        
        
        
        
        
        
        
        
        
        
        
        
        
               
        

	}

}
