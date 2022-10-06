package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CommonPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;

    protected WebDriverWait driverWait;

    protected HomePage homePage;

    protected LoginPage loginPage;

    protected CommonPage commonPage;

    protected Faker faker;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver,driverWait);
        loginPage = new LoginPage(driver, driverWait);
        commonPage = new CommonPage(driver, driverWait);
        faker = new Faker();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().deleteAllCookies();
    }


    @AfterClass
    public void afterClass() {
        sleep(5000);
        driver.quit();
    }

    public String fakeEmail () {
        String fakerEmail = faker.name().firstName().toLowerCase()+"@"+faker.name().firstName().toLowerCase()+".com";
        return fakerEmail;
    }

    public String fakePassword () {
        int pass = faker.number().numberBetween(10000, 99999);
        return String.valueOf(pass);
    }

}
