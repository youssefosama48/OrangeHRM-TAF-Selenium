package com.hrmorange.dataprovider;

import com.hrmorange.utils.dataReader.JsonReader;
import org.testng.annotations.DataProvider;


public class LoginDataProvider {
    private JsonReader testData = new JsonReader("testData");

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][]{
                {
                        testData.getJsonData("invalidLoginScenarios[0].username"),
                        testData.getJsonData("invalidLoginScenarios[0].password"),
                        testData.getJsonData("invalidLoginScenarios[0].errorType"),
                        testData.getJsonData("invalidLoginScenarios[0].expectedMessage")
                },
                {
                        testData.getJsonData("invalidLoginScenarios[1].username"),
                        testData.getJsonData("invalidLoginScenarios[1].password"),
                        testData.getJsonData("invalidLoginScenarios[1].errorType"),
                        testData.getJsonData("invalidLoginScenarios[1].expectedMessage")
                }
        };
    }

}