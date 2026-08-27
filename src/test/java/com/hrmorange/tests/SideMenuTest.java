package com.hrmorange.tests;

import com.hrmorange.pages.components.SideMenu;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SideMenuTest extends BaseTest {
    @Story("Side Menu")
    @Description("Verify that the Side Menu contains all available modules.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void sideMenuShouldContainAllModules() {
        login();
        new SideMenu(driver)
                .verifyAllModulesDisplayed();
    }
}
