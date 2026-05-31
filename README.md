\# Selenium Automation Framework



A professional test automation framework built with Java, Selenium WebDriver, TestNG, and Cucumber BDD.



\## Tech Stack

\- Java 17

\- Selenium WebDriver 4.21.0

\- TestNG 7.9.0

\- Cucumber 7.18.0 (BDD)

\- ExtentReports 5.1.1

\- Maven



\## Framework Architecture

\- \*\*BasePage\*\* — shared driver, wait, and helper methods

\- \*\*Page Objects\*\* — locators and page-specific actions  

\- \*\*BaseTest\*\* — driver lifecycle and ExtentReports integration

\- \*\*Test Classes\*\* — test scenarios and assertions

\- \*\*ConfigReader\*\* — external configuration management

\- \*\*Step Definitions\*\* — BDD step implementations



\## Test Coverage

\- Login — valid/invalid credentials with DataProvider (3 scenarios)

\- Fund Transfer — multi-account transfer with confirmation

\- Dynamic Controls — checkbox and input enable/disable

\- BDD Scenarios — Cucumber feature files for business-readable tests



\## How to Run

1\. Clone the repository

2\. Open in IntelliJ IDEA

3\. Run `mvn test` or right-click test class → Run



\## Reports

Test reports generated in `reports/TestReport.html` after each run.

Screenshots captured automatically on test failure.

