package com.hrmorange.tests;

import com.hrmorange.dataprovider.EmployeeDataProvider;
import com.hrmorange.pages.components.SideMenu;
import com.hrmorange.pages.pim.EmployeeListPage;
import com.hrmorange.utils.retry.RetryAnalyzer;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("PIM")
@Feature("Employee List")
public class EmployeeListTest extends BaseTest {

    @Story("Search Employee")
    @Description("Verify that an existing employee is displayed in the employee table after searching by employee name.")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "existingEmployeesData",
            dataProviderClass = EmployeeDataProvider.class)
    public void employeeShouldBeDisplayedAfterSearch(String employeeName) {
        login();
        new SideMenu(driver)
                .clickPIM();

        new EmployeeListPage(driver)
                .enterEmployeeName(employeeName)
                .clickSearch()
                .verifyEmployeeDisplayedInTable(employeeName);
    }

    @Story("Search Employee")
    @Description("Verify that a non-existing employee is not displayed in the employee table after searching by employee name.")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "nonExistingEmployeeData",
            dataProviderClass = EmployeeDataProvider.class
            , retryAnalyzer = RetryAnalyzer.class)
    public void nonExistingEmployeeShouldNotBeDisplayedAfterSearch(String employeeName) {
        login();
        new SideMenu(driver)
                .clickPIM();

        new EmployeeListPage(driver)
                .enterEmployeeName(employeeName)
                .clickSearch()
                .verifyNoResultsFound();
    }
}
