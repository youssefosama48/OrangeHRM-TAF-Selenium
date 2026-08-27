package com.hrmorange.tests;

import com.hrmorange.pages.components.SideMenu;
import com.hrmorange.utils.retry.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class UserManagementTest extends BaseTest {
    @Story("Admin - Add User")
    @Description("Verify that the Add User form contains User Role, Employee Name, Username, and Password fields.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addUserPageShouldContainRequiredFields() {
        login();
        new SideMenu(driver)
                .clickAdmin()
                .clickAddButton()
                .verifyAddUserFormDisplayed();
    }
}
