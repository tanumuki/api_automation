# new feature
# Tags: optional

Feature: Gets the user's current subscription details

  Scenario: Gets the user's current subscription details
    Given Payload with endpoint get current subs "GetUserCurrSubscription" with given credentials
    When User calls get current subs api
    Then get current subs api must respond with status code "OK"
    And get current subs api response must be validated successfully
