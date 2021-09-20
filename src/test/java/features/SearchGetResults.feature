# new feature
# Tags: optional

Feature: search.getResults

  Scenario Outline: Get song results for a given query
#    Given Payload with endpoint search get results "SearchGetResults"
    Given I have the endpoint for "SearchGetResults"
#    When User calls search get results api with the "<query>"
    When I make the "GET" request with the following query parameters
      | q |
      |<query>|
    Then I validate status code with "OK"
    And search get results api response must be validated

    Examples:
    | query |
    | A |