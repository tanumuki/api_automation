Feature: content.handleUnsupportedDeeplink

  Scenario Outline: Verify content handle unsupported deeplink
    Given I have the endpoint for "ContentHandleUnsupportedDeeplinkAPI"
    When I make the "GET" request with the following query parameters
    | deeplink   |
    | <deeplink_Id> |
    And Content handle unsupported deeplink api response must be validated successfully

    Examples:
    | deeplink_Id |
    | jiosaavn://open/settings  |
    | jiosaavn://open/webgopro |git staus