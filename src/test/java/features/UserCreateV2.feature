Feature: user.createV2

  Background:
    Given I have the endpoint for "UserCreateV2API"

  Scenario: Verify user account can be created with a valid email
    When I make the "GET" request for the userCreateV2 API
    Then I validate status code with "OK"
    And The user account was created successfully

  Scenario: Verify error if an account is created with an email that already exists
    When I make the "GET" request with the following query parameters
      | username  | email | password |
      | paypaltest7@saavn.com | paypaltest7@saavn.com | Saavn@1234 |
    Then I validate status code with "OK"
    But The user account does not get created and responds with "User already exists. Please try another username."
