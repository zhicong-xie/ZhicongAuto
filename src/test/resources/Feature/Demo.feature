@testDemo
Feature: test demo

  Scenario: Just check the Cucumber functionality without actually doing anything by Scenario
    Given the user on Logon page
    When the user input login information on Logon page
    And  the user click Confirm button on the Login page
    Then the user able to see Home page


  Scenario Outline: Just check the Cucumber functionality without actually doing anything by Scenario Outline
    Given the user on Logon page
    When the user input <username> in username input box on Logon page
    And the user input <password> in password input box on Logon page
    And  the user click Confirm button on the Login page
    Then the user able to see Home page
    Examples:
    |username|password|
    | ABC    |  123   |
    | abc    |  234   |
    | XYZ    |  345   |
    | xyz    |  456   |


  Scenario: Just check the Cucumber functionality without actually doing anything by parameter
    Given the user on Logon page
    When the user input parameter in username input box on Logon page
    And the user input parameter in password input box on Logon page
    And  the user click Confirm button on the Login page
    Then the user able to see Home page