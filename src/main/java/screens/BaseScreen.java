package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver){
        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void type(MobileElement element, String text){
      //pause(15000);
        element.click();
        element.clear();
        element.sendKeys(text);

    };
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitElement(MobileElement element, int time){
        new WebDriverWait(driver, time).until(
                ExpectedConditions.visibilityOf(element)
        );
    }
    public void present(MobileElement element, int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.visibilityOf(element));
    }
    public boolean isDisplayedWithExp(MobileElement element,int time){
        try {
            present(element, time);
            return element.isDisplayed();
        }catch (Exception ex){
            return false;
        }
    }

}
