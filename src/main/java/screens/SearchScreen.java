package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
@FindBy(id="com.telran.ilcarro:id/editLocation")

    MobileElement locationEditText;




    public SearchScreen fillLocation(){
        type(locationEditText,"Tel Aviv");
        return this;
    }
    public String getLocation(){
        return  locationEditText.getText();
    }


}


