package com.mhra.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepartmentSearch {
     private WebDriver driver;
    private WebDriverWait wait;
    
    public DepartmentSearch(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
     public void i_filter_based_on_department(String department) {
        // Accept the cookies
      
        WebElement departmentButton = driver.findElement(By.xpath("//button[text()=' Department ']"));  // Use the appropriate locator for your element

        // Scroll until the target element is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
              // Scroll in chunks until the element is visible
              while (true) {
                try {
                    // Scroll down by 1000 pixels
                    js.executeScript("window.scrollBy(0, 1000);");
    
                    // Check if the element is visible after scrolling
                    if (departmentButton.isDisplayed()) {
                        System.out.println("Target element is visible.");
                        break;  // Exit the loop if the element is visible
                    }
                    // Wait before scrolling again (optional)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        
        departmentButton.click();
    }
    public void  i_select_MHRA_department() throws InterruptedException{
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("oselect-filter-textbox"))).sendKeys("Medicines and Healthcare products Regulatory Agency ");

    }

}
