Feature: Validating Jio Send OTP API

  Scenario: Verify if user is able to generate an OTP using Jio Send OTP API

    Given I have the endpoint for "JioSendOtpApi"
    When I make the "GET" request with the following query parameters
      | phone_number  |
      | +919372804795 |
    Then The Jio Send OTP API returns response with status code 200


