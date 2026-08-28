package com.hrmorange.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstractDriver {

    private EdgeOptions getOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        return options;
    }

    @Override
    public WebDriver createDriver() {
        return new EdgeDriver();
    }
}
