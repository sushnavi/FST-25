import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.SkipException;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Assignment_jobTest {
    WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        //WebDriverManager.firefox().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
            
        //Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    
    @Test
    public void testWebsiteTitle() {
       driver.get("https://alchemy.hguy.co/jobs");
       String title = driver.getTitle();
       Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
       //driver.close();
    }
    
    @Test
    public void testWebsiteHeading() {
    	driver.get("https://alchemy.hguy.co/jobs");
        WebElement heading = driver.findElement(By.className("entry-title"));
        String headingText = heading.getText();
        Assert.assertEquals(headingText, "Welcome to Alchemy Jobs");
        //driver.close()
   }
    
    //@SuppressWarnings("deprecation")
	@Test
    public void testHeaderImageURL() {
    	driver.get("https://alchemy.hguy.co/jobs");
        WebElement headerImage = driver.findElement(By.cssSelector("header img"));
        @SuppressWarnings("deprecation")
		String imageUrl = headerImage.getAttribute("src");
        System.out.println("Header image URL: " + imageUrl);
       // driver.close();
    }
    
    @Test
    public void testSecondHeading() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement secondHeading = driver.findElement(By.xpath("//h2"));
        String secondHeadingText = secondHeading.getText();
        Assert.assertEquals(secondHeadingText, "Quia quis non");
        System.out.println(secondHeadingText);
        //driver.close();
    }
    
    @Test
    public void testNavigateToJobsPage() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement jobMenuItem = driver.findElement(By.linkText("Jobs"));
        jobMenuItem.click();
        //driver.manage().timeouts().implicitlyWait(500, null);
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Jobs"));
    }
    
    @Test
    public void testApplyToJob() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement jobsMenuItem = driver.findElement(By.linkText("Jobs"));
        jobsMenuItem.click();
        WebElement firstJob = driver.findElement(By.id("search_keywords"));
        firstJob.click();
        firstJob.sendKeys("Banking");
        WebElement searchJobs = driver.findElement(By.xpath("//input[@type='submit']"));
        searchJobs.click();
        //driver.manage().timeouts().implicitlyWait(5000, null);
        WebElement jobLink = driver.findElement(By.xpath("//h3[text()='banking']"));
        jobLink.click();
        WebElement applyButton = driver.findElement(By.linkText("Apply for job"));
        applyButton.click();
        WebElement emailField = driver.findElement(By.cssSelector("a.mailto"));
        System.out.println("Email to apply: " + emailField.getText());
    }
    
    @Test
    public void createJobListing() {
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement postJobLink = driver.findElement(By.linkText("Post a Job"));
        postJobLink.click();

        WebElement jobTitle = driver.findElement(By.id("job_title"));
        WebElement jobLocation = driver.findElement(By.id("job_location"));
        WebElement jobDescription = driver.findElement(By.id("job_description"));

        jobTitle.sendKeys("Test Job Title");
        jobLocation.sendKeys("Test Location");
        jobDescription.sendKeys("Test job description");

        WebElement previewButton = driver.findElement(By.id("job_preview"));
        previewButton.click();

        WebElement submitButton = driver.findElement(By.id("job_submit"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("jobs"), "Job listing creation failed!");
    }

    @Test
    public void loginToBackend() {
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        WebElement usernameField = driver.findElement(By.id("user_login"));
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        WebElement loginButton = driver.findElement(By.id("wp-submit"));

        usernameField.sendKeys("admin");  // Replace with valid credentials
        passwordField.sendKeys("password");  // Replace with valid credentials
        loginButton.click();

        String dashboardTitle = driver.getTitle();
        Assert.assertTrue(dashboardTitle.contains("Dashboard"), "Login to backend failed!");
    }

    @Test
    public void createJobListingViaBackend() {
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        WebElement usernameField = driver.findElement(By.id("user_login"));
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        WebElement loginButton = driver.findElement(By.id("wp-submit"));

        usernameField.sendKeys("admin");  // Replace with valid credentials
        passwordField.sendKeys("password");  // Replace with valid credentials
        loginButton.click();

        WebElement jobListingsMenu = driver.findElement(By.linkText("Job Listings"));
        jobListingsMenu.click();

        WebElement addNewButton = driver.findElement(By.linkText("Add New"));
        addNewButton.click();

        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys("Backend Job Title");

        WebElement descriptionField = driver.findElement(By.id("job_description"));
        descriptionField.sendKeys("Backend job description");

        WebElement publishButton = driver.findElement(By.id("publish"));
        publishButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("job-listings"), "Job listing creation failed in backend!");
    }
    


}