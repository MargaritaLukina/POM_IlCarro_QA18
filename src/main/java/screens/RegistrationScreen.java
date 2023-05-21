package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationScreen extends BaseScreen{

    public RegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id="com.telran.ilcarro:id/editRegName")
    MobileElement txtRegName;

    @FindBy(id="com.telran.ilcarro:id/editRegLastName")
    MobileElement txtRegLastName;

    @FindBy(id="com.telran.ilcarro:id/editRegEmail")
    MobileElement txtRegEmail;

    @FindBy(id="com.telran.ilcarro:id/editRegPassword")
    MobileElement txtRegPassword;

    @FindBy(id="com.telran.ilcarro:id/checkBoxAgree")
    MobileElement chkcheckBoxAgree;


    @FindBy(id="com.telran.ilcarro:id/regBtn")
    MobileElement btnregBtn;


    @FindBy(id="com.telran.ilcarro:id/loginTitle")
    MobileElement labelLoginTitle;

    public RegistrationScreen isRegistrationScreenPresent(){
        Assert.assertTrue(labelLoginTitle.getText().equals("Registration"));
        return this;
    }
public RegistrationScreen registration(User user){
    present(txtRegName, 5);
    type(txtRegName,user.getName());
    type(txtRegLastName, user.getLastname());
    type(txtRegEmail, user.getEmail());
    type(txtRegPassword,user.getPassword());
    return this;
}

public RegistrationScreen clickchkBox(){
        chkcheckBoxAgree.click();
        return this;
}

public SearchScreen clickReg(){
        btnregBtn.click();
        return new SearchScreen(driver);
}

public RegistrationScreen alertMess(String text){
    Alert alert=new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert();
    Assert.assertTrue(alert.getText().contains(text));
    alert.accept();
    return this;

}

}
