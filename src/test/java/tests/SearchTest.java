package tests;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SearchScreen;

public class SearchTest extends AppiumConfig {

    @Test
    public void searchCar(){

      String location =  new SearchScreen(driver).fillLocation().getLocation();
        System.out.println(location);
        Assert.assertEquals(location,"Tel Aviv");


    }
}
