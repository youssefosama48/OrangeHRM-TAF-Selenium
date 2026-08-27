package com.hrmorange.pages.components;

import com.hrmorange.drivers.GUIDriver;
import com.hrmorange.utils.dataReader.JsonReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Footer {
    private final GUIDriver driver;
    private final String ORIGINAL_WEBSITE =
            new JsonReader("testData").getJsonData("original_website");
    //Locators
    private final By footerText =
            By.xpath("//div[contains(@class,'orangehrm-copyright')]");
    private final By orangeHRMLink =
            By.partialLinkText("OrangeHRM, Inc");

    public Footer(GUIDriver driver) {
        this.driver = driver;
    }

    //Actions
    @Step("Click OrangeHRM, Inc link")
    public Footer clickOrangeHRMLink() {
        driver.elementActions()
                .clickOnElement(orangeHRMLink);
        return this;
    }

    //Validations
    @Step("Verify OrangeHRM website is opened")
    public Footer verifyOrangeHRMWebsiteOpened() {
        clickOrangeHRMLink();
        driver.browserActions()
                .switchToNewTab();
        Assert.assertTrue(
                driver.browserActions()
                        .waitForUrlContains(ORIGINAL_WEBSITE),
                "OrangeHRM website was not opened");

        return this;
    }
}
