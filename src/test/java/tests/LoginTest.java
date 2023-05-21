package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class LoginTest extends AppiumConfig {
    @Test
    public void successLogin(){

        Assert.assertTrue(new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
               .submitLogin()
                .isSearchScreenDisplayed());

   }
    @AfterMethod
    public void posCondition(){
        new SearchScreen(driver)
                .openMoreOptions()
                .logout();
    }

}
