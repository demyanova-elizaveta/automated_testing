package org.example.cucumber;

import io.cucumber.java.*;
import io.cucumber.java.ru.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.GoogleMainPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    public WebDriver driver;

    @Before
    public void setUp()
    {
        switch(RunnerTests.browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser value doesn't match!");
        }
    }

    @Когда("пользователь переходит по ссылке {string}")
    public void пользователь_переходит_по_ссылке(String link) {
        driver.get(link);
    }

    @Тогда("заголовок страницы есть {string}")
    public void заголовок_страницы_есть(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @Когда("пользователь делает запрос {string}")
    public void пользователь_делает_запрос(String searchString) {
        GoogleMainPage homePage = new GoogleMainPage(driver);
        homePage.doSearch(searchString);
    }

    @Когда("пользователь нажимает кнопку Войти")
    public void пользователь_нажимает_кнопку_Войти()
    {
        GoogleMainPage homePage = new GoogleMainPage(driver);
        homePage.pressLoginAccountButton();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
