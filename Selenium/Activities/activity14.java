package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
        
		
        // Open the browser
        driver.get("https://training-support.net/webelements/tables");

        // Verify page title
        System.out.println("Page title is: " + driver.getTitle());
        
        List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("Number of columns : "+ cols.size());
        
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("Number of columns : "+ rows.size());
        
        String book1 = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]")).getText();
        System.out.println("Before sorting : " +book1);
        
        //sorting
        driver.findElement(By.xpath("//table/thead/tr/th[2]")).click();
        
        book1 = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]")).getText();
        System.out.println("After sorting : " +book1);
        
        //closing
        driver.quit();
	}

}
