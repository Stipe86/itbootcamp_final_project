package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {

//    Test #1: Forbids visits to home url if not authenticated
//    Assert:
//    Load '/home' page when user not logged in
//    Verify that the route '/login' appears in the url of the page
    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticatedTest(){
        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/home'
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify redirection to '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

//   Test #2: Forbids visits to profile url if not authenticated
//   Assert:
//   Load '/profile' page when user not logged in
//   Verify that the route '/login' appears in the url of the page
    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticatedTest(){

        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/profile'
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify redirection to '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

//   Test #3: Forbids visits to admin cities url if not authenticated
//   Assert:
//   Load '/admin/cities' page
//   Verify that the route '/login' appears in the url of the page
    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticatedTest(){

        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/admin/cities'
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify redirection to '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

//   Test #4: Forbids visits to admin users url if not authenticated
//   Assert:
//   Load '/admin/users' page
//   Verify that the route '/login' appears in the url of the page
    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticatedTest(){

        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/admin/users'
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify redirection to '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
