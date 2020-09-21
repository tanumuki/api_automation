Feature: Validation of user get profile API

  Scenario: Verify user is able to get profile information
    Given I have the endpoint for "UserGetProfileAPI"
      | username | password |
      | sun@s.in | saavn123 |
    When I make the "GET" request with the following query parameters
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
    Then The User Get Profile API returns response with status code 200


