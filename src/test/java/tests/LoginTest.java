package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.CommonPage;
import pages.LoginPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {




    @Test(priority = 1)
    public void testVisitsTheLoginPageAssert() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 2)
    public void checkInputTypesTest(){
        String expectedEmailTypeResult = "email";
        String expectedPasswordTypeResult = "password";
        commonPage.getLoginPageButton().click();
   //     sleep(5000);
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));
        String actualEmailTypeResult = loginPage.getEmailField().getAttribute("type");
        System.out.println("EmailType: "+actualEmailTypeResult);
        Assert.assertEquals(actualEmailTypeResult, expectedEmailTypeResult);
        String actualPasswordTypeResult = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualPasswordTypeResult, expectedPasswordTypeResult);

    }

    @Test(priority = 3)
    public void displayingErrorsWhenUserDoesNotExistTest(){
        String expectedResult = "User does not exists";
        commonPage.getLoginPageButton().click();
        String fakeEmail = fakeEmail();
        String fakePassword = fakePassword();
        loginPage.loginMethod(fakeEmail, fakePassword);
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorNotification()));
        String actualResult = loginPage.getErrorNotification().findElement(loginPage.getEmailErrorNotification()).getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

/*
Test #4: Displays errors when password is wrong
Podaci: email: admin@admin.com i proizvoljan password
asssert:
Verifikovati da greska sadrzi poruku Wrong password
Verifikovati da se u url-u stranice javlja /login ruta

//*[@id="app"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]
//li[contains(text(),'Wrong password')]

 */
    @Test(priority = 4)
    public void displayingErrorsWhenPasswordIsWrongTest(){
        String expectedResult = "Wrong password";
        commonPage.getLoginPageButton().click();
        loginPage.loginMethod("admin@admin.com", "12346");
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorNotification()));
        String actualResult = loginPage.getErrorNotification().findElement(loginPage.getPasswordErrorNotification()).getText();
        System.out.println("error msg: "+actualResult);
        loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("/login"));

    }


    @Test(priority = 5)
    public void login() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        commonPage.getLoginPageButton().click();
        loginPage.loginMethod("admin@admin.com", "12345");

         driverWait.until(ExpectedConditions.urlContains("/home"));

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test   //  (priority = 6) problem
    public void logoutTest(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));
        loginPage.loginMethod("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getLogoutBtn()));
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());

        homePage.getLogoutBtn().click();

        driverWait.until(ExpectedConditions.urlContains("/login"));

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        driverWait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }



}
