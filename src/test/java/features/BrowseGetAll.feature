# new feature
# Tags: optional

Feature: Get all channels of browse

  Scenario: Get all channels of browse
    Given Payload with browse get all endpoint "BrowseGetAll" along with given credentials
    When User calls browse get all api
    Then Browse get all api should return with status code "OK"
    And Browse get all response must be validated successfully