# new feature
# Tags: optional

Feature: subscription.getUserCurrentSubscription

  Scenario: Gets the user's current subscription details
    Given I have the cookie for the following user
    | username | password |
    | testproapi2@saavn.com | Saavn@1234 |
    And I have the endpoint for "GetUserCurrSubscription"
    When I make the "GET" request
    Then I validate status code with "OK"
    And get current subs api response must be validated successfully

