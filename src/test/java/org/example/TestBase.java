package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser)
    {
        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser value doesn't match!");
        }
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
