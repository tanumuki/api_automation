Feature: search.getResultsFromEntities

  Background:
    Given I login with randomly generated user credentials

  Scenario: Verify search result from entities API
    Given I have the endpoint for "SearchGetResultsFromEntities"
    When I make the "GET" request with the following query parameters
      | entities |
      | dance    |
    Then The Search Get Results from Entities API returns response with status code 200


