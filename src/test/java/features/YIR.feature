# new feature
# Tags: optional

Feature: Year in Replay

  Scenario: Gets the year in replay for user
    Given Payload with endpoint YIR "ContentGetReplay"
    When User calls YIR api with the given user credentials
    Then YIR must respond with status code "OK"
    And YIR api response must be validated successfully