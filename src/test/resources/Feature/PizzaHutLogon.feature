Feature: Pizza  Log in function


  @PizzaLogin
  Scenario: the user able to log in when the login entered the email and password were right
    Given the user on the Login screen
    When the user input logon information on the Logon screen
      | username | 63248160 |
      | password | Aa123456 |
    And  the user click the Confirm button on the Logon screen
    Then the user able to direct the Home screen