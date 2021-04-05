# new feature
# Tags: optional

Feature: Gets app get launch data for logged out user
  Scenario: Gets app get launch data
    Given Payload with endpoint for app get launch "AppGetLaunchData"
    When User calls app get launch api
    Then App get launch data api must respond with code "OK"
    And App get launch data response must be validated successfully

  Scenario: Gets app get launch data for logged in user
    Given Payload with app get launch endpoint "AppGetLaunchData" along with given credentials
    When User calls app get launch api
    Then App get launch data api must respond with code "OK"
    And App get launch data response must be validated successfully
