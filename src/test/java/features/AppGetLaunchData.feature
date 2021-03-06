Feature: app.getLaunchData

  Scenario: Gets app get launch data for a logged out user
    Given I have the endpoint for "AppGetLaunchData"
    When I make the "GET" request
    Then I validate status code with "OK"
    And App get launch data response must be validated successfully

  Scenario: app.getLaunchData for a logged-in user
    Given I login with randomly generated user credentials
    When I have the endpoint for "AppGetLaunchData"
    And I make the "GET" request
    Then I validate status code with "OK"
    And App get launch data response must be validated successfully
