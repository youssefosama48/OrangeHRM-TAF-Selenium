package com.hrmorange.pages.components;

import com.hrmorange.drivers.GUIDriver;
import com.hrmorange.pages.UserManagementPage;
import com.hrmorange.pages.pim.EmployeeListPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SideMenu {
    private final GUIDriver driver;
    private final List<String> expectedModules = List.of(
            "Admin",
            "PIM",
            "Leave",
            "Time",
            "Recruitment",
            "My Info",
            "Performance",
            "Dashboard",
            "Directory"
    );
    //Locators
    private final By pimModule =
            By.xpath("//*[@class='oxd-main-menu']//span[contains(.,'PIM')]");

    private final By adminModule =
            By.xpath("//*[@class='oxd-main-menu-item-wrapper']//span[contains(.,'Admin')]");

    private final By menuItems =
            By.cssSelector(".oxd-main-menu-item--name");

    public SideMenu(GUIDriver driver) {
        this.driver = driver;
    }

    //Navigations
    @Step("Open PIM module")
    public EmployeeListPage clickPIM() {
        driver.elementActions().clickOnElement(pimModule);
        return new EmployeeListPage(driver);
    }

    @Step("Open Admin module")
    public UserManagementPage clickAdmin() {
        driver.
                elementActions().clickOnElement(adminModule);
        return new UserManagementPage(driver);
    }

    //Validations
    @Step("Verify all Side Menu modules are displayed")
    public SideMenu verifyAllModulesDisplayed() {

        List<WebElement> actualModules =
                driver.elementActions().findWebElements(menuItems);

        List<String> actualModuleNames = actualModules.stream()
                .map(WebElement::getText)
                .toList();

        Assert.assertTrue(
                actualModuleNames.containsAll(expectedModules),
                "Some Side Menu modules are missing"
        );

        return this;
    }
}
