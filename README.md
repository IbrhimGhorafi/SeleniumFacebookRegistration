## Selenium Facebook Registration

This project demonstrates automated testing of the Facebook registration form using Selenium WebDriver and Cucumber. The tests are designed to verify that users can successfully register on Facebook by filling out the registration form.

### Features:

- **Automated Testing:** Utilizes Selenium WebDriver to automate the testing of the Facebook registration form.
- **Data-Driven Testing:** Uses Cucumber Scenario Outline to parameterize test data.
- **Page Object Model (POM):** Implements the POM design pattern for better code organization and maintenance.
- **Custom Listener:** Implements a custom listener to handle WebDriver events.
- **TestNG:** Utilizes TestNG for test execution and reporting.

### Project Structure:

- **PagesTest Package:** Contains test classes for testing Facebook registration.
- **Page Package:** Contains page object classes for interacting with web elements on the Facebook registration page.
- **Utils Package:** Contains utility classes, such as Locators and WebDriverListener.
- **StepDefs Package:** Contains step definition classes for Cucumber scenarios.

### Test Scenario:

- **Scenario Outline:** User fills the registration form on Facebook.
  - **Given:** User is on Facebook registration page.
  - **When:** User enters registration details: First Name, Last Name, Email, Password, Day of Birth, Month of Birth, Year of Birth, Gender.
  - **And:** User clicks the submit button.
  - **Then:** User should be registered successfully.

### Usage:

1. Clone the repository.
2. Set up dependencies using Maven.
3. Configure the ChromeDriver path in the `TestBase` class.
4. Run the `TestRunner` class to execute the tests.

### Example Data:

| First Name | Last Name | Email                | Password    | Day of Birth | Month of Birth | Year of Birth | Gender |
|------------|-----------|----------------------|-------------|--------------|----------------|---------------|--------|
| John       | Doe       | john.doe@example.com | password123 | 15           | jan            | 1990          | Male   |

---

