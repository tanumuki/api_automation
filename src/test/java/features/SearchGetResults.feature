# new feature
# Tags: optional

Feature: search.getResults

  Scenario Outline: Get song results for a given query
    Given Payload with endpoint search get results "SearchGetResults"
    When User calls search get results api with the "<query>"
    Then search get results api must respond with status code "OK"
    And search get results api response must be validated

    Examples:
    | query |
    | A |