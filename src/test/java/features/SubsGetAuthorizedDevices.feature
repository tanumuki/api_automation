Feature: Get authorized devices for a user

  Scenario: Get authorized devices for a user
    Given Payload with get authorized devices endpoint "SubsGetAuthorizedDevices" along with given credentials
    When User calls get authorized devices api
    Then get authorized devices api must respond with code "OK"
    And get authorized devices response must be validated successfully