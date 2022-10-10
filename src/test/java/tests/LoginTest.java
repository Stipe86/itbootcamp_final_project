package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

/*
Test #1: Visits the login page
assert:
Verifikovati da se u url-u stranice javlja ruta /login
 */

    @Test
    public void visitsTheLoginPageTest() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();
        // Get url of opened page
        driverWait.until(ExpectedConditions.urlContains("/login"));
        String actualResult = driver.getCurrentUrl();
        // Verify that url contains '/login'
        Assert.assertEquals(actualResult, expectedResult);
    }

    /*
    Test #2: Checks input types
assert:
Verifikovati da polje za unos emaila za atribut type ima vrednost
email
Verifikovati da polje za unos lozinke za atribut type ima vrednost
password
     */

    @Test
    public void checkInputTypesTest(){
        String expectedEmailTypeResult = "email";
        String expectedPasswordTypeResult = "password";
        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Verify that 'Email' field has attribute type value 'email'
        String actualEmailTypeResult = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualEmailTypeResult, expectedEmailTypeResult);

        // Verify that 'password' field has attribute type value 'password'
        String actualPasswordTypeResult = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualPasswordTypeResult, expectedPasswordTypeResult);

    }

    /*
    Test #3: Displays errors when user does not exist
Podaci: random email i password koristeći faker libarary
asssert:
Verifikovati da greska sadrzi poruku User does not exists
Verifikovati da se u url-u stranice javlja /login ruta
     */

    @Test
    public void displayingErrorsWhenUserDoesNotExistTest(){
        String expectedResult = "User does not exists";

        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();

        // Input random data in 'Email' and 'Password' fields
        loginPage.loginMethod(randomEmail(), randomPassword());
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorNotification()));

        // Verify that error notification has text 'User does not exists'
        String actualResult = loginPage.getErrorNotification().findElement(loginPage.getEmailErrorNotification()).getText();
        Assert.assertEquals(actualResult, expectedResult);

        // Verify that url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

/*
Test #4: Displays errors when password is wrong
Podaci: email: admin@admin.com i proizvoljan password
asssert:
Verifikovati da greska sadrzi poruku Wrong password
Verifikovati da se u url-u stranice javlja /login ruta


 */
    @Test
    public void displayingErrorsWhenPasswordIsWrongTest(){
        String expectedResult = "Wrong password";

        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();

        // Input admin data in 'Email' field and random data in 'Password' field
        loginPage.loginMethod(adminEmail(), randomPassword());
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorNotification()));

        // Verify that error notification has text 'Wrong password'
        String actualResult = loginPage.getErrorNotification().findElement(loginPage.getPasswordErrorNotification()).getText();
        Assert.assertEquals(actualResult, expectedResult);

        // Verify that url contains '/login'
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("/login"));

    }

    /*
    Test #5: Login
Podaci:
email: admin@admin.com
password: 12345
asssert:
Verifikovati da se u url-u stranice javlja /home ruta
     */


    @Test
    public void login() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";

        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();

        // Input admin data in 'Email' and 'Password' field
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.urlContains("/home"));

        // Verify that url contains '/home'
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

    }
/*

    Test #6: Logout
assert:
        Verifikovati da je dugme logout vidljivo na stranici
Verifikovati da se u url-u stranice javlja /login ruta
Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u
    stranice javlja /login ruta

*/

    @Test
    public void logoutTest(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Input admin data in 'Email' and 'Password' field
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getLogoutBtn()));

        // Verify that 'LOGOUT' button is displayed
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());

        // Click on "LOGOUT" button
        homePage.getLogoutBtn().click();
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify that url contains '/login'
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/home'
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));


        // Verify that after attempt to load home page url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }



}
