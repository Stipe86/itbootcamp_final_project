package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StagingTests extends BaseTest{
/*
//*[@id="app"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]
//li[contains(text(),'Wrong password')]
*/

//    @Test(priority = 4)
//    public void displayingErrorsWhenPasswordIsWrongTest(){
//        String expectedResult = "Wrong password";
//        commonPage.getLoginPageButton().click();
//        loginPage.loginMethod("admin@admin.com", "12346");
//       // sleep(5000);
//        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getPasswordErrorNotification()));
//      //  driverWait.until(ExpectedConditions.alertIsPresent());
//        String actualResult = loginPage.getPasswordErrorNotification().findElement(By.xpath("//li[contains(text(),'Wrong password')]")).getText();
//        System.out.println("error msg: "+actualResult);
//        loginPage.getDriver().getCurrentUrl();
//        System.out.println("Current url"+loginPage.getDriver().getCurrentUrl());
//        Assert.assertEquals(actualResult, expectedResult);
//        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("/login"));
//    }
//
//
 /*
 Test #3: Displays errors when user does not exist
Podaci: random email i password koristeći faker libarary
asssert:
Verifikovati da greska sadrzi poruku User does not exists
Verifikovati da se u url-u stranice javlja /login ruta
  */
//    @Test
//    public void displayingErrorsWhenUserDoesNotExist(){
//        String expectedResult = "User does not exists";
//        commonPage.getLoginPageButton().click();
//      //  String email = faker.name().firstName().toLowerCase()+"@"+faker.name().firstName().toLowerCase()+".com";
//        String fakeEmail = fakeEmail();
//        String fakePassword = fakePassword();
//     //   int pass = faker.number().numberBetween(10000, 99999);
//        loginPage.loginMethod(fakeEmail, fakePassword);
//        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorNotification()));
//        String actualResult = loginPage.getErrorNotification().findElement(loginPage.getEmailErrorNotification()).getText();
//
//        System.out.println(fakeEmail);
//        System.out.println(fakePassword);
//        System.out.println(actualResult);
//        Assert.assertEquals(actualResult, expectedResult);
//
//    }
//

}
