@search
Feature: autocomplete.get

  Scenario Outline: Search for album and verify the results

    Given I have the endpoint for "AutocompleteGet"
    When I make the "GET" request with the following query parameters
    | query   |
    | <query> |
    Then I validate status code with "OK"
    And I should see response with JSON validation

    Examples:
      | query          |
      | Tum Hi Ho      |
      | No filter Neha |
      | Arijit Singh   |
      | Kabir Singh    |
      | Hariharan Hits |
      | Jazz           |
    
