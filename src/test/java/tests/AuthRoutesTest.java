package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {
    /*
    Auth Routes Tests
Test #1: Forbids visits to home url if not authenticated
assert:
Ucitati /home stranu kada korisnik nije ulogovan
Verifikovati da se u url-u stranice javlja ruta /login
Test #2: Forbids visits to profile url if not authenticated
assert:
Ucitati /profile stranu
Verifikovati da se u url-u stranice javlja ruta /login
Test #3: Forbids visits to admin cities url if not authenticated
assert:
Ucitati /admin/cities stranu
Verifikovati da se u url-u stranice javlja ruta /login
Test #4: Forbids visits to admin users url if not authenticated
assert:
Ucitati /admin/users stranu
Verifikovati da se u url-u stranice javlja ruta /login
     */
//    Auth Routes Tests
//    Test #1: Forbids visits to home url if not authenticated
//assert:
//        Ucitati /home stranu kada korisnik nije ulogovan
//Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticatedTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        driverWait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticatedTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");

        driverWait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }


    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticatedTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        driverWait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }


    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticatedTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");

        driverWait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
