package com.hrmorange.dataprovider;

import com.hrmorange.utils.dataReader.JsonReader;
import org.testng.annotations.DataProvider;


public class LoginDataProvider {
    private JsonReader testData = new JsonReader("testData");

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][]{
                {
                        testData.getJsonData("login.invalidLogin[0].username"),
                        testData.getJsonData("login.invalidLogin[0].password"),
                        testData.getJsonData("login.invalidLogin[0].errorType"),
                        testData.getJsonData("login.invalidLogin[0].expectedMessage")
                },
                {
                        testData.getJsonData("login.invalidLogin[1].username"),
                        testData.getJsonData("login.invalidLogin[1].password"),
                        testData.getJsonData("login.invalidLogin[1].errorType"),
                        testData.getJsonData("login.invalidLogin[1].expectedMessage")
                }
        };
    }

}