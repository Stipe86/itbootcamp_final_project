package pages;

import helper.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage{
    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By logoutButton = By.xpath("//i[contains(@class, 'mdi-exit-to-app')]/ancestor::button");

    private By newItemButton = By.xpath("//i[contains(@class, 'mdi-plus')]/ancestor::button");

    private By inputField = By.id("name");

    private By saveButton = By.xpath("//*[contains(@class, 'btnSave' )]");

//    private By confirmationMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    private By confirmationMessage = By.xpath("//div[@role='status'][text()=' Saved successfully ']");

    private By deleteConfirmationMessage = By.xpath("//div[@role='status'] [text()=' Deleted successfully ']");

    private String cityName;

    private String cityNameEdit = cityName + " edit";


    private By editButton = By.id("edit");

    private By deleteButton = By.id("delete");

    private By deleteConfirmButton = By.xpath("//button/span[contains(text(), 'Delete')]");

    //i[contains(@class, 'mdi-pencil')]/ancestor::button
    //i[contains(@class, 'mdi-pencil')]
    //*[@id='edit']

    private By tableRow1Name = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");

    //*[@id="app"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]

    private By tableRow1EditButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]//i[contains(@class, 'mdi-pencil')]/ancestor::button");

    private By editField = By.id("name");

    private By saveButtonEditField = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");

    private By tableCityRows = By.xpath("//table/tbody/tr");

    private By tableCityRow1 = By.xpath("//table/tbody/tr[1]");

    private By searchField = By.id(("search"));


    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public WebElement getNewItemButton() {
        return getDriver().findElement(newItemButton);
    }

    public WebElement getInputField() {
        return getDriver().findElement(inputField);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getConfimationMessage() {
        return getDriver().findElement(confirmationMessage);
    }

    public WebElement getDeleteConfirmationMessage() {
        return getDriver().findElement(deleteConfirmationMessage);
    }

    public WebElement getEditButton() {
        return getDriver().findElement(editButton);
    }

    public WebElement getTableRow1Name() {
        return getDriver().findElement(tableRow1Name);
    }

    public WebElement getTableRow1EditButton() {
        return getDriver().findElement(tableRow1EditButton);
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public WebElement getEditField() {
        return getDriver().findElement(editField);
    }

    public WebElement getSaveButtonEditField() {
        return getDriver().findElement(saveButtonEditField);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public List<WebElement> getTableCityRows(){
        return getDriver().findElements(tableCityRows);
    }

    public WebElement getTableCityRow1() {
        return getDriver().findElement(tableCityRow1);
    }

    public By getTableCityRowsLocator() {
        return tableCityRows;
    }

    public WebElement getDeleteConfirmButton() {
        return getDriver().findElement(deleteConfirmButton);
    }

    public void makeNewCityMethod(String cityName){
        getNewItemButton().click();
        getInputField().sendKeys(cityName);
        getSaveButton().click();
    }





    public void editCityNameMethod(String editCity){
        getEditField().sendKeys(editCity);
        getSaveButtonEditField().click();
    }



    private void editOrDeleteCityMethod(Action action, String cityName) {
        for (int i = 0; i < getTableCityRows().size(); i++) {
            WebElement singleRow = getTableCityRows().get(i);
            if (singleRow.getText().contains(cityName)) {
                switch (action) {
                    case EDIT:
                        singleRow.findElement(editButton).click();
                        break;
                    case DELETE:
                        singleRow.findElement(deleteButton).click();
                }
                break;
            }
        }
    }

    public void editCity(String currentName, String newName) {
        editOrDeleteCityMethod(Action.EDIT, currentName);
        getEditField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getEditField().sendKeys(newName);
        getSaveButtonEditField().click();
    }

    public void deleteCity(String cityName) {
        editOrDeleteCityMethod(Action.DELETE, cityName);
        getDeleteConfirmButton().click();

    }


    public void editCityName(String currentName, String newName) {
        for (int i = 0; i < getTableCityRows().size(); i++) {
            WebElement singleRow = getTableCityRows().get(i);
            if (singleRow.getText().contains(currentName)) {
                singleRow.findElement(editButton).click();
                getEditField().sendKeys(newName);
                getSaveButtonEditField().click();
                break;
            }
        }
    }

    public void inputTextInSearchField(String text){
        getSearchField().sendKeys(text);
    }


//    public List<WebElement> getAddCitiesToListMethod(){
//        return getDriver().findElements((By) getEditButton());
//    }
}
