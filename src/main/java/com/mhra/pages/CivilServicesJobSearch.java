package com.mhra.pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mhra.utils.SeleniumUtils;

public class CivilServicesJobSearch {
     private WebDriver driver;
    private WebDriverWait wait;
    
    public CivilServicesJobSearch(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void i_am_on_the_civil_service_jobs_page() {
        driver.get("https://www.civilservicejobs.service.gov.uk/csr/index.cgi");
        System.out.println("Please solve the CAPTCHA manually.");
       
        SeleniumUtils.addWaitForCurrentThread(15000);

        // Accept the cookies
        WebElement acceptAllElements = wait.until(ExpectedConditions.elementToBeClickable(By.name("accept_all_cookies_button")));
        acceptAllElements.click();

        // Once cookie is accepted close the banner
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('csr-cookie-accept-all').style.display='none';");
    }

    public void i_enter_search_criteria_on_civil_service_jobs_page(String keyword, String location) {
    
        driver.findElement(By.name("what")).sendKeys(keyword);
        driver.findElement(By.name("where")).sendKeys(location);

        SeleniumUtils.addWaitForCurrentThread(5000);

         driver.findElement(By.name("search_button")).sendKeys(Keys.RETURN);

         SeleniumUtils.addWaitForCurrentThread(10000);
        
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-results-panel-main")));

       
    
    }

    public void i_should_see_all_correct_job_listings_for(String keyword, String location) {
        List<WebElement> jobItems = driver.findElements(By.className("search-results-job-box"));

        boolean allRelevantJobsFound = true;
        for (WebElement jobListing : jobItems) {
            System.out.println(jobListing.getText());
            allRelevantJobsFound = jobListing.getText().contains(location) && jobListing.getText().contains(keyword);

            if(!allRelevantJobsFound){
                break;
            }
        }

        if (allRelevantJobsFound) {
            System.out.println("All job listings are relevant to the search.");
        } else {
            System.out.println("Some job listings are not relevant to the search.");
        }

        Assert.assertTrue(!allRelevantJobsFound);
    }

   


}
