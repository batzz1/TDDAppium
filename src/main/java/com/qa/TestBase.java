package com.qa;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    protected AppiumDriver driver;
    protected Properties properties;
    protected FileInputStream fileInputStream;

    @BeforeTest
    public void beforeTest() {
        try {
            String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                    + File.separator + "resources" + File.separator + "config.properties";
            properties = new Properties();
            fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);

            //Desired CAPS
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("","");
            capabilities.setCapability("","");
            capabilities.setCapability("","");
            capabilities.setCapability("","");
            capabilities.setCapability("","");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
