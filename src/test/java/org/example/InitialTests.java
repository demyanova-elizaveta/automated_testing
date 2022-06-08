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
        GoogleMainPage homePage = new GoogleMainPage(driver);
        driver.get(GoogleMainPage.mainURL);

        homePage.doSearch("товары для дома");
        Assert.assertEquals("товары для дома - Поиск в Google", driver.getTitle());
    }

}

