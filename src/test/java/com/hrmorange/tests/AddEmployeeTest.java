package com.hrmorange.tests;

import com.hrmorange.pages.components.SideMenu;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("PIM")
@Feature("Add Employee")
public class AddEmployeeTest extends BaseTest {

    @Story("Add Employee Page")
    @Description("Verify that the Add Employee page is displayed with the First Name and Last Name fields.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void addEmployeePageShouldBeDisplayedWithRequiredFields() {
        login();
        new SideMenu(driver)
                .clickPIM()
                .navigateToAddEmployee()
                .validateUrl()
                .verifyAddEmployeePageDisplayed();
    }

    @Story("Add Employee")
    @Description("Verify that the Required validation message is displayed under First Name when it is left empty.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void addEmployeeWithEmptyFirstNameShouldDisplayRequiredError() {
        login();
        new SideMenu(driver)
                .clickPIM()
                .navigateToAddEmployee()
                .enterLastName(testData
                        .getJsonData("addEmployee.validEmployees[0].lastName"))
                .clickSave()
                .verifyFirstNameRequiredErrorDisplayed();
    }
}
