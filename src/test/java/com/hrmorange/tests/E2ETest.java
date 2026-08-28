package com.hrmorange.tests;


import com.hrmorange.dataprovider.EmployeeDataProvider;
import com.hrmorange.pages.components.SideMenu;
import com.hrmorange.utils.retry.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class E2ETest extends BaseTest {

    @Story("Add Employee")
    @Description("Verify that a new employee can be added successfully and appears in the Employee List.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "newEmployeeData"
            , dataProviderClass = EmployeeDataProvider.class
            , retryAnalyzer = RetryAnalyzer.class)
    public void newEmployeeShouldBeAddedSuccessfully(String firstName, String lastName,
                                                     String employeeId, String employeeName) {
        login();
        new SideMenu(driver)
                .clickPIM()
                .navigateToAddEmployee()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .clearEmployeeId()
                .enterEmployeeId(employeeId)
                .saveEmployee()
                .verifyPersonalDetailsPageDisplayed();

        new SideMenu(driver)
                .clickPIM()
                .enterEmployeeName(employeeName)
                .clickSearch()
                .verifyEmployeeDisplayedInTable(employeeName);
    }
}
