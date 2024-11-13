# Using Appium  for Mobile Automation Testing of General Store App
This repository contains resources for mobile automation testing of the (` General-Store.apk `) . The automation framework included here is designed to test the app's functionality, stability, and performance on Android devices.

## Table of Contents

* About the App
* Technologies Used
* Installation
* Running Tests
* Test Structure
* Reporting Bugs

### About the App

The goal of this project is to provide an automated testing suite for the General Store app, ensuring a smooth user experience by validating core functionality and performance. The tests target Android devices and simulate user interactions, covering various scenarios such as login, product browsing, cart management, and checkout.

### Technology Used

This project uses the following technologies and tools for mobile automation testing:

  * **Appium**: For mobile automation on Android devices
  * **Java**: Programming language for writing test scripts
  * **TestNG** (if using Java): For test execution and reporting
  * **Maven** (Java projects): For dependency management
  * **Android Studio**: For emulating Android devices and debugging
    
     

### Installation

### Prerequisites

* Java (for Java-based tests) should be installed on your machine.
* Appium Server should be installed and running. You can install it via Node.js:

  ```
  npm install -g appium
  ```

* **Android SDK**: Install this for Android emulation and debugging.
* **Device**: Either use an Android emulator or connect an Android device.


## Steps

1. Clone the repository.

   ```
   git clone https://github.com/itsnipa/mobile_automation_test.git
   cd MobileAutomation
   ```
2. Install depedencies for Java Proejects:

   ```
   mvn install
   ```

3. Start the Appium server before running tests:

   ```
   appium
   ```

## Running Test

### Using TestNG (for Java)

1. Navigate to the test suite directory.
2. Execute the tests using Maven:
   ```
   mvn test
   ```
### Running Specific Tests

You can specify certain test cases or suites to run by tagging them in the test configuration or using filters.

### Test Structure

The project follows a typical structure for mobile automation testing:
* **/src/test/java or /tests**: Directory containing test cases and scenarios.
* **/src/main/java or /pages**: Page Object Model (POM) structure, representing different screens of the app.
*  **/resources**: Contains configuration files (e.g., capabilities, device settings).
*  **/report**: Generated reports for test runs, including logs and screenshots of failed tests.

### Reporting Bugs

If you encounter bugs while running the tests, please open an issue on this GitHub repository with the following details:

* Description of the bug
* Steps to reproduce
* Expected behavior
* Actual behavior
* Attach screenshots/logs if applicable
