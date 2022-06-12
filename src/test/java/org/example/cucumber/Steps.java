package org.example.cucumber;

import io.cucumber.java.*;
import io.cucumber.java.ru.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ConfProperties;
import org.example.GoogleMainPage;
import org.example.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    public WebDriver driver;
    GoogleMainPage homePage;
    LoginPage loginPage;

    @Before
    public void setUp()
    {
        switch(RunnerTests.browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                homePage = new GoogleMainPage(driver);
                loginPage = new LoginPage(driver);
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
        homePage.doSearch(searchString);
    }

    @Когда("пользователь нажимает кнопку Войти")
    public void пользователь_нажимает_кнопку_Войти()
    {
        homePage.pressLoginAccountButton();
    }

    @Когда("пользователь вводит логин")
    public void пользователь_вводит_логин()
    {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
    }

    @Когда("пользователь вводит пароль")
    public void пользователь_вводит_пароль()
    {
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
    }

    @Тогда("пользователь перенаправляется на страницу {string}")
    public void пользователь_перенаправляется_на_страницу(String link)
    {
        String path = String.format("//base[@href='%s']",link);
        Assert.assertTrue(driver.findElement(By.xpath(path)).isEnabled());
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
