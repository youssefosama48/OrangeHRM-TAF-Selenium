package com.hrmorange.tests;

import com.hrmorange.pages.components.Footer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {
    @Story("Footer")
    @Description("Verify that clicking the OrangeHRM, Inc footer link opens the official OrangeHRM website.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void orangeHRMFooterLinkShouldOpenOfficialWebsite() {
        new Footer(driver)
                .verifyOrangeHRMWebsiteOpened();
    }
}
