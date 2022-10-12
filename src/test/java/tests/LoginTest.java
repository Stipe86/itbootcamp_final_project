package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


//    Test #1: Visits the login page
//    Assert:
//    Verify that the route '/login' appears in the url of the page
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

//    Test #2: Checks input types
//    Assert:
//    Verify that the email input field for the type attribute has the value 'email'
//    Verify that the password input field for the type attribute has the value 'password'
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

//    Test #3: Displays errors when user does not exist
//    Data:
//    random email and password using faker library
//    Asssert:
//    Verify that error notification contains message 'User does not exists'
//    Verify that the route '/login' appears in the url of the page
    @Test
    public void displayingErrorsWhenUserDoesNotExistTest(){
        String expectedResult = "User does not exists";

        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();

        // Input random data in 'Email' and 'Password' fields
        loginPage.loginMethod(randomEmail(), randomPassword());
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorNotification()));

        // Verify that error notification has text 'User does not exists'
        String actualResult = loginPage.getErrorNotification().getText();
        Assert.assertEquals(actualResult, expectedResult);

        // Verify that url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

//      Test #4: Displays errors when password is wrong
//      Data:
//      email: admin@admin.com and random password
//      Asssert:
//      Verify that error notification message has text 'Wrong password'
//      Verify that the route '/login' appears in the url of the page
    @Test
    public void displayingErrorsWhenPasswordIsWrongTest(){
        String expectedResult = "Wrong password";

        // Navigate to 'Login' page
        commonPage.getLoginPageButton().click();

        // Input admin data in 'Email' field and random data in 'Password' field
        loginPage.loginMethod(adminEmail(), randomPassword());
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorNotification()));

        // Verify that error notification has text 'Wrong password'
        String actualResult = loginPage.getErrorNotification().getText();
        Assert.assertEquals(actualResult, expectedResult);

        // Verify that url contains '/login'
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("/login"));

    }

//     Test #5: Login
//     Data:
//     email: admin@admin.com
//     password: 12345
//     Asssert:
//     Verify that the route '/home' appears in the url of the page


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

//    Test #6: Logout
//    Assert:
//    Verify that logout button is visible on the page
//    Verify that the route '/login' appears in the url of the page
//    Verify that after trying to open the '/home' route, the '/login' route appears in the url of the page

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


        // Verify that, after attempt to load the home page, url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }



}
