package com.hrmorange.pages;

import com.hrmorange.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UserManagementPage {
    private final GUIDriver driver;

    //Locators
    private final By addButton =
            By.xpath("//div[@class='orangehrm-header-container']//button");
    private final By userRoleLabel =
            By.xpath("//label[contains(.,'User Role')]");
    private final By employeeNameLabel =
            By.xpath("//label[contains(.,'Employee Name')]");
    private final By passwordLabel =
            By.xpath("//label[contains(.,'Password')]");
    private final By usernameLabel =
            By.xpath("//label[contains(.,'Username')]");


    public UserManagementPage(GUIDriver driver) {
        this.driver = driver;
    }

    //Actions
    @Step("Click Add Button")
    public UserManagementPage clickAddButton() {
        driver.elementActions()
                .clickOnElement(addButton);
        return this;
    }

    //Validations
    @Step("Verify User Role field is displayed")
    public UserManagementPage verifyUserRoleDisplayed() {
        Assert.assertTrue(
                driver.elementActions().findWebElement(userRoleLabel).isDisplayed(),
                "User Role field is not displayed"
        );
        return this;
    }

    @Step("Verify Employee Name field is displayed")
    public UserManagementPage verifyEmployeeNameDisplayed() {
        Assert.assertTrue(
                driver.elementActions().findWebElement(employeeNameLabel).isDisplayed(),
                "Employee Name field is not displayed"
        );
        return this;
    }

    @Step("Verify Username field is displayed in User Management page")
    public UserManagementPage verifyUsernameDisplayed() {
        Assert.assertTrue(
                driver.elementActions().findWebElement(usernameLabel).isDisplayed(),
                "Username field is not displayed"
        );
        return this;
    }

    @Step("Verify Password field is displayed in User Management page")
    public UserManagementPage verifyPasswordDisplayed() {
        Assert.assertTrue(
                driver.elementActions().findWebElement(passwordLabel).isDisplayed(),
                "Password field is not displayed"
        );
        return this;
    }

    @Step("Verify Add User form contains all required fields")
    public UserManagementPage verifyAddUserFormDisplayed() {

        verifyUserRoleDisplayed();
        verifyEmployeeNameDisplayed();
        verifyUsernameDisplayed();
        verifyPasswordDisplayed();

        return this;
    }
}
