package com.hrmorange.tests;

import com.hrmorange.drivers.GUIDriver;
import com.hrmorange.drivers.WebDriverProvider;
import com.hrmorange.utils.dataReader.JsonReader;
import com.hrmorange.utils.dataReader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements WebDriverProvider {
    protected GUIDriver driver;
    protected JsonReader testData = new JsonReader("testData");

    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        driver.browserActions().navigateTo(PropertyReader.getProperty("baseUrlWeb"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quitDriver();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }
}
