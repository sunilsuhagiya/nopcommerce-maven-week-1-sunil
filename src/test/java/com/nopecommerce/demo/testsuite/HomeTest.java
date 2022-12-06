package com.nopecommerce.demo.testsuite;

import com.nopecommerce.demo.pages.HomePage;
import com.nopecommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToComputer() {
        homePage.selectMenu("Computers");
        Assert.assertEquals(homePage.getVerifyComputer(), "Computers", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToElectronics() {
        homePage.selectMenu("Electronics");
        Assert.assertEquals(homePage.getVerifyElectronics(), "Electronics", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToApparel() {
        homePage.selectMenu("Apparel");
        Assert.assertEquals(homePage.getVerifyApparel(), "Apparel", "Error Message not displayed");
    }
}
