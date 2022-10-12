package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        // Setting the city name that will be used in tests
        adminCitiesPage.setCityName(randomCity());
    }

//    Test #1: Visits the admin cities page and list cities
//    Data:
//    admin email: admin@admin.com
//    admin password: 12345
//    Assert:
//    Verify that url contains '/admin/cities'
//    Verify that 'Logout' button is displayed
    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCitiesTest(){
        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));

        // Navigate to 'Cities' page
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getLogoutButton()));

        // Verify url contains '/admin/cities'
        Assert.assertTrue(adminCitiesPage.getDriver().getCurrentUrl().contains("/admin/cities"));

        // Verify 'Logout' button is displayed
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }


//    Test #2: Create new city
//    Data:
//    random city using faker library
//    Assert:
//    Verify message contains text 'Saved successfully'
    @Test(priority = 2)
    public void createNewCityTest() {
        String expectedResult = "Saved successfully";

        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));

        // Navigate to 'Cities' page
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Create city using the name that was set up in the 'BeforeClass'
        String city = adminCitiesPage.getCityName();
        adminCitiesPage.makeNewCityNameMethod(city);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getConfimationMessage()));

        // Verify that confirmation message contains text 'Saved successfully'
        String actualResult = adminCitiesPage.getConfimationMessage().getText().trim();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


//    Test #3: Edit city
//    Data:
//    edit city that was made in test #2 to be - current city name + 'edited'
//    (example: New York - New York edited)
//    Assert:
//    Verify that message contains text 'Saved successfully'
    @Test(priority = 3)
    public void editCityTest() {
        String expectedResult = "Saved successfully";

        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));

        // Navigate to 'Cities' page
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Replace city name that was set in the 'BeforeClass' with a new name
        String city = adminCitiesPage.getCityName();
        driverWait.until(ExpectedConditions.elementToBeClickable(adminCitiesPage.getEditButton()));
        adminCitiesPage.editCity(city, city+" edited");
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getConfimationMessage()));

        // Set that new name so that it can be used in following tests
        String newName = city+" edited";
        adminCitiesPage.setCityName(newName);

        // Verify that confirmation message contains text 'Saved successfully'
        String actualResult = adminCitiesPage.getConfimationMessage().getText().trim();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

//    Test #4: Search city
//    Data:
//    edited city from test #3
//    Assert:
//    Verify that text in the first row of the table matches the input in 'Search' field
    @Test(priority = 4)
    public void searchCityTest() {
        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Login with admin credentials
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Search for city that was edit in test #3
        String city = adminCitiesPage.getCityName();
        adminCitiesPage.inputTextInSearchField(city);
        driverWait.until(ExpectedConditions.numberOfElementsToBe(adminCitiesPage.getTableCityRowsLocator(),1));

        // Verify that text in the first row of the table matches the input in 'Search' field
        String expectedResult = city;
        String actualResult = adminCitiesPage.getTableCityRow1().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

//    Test #5: Delete city
//    Data:
//    edited city from test #3
//    Assert:
//    In search field input city edited name from test #3
//    Wait number of table rows to be 1
//    Verify that text in the row matches the input in 'Search' field
//    Click on that first row delete button
//    Wait for the delete dialog to be visible
//    Click on delete button in dialog
//    Wait for delete confirmation message to be visible
//    Verify that confirmation message contains text 'Deleted successfully'
    @Test(priority = 5)
    public void deleteCityTest(){
        // Navigate to 'Login page'
        commonPage.getLoginPageButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

        // Navigate to 'Cities' page
        loginPage.loginMethod(adminEmail(), adminPassword());
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getAdminButton()));
        homePage.getAdminButton().click();
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getCitiesButton()));
        homePage.getCitiesButton().click();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));

        // Search for city that was edit in test 3
        String city = adminCitiesPage.getCityName();
        adminCitiesPage.inputTextInSearchField(city);
        driverWait.until(ExpectedConditions.numberOfElementsToBe(adminCitiesPage.getTableCityRowsLocator(),1));

        // Verify that text in the first row of the table matches the input in 'Search' field
        String expectedResult = city;
        String actualResult = adminCitiesPage.getTableCityRow1().getText();
        Assert.assertEquals(actualResult, expectedResult);

        // Delete city that was edit in test 3
        adminCitiesPage.deleteCity(city);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getDeleteConfirmationMessage()));

        // Verify that confirmation message contains text 'Deleted successfully'
        String expectedResult2 = "Deleted successfully";
        String actualResult2 = adminCitiesPage.getDeleteConfirmationMessage().getText().trim();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }
}
