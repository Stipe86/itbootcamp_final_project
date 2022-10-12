package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    private By emailField = By.id("email");

    private By passwordField = By.id("password");

    private By loginButton = By.xpath("//button/span[text()='Login']");

    private By errorNotification = By.xpath("//div[@role= 'status']//li");

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getErrorNotification() {
        return getDriver().findElement(errorNotification);
    }

    public void loginMethod (String email, String password) {

        getEmailField().clear();
        getPasswordField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();

    }


}
