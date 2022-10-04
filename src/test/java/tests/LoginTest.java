package tests;

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

import java.time.Duration;

public class LoginTest extends BaseTest {

//    private WebDriver driver;
//
//    private WebDriverWait driverWait;
//
//    private LoginPage loginPage;
//
//    private CommonPage commonPage;

//
//    @BeforeClass
//    public void beforeClass() {
//        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
//        driver = new ChromeDriver();
//        loginPage = new LoginPage(driver, driverWait);
//        commonPage = new CommonPage(driver, driverWait);
//        driver.get("https://vue-demo.daniel-avellaneda.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//        driver.get("https://vue-demo.daniel-avellaneda.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//    }
//
//    @AfterClass
//    public void afterClass() {
//        BaseTest.sleep(3000);
//
//        driver.quit();
//    }
//


    @Test(priority = 1)
    public void testVisitsTheLoginPageAssert() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        commonPage.getLoginPageButton().click();
        // getCurrentUrl() method.

        BaseTest.sleep(10000);

      //  driverWait.until(ExpectedConditions.urlContains("/home"));
        String actualResult = driver.getCurrentUrl();
        System.out.println("test1 actual: "+actualResult);

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test(priority = 2)
    public void login() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        commonPage.getLoginPageButton().click();
        loginPage.loginMethod("admin@admin.com", "12345");

         driverWait.until(ExpectedConditions.urlContains("/home"));

      //  BaseTest.sleep(10000);


        String actualResult = driver.getCurrentUrl();

        System.out.println("test actual: "+actualResult);


        Assert.assertEquals(actualResult, expectedResult);
        //https://vue-demo.daniel-avellaneda.com/home
    }


}
