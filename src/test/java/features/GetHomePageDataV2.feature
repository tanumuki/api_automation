
Feature: Get Homepage data

  Scenario: Get Homepage data when user is in logged out state
    Given Payload with endpoint GetHomepageDataV2 "GetHomepageDataV2"
    When User calls get homepage data api
    Then Get homepage data api must respond with status code "OK"
    And Get homepage data api response must be validated successfully with userstate as logged out
