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
        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/home'
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify that after attempt to load 'home' page url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }


   /*
   Test #2: Forbids visits to profile url if not authenticated
assert:
        Ucitati /profile stranu
Verifikovati da se u url-u stranice javlja ruta /login
*/

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticatedTest(){

        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/profile'
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify that after attempt to load 'profile' page url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

   /*
   Test #3: Forbids visits to admin cities url if not authenticated
assert:
        Ucitati /admin/cities stranu
Verifikovati da se u url-u stranice javlja ruta /login
*/


    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticatedTest(){

        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/admin/cities'
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify that after attempt to load 'admin cities' page url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }



   /* Test #4: Forbids visits to admin users url if not authenticated
assert:
        Ucitati /admin/users stranu
Verifikovati da se u url-u stranice javlja ruta /login
     */

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticatedTest(){

        // Load page with url : 'https://vue-demo.daniel-avellaneda.com/admin/users'
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        driverWait.until(ExpectedConditions.urlContains("/login"));

        // Verify that after attempt to load 'admin users' page url contains '/login'
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
