package com.hrmorange.pages;

import com.hrmorange.drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage {
    private final GUIDriver driver;
    private final String dashboardPageUrl = "/dashboard/index";

    //Locators
    By title = By.cssSelector(".oxd-topbar-header-breadcrumb > h6");

    public DashboardPage(GUIDriver driver) {
        this.driver = driver;
    }

    //Dashboard Page Actions
    @Step("Get the dashboard page title")
    public String getDashboardPageTitle() {
        return driver
                .elementActions().getText(title);
    }

    // Validations
    @Step("Check if user is in dashboard page")
    public DashboardPage verifyUserNavigatedToDashboardPage() {
        Assert.assertTrue(driver.browserActions().getCurrentUrl().contains(dashboardPageUrl));
        return this;
    }

    @Step("Check if dashboard page title is {Dashboard}")
    public DashboardPage verifyDashboardPageTitle() {
        Assert.assertEquals(getDashboardPageTitle(), "Dashboard", "Dashboard page title is incorrect");
        return this;
    }
}
