package com.mhra.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        System.out.println("starting");
        System.setProperty("webdriver.chrome.driver", "C:\\Bibhishan\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions(); 
        options.addArguments("--start-maximized");
       // options.addArguments("user-data-dir=C:\\Users\\Rupali\\AppData\\Local\\Google\\Chrome\\User Data"); // Use your own Chrome profile
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        System.out.println("driver created");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes( 3));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        if (driver !=null){
            driver.quit();
        }
    }
}
