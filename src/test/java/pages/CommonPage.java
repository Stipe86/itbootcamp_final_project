package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage extends BasePage {
    public CommonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By homePageButton = By.xpath("//a[@href= '/']/span[contains(text(), 'Home')]");

    private By loginPageButton = By.xpath("//a[contains(@class, 'btnLogin')][@href='/login']");

    private By aboutPageButton = By.xpath("//a[@href= '/about']/span[contains(text(), 'About')]");

    private By signUpPageButton = By.xpath("//a[contains(@class, 'btnLogin')][@href= '/signup']");

    private By localeButton = By.xpath("//button[contains(@class,  'btnLocaleActivation')]");

    private By espButton = By.xpath("//span[contains(@class,  'f-es')]");

    private By engButton = By.xpath("//span[contains(@class,  'f-gb')]");

    private By fraButton = By.xpath("//span[contains(@class,  'f-fr')]");


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

    public WebElement getLocaleButton() {
        return getDriver().findElement(localeButton);
    }

    public WebElement getEspButton() {
        return getDriver().findElement(espButton);
    }

    public WebElement getEngButton() {
        return getDriver().findElement(engButton);
    }

    public WebElement getFraButton() {
        return getDriver().findElement(fraButton);
    }


}



