Feature: Web auto testing

  @AC7.5
  Scenario: scroll down to the bottom on Cryptocurrencies section get currency list
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Accept Cookies & Continue on Coinmarketcap screen if exists
    Then the user swipe to down get currency list size is 100 on Coinmarketcap screen
#    When the user quit app

  @AC7.6
  Scenario: select LOOM currency and direct currency details screen
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Accept Cookies & Continue on Coinmarketcap screen if exists
    And the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen
#    When the user quit app

  @AC7.6
  @AC7.7
  Scenario: check Binance Exchange Proportion
    Given the user able to see Coinmarketcap currency details screen
    When the user click Markets button on Coinmarketcap currency details screen top banner
#    And the user select "100" rows on Coinmarketcap currency details screen rows dropDown
#    Then the user able to see "Binance" volume percentage is correct on Coinmarketcap currency details screen

  @AC7.8 @AC7.9 @AC7.10
  Scenario: select MetaMask on Supported wallets
    Given the user able to see Coinmarketcap currency details screen
    When the user select Metamask icon on Coinmarketcap currency details screen support wallets view
    And the user switch to last window
    Then the Browser is opening "https://metamask.io/download/" url on Google Chrome
    When the user switch to first window
    Then the user able to see Coinmarketcap currency details screen
    And the Browser is opening "https://coinmarketcap.com/currencies/loom-network/#Markets" url on Google Chrome
#    When the user quit app

  @AC7.11
  Scenario: Verify Loom Network 1D icon appears the same as the response
    Given the user able to see Coinmarketcap currency details screen
    When the user click Chart button on Coinmarketcap currency details screen top banner
#TODO

    Then the user able to see Coinmarketcap screen
    When the user click Fear and Greed Index chat on Coinmarketcap screen
    Then the user able to see Global Live Cryptocurrency Charts screen
    When the user click Market cap 1d button on Global Live Cryptocurrency Charts screen
    Then the user verify Market cap the 1D icon appears the same as the response
#    When the user quit app

  @AC7.12
  Scenario: Check About LOOM NetWork copy
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen
    And the user able to see About LOOM NetWork copy on Coinmarketcap currency details screen
#    When the user quit app

  @AC7.13
  Scenario: Check watchlist functionality
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen
    When the user click Follow button on Coinmarketcap currency details screen
    And the user click Watchlist button on Coinmarketcap currency details screen
    Then the user able to see Coinmarketcap watchlist screen
    And the user able to see "LOOM" currency in watchlist on Coinmarketcap watchlist screen
    When the user quit app