Feature: content.getTopSearches

  Background:
    Given I login with randomly generated user credentials

  Scenario: Verify content get top searches API
    Given I have the endpoint for "ContentGetTopSearches"
    When I make the "GET" request
    Then The Content Get Top Searches API returns response with status code 200


