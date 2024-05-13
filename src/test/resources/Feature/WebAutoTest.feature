Feature: Web auto testing

  @AC7.5
  Scenario: scroll down to the bottom on Cryptocurrencies section get currency list
    Given the user open "https://coinmarketcap.com/" url on Google Chrome
    Then the user able to see Coinmarketcap screen
    When the user click Accept Cookies & Continue on Coinmarketcap screen if exists
    Then the user swipe to down get currency list size is 100 on Coinmarketcap screen
    When the user click Back to top button on Coinmarketcap screen

  @AC7.6
  Scenario: select LOOM currency and direct currency details screen
    Given the user able to see Coinmarketcap screen
    When the user click Search bar on Coinmarketcap screen
    And the user input "LOOM" in Search input bar on Coinmarketcap screen
    And the user select first search result on Coinmarketcap screen
    Then the user able to see Coinmarketcap currency details screen

  @AC7.7
  Scenario: check Binance Exchange Proportion
    Given the user able to see Coinmarketcap currency details screen
    When the user click Markets button on Coinmarketcap currency details screen top banner
    And the user select "100" rows on Coinmarketcap currency details screen rows dropDown
    Then the user able to see "Binance" volume percentage is correct on Coinmarketcap currency details screen

  @AC7.8 @AC7.9 @AC7.10
  Scenario: select MetaMask on Supported wallets
    Given the user able to see Coinmarketcap currency details screen
    When the user select Metamask icon on Coinmarketcap currency details screen support wallets view
    And the user switch to last window
    Then the Browser is opening "https://metamask.io/download/" url on Google Chrome
    When the user switch to first window
    Then the user able to see Coinmarketcap currency details screen
    And the Browser is opening "https://coinmarketcap.com/currencies/loom-network/#Markets" url on Google Chrome

  @AC7.11
  Scenario: Verify Loom Network 1D icon appears the same as the response
    Given the user able to see Coinmarketcap currency details screen
    When the user click Chart button on Coinmarketcap currency details screen top banner
    Then the user verify 1D price chart data is align with response on Coinmarketcap currency details screen

  @AC7.12
  Scenario: Check About LOOM NetWork copy
    Given the user able to see Coinmarketcap currency details screen
    When the user click About button on Coinmarketcap currency details screen top banner
    Then the user able to see About LOOM NetWork copy "What Is Loom Network (LOOM)?Loom Network is a platform as a service that is built on top of Ethereum and allows developers to run large-scale decentralized applications. This platform was released on October 1st, 2017.The goal of this is to allow application developers to have smart contracts that can access much more computing power when it is required, or maintain the same power at lower costs for tasks such as trials for onboarding new users or applications that simply do not need the full security of blockchain to begin with.In this system you have the ability to interact with APIs developed by third parties which are not on chain. Loom attempts to be the ultimate platform that allows smart contract developers to create applications without the need to switch to another programming language.As such, they can easily integrate their applications with the outside world.The Loom Network runs on Plasma, which is a scaling solution that allows for faster transactions throughout the network." on Coinmarketcap currency details screen
    When the user click Back to top button on Coinmarketcap screen

  @AC7.13
  Scenario: Check watchlist functionality
    Given the user able to see Coinmarketcap currency details screen
    When the user click Follow button on Coinmarketcap currency details screen
    And the user click Watchlist button on Coinmarketcap currency details screen
    Then the user able to see Coinmarketcap watchlist screen
    And the user able to see "LOOM" currency in watchlist on Coinmarketcap watchlist screen
    When the user quit app

  @AC7.14
  Scenario: Restful api call "/v1/cryptocurrency/map" with parameters
    Given the user use Restful api call /v1/cryptocurrency/map api with parameters
      | start          | 1      |
      | limit          | 100    |
      | listing_status | active |
    When the user get Restful api call /v1/cryptocurrency/map api response
    Then the user able to see Restful api states is 200

  @AC7.14
  Scenario: Restful api call "/v1/cryptocurrency/map"
    Given the user use Restful api call /v1/cryptocurrency/map api
    When the user get Restful api call /v1/cryptocurrency/map api response
    Then the user able to see Restful api states is 200