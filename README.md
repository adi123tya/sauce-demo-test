# Sauce Labs Demo Test Suite

## Setup

1. Clone the repository
   ```bash
   git clone <repository_link>
   cd sauce-demo-test



# Automated Test Suite for Sauce Labs Demo Website

## Overview
This project is an automated test suite for the Sauce Labs demo website. The test suite covers the customer flow of selecting three random items and completing the checkout process. It uses Selenium WebDriver for browser automation, TestNG for the testing framework, and Maven for dependency management and build automation.

## Project Structure
- src/test/java/com/example/SauceDemoTest.java: Contains the test class for the checkout flow.
- pom.xml: Maven configuration file that specifies project dependencies and build plugins.
- testng.xml: TestNG configuration file that defines the test suite and test classes.
- README.md: Documentation file explaining the setup and execution process.

## Setup

### Prerequisites
- **Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed on your system.
- **Maven**: Install Maven for project build and dependency management.
- **ChromeDriver**: Make sure ChromeDriver is installed and its path is added to the system's PATH environment variable.

## Code Explanation

### SauceDemoTest.java

#### Explanation
- **Setup Method (setup)**: This method is annotated with @BeforeClass and is executed before any test method. It initializes the WebDriver for Chrome using WebDriverManager, maximizes the browser window, and sets an implicit wait.
- **Test Method (testCheckoutFlow)**: This method is annotated with @Test and contains the test steps:
  - Opens the Sauce Labs demo website.
  - Logs in using predefined credentials.
  - Selects three random items from the inventory.
  - Proceeds to the cart and initiates the checkout process.
  - Fills in the checkout information and completes the order.
  - Asserts that the checkout was successful by checking the confirmation message.
- **Teardown Method (teardown)**: This method is annotated with @AfterClass and is executed after all test methods. It closes the browser and quits the WebDriver instance.

### testng.xml
This file defines the TestNG test suite configuration. It specifies the test suite name and includes the SauceDemoTest class.

## Test Execution

### Running the Tests
To execute the tests and generate an HTML report, run the following command: mvn test


