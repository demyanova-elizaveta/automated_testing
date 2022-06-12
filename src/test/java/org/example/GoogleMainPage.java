package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.model.MouseButton;

import java.awt.event.MouseAdapter;

public class GoogleMainPage {

    public static String mainURL = "https://www.google.com/";

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
