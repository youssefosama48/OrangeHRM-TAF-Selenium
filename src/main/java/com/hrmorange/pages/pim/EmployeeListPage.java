package com.hrmorange.pages.pim;

import com.hrmorange.drivers.GUIDriver;
import com.hrmorange.utils.dataReader.JsonReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class EmployeeListPage {
    private final GUIDriver driver;
    private final String END_POINT =
            new JsonReader("testData").getJsonData("endpoints.employeeList");
    //Locators
    private final By employeeNameField =
            By.xpath("(//*[@class='oxd-autocomplete-wrapper'])[1]//input");
    private final By searchButton =
            By.xpath("//button[@type='submit']");
    private final By noResultFoundMessage =
            By.xpath("//*[@class='orangehrm-paper-container']//span[contains(.,'No Records Found')]");
    private final By addEmployeeTab =
            By.xpath("//a[contains(.,'Add Employee')]");

    public EmployeeListPage(GUIDriver driver) {
        this.driver = driver;
    }

    //Dynamic Locators
    private By employeeResult(String employeeName) {
        return By.xpath(
                "//div[@class='oxd-table-card']/div[contains(.,'"
                        + employeeName + "')]"
        );
    }


    //Navigations
    @Step("Navigate to (Add Employee) page")
    public AddEmployeePage navigateToAddEmployee() {
        driver
                .elementActions().clickOnElement(addEmployeeTab);
        return new AddEmployeePage(driver);
    }

    //Actions
    @Step("Enter employee name: {employeeName}")
    public EmployeeListPage enterEmployeeName(String employeeName) {
        driver.elementActions().sendKeys(employeeNameField, employeeName);
        return this;
    }

    @Step("Click Search button")
    public EmployeeListPage clickSearch() {
        driver.elementActions().clickOnElement(searchButton);
        return this;
    }

    //Validations
    @Step("Verify employee '{employeeName}' is displayed")
    public EmployeeListPage verifyEmployeeDisplayedInTable(String employeeName) {

        Assert.assertTrue(
                driver.elementActions()
                        .findWebElement(employeeResult(employeeName))
                        .isDisplayed(),
                "Employee " + employeeName + " is not displayed"
        );
        return this;
    }

    @Step("Verify that no results are found")
    public EmployeeListPage verifyNoResultsFound() {
        Assert
                .assertTrue(
                        driver.elementActions()
                                .findWebElement(noResultFoundMessage).isDisplayed()
                );
        return this;
    }
}
