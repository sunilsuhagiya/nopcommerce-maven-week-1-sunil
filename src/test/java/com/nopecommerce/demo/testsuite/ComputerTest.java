package com.nopecommerce.demo.testsuite;

import com.nopecommerce.demo.pages.ComputerPage;
import com.nopecommerce.demo.pages.HomePage;
import com.nopecommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerTest extends BaseTest {

    ComputerPage computerPage = new ComputerPage();
    HomePage homePage = new HomePage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        computerPage.clickOnComputer();
        computerPage.clickOnDesktop();
        computerPage.getSelectByValue("6");

        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: Z to A");
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        computerPage.clickOnComputer();
        computerPage.clickOnDesktop();
        computerPage.getSelectByValue("5");
        computerPage.clickOnAddToCart();
        Assert.assertEquals(computerPage.getVerifyBuildYourOwn(), "Build your own computer", "Error message not displayed");
        computerPage.selectProcessorByValue("1");
        computerPage.selectRamByValue("5");
        computerPage.clickOnHDD400GB();
        computerPage.clickOnOsVistaPremium();
        computerPage.clickOnSoftwareTotalCommander();
        Thread.sleep(5000);
        Assert.assertEquals(computerPage.verifyTotalPrice(), "$1,475.00", "Error message not displayed");
        computerPage.clickOnAddToCartButton();
        Assert.assertEquals(computerPage.verifyCaryMessage(), "The product has been added to your shopping cart", "Error message not displayed");
        computerPage.closeMessageBar();
        computerPage.mouseHoverOnElementShoppingCart();
        computerPage.clickOnGoToCart();
        Assert.assertEquals(getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Shopping cart");
        computerPage.mouseHoverOnElementShoppingCart();
        computerPage.clickOnGoToCart();
        Assert.assertEquals(getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")), "Shopping cart");
        computerPage.clearTextInQuantityField();
        computerPage.sendTextToQuantityField();
        computerPage.clickOnUpdateShoppingCartButton();
        Assert.assertEquals(computerPage.verifyUpdatedPrice(),"$2,950.00", "Does not match");
        computerPage.clickOnCheckBoxIAgreeWithTermsAndCondition();
        computerPage.clickOnCheckOutButton();
        Assert.assertEquals(getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")), "Welcome, Please Sign In!");
        computerPage.clickOnCheckOutAsGuest();
        computerPage.sendTextToFirstNameField("Aa");
        computerPage.sendTextToLastNameField("Testing");
        computerPage.sendTextToEmailField("aass@gmail.com");
        computerPage.sendTextToCompanyField("AaPrimetest");
        computerPage.selectCountryFromDropDownList();
        computerPage.sendTextToCityField("Brisbane");
        computerPage.sendTextToAddressLine1("Zetland road");
        computerPage.sendTextToAddressLine2("UpperMount");
        computerPage.sendTextToPostcode("4122");
        computerPage.sendTextToPhoneNumberField("1234567890");
        computerPage.clickOnContinueButton();
        computerPage.clickOnNextDayAirButton();
        computerPage.clickOnContinueButtonAgain();
        computerPage.clickOnCreditCardButton();
        computerPage.selectClickOnContinue1();
        computerPage.selectMasterCardFromCreditCardDropdown("MasterCard");
        computerPage.sendTextTOCardHolderName("testng");
        computerPage.sendTextTOCardNumber("5555555555554444");
        computerPage.selectMonthAndYearForCreditCardExpireData();
        computerPage.sendTextToCardCode("469");
        computerPage.clickOnContinueButton2();
        Thread.sleep(2000);
        Assert.assertEquals(computerPage.getVerifyText1(), "Credit Card", "Error Message not displayed");
        Assert.assertEquals(computerPage.getVerifyText2(), "Next Day Air", "Error Message not displayed");
        Assert.assertEquals(computerPage.getVerifyText3(), "$2,950.00", "Error Message not displayed");
        computerPage.clickOnConformButton();
        Assert.assertEquals(computerPage.getVerifyText4(), "Checkout", "Error Message not displayed");
        Assert.assertEquals(computerPage.getVerifyText5(), "Your order has been successfully processed!", "Error Message not displayed");
        computerPage.clickOnContinueButton3();
        Thread.sleep(2000);
        Assert.assertEquals(computerPage.getVerifyText6(), "Welcome to our store", "Error Message not displayed");
    }
    }

