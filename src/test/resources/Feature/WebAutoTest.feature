Feature: Assessment for Senior QA Office

  @AC7.5
  Scenario: scroll down to the bottom on Cryptocurrencies section, test whether the of currencies per page is met the requirement 100
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    And the user swipe to down get currency list size is 100 on Coinmarketcap screen
    When the user quit app

  @AC7.6
  Scenario: select LOOM currency
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user Maximize window
#    When the user click Back to top button on Coinmarketcap screen
    And the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen
    When the user quit app
