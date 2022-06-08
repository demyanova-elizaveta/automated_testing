package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage {

    private WebDriver driver;
    public static String mainURL = "https://www.google.com/";

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void doSearch(String query) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@aria-label='Найти']"));

        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.ENTER);
    }
}
