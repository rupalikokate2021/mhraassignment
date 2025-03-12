package com.mhra.pages;

import java.time.Duration;
import java.util.List;

import com.mhra.utils.MHRAAUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepartmentSearch {
    private static final Logger log = LoggerFactory.getLogger(DepartmentSearch.class);
    private WebDriver driver;
    private WebDriverWait wait;
    
    public DepartmentSearch(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
     public void i_filter_based_on_department(String department) {

        WebElement departmentButton = driver.findElement(By.xpath("//button[text()=' Department ']"));  // Use the appropriate locator for your element

         // scroll until department button is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
              while (true) {
                try {
                    js.executeScript("window.scrollBy(0, 1000);");

                    // Check if the element is visible after scrolling
                    if (departmentButton.isDisplayed()) {
                        break;
                    }
                    MHRAAUtils.addWaitForCurrentThread(1000);
                } catch (Exception e) {
                  log.error("Exception Occurred while scrolling for department...",e);
                }
            }
        
        departmentButton.click();
    }
    public void  i_select_MHRA_department(String department) throws InterruptedException{

        WebElement collapsiblePane = driver.findElements(By.className("search-sidebar")).get(4);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'block';", collapsiblePane);
        collapsiblePane.click();
       MHRAAUtils.addWaitForCurrentThread(8000);

        WebElement filterDiv = driver.findElements(By.className("oselect__filter")).get(1);
        js.executeScript("arguments[0].style.display = 'block';", filterDiv);
        MHRAAUtils.addWaitForCurrentThread(8000);

        WebElement searchBox = driver.findElements(By.name("oselect-filter-textbox")).get(1);
        js.executeScript("arguments[0].style.display = 'block';", searchBox);
        MHRAAUtils.addWaitForCurrentThread(8000);

        WebElement defaultSelected = driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + 258434 + "']"));
        defaultSelected.click();

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='" + 211315 + "']"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        MHRAAUtils.addWaitForCurrentThread(3000);
        boolean isReady = isUpdateFilterReadyUpdateFilter();
        if(isReady){
            driver.findElement(By.id("submitSearchUpdate")).sendKeys(Keys.RETURN);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-results-panel-main")));
    }

    private boolean isUpdateFilterReadyUpdateFilter(){
        boolean isUpdateFilterReadyUpdateFilter = true;
        WebElement updateFilterResults = driver.findElement(By.id("submitSearchUpdate"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (true) {
            try {
                js.executeScript("window.scrollBy(0, 1000);");

                if (updateFilterResults.isDisplayed()) {
                    break;
                }
               MHRAAUtils.addWaitForCurrentThread(1000);
            } catch (Exception e) {
                log.error("Exception Occurred while scrolling for update filter button...",e);
                isUpdateFilterReadyUpdateFilter = false;
            }
        }
        return isUpdateFilterReadyUpdateFilter;
    }

    public void i_select_first_job_to_find_No_of_postion() {
        // Locate the <ul> element with title="Job list"
        WebElement jobList = driver.findElement(By.xpath("//ul[@title='Job list']"));

        // Find all <li> elements inside that <ul> with class 'search-results-job-box'
        List<WebElement> jobItems = driver.findElements(By.xpath("//ul[@title='Job list']/li[@class='search-results-job-box']"));

        // Loop through the job items
        for (WebElement job : jobItems) {
            driver.findElement(By.className("search-results-job-box-title")).click();
            // job.click();
             break;
        }

        // get the number of positions
        List<WebElement> allFields = driver.findElements(By.className("vac_display_field"));
        for (WebElement webElement : allFields){
            if(webElement.getText().contains("Number of jobs available")){
                List<WebElement> childDivs = webElement.findElements(By.xpath(".//div[@class='vac_display_field_value']"));
                log.info("Number of jobs available : "+childDivs.get(0).getText());
            }
        }
    }
}
