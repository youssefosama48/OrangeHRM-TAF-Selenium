package com.hrmorange.drivers;

import com.hrmorange.utils.actions.BrowserActions;
import com.hrmorange.utils.actions.ElementActions;
import com.hrmorange.utils.dataReader.PropertyReader;
import com.hrmorange.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GUIDriver {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver() {
        String browser = PropertyReader.getProperty("browserType");
        LogsManager.info("Initializing GUIDriver with browser: " + browser);
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        LogsManager.info("Starting driver for browser: " + browserType);
        AbstractDriver abstractDriver = browserType.getDriverFactory(); //local
        WebDriver driver = ThreadGuard.protect(abstractDriver.createDriver());
        driverThreadLocal.set(driver);
    }

    public static WebDriver get() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }


    public ElementActions elementActions() {
        return new ElementActions(get());
    }

    public BrowserActions browserActions() {
        return new BrowserActions(get());
    }
}