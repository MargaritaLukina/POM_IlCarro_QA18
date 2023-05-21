package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ResultScreen extends BaseScreen {
    public ResultScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id="com.telran.ilcarro:id/resultTitle")
    MobileElement title;

    public boolean isResultScreenDisplayed(){
        present(title,5);
        return title.getText().equals("Search result");
    }
}
