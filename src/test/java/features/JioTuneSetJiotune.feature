Feature: jiotune.setJiotune

  Scenario: I generate the SSO_Token
    Given I have the following params for SSO Token generation
      |Content-Type|x-api-key|app-name|
      |application/json|l7xx77e611b130e44bdd91e5193986704c32|RJIL_JioSaavn|

  Scenario:Get vcode from jiotune.getHomepageData api
    Given Payload with jiotune home page data endpoint "JiotuneGetHomepageData"
    When User calls jiotune home page data api
    Then jiotune home page data api should respond with status code "OK"

    Scenario: Verify setJiotune api response
      Given I have the endpoint for "JiotuneSetJioTune"
      When I make the "GET" request with the following query parameters with response specification
        |Content-Type|lbCookie|api-key                             |msisdn                              |uid   |vcode|ssoToken|
        |application/json|1  |l7xx77e611b130e44bdd91e5193986704c32|RrXcJeH%252F0WYXX7atH0ipSw%253D%253D|bharatkhati08|vcode|ssoToken|
      Then The Jio Tune API returns "success" with status code 200 and response message is validated


