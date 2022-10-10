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

//    private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    private By loginButton = By.xpath("//button/span[text()='Login']");


    //button/span[text()='Login']
    //button[@type= 'submit']

    //*[@id="app"]/div/div/header/div/div[3]/a[3]

    //*[@id="app"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button

    //*[@id="app"]/div/div/header/div/div[3]/a[3]

 //   private By emailTypeAtribute = By.cssSelector("input[type='email']");

 //   private By passwordTypeAtribute = By.cssSelector("input[type='password']");

    private By errorNotification = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");

    //*[@id="app"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]

    private By emailErrorNotification = By.xpath("//li[contains(text(),'User does not exists')]");


    private By passwordErrorNotification = By.xpath("//li[contains(text(),'Wrong password')]");


    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getloginButton() {
        return getDriver().findElement(loginButton);
    }

//    public WebElement getEmailTypeAtribute() {
//        return getDriver().findElement(emailTypeAtribute);
//    }
//
//    public WebElement getPasswordTypeAtribute() {
//        return getDriver().findElement(passwordTypeAtribute);
//    }

    public WebElement getErrorNotification() {
        return getDriver().findElement(errorNotification);
    }

    public By getEmailErrorNotification() {
        return emailErrorNotification;
    }

    public By getPasswordErrorNotification() {
        return passwordErrorNotification;
    }

    //    public WebElement getPasswordErrorNotification() {
//        return getDriver().findElement(passwordErrorNotification);
//    }

    public void loginMethod (String email, String password) {

        getEmailField().clear();
        getPasswordField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getloginButton().click();


    }

}
