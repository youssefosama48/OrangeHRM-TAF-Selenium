package com.hrmorange.pages;

import com.hrmorange.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    private final GUIDriver driver;
    //Locators
    private final By loginUsername = By.name("username");
    private final By loginPassword = By.cssSelector("[type='password']");
    private final By loginButton = By.cssSelector(".orangehrm-login-action > button");
    private final By invalidLoginMsg = By.xpath("//div[@role='alert']//p");
    private final By requiredErrorMsg = By.xpath("//span[contains(.,'Required')]");

    //Constructor
    public LoginPage(GUIDriver driver) {
        this.driver = driver;
    }


    //Page Actions

    @Step("Enter username: {username}")
    public LoginPage enterUsername(String username) {
        driver.elementActions().sendKeys(loginUsername, username);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        driver.elementActions().sendKeys(loginPassword, password);
        return this;
    }

    @Step("Click Login button")
    public LoginPage clickLoginButton() {
        driver.elementActions().clickOnElement(loginButton);
        return this;
    }

    @Step("Login with valid credentials")
    public DashboardPage loginWithValidCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage(driver);
    }

    @Step("Login with invalid credentials")
    public LoginPage loginWithInvalidCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return this;
    }


    //Validations
    @Step("Verify login error message")
    public LoginPage verifyErrorMessageDisplayed(String errorType, String expectedMessage) {
        By error = errorType.equals("required") ? requiredErrorMsg : invalidLoginMsg;
        Assert
                .assertEquals(driver.elementActions().getText(error),
                        expectedMessage
                );
        return this;
    }

    @Step("Verify Required error is displayed for both username and password fields")
    public LoginPage verifyRequiredMsgDisplayedOnBoth() {

        Assert.assertEquals(
                driver.elementActions()
                        .findWebElements(requiredErrorMsg)
                        .size(),
                2,
                "Required error should be displayed for both fields"
        );

        return this;
    }

}
