package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputLogin(String login) {
        WebElement loginField = driver.findElement(By.xpath("//input[@id='identifierId']"));
        loginField.sendKeys(login);

        WebElement nextBtn = driver.findElement(By.xpath("//button[contains(., 'Далее')]"));
        nextBtn.click();
    }

    public void inputPasswd(String passwd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Введите пароль']")));

        WebElement passwdField = driver.findElement(By.xpath("//input[@aria-label='Введите пароль']"));
        passwdField.sendKeys(passwd);
        WebElement loginBtn = driver.findElement(By.xpath("//input[@aria-label='Введите пароль']"));
        loginBtn.click();
    }
}
