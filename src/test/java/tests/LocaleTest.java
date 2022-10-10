package tests;

import helper.Cities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {
    /*
    Locale Tests
Test #1: Set locale to ES
assert:
Postaviti jezik na ES
Verifikovati da se na stranici u hederu javlja tekst Página de
aterrizaje
Test #2: Set locale to EN
assert:
Postaviti jezik na EN
Verifikovati da se na stranici u hederu javlja tekst Landing
Test #3: Set locale to FR
assert:
Postaviti jezik na FR
Verifikovati da se na stranici u hederu javlja tekst Page
d'atterrissage
     */

    @Test
    public void setLocaleToESTest() {
        String expectedResult = "Página de aterrizaje";
        commonPage.getLocaleButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(commonPage.getEspButton()));
    //    sleep(10000);
        commonPage.getEspButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeader()));
        String actualResult = homePage.getHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void setLocaleToENTest() {
        String expectedResult = "Landing";
        commonPage.getLocaleButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(commonPage.getEngButton()));
        //    sleep(10000);
        commonPage.getEngButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeader()));
        String actualResult = homePage.getHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void setLocaleToFRTest() {
        String expectedResult = "Page d'atterrissage";
        commonPage.getLocaleButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(commonPage.getFraButton()));
        commonPage.getFraButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeader()));
        String actualResult = homePage.getHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);

    }




}
