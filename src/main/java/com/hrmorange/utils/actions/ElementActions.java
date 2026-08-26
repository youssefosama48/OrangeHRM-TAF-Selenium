package com.hrmorange.utils.actions;

import com.hrmorange.utils.WaitManager;
import com.hrmorange.utils.logs.LogsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementActions {
    private final WebDriver driver;
    private WaitManager waitManager;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    /**
     * Click on an element located by the given locator.
     *
     * @param locator
     * @return object from ElementActions class
     */
    public ElementActions clickOnElement(By locator) {
        waitManager.explicitWait().until(driver ->
                {
                    try {
                        WebElement element = driver.findElement(locator);
                        scrollToElementJS(locator);
                        element.click();
                        LogsManager.info("Clicked on element: " + locator.toString());
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Failed to click on element: " + locator.toString());
                        return false;
                    }
                }
        );
        return this;
    }

    /**
     * Type text into an input field located by the given locator.
     *
     * @param locator
     * @param text
     * @return object from ElementActions class
     */
    public ElementActions sendKeys(By locator, String text) {
        waitManager.explicitWait().until(driver ->
                {
                    try {
                        WebElement element = driver.findElement(locator);
                        scrollToElementJS(locator);
                        element.clear();
                        element.sendKeys(text);
                        LogsManager.info("Sent keys to element: " + locator.toString());
                        return true;
                    } catch (Exception e) {
                        LogsManager.error("Failed to send keys to element: " + locator.toString());
                        return false;
                    }
                }
        );
        return this;
    }

    /**
     * Get text from an element located by the given locator.
     *
     * @param locator
     * @return text from the element
     */
    public String getText(By locator) {
        return waitManager.explicitWait().until(driver ->
                {
                    try {
                        WebElement element = driver.findElement(locator);
                        scrollToElementJS(locator);
                        String msg = element.getText();
                        return msg;
                    } catch (Exception e) {
                        LogsManager.error("Failed to get text from element: " + locator.toString());
                        return null;
                    }
                }
        );
    }

    /**
     * Find a WebElement located by the given locator.
     *
     * @param locator from By class
     * @return WebElement found by the locator
     */
    public WebElement findWebElement(By locator) {
        return waitManager.explicitWait().until(driver ->
                {
                    try {
                        WebElement element = driver.findElement(locator);
                        LogsManager.info("Found element: " + locator.toString());
                        return element;
                    } catch (Exception e) {
                        LogsManager.error("Failed to find element: " + locator.toString());
                        return null;
                    }
                }
        );
    }

    public List<WebElement> findWebElements(By locator) {
        return waitManager.explicitWait().until(driver -> {
                    List<WebElement> elements = driver.findElements(locator);

                    if (!elements.isEmpty()) {
                        LogsManager.info("Found elements: " + locator);
                        return elements;
                    }

                    return null;
                }
        );
    }

    /**
     * Scroll to an element located by the given locator using JavaScript.
     *
     * @param locator
     */
    public void scrollToElementJS(By locator) {
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(""" 
                        arguments[0].scrollIntoView({behaviour:"auto",block:"center",inline:"center"});""", findWebElement(locator));
    }
}
