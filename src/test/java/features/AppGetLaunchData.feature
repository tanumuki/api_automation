# new feature
# Tags: optional

Feature: Gets app get launch data

  Scenario: Gets app get launch data
    Given Payload with endpoint for app get launch "AppGetLaunchData"
    When User calls app get launch api
    Then App get launch data api must respond with code "OK"
    And App get launch data response must be validated successfully