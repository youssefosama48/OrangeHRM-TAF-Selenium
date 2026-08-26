package com.hrmorange.utils;

import com.hrmorange.utils.dataReader.PropertyReader;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {
    private WebDriver driver;

    public WaitManager(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(java.time.Duration.ofSeconds(Long.parseLong(PropertyReader.getProperty("WAIT_INTERVAL"))))
                .pollingEvery(java.time.Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class,
                        StaleElementReferenceException.class);
    }

    public WebDriverWait explicitWait() {
        return new WebDriverWait(driver, java.time.Duration.ofSeconds(Long.parseLong(PropertyReader.getProperty("WAIT_INTERVAL"))));
    }
}
