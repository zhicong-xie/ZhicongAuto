Feature: Pizza  Log in function


  @Pizza
  Scenario: the user able to log in when the login entered the email and password were right
    Given the user on the login screen
    When the user input logon information on the logon screen
      | username | 63248160|
      | password |  Aa123456 |
    And  the user click the Confirm button on the login screen
    Then the user able to direct the Home screen