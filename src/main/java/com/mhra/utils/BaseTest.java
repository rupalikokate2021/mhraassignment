package com.mhra.utils;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        log.info("starting");
        //System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions(); 
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        log.info("driver created");
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
