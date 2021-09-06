@search
Feature: autocomplete.get

  Scenario Outline: Search for album and verify the results

    Given Add payload with search endpoint "AutocompleteGet"
    When User calls "GET" https request for queries in "<query>"
    Then Api should return response with status code "200"
    And I should see response with JSON validation

    Examples:
      | query          |
      | Tum Hi Ho      |
      | No filter Neha |
      | Arijit Singh   |
      | Kabir Singh    |
      | Hariharan Hits |
      | Jazz           |
    
