package com.demoorangehrm.utils.actions;

import com.demoorangehrm.utils.WaitManager;
import org.openqa.selenium.WebDriver;

public class ElementActions {
    private final WebDriver driver;
    private WaitManager waitManager;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    //Clicking
    
}
