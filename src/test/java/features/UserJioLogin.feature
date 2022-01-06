#Feature: user.jioLogin
#  Background: I generate the SSO_Token
#    Given I have the following params for SSO Token generation
#          |Content-Type|x-api-key|app-name|
#          |application/json|l7xx77e611b130e44bdd91e5193986704c32|RJIL_JioSaavn|
#    Scenario: Verify jio login
#      Given I have the endpoint for "UserJioLoginAPI"
#      When I make the "GET" request with the following query parameters with response specification
#       |Content-Type|lbCookie|platform|subscriberId|device_identifier_name|device_identifier_value|
#        |application/json|1   |android |9335346391  |android_id|54a18c4b9c8cb694      |
#      Then The Jio Login API returns "success" with status code 200 and response message is validated