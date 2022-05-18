Feature: Printing name and age

  Scenario Outline: Printing name of class A
    Given when user open notepad
    And print class A <name> and <age>

    Examples: 
      | name     | age |
      | Ashutosh |  22 |

  Scenario Outline: Printing name of class B
    Given when user opened notepad
    And class B <name> and <age>

    Examples: 
      | name  | age |
      | Nisha |  22 |
