package org.example;

import org.junit.Assert;
import org.testng.annotations.Test;

public class InitialTests extends TestBase {

    @Test
    public void loadPage() {
        driver.get(GoogleMainPage.mainURL);
        Assert.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void search()
    {
        driver.get(GoogleMainPage.mainURL);

        GoogleMainPage homePage = new GoogleMainPage(driver);
        homePage.doSearch("товары для дома");

        Assert.assertEquals("товары для дома - Поиск в Google", driver.getTitle());
    }
}

