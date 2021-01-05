package com.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected AppiumDriver driver;
    protected Properties properties;
    protected FileInputStream fileInputStream;
    protected DesiredCapabilities capabilities;

    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeTest
    public void beforeTest(String platformName, String platformVersion, String deviceName) {
        try {
            String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                    + File.separator + "resources" + File.separator + "config.properties";
            properties = new Properties();
            fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);

            //Desired CAPS
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("automationName", properties.getProperty("androidAutomationName"));
            capabilities.setCapability("appPackage", properties.getProperty("androidAppPackage"));
            capabilities.setCapability("appActivity", properties.getProperty("androidAppActivity"));

            String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                    + File.separator + "resources" + File.separator + "app" + File.separator + properties.getProperty("androidAppLocation");
            capabilities.setCapability("app", appPath);
            URL url = new URL(properties.getProperty("appiumURL"));
            driver = new AndroidDriver(url, capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
