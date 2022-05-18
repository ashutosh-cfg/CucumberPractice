Feature: Test login functionality

  Scenario Outline: Check login is successfull with valid credentials
    Given Browser is open
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login button
    Then user navigated to the home page

    Examples: 
      | username | password |
      | Ashutosh |    12345 |
      | Nilesh   |    12345 |
      | Vikash   |    12345 |
