package com.nopecommerce.demo.testsuite;

import com.nopecommerce.demo.pages.ElectronicPage;
import com.nopecommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicTest extends BaseTest {
   ElectronicPage ePage = new ElectronicPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        ePage.mouseHoverOnElectronicTab();
        ePage.clickOnCellPhones();
        Assert.assertEquals(ePage.getCellPhoneText(), "Cell phones", "Cell phones is not displayed");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        ePage.mouseHoverOnElectronicTab();
        ePage.clickOnCellPhones();
        Assert.assertEquals(ePage.getCellPhoneText(), "Cell phones", "Cell phones is not displayed");
        ePage.clickOnListViewTab();
        Thread.sleep(5000);
        ePage.clickOnNokiaLumiaProduct();
        Assert.assertEquals(ePage.verifyNokiaLumiaText(), "Nokia Lumia 1020", "Nokia Lumia 1020 is not displayed");
        Assert.assertEquals(ePage.verifyPrice(), "$349.00", "$349.00 is not displayed");
        ePage.changeTheQuantity();
        ePage.clickOnAddToCartButton();
        String expectedText = "The product has been added to your shopping cart";
        Assert.assertEquals(ePage.verifyProductAddedInShoppingCartText(), expectedText, "Product add in shopping cart is not displayed");
        ePage.clickOnCloseButton();
        ePage.hoverOnShoppingCartAndClickOnGoToCartButton();
        Assert.assertEquals(ePage.verifyShoppingCartText(), "Shopping cart", "Shopping cart is not displayed");
        Thread.sleep(5000);
        Assert.assertEquals(ePage.verifyTheQuantity(),  "(2)", "Number is not displayed");
        Assert.assertEquals(ePage.verifyTheTotal(), "$698.00", "$698.00 is not displayed");
        ePage.clickOnCheckBox();
        ePage.clickOnCheckoutButton();
        Assert.assertEquals(ePage.verifyWelcomeMessage(), "Welcome, Please Sign In!", "Welcome message is not displayed");
        ePage.clickOnRegisterTab();
        Assert.assertEquals(ePage.verifyRegisterText(), "Register", "Register is not displayed");
        ePage.mandatoryFields();
        ePage.clickOnRegistrationButton();
        Assert.assertEquals(ePage.verifyRegistrationText(), "Your registration completed", "Registration text is not displayed");
        ePage.clickOnContinueTab();
        Assert.assertEquals(ePage.checkShoppingCartText(), "Shopping cart", "Shopping cart is not displayed");
        ePage.clickOnCheckBox();
        ePage.clickOnCheckoutButton();
        ePage.fillDeliveryAddressFields();
        ePage.clickOnContinueButton();
        ePage.clickOn2ndDayAirButton();
        ePage.clickContinue();
        ePage.selectCreditCardRadioButton();
        ePage.clickCon();
        ePage.selectVisaFromDropDown();
        ePage.fillCardDetails();
        ePage.clickConBtn();
        Assert.assertEquals(ePage.verifyCreditCardText(), "Credit Card", "Credit Card is not displayed");
        Assert.assertEquals(ePage.verify2ndDayAirText(), "2nd Day Air", "2nd Day Air is not displayed");
        Assert.assertEquals(ePage.verifyFinalTotal(), "$698.00", "$698.00 is not displayed");
        ePage.clickOnConfirmButton();
        Assert.assertEquals(ePage.verifyThankYouText(), "Thank you", "Thank you is not displayed");
        Assert.assertEquals(ePage.verifySuccessfullyProcessedMessage(), "Your order has been successfully processed!", "Successfully processed message is not displayed");
        ePage.clickOnContinue();
        Assert.assertEquals(ePage.verifyWelcomeToOurStoreText(), "Welcome to our store", "Welcome to our store is not displayed");
        ePage.clickOnLogoutLink();
    }

    }
