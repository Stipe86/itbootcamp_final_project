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

    private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    //*[@id="app"]/div/div/header/div/div[3]/a[3]

    //*[@id="app"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button

    //*[@id="app"]/div/div/header/div/div[3]/a[3]


    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getpasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getloginButton() {
        return getDriver().findElement(loginButton);
    }

    public void loginMethod (String email, String password) {

        getEmailField().clear();
        getpasswordField().clear();
        getEmailField().sendKeys(email);
        getpasswordField().sendKeys(password);
        getloginButton().click();


    }

}
