Feature: Check login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters valid <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username | password |
      | Ashutosh |    12345 |
      | Nilesh   |    12345 |
      