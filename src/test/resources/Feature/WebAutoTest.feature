Feature: Assessment for Senior QA Office

  @AC7.5
  Scenario: scroll down to the bottom on Cryptocurrencies section, test whether the of currencies per page is met the requirement 100
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    And the user swipe to down get currency list size is 100 on Coinmarketcap screen

