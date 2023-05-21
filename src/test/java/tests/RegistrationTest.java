package tests;

import config.AppiumConfig;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class RegistrationTest extends AppiumConfig {

    @Test
    public void regPositive(){
        Assert.assertTrue(new SearchScreen(driver)
                .openMoreOptions()
                .openRegForm()
                .registration(User.builder().name("noa3").lastname("noa").email("noa3@gmail.com").password("Nnoa12345$").build())
                .clickchkBox()
                .clickReg()
                .isSearchScreenDisplayed());


    }
}
