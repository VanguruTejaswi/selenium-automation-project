E-Commerce Test Automation Framework

## Overview

This project is a **UI Test Automation Framework** built using **Java, Selenium WebDriver, TestNG, and Maven**.
The framework follows the **Page Object Model (POM)** design pattern to ensure clean architecture, maintainability, and scalability.

The goal of this project is to demonstrate **industry-level automation framework structure** used for testing web applications, particularly in the **e-commerce domain**.

The framework currently automates key workflows such as:

* User Login
* Product Navigation
* Adding Products to Cart
* Checkout Flow

---

# Technology Stack

| Technology         | Purpose                             |
| ------------------ | ----------------------------------- |
| Java               | Programming language                |
| Selenium WebDriver | Web UI automation                   |
| TestNG             | Test execution and assertions       |
| Maven              | Build and dependency management     |
| WebDriverManager   | Automatic browser driver management |

---

# Framework Design

The framework follows the **Page Object Model (POM)** design pattern.

In this approach:

* Each web page is represented by a **Page Class**
* Page classes contain **locators and reusable methods**
* Test classes focus only on **test scenarios**

### Benefits

* Better maintainability
* Improved code readability
* Reusable page methods
* Easier test scalability

---

# Current Project Structure

```
ecommerce-automation
│
├── src
│
│   ├── main/java/com/automation
│   │
│   │   ├── pages
│   │   │   ├── LoginPage.java
│   │   │   ├── HomePage.java
│   │   │   ├── BooksPage.java
│   │   │   ├── ProductDetailsPage.java
│   │   │   ├── CartPage.java
│   │   │   └── CheckOutPage.java
│   │   │
│   │   └── utilities
│   │       ├── DriverFactory.java
│   │       └── WaitUtil.java
│   │
│   └── test/java/com/automation
│
│       ├── base
│       │   └── BaseTest.java
│       │
│       └── tests
│           ├── LoginTest.java
│           ├── AddToCartTest.java
│           └── CheckOutTest.java
│
└── pom.xml


---
Key Framework Components

## DriverFactory

Responsible for **WebDriver initialization and management**.

Features:

* Uses **WebDriverManager** to automatically manage browser drivers
* Implements a **centralized driver creation mechanism**
* Handles browser lifecycle management

---

## BaseTest

Provides common test setup and teardown logic.

Responsibilities:

* Initialize WebDriver before test execution
* Launch the application URL
* Close the browser after test completion

---

## Page Classes

Each page of the application is implemented as a **Page Object Class**.

Examples:

* `LoginPage`
* `HomePage`
* `ProductPage`
* `CartPage`
* `CheckoutPage`

Responsibilities:

* Store element locators
* Provide reusable actions for the page
* Abstract UI interactions from test logic

---

## Test Classes

Test classes contain **automation scenarios** that validate application functionality.

Examples:

* `LoginTest`
* `AddToCartTest`
* `CheckoutTest`

Responsibilities:

* Execute test workflows
* Validate expected outcomes using assertions

---

# Example Automated Workflow

Example test scenario implemented in this framework:

1. Launch browser
2. Navigate to application
3. Enter login credentials
4. Login successfully
5. Browse products
6. Add product to cart
7. Proceed to checkout
8. Validate expected behavior

---

# Test Execution

Tests can be executed using **Maven** or **TestNG**.

### Run tests using Maven

```
mvn clean test


# Planned Framework Enhancements

The framework is designed to be extended with additional utilities and configurations to support **data-driven testing and enhanced debugging capabilities**.

### Additional Utilities

* **ExcelReader** – Support for data-driven testing
* **ScreenshotUtil** – Capture screenshots during test failures
* **ConfigReader** – Centralized configuration management
* **Reusable logging utilities**

### Configuration Support

Future configuration files may include:

```
src/test/resources
├── config.properties
├── testdata.xlsx
```

These enhancements will enable:

* Data-driven test execution
* Centralized environment configuration
* Better debugging support

---

# Author

**Tejaswi Vanguru**

Quality Engineer with experience in:

* Selenium Automation
* Java
* TestNG
* API Testing
* Test Automation Framework Design
