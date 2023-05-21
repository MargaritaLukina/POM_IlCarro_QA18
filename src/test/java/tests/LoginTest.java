package tests;

import config.AppiumConfig;
import models.User;
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
    @Test
    public void loginNegativeEmailModel() {
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
              //  .fillLoginForm(User.builder().email("noagmail.com").password("Nnoa12345$").build())
                .fillEmail("noagmail.com")
                .fillPassword("Nnoa12345$")
                .submitLoginNegative()
                .isErrorMessageTest("Login or Password incorrect");
    }

    @Test
    public void loginNegativePassword() {
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa1")
                .submitLoginNegative()
                .isErrorMessageTest("Login or Password incorrect");
    }

    @AfterMethod
    public void posCondition(){
        new SearchScreen(driver)
                .openMoreOptions()
                .logout();
    }

}
