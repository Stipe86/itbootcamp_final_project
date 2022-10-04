package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage extends BasePage {
    public CommonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By homePageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[1]");

    private By loginPageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");

    private By aboutPageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]");

    private By signUpPageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");


    public WebElement getHomePageButton() {
        return getDriver().findElement(homePageButton);
    }

    public WebElement getLoginPageButton() {
        return getDriver().findElement(loginPageButton);
    }

    public WebElement getAboutPageButton() {
        return getDriver().findElement(aboutPageButton);
    }

    public WebElement getSignUpPageButton() {
        return getDriver().findElement(signUpPageButton);
    }
}
