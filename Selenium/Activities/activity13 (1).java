package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class activity13 {

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
        
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
        System.out.println("Third row cell values: ");
        for(WebElement cell : thirdRow) {
        	System.out.println(cell.getText());
        }
        // Print the cell value of the second row and second column
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText());
        driver.quit();

	}

}
