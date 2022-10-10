package tests;

import helper.Cities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    /*
    Test #1: Set locale to ES
assert:
Postaviti jezik na ES
Verifikovati da se na stranici u hederu javlja tekst Página de
aterrizaje
     */
    @Test
    public void setLocaleToESTest() {
        String expectedResult = "Página de aterrizaje";

        // Open localization menu
        commonPage.getLocaleButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(commonPage.getEspButton()));

        // Select "ES"
        commonPage.getEspButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeader()));

        // Verify that page header has text 'Página de aterrizaje'
        String actualResult = homePage.getHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

   /*
   Test #2: Set locale to EN
assert:
        Postaviti jezik na EN
Verifikovati da se na stranici u hederu javlja tekst Landing
*/

    @Test
    public void setLocaleToENTest() {
        String expectedResult = "Landing";

        // Open localization menu
        commonPage.getLocaleButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(commonPage.getEngButton()));

        // Select "EN"
        commonPage.getEngButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeader()));

        // Verify that page header has text 'Landing'
        String actualResult = homePage.getHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    /*
    Test #3: Set locale to FR
assert:
Postaviti jezik na FR
Verifikovati da se na stranici u hederu javlja tekst Page
d'atterrissage
     */

    @Test
    public void setLocaleToFRTest() {
        String expectedResult = "Page d'atterrissage";

        // Open localization menu
        commonPage.getLocaleButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(commonPage.getFraButton()));

        // Select "FR"
        commonPage.getFraButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getHeader()));

        // Verify that page header has text 'Page d'atterrissage'
        String actualResult = homePage.getHeader().getText();
        Assert.assertEquals(actualResult, expectedResult);

    }




}
