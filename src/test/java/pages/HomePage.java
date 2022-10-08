package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

//    private By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By logoutBtn = By.xpath("//button[contains(@class, 'btnLogout')]");
    // //i[contains(@class, 'mdi-exit-to-app' )]/ancestor::button
    private By adminButton = By.xpath("//i[contains(@class, 'mdi-lock')]/ancestor::button");

    private By citiesButton = By.xpath("//a[@href='/admin/cities']");

    private By usersButton = By.xpath("//a[@href='/admin/users']");


    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public List<WebElement> getListLogoutBtn() {
        return getDriver().findElements(logoutBtn);
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getCitiesButton() {
        return getDriver().findElement(citiesButton);
    }

    public WebElement getUsersButton() {
        return getDriver().findElement(usersButton);
    }
}
