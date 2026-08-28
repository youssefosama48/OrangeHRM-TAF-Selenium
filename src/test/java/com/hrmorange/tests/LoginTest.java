package com.hrmorange.tests;

import com.hrmorange.dataprovider.LoginDataProvider;
import com.hrmorange.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login")
@Owner("Youssef Osama")
public class LoginTest extends BaseTest {

    @Description("Verify that a user with valid credentials is redirected to the Dashboard page.")
    @Story("Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void validLoginShouldRedirectUserToDashboard() {
        login()
                .verifyUserNavigatedToDashboardPage()
                .verifyDashboardPageTitle();
    }

    @Description("Verify that users cannot log in with invalid credentials and an error message is displayed")
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "invalidLoginData",
            dataProviderClass = LoginDataProvider.class)
    public void invalidCredentialsShouldDisplayLoginError(String username, String password,
                                                          String errorType, String expectedMessage) {
        new LoginPage(driver)
                .loginWithInvalidCredentials(username, password)
                .verifyErrorMessageDisplayed(errorType, expectedMessage);
    }

    @Story("Empty Credentials")
    @Description("Verify that Required validation messages are displayed for both username and password fields when they are left empty.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void emptyCredentialsShouldDisplayRequiredMessages() {
        new LoginPage(driver)
                .clickLoginButton()
                .verifyRequiredMsgDisplayedOnBoth();
    }
}
