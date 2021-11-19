# new feature
# Tags: optional

Feature: subscription.getUserCurrentSubscription

  Scenario: Gets the user's current subscription details
    Given Payload with endpoint get current subs "GetUserCurrSubscription" with given credentials
    When User calls get current subs api
    Then get current subs api must respond with status code "OK"
    And get current subs api response must be validated successfully
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
