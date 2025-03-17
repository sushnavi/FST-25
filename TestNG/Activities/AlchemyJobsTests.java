//import org.openqa.selenium.*;
//import org.testng.Assert;
//import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlchemyJobsTests {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
    	driver.get("https://alchemy.hguy.co/jobs/");
        // Set up the driver (make sure the chromedriver path is correctly set)
        //System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\Chromedriver.exe");
        //driver = new ChromeDriver();
    }

    @Test
    public void testWebsiteTitle() {
        driver.get("https://alchemy.hguy.co/jobs");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
    }

    @Test
    public void testWebsiteHeading() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement heading = driver.findElement(By.tagName("h1"));
        String headingText = heading.getText();
        Assert.assertEquals(headingText, "Welcome to Alchemy Jobs");
    }

    @Test
    public void testHeaderImageURL() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement headerImage = driver.findElement(By.cssSelector("header img"));
        String imageUrl = headerImage.getAttribute("src");
        System.out.println("Header image URL: " + imageUrl);
    }

    @Test
    public void testSecondHeading() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement secondHeading = driver.findElement(By.xpath("//h2[2]"));
        String secondHeadingText = secondHeading.getText();
        Assert.assertEquals(secondHeadingText, "Quia quis non");
    }

    @Test
    public void testNavigateToJobsPage() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement jobsMenuItem = driver.findElement(By.linkText("Jobs"));
        jobsMenuItem.click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Jobs"));
    }

    @Test
    public void testApplyToJob() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement jobsMenuItem = driver.findElement(By.linkText("Jobs"));
        jobsMenuItem.click();
        WebElement firstJob = driver.findElement(By.cssSelector(".job_listings .job_listing:first-child a"));
        firstJob.click();
        WebElement applyButton = driver.findElement(By.linkText("Apply for job"));
        applyButton.click();
        WebElement emailField = driver.findElement(By.cssSelector("a.mailto"));
        System.out.println("Email to apply: " + emailField.getText());
    }

    @Test
    public void testCreateNewJobListing() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement postJobMenuItem = driver.findElement(By.linkText("Post a Job"));
        postJobMenuItem.click();
        WebElement jobTitleField = driver.findElement(By.id("job_title"));
        jobTitleField.sendKeys("New Job Listing");
        WebElement jobDescriptionField = driver.findElement(By.id("job_description"));
        jobDescriptionField.sendKeys("This is a job description for the new listing.");
        WebElement previewButton = driver.findElement(By.id("preview"));
        previewButton.click();
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement jobListingLink = driver.findElement(By.linkText("New Job Listing"));
        Assert.assertTrue(jobListingLink.isDisplayed());
    }

    @Test
    public void testLoginToBackend() {
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys("root");
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys("pa$$w0rd");
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();
        WebElement dashboardTitle = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(dashboardTitle.getText().contains("Dashboard"));
    }

    @Test
    public void testCreateJobListingBackend() {
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys("root");
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys("pa$$w0rd");
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();
        
        WebElement jobListingsMenu = driver.findElement(By.linkText("Job Listings"));
        jobListingsMenu.click();
        
        WebElement addNewButton = driver.findElement(By.linkText("Add New"));
        addNewButton.click();
        
        WebElement jobTitleField = driver.findElement(By.id("title"));
        jobTitleField.sendKeys("Backend Job Listing");
        
        WebElement jobDescriptionField = driver.findElement(By.id("content"));
        jobDescriptionField.sendKeys("Description for backend job.");
        
        WebElement publishButton = driver.findElement(By.id("publish"));
        publishButton.click();
        
        WebElement jobTitleOnList = driver.findElement(By.linkText("Backend Job Listing"));
        Assert.assertTrue(jobTitleOnList.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
