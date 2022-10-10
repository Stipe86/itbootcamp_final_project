package tests;

import helper.Cities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyProfileTest extends BaseTest{
   /* Profile Tests
    Test #1: Edits profile
    Podaci: random podaci korišćenjem faker library-ja
assert:
        Verifikovati da je prikazana poruka Profile saved successfuly
Verifikovati da svaki input sada za value atribut ima vrednost koja
    je uneta u okviru forme*/

    @BeforeClass
    public void setUp() {
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getNameField()));
        String name = faker.name().firstName() + " " + faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = randomPassword();

        signupPage.signUpMethod(name, email, password);
        driverWait.until(ExpectedConditions.visibilityOf(commonPage.getLoginPageButton()));

//        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getSignupDialog()));
        signupPage.getCloseDialogButton().click();
     /*   loginPage.getEmailField().sendKeys(email);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getloginButton().click();
*/
        homePage.getMyProfileButton().click();
    }

    @Test
    public void editProfileTest(){
        String expectedResult = "Profile saved successfuly";
        homePage.getMyProfileButton().click();
        driverWait.until(ExpectedConditions.urlContains("/profile"));
        String newName = faker.name().firstName() + " " + faker.name().lastName();
        String phone = faker.phoneNumber().phoneNumber();
        String newEmail = faker.internet().emailAddress();
        String newPassword = randomPassword();
        String newCountry = faker.country().name();
        String newTwitter = "https://" + faker.internet().url();
        String newGitHub = "https://" + faker.internet().url();
 //       String city = Cities.BUCARAMANGA.toString();
//        sleep(10000);
        myProfilePage.getNameField().click();
        myProfilePage.getNameField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
//        driverWait.until(ExpectedConditions.textToBePresentInElement(myProfilePage.getNameField(), ""));
        sleep(300);

        myProfilePage.getNameField().sendKeys(newName);
        sleep(300);

//        driverWait.until(ExpectedConditions.textToBePresentInElement(myProfilePage.getNameField(), newName));
 //       driverWait.until(ExpectedConditions.attributeContains(myProfilePage.getNameField(), "value", newName));



        myProfilePage.getPhoneField().click();
//        myProfilePage.getPhoneField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
//        driverWait.until(ExpectedConditions.attributeContains(myProfilePage.getPhoneField(), "value", ""));
//        sleep(300);


        myProfilePage.getPhoneField().sendKeys(phone);
//        driverWait.until(ExpectedConditions.attributeContains(myProfilePage.getPhoneField(), "value", phone));
//        sleep(300);




//        myProfilePage.getCityField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        myProfilePage.chooseCity(Cities.BUCARAMANGA);
//        sleep(300);

        myProfilePage.getCountryField().click();
//        myProfilePage.getCountryField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
//        sleep(300);

        myProfilePage.getCountryField().sendKeys(newCountry);
//        sleep(300);


//        myProfilePage.getTwitterField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
//        sleep(300);
        myProfilePage.getTwitterField().click();
        myProfilePage.getTwitterField().sendKeys(newTwitter);
//        sleep(300);


//        myProfilePage.getGitHubField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
//        sleep(300);

        myProfilePage.getGitHubField().click();
        myProfilePage.getGitHubField().sendKeys(newGitHub);
//        sleep(300);



        myProfilePage.getSaveBtn().click();

 //       sleep(1000);
        driverWait.until(ExpectedConditions.visibilityOf(myProfilePage.getConfimationMessage()));

        String actualResult = myProfilePage.getConfimationMessage().getText().trim();
     //   Assert.assertTrue(actualResult.contains(expectedResult));

        String actualNameResult = myProfilePage.getNameField().getAttribute("value");
        System.out.println("Name: " + actualNameResult);


        String actualPhoneResult = myProfilePage.getPhoneField().getAttribute("value");
        System.out.println("Phone: " +actualPhoneResult);

        String actualCityResult = myProfilePage.getCityField().getAttribute("value");
        System.out.println(actualCityResult);

        String actualCountryResult = myProfilePage.getCountryField().getAttribute("value");
        System.out.println(actualCountryResult);

        String actualTwitterResult = myProfilePage.getTwitterField().getAttribute("value");
        System.out.println(actualTwitterResult);

        String actualGitHubResult = myProfilePage.getGitHubField().getAttribute("value");
        System.out.println(actualGitHubResult);


        Assert.assertTrue(actualResult.contains(expectedResult));

        Assert.assertEquals(actualNameResult, newName);
        Assert.assertEquals(actualPhoneResult, phone);
        Assert.assertEquals(actualCityResult, Cities.BUCARAMANGA.toString());
        Assert.assertEquals(actualCountryResult, newCountry);
        Assert.assertEquals(actualTwitterResult, newTwitter);
        Assert.assertEquals(actualGitHubResult, newGitHub);










    }

}
