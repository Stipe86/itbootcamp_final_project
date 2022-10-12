package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected HomePage homePage;

    protected LoginPage loginPage;

    protected CommonPage commonPage;

    protected SignupPage signupPage;

    protected AdminCitiesPage adminCitiesPage;

    protected MyProfilePage myProfilePage;

    protected Faker faker;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver,driverWait);
        loginPage = new LoginPage(driver, driverWait);
        commonPage = new CommonPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        myProfilePage = new MyProfilePage(driver, driverWait);
        faker = new Faker();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }


    public void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().deleteAllCookies();

    }

    @AfterMethod
      public void afterMethod(){
        signupPage.clickCloseDialogButton();

        signupPage.clickOnLogoutBtn();
    }


    @AfterClass
    public void afterClass() {
        sleep(5000);
        driver.quit();
    }

    public String adminEmail (){
        return "admin@admin.com";
    }
    public String adminPassword () {
        return "12345";
    }

    public String randomEmail() {
        String fakerEmail = faker.internet().emailAddress();
        return fakerEmail;
    }

    public String randomPassword() {
        int pass = faker.number().numberBetween(10000, 99999);
        return String.valueOf(pass);
    }


    public String randomCity() {
        String fakerCity = faker.address().city();
        return fakerCity;
    }


}
