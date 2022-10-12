package pages;

import helper.Cities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyProfilePage extends BasePage{
    public MyProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By nameField = By.id("name");

    private By phoneField = By.id("phone");

    private By cityField = By.id("city");

    private By cities = By.xpath("//div[@role='listbox']//div[@class='v-list-item__title']");

    public By countryField = By.id("country");

    public By twitterField = By.id("urlTwitter");

    public By gitHubField = By.id("urlGitHub");

    private By confirmationMessage = By.xpath("//div[contains(@class,'success')]");

    private By btnSave = By.xpath("//button[contains(@class,'btnSave')]");

    public WebElement getSaveBtn() {
        return getDriver().findElement(btnSave);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getCountryField() {
        return getDriver().findElement(countryField);
    }

    public WebElement getTwitterField() {
        return getDriver().findElement(twitterField);
    }

    public WebElement getGitHubField() {
        return getDriver().findElement(gitHubField);
    }

    public WebElement getConfimationMessage() {
        return getDriver().findElement(confirmationMessage);
    }
    
    private List<WebElement> citiesList(){
        return getDriver().findElements(cities);
    }

    public void chooseCity(Cities cityName){
        getCityField().click();
        for (int i = 0; i < citiesList().size(); i++) {
            WebElement oneCity = citiesList().get(i);
            if (oneCity.getText().equals(cityName.toString())){
                 oneCity.click();
                 break;

            }
        }
    }
}
