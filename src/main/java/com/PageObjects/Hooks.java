package com.PageObjects;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;


public class Hooks {

    public AppiumDriver driver;


    @Before
    public void antes() {
        driver = BasePage.getDriver();
    }

    @After
    public void depois() {
        BasePage.killDriver();
    }
}
