Feature: User registration on Facebook

  Scenario Outline: User fills the registration form on Facebook
    Given User is on Facebook registration page
    When User enters registration details "<First Name>", "<Last Name>", "<Email>", "<Password>", "<Day of Birth>", "<Month of Birth>", "<Year of Birth>", "<Gender>"
    And User clicks the submit button
    Then User should be registered successfully
    Examples:
      | First Name | Last Name | Email              | Password    | Day of Birth | Month of Birth | Year of Birth | Gender |
      | John       | Doe       | john.doe@gmail.com | password123 | 15           | jan            | 1990          | Male   |
