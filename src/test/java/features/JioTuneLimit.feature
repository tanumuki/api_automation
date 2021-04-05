Feature: Validating Jio Send OTP API

  Background:
    Given I have the cookie for the following user
      | username | password |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario: Verify the functionality of Jio tune limite API

    Given I have the endpoint for "JioTuneLimitApi"
    When I make the "GET" request
    Then The Jio tune API returns response with status code 200


