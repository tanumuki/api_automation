Feature: jio.sendOtp

  Scenario: Verify if user is able to generate an OTP using Jio Send OTP API

    Given I have the endpoint for "JioSendOtpApi"
    When I make the "GET" request with the following query parameters
      | phone_number  |
      | +919372804795 |
    Then The Jio Send OTP API returns response with status code 200

  Scenario: Verify if user is not able to generate an OTP using Jio Send OTP API with an incorrect number

    Given I have the endpoint for "JioSendOtpApi"
    When I make the "GET" request with the following query parameters
      | phone_number  |
      | 9372804795 |
    Then The Jio Send OTP API returns response with status code 200


