package tests;
import config.AppiumConfig;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class RemoveCarTest extends AppiumConfig {
    @BeforeMethod
    public void preCondition(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openFormLogin()
                .fillLoginForm(User.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin();
    }

    @Test
    public void removeCarSuccessTest(){
        new SearchScreen(driver)
                .openMoreOptions()
                .openMyCarsList()
                .removeCar();
    }

}
