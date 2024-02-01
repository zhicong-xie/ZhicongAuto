Feature: Assessment for Senior QA Office

  @AC7.5
  Scenario: scroll down to the bottom on Cryptocurrencies section, test whether the of currencies per page is met the requirement 100
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    And the user swipe to down get currency list size is 100 on Coinmarketcap screen
    When the user quit app

  @AC7.6
  Scenario: select LOOM currency and direct currency details screen
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen
    When the user quit app

  @AC7.7
  Scenario: check Binance Exchange Proportion
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Exchange button on Coinmarketcap screen
    Then the user able to see Top Cryptocurrency Spot Exchanges screen
    When the user select "Binance" spot exchange on Top Cryptocurrency Spot Exchanges screen
    Then the user able to see Binance Spot Exchanges details screen
    And the user check Binance Exchange Proportion on Binance Spot Exchanges details screen
    When the user quit app

  @AC7.8 @AC7.9 @AC7.10
  Scenario: select MetaMask on Supported wallets
    Given the user open "https://yogapetz-prelaunch-website.vercel.app" url on Google Chrome
    Then the user able to see Yogapetz screen
    When the user click Menu button on Yogapetz screen
    And the user click Setting button on Yogapetz screen
    And the user click "Connect wallet" button on Yogapetz screen
    Then the user able to see Connect a Wallet partial modal
    When the user click MetaMask button on Connect a Wallet partial modal
    And the user click Get a Wallet button on Connect a Wallet partial modal
    And the user click GET button on Connect a Wallet partial modal
    And the user click Add to Chrome button on Connect a Wallet partial modal
    Then the user able to see Chrome store screen
    When the user click metamask io link on Chrome store screen
    And the user click Got it button on Chrome store screen
    And the user switch to last window
    Then the Browser is opening "https://metamask.io/" url on Google Chrome
    When the user switch to first window
    Then the user able to see Yogapetz screen
    Then the Browser is opening "https://yogapetz-prelaunch-website.vercel.app/mission" url on Google Chrome
    When the user quit app

  @AC7.11
  Scenario: Verify that the 1D icon appears the same as the response
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Fear and Greed Index chat on Coinmarketcap screen
    Then the user able to see Global Live Cryptocurrency Charts screen

    When the user quit app


  @AC7.12
  Scenario: Check About LOOM NetWork copy
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen
    And the user able to see About LOOM NetWork copy on Coinmarketcap currency details screen
    When the user quit app

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