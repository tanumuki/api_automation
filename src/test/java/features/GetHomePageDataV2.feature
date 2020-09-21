
Feature: Get Homepage data

  Scenario: Get Homepage data when user is in logged out state
    Given Payload with endpoint GetHomepageDataV2 "GetHomepageDataV2"
    When User calls get homepage data api
    Then Get homepage data api must respond with status code "OK"
    And Get homepage data api response must be validated successfully with userstate as logged out

  Scenario: Get Homepage data when user is logged in with given credentials
    Given Payload with endpoint GetHomepageDataV2 "GetHomepageDataV2" along with the credentials
    When User calls get homepage data api
    Then Get homepage data api must respond with status code "OK"
    And Get homepage data api response must be validated successfully with user state as logged in