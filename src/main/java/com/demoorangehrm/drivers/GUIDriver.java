package com.demoorangehrm.drivers;

import com.demoorangehrm.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GUIDriver {
    private final static String browser = PropertyReader.getProperty("browserType");

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver() {
        WebDriver driver = ThreadGuard.protect(getDriver());
        driverThreadLocal.set(driver);
    }

    public static WebDriver get() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

    //safari > SAFARI
    private WebDriver getDriver() {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserType.getDriverFactory(); //local
        return abstractDriver.createDriver();
    }
}