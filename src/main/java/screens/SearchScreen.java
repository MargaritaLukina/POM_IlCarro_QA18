package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
@FindBy(id="com.telran.ilcarro:id/editLocation")
    MobileElement locationEditText;

    @FindBy(id = "com.telran.ilcarro:id/editFrom")
    MobileElement fromText;

    @FindBy(id = "com.telran.ilcarro:id/editTo")
    MobileElement toText;
    @FindBy(id="com.telran.ilcarro:id/searchBtn")
    MobileElement searchBtn;

    @FindBy(how = How.XPATH,using = "//*[@text='Registration']")
    MobileElement registrationButton;


    @FindBy(how = How.XPATH,using = "//*[@content-desc='More options']")
    MobileElement moreOptions;

    @FindBy(how = How.XPATH,using = "//*[@text='Login']")
    MobileElement loginButton;
    @FindBy(how = How.ID,using = "com.telran.ilcarro:id/findTitle")
    MobileElement titlePage;

    @FindBy(how = How.XPATH,using = "//*[@text='Logout']")
    MobileElement logoutButton;

    @FindBy (xpath ="//*[@text='My Cars']" )
    MobileElement myCarsButton;

    public MyCarsScreen openMyCarsList(){
        myCarsButton.click();
        return new MyCarsScreen(driver);
    }

    public SearchScreen openMoreOptions() {

        if(isDisplayedWithExp(moreOptions,15)) {
            moreOptions.click();
        }
        return this;
    }
    public LoginScreen openFormLogin(){
        loginButton.click();
        return new LoginScreen(driver);
    }
    public RegistrationScreen openRegForm(){
        registrationButton.click();
        return new RegistrationScreen(driver);
    }

    public boolean isSearchScreenDisplayed(){
        present(titlePage,5);
        return titlePage.getText().equals("Find your car now!");
    }
    public SearchScreen logout(){

        if(isDisplayedWithExp(logoutButton,5)) {

            logoutButton.click();
        }
        return this;
    }

    public SearchScreen isSearchScreenDisplayedAssert(){
        present(titlePage,5);
        Assert.assertTrue(titlePage.getText().equals("Find your car now!"));
        return this;
    }

    public ResultScreen fillLocation(){
        isDisplayedWithExp(locationEditText, 15);
        driver.hideKeyboard();
        locationEditText.click();
        locationEditText.clear();
        type(locationEditText,"Tel Aviv");
       // type(fromText, "23/05/2023");
       // fromText.click();
        fromText.sendKeys("23/05/2023");
        //type(toText, "24/05/2023");
        toText.sendKeys("24/05/2023");
        searchBtn.click();

        return new ResultScreen(driver);
    }




    public String getLocation(){
        return  locationEditText.getText();
    }


}


