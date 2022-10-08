package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {
    /*
    Admin Cities Tests
Test #1: Visits the admin cities page and list cities
Podaci:
admin email: admin@admin.com
admin password: 12345
assert:
Verifikovati da se u url-u stranice javlja /admin/cities ruta
Verifikovati postojanje logut dugmeta
Test #2: Create new city
Podaci: random grad korisćenjem faker library-ja
assert:
Verifikovati da poruka sadrzi tekst Saved successfully
Test #3: Edit city
Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited
(primer: Beograd – Beograd edited)
assert:
Verifikovati da poruka sadrzi tekst Saved successfully
Test #4: Search city
Podaci: editovani grad iz testa #3
assert:
Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
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

//    Admin Cities Tests
//    Test #1: Visits the admin cities page and list cities
//    Podaci:
//            admin email: admin@admin.com
//admin password: 12345
//            assert:
//            Verifikovati da se u url-u stranice javlja /admin/cities ruta
//Verifikovati postojanje logut dugmeta

    @BeforeClass
    public void setUp() {
        adminCitiesPage.setCityName(randomCity());
    }

    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCitiesTest(){
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getLogoutButton()));
        Assert.assertTrue(adminCitiesPage.getDriver().getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }


//    Test #2: Create new city
//    Podaci: random grad korisćenjem faker library-ja
//assert:
//        Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 2)
    public void createNewCityTest() {
        String expectedResult = "Saved successfully";
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));
        String city = adminCitiesPage.getCityName();
//        adminCitiesPage.setCityName(city);
        adminCitiesPage.getAddCityMethod(city);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getConfimationMessage()));
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
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));
      //  System.out.println(adminCitiesPage.getCityName());
      //  adminCitiesPage.getAddCityMethod();


        System.out.println("CityName pre setovanja: "+ adminCitiesPage.getCityName());  // null




//        String city = randomCity();
//        adminCitiesPage.setCityName(city);
        String city = adminCitiesPage.getCityName();
//        adminCitiesPage.getAddCityMethod(city);
        driverWait.until(ExpectedConditions.elementToBeClickable(adminCitiesPage.getEditButton()));
        adminCitiesPage.clickEditForCity(city);
//        adminCitiesPage.getTableRow1EditButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getEditField()));
        adminCitiesPage.getEditCityNameMethod(" edit");
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getConfimationMessage()));
        String actualResult = adminCitiesPage.getConfimationMessage().getText().trim();
        System.out.println("Actual confirmation message: " +actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult));

        System.out.println("CityName nakon setovanja: "+ adminCitiesPage.getCityName());  // Kelvinland










        //   driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getConfimationMessage()));
//        adminCitiesPage.getAddCitiesToListMethod().size();
//        System.out.println(adminCitiesPage.getAddCitiesToListMethod().size());
//        for (int i = 0; i < adminCitiesPage.getAddCitiesToListMethod().size(); i++) {
//            WebElement element= adminCitiesPage.getAddCitiesToListMethod().get(i);
//
//        }

    }

}
