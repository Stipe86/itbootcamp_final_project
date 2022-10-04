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
    /*
    Login Tests
Test #1: Visits the login page
assert:
Verifikovati da se u url-u stranice javlja ruta /login
Test #2: Checks input types
assert:
Verifikovati da polje za unos emaila za atribut type ima vrednost
email
Verifikovati da polje za unos lozinke za atribut type ima vrednost
password
Test #3: Displays errors when user does not exist
Podaci: random email i password koristeći faker libarary
asssert:
Verifikovati da greska sadrzi poruku User does not exists
Verifikovati da se u url-u stranice javlja /login ruta
Test #4: Displays errors when password is wrong
Podaci: random email i password koristeći faker libarary
asssert:
Verifikovati da greska sadrzi poruku Wrong password
Verifikovati da se u url-u stranice javlja /login ruta
Test #5: Login
Podaci:
email: admin@admin.com
password: 12345
asssert:
Verifikovati da se u url-u stranice javlja /home ruta
Test #6: Logout
assert:
Verifikovati da je dugme logout vidljivo na stranici
Verifikovati da se u url-u stranice javlja /login ruta
Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u
stranice javlja /login ruta
     */


    @Test(priority = 1)
    public void testVisitsTheLoginPageAssert() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        commonPage.getLoginPageButton().click();
        // getCurrentUrl() method.

        sleep(5000);

      //  driverWait.until(ExpectedConditions.urlContains("/home"));
        String actualResult = driver.getCurrentUrl();
      //  System.out.println("test1 actual: "+actualResult);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 2)
    public void checkInputTypesTest(){
        String expectedEmailTypeResult = "email";
        String expectedPasswordTypeResult = "password";
        commonPage.getLoginPageButton().click();
        sleep(5000);
        String actualEmailTypeResult = loginPage.getEmailField().getAttribute("type");
        System.out.println("EmailType: "+actualEmailTypeResult);
        Assert.assertEquals(actualEmailTypeResult, expectedEmailTypeResult);
        String actualPasswordTypeResult = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualPasswordTypeResult, expectedPasswordTypeResult);

    }


    @Test(priority = 5)
    public void login() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        commonPage.getLoginPageButton().click();
        loginPage.loginMethod("admin@admin.com", "12345");

         driverWait.until(ExpectedConditions.urlContains("/home"));

      //  sleep(10000);


        String actualResult = driver.getCurrentUrl();

        System.out.println("test actual: "+actualResult);


        Assert.assertEquals(actualResult, expectedResult);
        //https://vue-demo.daniel-avellaneda.com/home
    }


}
