# new feature
# Tags: optional

Feature: Gets the contents rights of a given song id

  Scenario Outline: Gets the contents rights of a given song id
    Given Payload with endpoint check rights "SubscriptionCheckRights"
    When User calls check rights api with the "<pids>"
    Then check rights api must respond with status code "OK"
    And check rights api response must be validated successfully

    Examples:
    | pids  |
    | HdGekZSc  |
    | uf2JX_12,gx0VjdSb |


