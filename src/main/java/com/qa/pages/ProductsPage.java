package com.qa.pages;

import com.qa.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    @AndroidFindBy(xpath = "")
    private WebElement productTitleTxt;

    public ProductsPage(AndroidDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return getText(productTitleTxt);
    }
}
