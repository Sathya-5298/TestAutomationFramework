# Java Test Automation Framework

This Java-based Test Automation Framework is designed for efficient test execution.

It supports data-driven testing, cloud-based test execution like Lambda test, headless mode for faster execution, and integrates with CI/CD pipelines using Jenkins and GitHub Actions.


## 🚀 About Me
Hello, I am SathyaMurth D and a Test Automation Engineer with over 4 years of experience with end-to-end testing projects across multiple domains such as retail, luxury fashion, gaming. Expertise in Automation Testing using Selenium WebDriver with Java, Cucumber BDD, TestNG, API testing with Postman and REST Assured, database testing. Embracing a mindset of continuous learning and seeking new opportunities to develop and grow in my role



## Authors
- [SathyaMurthy D](https://github.com/Sathya-5298)
- EmailAddress: smurthy1298@gmail.com


## Tech Stack

**Programming Langauge:** Java 11


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Sathya-5298)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sathyamurthyd/)


## Prerequisites

Before running this framework, ensure the following softwares are installed on system:
- **Java 11** installed and configured
- **Maven** installed (mvn --version to verify)
- **TestNG** installed (mvn test should execute test cases)
- **LambdaTest** account (if running on the cloud)

## Features

- **Test Execution:** Utilizes TestNG for structured test execution.

- **Data-Driven Testing:** Supports CSV, JSON, and Excel data sources using OpenCSV, Gson, and Apache POI.

- **Cloud Testing:** Runs tests on LambdaTest.

- **Cross Browser Testing:** Runs tests on different browsers.

- **Headless Mode:** Enables fast execution without GUI rendering.

- **Logging & Reporting:** Uses Log4j for logging and Extent Reports for HTML-based test reports.

- **CI/CD Integration:** Integrated with Jenkins (AWS EC2) and GitHub Actions.


## Technologies Used

- Java 11
- TestNG
- OpenCSV, Gson, and Apache POI
- Fake Data Generation
- LambdaTest
- Maven Surefire Plugin with custom parameters
- Extent Reports
- Log4j
- CI/CD Jenkins and GitHub Actions
## Installation

**Clone the repository:**

```bash
    git clone https://github.com/Sathya-5298/TestAutomationFramework.git

  cd TestAutomationFramework
```

**Parameters**

**browser:** Browser type (e.g., chrome, firefox, edge...)

**isLambdaTest:** Boolean to enable or disable LambdaTest execution

**isHeadless:** Boolean to enable or disable headless mode

**Running Tests on Local in Headless mode with chrome browser:**

```bash
    mvn test -X -Dbrowser=chrome -Dislambdatest=false -Disheadless=true
```

**Running Tests on Lambda Test(Cloud) with chrome browser:**

```bash
    mvn test -X -Dbrowser=chrome -Dislambdatest=true -Disheadless=false
```

## Generating Reports
After test execution, reports will be generated in the report.html file located in the ./reports.html.

## Logging
Logs will be stored in the logs directory as specified in the ./logs/automation.log

## Integrated project with Github Actions
This TestAutomationFramework is integrated with github actions and tests will be executed at 11:30pm IST every single day.
