package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest{

//    Test #1: Visits the signup page
//    Assert:
//    Verify that the route '/signup' appears in the url of the page

    @Test
    public void visitsTheSignUpPage(){
        // Navigate to 'Sign Up' page
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getEmailField()));

        // Verify that url contains '/signup'
        Assert.assertTrue(signupPage.getDriver().getCurrentUrl().contains("/signup"));

    }

//    Test #2: Checks input types
//    Assert:
//    Verify that the email input field for the type attribute has the value 'email'
//    Verify that the password input field for the type attribute has the value 'password'
//    Verify that the confirmation password input field for the type attribute has the value 'password'

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

//     Test #3: Displays errors when user already exists
//     Data:
//     name: Test Test
//     email: admin@admin.com
//     password: 123654
//     confirm password: 123654
//     Assert:
//     Verify that error notification message has text 'E-mail already exists'
//     Verify that the route '/signup' appears in the url of the page

    @Test
    public void displayErrorsWhenUserAlreadyExists() {
        String expectedResult = "E-mail already exists";

        // Navigate to 'Sign Up' page
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getNameField()));

        // Input already existing user credentials
        signupPage.signUpAlreadyExistUserMethod();

        // Verify that error notification has text 'E-mail already exists'
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getErrorNotification()));
        String actualResult = signupPage.getErrorNotification().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        // Verify that url contains '/signup'
        Assert.assertTrue(signupPage.getDriver().getCurrentUrl().contains("/signup"));
    }

//     Test #4: Signup
//     Data:
//     name: name and surname of the attendee
//     email template: name.surname@itbootcamp.rs
//     password: 123456
//     confirm password: 123456
//     Assert:
//     Verify that the notification dialog contains text 'IMPORTANT: Verify your account'
//     Note: This test can be run only once in every half hour, since database is refreshing in that interval

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
