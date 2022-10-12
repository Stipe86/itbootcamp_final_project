package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By nameField = By.id("name");

    private By emailField = By.id("email");

    private By passwordField = By.id("password");

    private By confirmPasswordField = By.id("confirmPassword");

    private By signMeUpButton = By.xpath("//button/span[text()='Sign me up']");

    private By errorNotification = By.xpath("//div[@role= 'status']//li");

    private By signupDialog = By.xpath("//div[contains(@class, 'dlgVerifyAccount')]");

    private By closeDialogButton = By.xpath("//button[contains(@class, 'btnClose')]");

    private By logoutButton = By.xpath("//button[contains(@class, 'btnLogout')]");

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getSignMeUpButton() {
        return getDriver().findElement(signMeUpButton);
    }

    public WebElement getErrorNotification() {
        return getDriver().findElement(errorNotification);
    }

    public WebElement getSignupDialog() {
        return getDriver().findElement(signupDialog);
    }

    public WebElement getCloseDialogButton() {
        return getDriver().findElement(closeDialogButton);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public void signUpAlreadyExistUserMethod () {
        String   name = "Test Test";
        String  email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";
        getNameField().clear();
        getEmailField().clear();
        getPasswordField().clear();
        getConfirmPasswordField().clear();
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpButton().click();
    }

    public void signUpMethodMyCredentials () {
        String   name = "Stjepan Miljkovic";
        String  email = "stjepan.miljkovic@itbootcamp.rs";
        String password = "123456";
        String confirmPassword = "123456";
        getNameField().clear();
        getEmailField().clear();
        getPasswordField().clear();
        getConfirmPasswordField().clear();
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpButton().click();
    }

    public void signUpMethod (String name, String email, String password) {
        getNameField().clear();
        getEmailField().clear();
        getPasswordField().clear();
        getConfirmPasswordField().clear();
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(password);
        getSignMeUpButton().click();
    }

    public List<WebElement> getListCloseDialogButton() {
        return getDriver().findElements(closeDialogButton);
    }

    public List<WebElement> getListLogoutButton() {
        return getDriver().findElements(logoutButton);
    }

    public void clickCloseDialogButton() {
        if (getListCloseDialogButton().size() !=0 ) {
            getCloseDialogButton().click();
        }
    }

    public void clickOnLogoutBtn() {
        if (getListLogoutButton().size() !=0) {
            getLogoutButton().click();
        }
    }

}
