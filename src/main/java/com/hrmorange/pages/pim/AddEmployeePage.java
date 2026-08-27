package com.hrmorange.pages.pim;

import com.hrmorange.drivers.GUIDriver;
import com.hrmorange.pages.EmployeePersonalDetailsPage;
import com.hrmorange.utils.dataReader.JsonReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddEmployeePage {
    private final GUIDriver driver;
    private final String END_POINT =
            new JsonReader("testData").getJsonData("endpoints.addEmployee");
    //Locators
    private final By firstNameField =
            By.name("firstName");

    private final By lastNameField =
            By.name("lastName");

    private final By employeeIDField =
            By.xpath("//label[contains(.,'Employee Id')]/parent::div/following-sibling::div/input");

    private final By saveButton =
            By.cssSelector("[type='submit']");

    public AddEmployeePage(GUIDriver driver) {
        this.driver = driver;
    }

    //Dynamic Locator
    private By requiredError(int index) {
        return By.xpath(
                "(//div[@class='--name-grouped-field']//span)[" + index + "]"
        );
    }

    //Actions
    @Step("Enter First Name: {name}")
    public AddEmployeePage enterFirstName(String name) {
        driver
                .elementActions().sendKeys(firstNameField, name);
        return this;
    }

    @Step("Enter Last Name: {name}")
    public AddEmployeePage enterLastName(String name) {
        driver.elementActions().sendKeys(lastNameField, name);
        return this;
    }

    @Step("Click Save button")
    public AddEmployeePage clickSave() {
        driver.elementActions().clickOnElement(saveButton);
        return this;
    }

    @Step("Clear Employee ID field")
    public AddEmployeePage clearEmployeeId() {
        driver.elementActions()
                .clearText(employeeIDField);
        return this;
    }

    @Step("Enter Employee Id")
    public AddEmployeePage enterEmployeeId(String id) {
        driver.elementActions()
                .sendKeys(employeeIDField, id);
        return this;
    }

    //Validations

    @Step("Save new employee")
    public EmployeePersonalDetailsPage saveEmployee() {
        driver.elementActions().clickOnElement(saveButton);
        return new EmployeePersonalDetailsPage(driver);
    }

    @Step("Verify Add Employee page URL")
    public AddEmployeePage validateUrl() {
        Assert
                .assertTrue(
                        driver.browserActions().waitForUrlContains(END_POINT)
                );
        return this;
    }

    @Step("Verify First Name field is displayed")
    public AddEmployeePage verifyFirstNameFieldDisplayed() {

        Assert.assertTrue(
                driver.elementActions()
                        .findWebElement(firstNameField)
                        .isDisplayed(),
                "First Name field is not displayed"
        );
        return this;
    }

    @Step("Verify Last Name field is displayed")
    public AddEmployeePage verifyLastNameFieldDisplayed() {

        Assert.assertTrue(
                driver.elementActions()
                        .findWebElement(lastNameField)
                        .isDisplayed(),
                "Last Name field is not displayed"
        );
        return this;
    }

    @Step("Verify Add Employee page is displayed with First Name and Last Name fields")
    public AddEmployeePage verifyAddEmployeePageDisplayed() {

        Assert.assertTrue(
                driver.browserActions()
                        .waitForUrlContains(END_POINT),
                "Incorrect page URL"
        );

        Assert.assertTrue(
                driver.elementActions().findWebElement(firstNameField).isDisplayed(),
                "First Name field is not displayed"
        );

        Assert.assertTrue(
                driver.elementActions().findWebElement(lastNameField).isDisplayed(),
                "Last Name field is not displayed"
        );

        return this;
    }

    @Step("Verify Required error is displayed under First Name Field")
    public AddEmployeePage verifyFirstNameRequiredErrorDisplayed() {

        Assert.assertTrue(
                driver.elementActions()
                        .findWebElement(requiredError(1))
                        .isDisplayed(),
                "Required error is not displayed under First Name"
        );

        return this;
    }

    @Step("Verify Required error is displayed under Last Name Field")
    public AddEmployeePage verifyLastNameRequiredErrorDisplayed() {

        Assert.assertTrue(
                driver.elementActions()
                        .findWebElement(requiredError(2))
                        .isDisplayed(),
                "Required error is not displayed under First Name"
        );

        return this;
    }
}
