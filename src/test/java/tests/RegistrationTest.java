package tests;

import config.AppiumConfig;
import models.User;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class RegistrationTest extends AppiumConfig {

    @Test
    public void regPositive(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openRegForm()
                .registration(User.builder().name("noa1").lastname("noa").email("noa1@gmail.com").password("Nnoa12345$").build())
                .clickchkBox()
                .clickReg();

    }
}
