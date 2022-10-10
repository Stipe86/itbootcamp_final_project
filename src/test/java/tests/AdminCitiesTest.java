package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        // Seting the city name that will be used in tests
        adminCitiesPage.setCityName(randomCity());
    }


//    Test #1: Visits the admin cities page and list cities
//    Podaci:
//            admin email: admin@admin.com
//admin password: 12345
//            assert:
//            Verifikovati da se u url-u stranice javlja /admin/cities ruta
//Verifikovati postojanje logut dugmeta

    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCitiesTest(){
        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));

        // Navigate to 'Cities' page
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getLogoutButton()));

        // Verify url contains '/admin/cities'
        Assert.assertTrue(adminCitiesPage.getDriver().getCurrentUrl().contains("/admin/cities"));

        // Verify 'Logout' button is displayed
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }


//    Test #2: Create new city
//    Podaci: random grad korisćenjem faker library-ja
//assert:
//        Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 2)
    public void createNewCityTest() {
        String expectedResult = "Saved successfully";

        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));

        // Navigate to 'Cities' page
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Create city using the name that was setup in the 'BeforeClass'
        String city = adminCitiesPage.getCityName();
        adminCitiesPage.makeNewCityNameMethod(city);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getConfimationMessage()));

        // Verify that confirmation message contains text 'Saved successfully'
        String actualResult = adminCitiesPage.getConfimationMessage().getText().trim();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


//    Test #3: Edit city
//    Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited
//            (primer: Beograd – Beograd edited)
//assert:
//        Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 3)
    public void editCityTest() {
        String expectedResult = "Saved successfully";

        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));

        // Navigate to 'Cities' page
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Replace city name that was setup in the 'BeforeClass' with new name
        String city = adminCitiesPage.getCityName();
        driverWait.until(ExpectedConditions.elementToBeClickable(adminCitiesPage.getEditButton()));
        adminCitiesPage.editCity(city, city+" edit");
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getConfimationMessage()));

        // Set that new name so that it can be used in following tests
        String newName = city+" edit";
        adminCitiesPage.setCityName(newName);

        // Verify that confirmation message contains text 'Saved successfully'
        String actualResult = adminCitiesPage.getConfimationMessage().getText().trim();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    /*
    Test #4: Search city
Podaci: editovani grad iz testa #3
assert:
Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
     */

    @Test(priority = 4)
    public void searchCityTest() {
        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Search for city that was edit in test 3
        String city = adminCitiesPage.getCityName();
        adminCitiesPage.inputTextInSearchField(city);
        driverWait.until(ExpectedConditions.numberOfElementsToBe(adminCitiesPage.getTableCityRowsLocator(),1));
        sleep(5000);

        // Verify that text in the first row of the table matches the input in 'Search' field
        String expectedResult = city;
        String actualResult = adminCitiesPage.getTableCityRow1().getText();
        Assert.assertEquals(actualResult, expectedResult);


    }

    /*
    Test #5: Delete city
Podaci: editovani grad iz testa #3
assert:
U polje za pretragu uneti staro ime grada
Sacekati da broj redova u tabeli bude 1
Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
Kliknuti na dugme Delete iz prvog reda
Sacekati da se dijalog za brisanje pojavi
Kliknuti na dugme Delete iz dijaloga
Sacekati da popu za prikaz poruke bude vidljiv
Verifikovati da poruka sadrzi tekst Deleted successfully
     */

    @Test(priority = 5)
    public void deleteCityTest(){
        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Navigate to 'Cities' page
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Search for city that was edit in test 3
        String city = adminCitiesPage.getCityName();
        adminCitiesPage.inputTextInSearchField(city);
        driverWait.until(ExpectedConditions.numberOfElementsToBe(adminCitiesPage.getTableCityRowsLocator(),1));
        sleep(5000);   // doesn't work without sleep

        // Verify that text in the first row of the table matches the input in 'Search' field
        String expectedResult = city;
        String actualResult = adminCitiesPage.getTableCityRow1().getText();
        Assert.assertEquals(actualResult, expectedResult);

        // Delete city that was edit in test 3
        adminCitiesPage.deleteCity(city);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getDeleteConfirmationMessage()));

        // Verify that confirmation message contains text 'Deleted successfully'
        String expectedResult2 = "Deleted successfully";
        String actualResult2 = adminCitiesPage.getDeleteConfirmationMessage().getText().trim();
        Assert.assertTrue(actualResult2.contains(expectedResult2));

    }




}
