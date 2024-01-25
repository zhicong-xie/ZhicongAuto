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
    When the user Maximize window
#    When the user click Back to top button on Coinmarketcap screen
    And the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen
    When the user quit app

  @AC7.7
  Scenario: check Binance Exchange Proportion
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user Maximize window
    And the user click Exchange button on Coinmarketcap screen
    Then the user able to see Top Cryptocurrency Spot Exchanges screen
    When the user select "Binance" spot exchange on Top Cryptocurrency Spot Exchanges screen
    Then the user able to see Binance Spot Exchanges details screen
    And the user check Binance Exchange Proportion on Binance Spot Exchanges details screen

  @AC7.8
  Scenario: select MetaMask on Supported wallets
    Given the user open "https://yogapetz-prelaunch-website.vercel.app" url on Google Chrome
    Then the user able to see Yogapetz screen
    When the user click Menu button on Yogapetz screen
    And the user click Setting button on Yogapetz screen
    And the user click "Connect wallet" button on Yogapetz screen
    Then the user able to see Connect a Wallet partial modal
    When the user click "MetaMask" button on Yogapetz screen

