package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest{

/*
Test #1: Visits the signup page
assert:
Verifikovati da se u url-u stranice javlja /signup ruta
 */

    @Test
    public void visitsTheSignUpPage(){
        // Navigate to 'Sign Up' page
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getEmailField()));

        // Verify that url cointains '/signup'
        Assert.assertTrue(signupPage.getDriver().getCurrentUrl().contains("/signup"));

    }

/*    Test #2: Checks input types
assert:
        Verifikovati da polje za unos emaila za atribut type ima vrednost
            email
Verifikovati da polje za unos lozinke za atribut type ima vrednost
            password
Verifikovati da polje za unos lozinke za potvrdu za atribut type ima
    vrednost password*/

    @Test
    public void checkInputTypes(){
        String expectedEmailTypeResult = "email";
        String expectedPasswordTypeResult = "password";
        String expectedConfirmPasswordTypeResult = "password";

        // Navigate to 'Sign Up' page
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getEmailField()));

        // Verify that 'E-mail' field has attribute type value 'email'
        String actualEmailTypeResult = signupPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualEmailTypeResult, expectedEmailTypeResult);

        // Verify that 'Password' field has attribute type value 'password'
        String actualPasswordTypeResult = signupPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualPasswordTypeResult, expectedPasswordTypeResult);

        // Verify that 'Confirm Password' field has attribute type value 'password'
        String actualConfirmPasswordTypeResult = signupPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(actualConfirmPasswordTypeResult, expectedConfirmPasswordTypeResult);
    }

    /*
    Test #3: Displays errors when user already exists
Podaci:
name: Test Test
email: admin@admin.com
password: 123654
confirm password: 123654
assert:
Verifikovati da greska sadrzi poruku E-mail already exists
Verifikovati da se u url-u stranice javlja /signup ruta

     */

    @Test
    public void displayErrorsWhenUserAlreadyExists() {
        String expectedResult = "E-mail already exists";

        // Navigate to 'Sign Up' page
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getNameField()));

        // Input already existing user credentials
        signupPage.signUpAlreadyExistUserMethod();

        // Verify that error notification has text 'E-mail already exists'
        String actualResult = signupPage.getErrorNotification().findElement(signupPage.getEmailAlreadyExistNotification()).getText();
        Assert.assertEquals(actualResult, expectedResult);

        // Verify that url contains '/signup'
        Assert.assertTrue(signupPage.getDriver().getCurrentUrl().contains("/signup"));
    }

   /* Test #4: Signup
    Podaci:
            name: Ime i prezime polaznika
email template: ime.prezime@itbootcamp.rs
password: 12346
            confirm password: 123456
            assert:
            Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT:
    Verify your account*/

    @Test
    public void signupTest(){
        String expectedResult = "IMPORTANT: Verify your account";
        // Navigate to 'Sign Up' page
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getNameField()));

        // Input credentials as if regularly making new account
        signupPage.signUpMethodMyCredentials();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getSignupDialog()));

        // Verify that sign up dialog has text 'IMPORTANT: Verify your account'
        String actualResult = signupPage.getSignupDialog().getText().trim();
        Assert.assertEquals(actualResult, expectedResult);


    }

}
