package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest{

    /*
    Signup Tests
Test #1: Visits the signup page
assert:
Verifikovati da se u url-u stranice javlja /signup ruta
Test #2: Checks input types
assert:
Verifikovati da polje za unos emaila za atribut type ima vrednost
email
Verifikovati da polje za unos lozinke za atribut type ima vrednost
password
Verifikovati da polje za unos lozinke za potvrdu za atribut type ima
vrednost password
Test #3: Displays errors when user already exists
Podaci:
name: Test Test
email: admin@admin.com
password: 123654
confirm password: 123654
assert:
Verifikovati da greska sadrzi poruku E-mail already exists
Verifikovati da se u url-u stranice javlja /signup ruta
Test #4: Signup
Podaci:
name: Ime i prezime polaznika
email template: ime.prezime@itbootcamp.rs
password: 12346
confirm password: 123456
assert:
Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT:
Verify your account
     */

//    Signup Tests
//    Test #1: Visits the signup page
//assert:

    @Test
    public void visitsTheSignUpPage(){
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getEmailField()));
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
   //     sleep(5000);
    //    driverWait.until(ExpectedConditions.elementToBeClickable(commonPage.getSignUpPageButton()));
        String expectedEmailTypeResult = "email";
        String expectedPasswordTypeResult = "password";
        String expectedConfirmPasswordTypeResult = "password";
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getEmailField()));
        String actualEmailTypeResult = signupPage.getEmailField().getAttribute("type");
        String actualPasswordTypeResult = signupPage.getPasswordField().getAttribute("type");
      //  driverWait.until(ExpectedConditions.visibilityOf(signupPage.getConfirmPasswordField()));
        String actualConfirmPasswordTypeResult = signupPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(actualEmailTypeResult, expectedEmailTypeResult);
        Assert.assertEquals(actualPasswordTypeResult, expectedPasswordTypeResult);
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
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getNameField()));
        signupPage.signUpAlreadyExistUserMethod();
        String actualResult = signupPage.getErrorNotification().findElement(signupPage.getEmailAlreadyExistNotification()).getText();
        Assert.assertEquals(actualResult, expectedResult);
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
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getNameField()));
//        String fakename = fakeName();
//        String fakeEmail = fakeEmail();
//        String fakePassword = fakePassword();
        signupPage.signUpMethod(randomName(), randomEmail(), randomPassword());
//        signupPage.signUpMethodMyCredentials();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getSignupDialog()));
        String actualResult = signupPage.getSignupDialog().getText().trim();
        Assert.assertEquals(actualResult, expectedResult);
//        signupPage.getCloseDialogButton().click();
//        signupPage.getLogoutButton().click();

    }

}
