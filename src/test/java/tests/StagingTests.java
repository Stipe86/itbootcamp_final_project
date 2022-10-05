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
    @Test(priority = 4)
    public void displayingErrorsWhenPasswordIsWrongTest(){
        String expectedResult = "Wrong password";
        commonPage.getLoginPageButton().click();
        loginPage.loginMethod("admin@admin.com", "12346");
       // sleep(5000);
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getPasswordErrorNotification()));
      //  driverWait.until(ExpectedConditions.alertIsPresent());
        String actualResult = loginPage.getPasswordErrorNotification().findElement(By.xpath("//li[contains(text(),'Wrong password')]")).getText();
        System.out.println("error msg: "+actualResult);
        loginPage.getDriver().getCurrentUrl();
        System.out.println("Current url"+loginPage.getDriver().getCurrentUrl());
        Assert.assertEquals(actualResult, expectedResult);


    }
}
