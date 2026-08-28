# OrangeHRM Selenium Test Automation Framework

A UI Test Automation Framework built for **OrangeHRM** using Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM).

The framework focuses on clean separation of test logic, page interactions, browser actions, test data, configuration, reporting, and reusable utilities.

## 🛠️ Tech Stack

- **Java 25** — Programming language
- **Selenium WebDriver 4.39.0** — UI automation
- **TestNG 7.10.2** — Test execution, assertions, DataProviders, and listeners
- **Maven** — Build and dependency management
- **Maven Surefire** — Test execution and parallel execution
- **Allure 2.35.4** — Test reporting
- **AspectJ Weaver** — Allure integration
- **JsonPath / JSON.simple** — JSON test-data handling
- **Log4j 2** — Logging
- **Git / GitHub** — Version control

## 🏗️ Framework Structure

```text
src
├── main
│   ├── java/com/hrmorange
│   │   ├── drivers
│   │   │   ├── AbstractDriver
│   │   │   ├── Browser
│   │   │   ├── ChromeFactory
│   │   │   ├── EdgeFactory
│   │   │   ├── GUIDriver
│   │   │   └── WebDriverProvider
│   │   │
│   │   ├── pages
│   │   │   ├── LoginPage
│   │   │   ├── DashboardPage
│   │   │   ├── UserManagementPage
│   │   │   ├── EmployeePersonalDetailsPage
│   │   │   ├── components
│   │   │   │   ├── SideMenu
│   │   │   │   └── Footer
│   │   │   └── pim
│   │   │       ├── AddEmployeePage
│   │   │       └── EmployeeListPage
│   │   │
│   │   └── utils
│   │       ├── actions
│   │       │   ├── ElementActions
│   │       │   └── BrowserActions
│   │       ├── dataReader
│   │       │   ├── JsonReader
│   │       │   └── PropertyReader
│   │       ├── logs
│   │       │   └── LogsManager
│   │       ├── retry
│   │       │   ├── RetryAnalyzer
│   │       │   └── RetryListener
│   │       └── WaitManager
│   │
│   └── resources
│       ├── driver.properties
│       ├── environment.properties
│       ├── waits.properties
│       └── log4j2.properties
│
└── test
    ├── java/com/hrmorange
    │   ├── dataprovider
    │   │   ├── LoginDataProvider
    │   │   └── EmployeeDataProvider
    │   └── tests
    │       ├── BaseTest
    │       ├── LoginTest
    │       ├── AddEmployeeTest
    │       ├── EmployeeListTest
    │       ├── E2ETest
    │       ├── UserManagementTest
    │       ├── SideMenuTest
    │       └── FooterTest
    │
    └── resources
        └── test-data
            └── testData.json
```

## 🔑 Main Framework Features

### Page Object Model
Each application page has its own Page Object containing its locators, actions, and validations. Reusable UI sections such as the **Side Menu** and **Footer** are implemented as components.

### Reusable Actions
`ElementActions` handles common element operations, while `BrowserActions` handles browser-level operations such as URL validation and tab switching.

### Data-Driven Testing
Test data is maintained in `testData.json` and consumed through reusable `JsonReader` and TestNG `DataProvider` classes.

### Explicit Waits
`WaitManager` provides centralized explicit-wait handling to improve test stability and avoid unnecessary hard-coded delays.

### Retry Mechanism
TestNG's `IRetryAnalyzer` is implemented through `RetryAnalyzer` and `RetryListener` to retry failed tests up to **2 times**.

### Parallel Execution
Maven Surefire is configured to execute TestNG methods in parallel using **2 threads**.

### Allure Reporting
Allure annotations such as `@Step`, `@Description`, `@Story`, and `@Severity` are used to provide detailed and readable test execution reports.

### Logging
Log4j 2 is used through `LogsManager` for framework and test execution logging.

## 🧪 Automated Test Areas

The current suite covers:

- Login with valid credentials
- Login with invalid credentials
- Login validation for empty required fields
- Existing employee search
- Non-existing employee search
- Add Employee required-field validation
- Successful employee creation E2E flow
- Admin → User Management validation
- Side Menu module validation
- OrangeHRM footer/branding link validation

## ▶️ Run Tests

Run the complete test suite with Maven:

```bash
mvn clean test
```

## 📊 Allure Report

After execution, Allure results are generated in:

```text
target/allure-results
```

Generate the report:

```bash
allure generate target/allure-results --clean -o target/allure-report
```

Open it with:

```bash
allure open target/allure-report
```

## 📌 Framework Goals

The framework is designed to be:

- **Maintainable** — Page Objects and reusable utilities isolate implementation details.
- **Reusable** — Common browser and element operations are centralized.
- **Readable** — Tests describe business scenarios using fluent page methods.
- **Scalable** — DataProviders, components, retry handling, and parallel execution support future expansion.
- **Stable** — Explicit waits and controlled WebDriver management reduce flaky execution.
