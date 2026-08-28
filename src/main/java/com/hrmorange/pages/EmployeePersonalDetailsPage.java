package com.hrmorange.pages;

import com.hrmorange.drivers.GUIDriver;
import com.hrmorange.pages.components.SideMenu;
import com.hrmorange.pages.pim.EmployeeListPage;
import com.hrmorange.utils.dataReader.JsonReader;
import io.qameta.allure.Step;
import org.testng.Assert;

public class EmployeePersonalDetailsPage {
    private final GUIDriver driver;
    private final String END_POINT =
            new JsonReader("testData").getJsonData("endpoints.employeePersonalDetails");

    public EmployeePersonalDetailsPage(GUIDriver driver) {
        this.driver = driver;
    }

    //Locators

    //Actions

    //Navigations

    @Step("Navigate to Employee List")
    public EmployeeListPage navigateToEmployeeList() {
        new SideMenu(driver)
                .clickPIM();
        return new EmployeeListPage(driver);
    }
    //Validations

    @Step("Verify Personal Details page is displayed")
    public EmployeePersonalDetailsPage verifyPersonalDetailsPageDisplayed() {

        Assert.assertTrue(
                driver.browserActions()
                        .waitForUrlContains(END_POINT),
                "Personal Details page is not displayed"
        );

        return this;
    }
}
