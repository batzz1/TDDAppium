package com.qa.pages;

import com.qa.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement usernameTxtFld;

    @AndroidFindBy(accessibility = "test-Password")
    private WebElement passwordTxtFld;

    @AndroidFindBy(accessibility = "test-Login")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "test-Login")
    private WebElement errTxt;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    //Page Related Methods

    public LoginPage enterUserName(String userName) {
        sendKeys(usernameTxtFld, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(passwordTxtFld, password);
        return this;
    }

    public String getErrText() {
        return getText(errTxt);
    }

    public ProductsPage tapLoginBtn() {
        tap(loginBtn);
        return new ProductsPage(driver);
    }
}
