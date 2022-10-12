package tests;

import helper.Cities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyProfileTest extends BaseTest{

//    Test #1: Edits profile
//    Data:
//    random data using faker library
//    Assert:
//    Verify that displayed message is 'Profile saved successfuly'
//    Verify that each input now for the value attribute has the value entered within the form

    @BeforeClass
    public void setUp() {
        // navigate to signup page
        commonPage.getSignUpPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getNameField()));

        // setup date for account that will be used for profile update testing
        String name = faker.name().firstName() + " " + faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = randomPassword();

        // register account that will be used for profile update testing
        signupPage.signUpMethod(name, email, password);

        // wait for account verification dialog to appear and close dialog
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getSignupDialog()));
        signupPage.getCloseDialogButton().click();

        // navigate to 'My profile' page
        homePage.getMyProfileButton().click();
    }

    @Test
    public void editProfileTest(){
        String expectedResult = "Profile saved successfuly";
        homePage.getMyProfileButton().click();
        driverWait.until(ExpectedConditions.urlContains("/profile"));

        // setup profile data for testing that will be used for updating an existing profile
        String newName = faker.name().firstName() + " " + faker.name().lastName();
        String phone = faker.phoneNumber().phoneNumber();
        String newCountry = faker.country().name();
        String newTwitter = "https://" + faker.internet().url();
        String newGitHub = "https://" + faker.internet().url();

        //  focus 'Name' field, delete existing data and input new full name
        myProfilePage.getNameField().click();
        myProfilePage.getNameField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        myProfilePage.getNameField().sendKeys(newName);

        // focus 'Phone' field and input phone number
        myProfilePage.getPhoneField().click();
        myProfilePage.getPhoneField().sendKeys(phone);

        // select the city from the dropdown
        myProfilePage.chooseCity(Cities.BUCARAMANGA);


        // focus 'Country' field and input country name
        myProfilePage.getCountryField().click();
        myProfilePage.getCountryField().sendKeys(newCountry);

        // focus 'Twitter' field and input url
        myProfilePage.getTwitterField().click();
        myProfilePage.getTwitterField().sendKeys(newTwitter);

        // focus 'GitHub' field and input url
        myProfilePage.getGitHubField().click();
        myProfilePage.getGitHubField().sendKeys(newGitHub);

        // click on 'SAVE' button
        myProfilePage.getSaveBtn().click();
        driverWait.until(ExpectedConditions.visibilityOf(myProfilePage.getConfimationMessage()));


        // verify that confirmation message is displayed with text : 'Profile saved successfuly'
        String actualResult = myProfilePage.getConfimationMessage().getText().trim();
        Assert.assertTrue(actualResult.contains(expectedResult));


        // verify that new data is displayed after changes are saved
        String actualNameResult = myProfilePage.getNameField().getAttribute("value");
        String actualPhoneResult = myProfilePage.getPhoneField().getAttribute("value");
        String actualCityResult = myProfilePage.getCityField().getAttribute("value");
        String actualCountryResult = myProfilePage.getCountryField().getAttribute("value");
        String actualTwitterResult = myProfilePage.getTwitterField().getAttribute("value");
        String actualGitHubResult = myProfilePage.getGitHubField().getAttribute("value");

        Assert.assertEquals(actualNameResult, newName);
        Assert.assertEquals(actualPhoneResult, phone);
        Assert.assertEquals(actualCityResult, Cities.BUCARAMANGA.toString());
        Assert.assertEquals(actualCountryResult, newCountry);
        Assert.assertEquals(actualTwitterResult, newTwitter);
        Assert.assertEquals(actualGitHubResult, newGitHub);

    }

}
