Feature: subscription.getAuthorizedDevices

  Scenario: Get authorized devices for a user
    Given I have the cookie for the following user
    | username | password |
    | testproapi@saavn.com | Saavn@1234 |
    Given I have the endpoint for "SubsGetAuthorizedDevices"
    When I make the "GET" request
    Then I validate status code with "OK"
    And get authorized devices response must be validated successfully
    Given I have the endpoint for "UserLogoutAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | e41bb84506d8d4f8020bd61cd34e4abf |
    Then The User Logout API returns "success" with status code 200
