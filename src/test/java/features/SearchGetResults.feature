# new feature
# Tags: optional

Feature: search.getResults

  Scenario Outline: Get song results for a given query
    Given I have the endpoint for "SearchGetResults"
    When I make the "GET" request with the following query parameters
      | q |
      |<query>|
    Then I validate status code with "OK"
    And search get results api response must be validated

    Examples:
    | query |
    | A |