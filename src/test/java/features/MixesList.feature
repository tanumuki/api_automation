# new feature
# Tags: optional

Feature: List Mixes

  Scenario Outline: List all the mixes for a user
    Given Payload with endpoint list mixes "MixesList"
    When User calls list mixes api with "<uid>"
    Then List mixes api must respond with status code "OK"
    And List mixes api response must be validated successfully

    Examples:
    | uid |
    | bce7c660c72e9872e9b627fd4f6fc0f2 |