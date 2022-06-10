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

    @�����("������������ ��������� �� ������ {string}")
    public void ������������_���������_��_������(String link) {
        driver.get(link);
    }

    @�����("��������� �������� ���� {string}")
    public void ���������_��������_����(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @����("������������ ��������� ������ ������ �� ������ {string}")
    public void ������������_���������_������_������_��_������(String link) {
        driver.get(link);
    }

    @�����("������������ ������ ������ {string}")
    public void ������������_������_������(String searchString) {
        GoogleMainPage homePage = new GoogleMainPage(driver);
        homePage.doSearch(searchString);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
