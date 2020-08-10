# new feature
# Tags: optional

Feature: Get all Top shows

  Scenario: Get all top shows
    Given Payload with endpoint content get top shows "ContentGetTopShows"
    When User calls get top shows api
    Then Get top shows must respond with status code "OK"
    And Get top shows api response must be validated successfully