package com.qa;

import com.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriverWait wait;
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, TestUtils.WAIT);
    }

    //Mobile Actions

    /**
     * Performs tap
     * @param element
     */
    public void tap(WebElement element) {
        waitForElementToBeVisible(element).click();
    }

    /**
     * Write Text
     * @param element
     * @param text
     */
    public void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void getAttribute(WebElement element,String attribute){
        waitForElementToBeVisible(element);
        element.getAttribute(attribute);
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickable(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
