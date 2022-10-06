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

    private By signMeUpButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");


    private By errorNotification = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]");

    private By emailAlreadyExistNotification = By.xpath("//li[contains(text(),'E-mail already exists')]");

//    private By signupDialog = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    private By signupDialog = By.xpath("//div[@class='v-card__title headline grey lighten-2 black--text dlgVerifyAccount']");

    private By closeDialogButton = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button");

    private By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");

//    private  List<WebElement> listCloseDialogButton = getDriver().findElements(closeDialogButton);
//
//    private List<WebElement> listLogoutButton = getDriver().findElements(logoutButton);


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

    public By getEmailAlreadyExistNotification() {
        return emailAlreadyExistNotification;
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
       String confirmpassword = "123654";
        getNameField().clear();
        getEmailField().clear();
        getPasswordField().clear();
        getConfirmPasswordField().clear();
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmpassword);
        getSignMeUpButton().click();
    }

    public void signUpMethodMyCredentials () {
        String   name = "Stjepan Miljkovic";
        String  email = "stjepan.miljkovic@itbootcamp.rs";
        String password = "123456";
        String confirmpassword = "123456";
        getNameField().clear();
        getEmailField().clear();
        getPasswordField().clear();
        getConfirmPasswordField().clear();
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmpassword);
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

//    public void checkVisibilityOfDialog() {
//        if (listCloseDialogButton.size() !=0);{
//            getCloseDialogButton().click();
//        }
//    }
//
//    public void checkVisibilityOfLogoutButton() {
//        if (listLogoutButton.size() !=0) {
//            getLogoutButton().click();
//        }
//    }

    public List<WebElement> getListCloseDialogButton() {
        return getDriver().findElements(closeDialogButton);
    }

    public List<WebElement> getListCloseLogoutButton() {
        return getDriver().findElements(logoutButton);
    }



}
