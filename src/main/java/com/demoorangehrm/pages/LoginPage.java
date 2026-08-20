package com.demoorangehrm.pages;

import com.demoorangehrm.drivers.GUIDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private final GUIDriver driver;
    //Locators
    private final By loginUsername = By.name("username");
    private final By loginPassword = By.cssSelector("[type='password']");
    private final By loginButton = By.cssSelector(".orangehrm-login-action > button");
    private final By loginErrorMsg = By.xpath("//div[@role='alert']//p");

    //Constructor
    public LoginPage(GUIDriver driver) {
        this.driver = driver;
    }


    //Page Actions


}
