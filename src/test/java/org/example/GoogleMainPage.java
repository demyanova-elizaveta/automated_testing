package org.example;

import org.openqa.selenium.*;

public class GoogleMainPage {

    private WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void doSearch(String query) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void pressLoginAccountButton() {
        WebElement loginAccountButton = driver.findElement(By.xpath("//*[contains(text(), 'Войти')]"));
        loginAccountButton.click();
    }
}
