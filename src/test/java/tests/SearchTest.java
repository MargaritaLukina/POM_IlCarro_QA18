package tests;

import config.AppiumConfig;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class SearchTest extends AppiumConfig {
    @BeforeMethod
    public void preCondition(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(User.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin();
    }

    @Test
    public void searchCar(){

       Assert.assertTrue(new SearchScreen(driver).fillLocation().isResultScreenDisplayed());




    }
}
