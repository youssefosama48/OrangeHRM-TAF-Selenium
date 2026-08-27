package com.hrmorange.dataprovider;

import com.hrmorange.utils.dataReader.JsonReader;
import org.testng.annotations.DataProvider;

public class EmployeeDataProvider {
    private JsonReader testData = new JsonReader("testData");

    @DataProvider(name = "existingEmployeesData")
    public Object[][] existingEmployeesData() {

        return new Object[][]{
                {
                        testData.getJsonData("employeeList.existingEmployees[0].employeeName")

                },
                {
                        testData.getJsonData("employeeList.existingEmployees[1].employeeName")
                }
        };
    }

    @DataProvider(name = "nonExistingEmployeeData")
    public Object[][] nonExistingEmployeeData() {
        return new Object[][]{
                {
                        testData.getJsonData("employeeList.nonExistingEmployees[0].employeeName")

                },
                {
                        testData.getJsonData("employeeList.nonExistingEmployees[1].employeeName")
                }
        };
    }

    @DataProvider(name = "newEmployeeData")
    public Object[][] newEmployeeData() {
        return new Object[][]{
                {
                        testData.getJsonData("addEmployee.validEmployees[0].firstName"),
                        testData.getJsonData("addEmployee.validEmployees[0].lastName"),
                        testData.getJsonData("addEmployee.validEmployees[0].employeeId"),
                        testData.getJsonData("addEmployee.validEmployees[0].employee_name")
                },
                {
                        testData.getJsonData("addEmployee.validEmployees[1].firstName"),
                        testData.getJsonData("addEmployee.validEmployees[1].lastName"),
                        testData.getJsonData("addEmployee.validEmployees[1].employeeId"),
                        testData.getJsonData("addEmployee.validEmployees[1].employee_name")
                }
        };
    }
}
