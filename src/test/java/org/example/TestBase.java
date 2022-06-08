package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;


public class TestBase {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeClass
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

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
