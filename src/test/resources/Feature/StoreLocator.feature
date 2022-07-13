Feature: Find Store Locator

  @FindNonExistStore
  Scenario: Find not exist store
    Given the user on the Login screen
    When the user input logon information on the Logon screen
      | username | 63248160 |
      | password | Aa123456 |
    And  the user click the Confirm button on the Logon screen
    And the user click Store locator button on the Home screen
    Then the user swipe up find "GuangZhou" store on the Store locator screen
    And the user return to Home screen
    Then the user able to direct the Home screen