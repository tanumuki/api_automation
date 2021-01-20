Feature: Validation of Search Get Results API

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | Saavn123 |

  Scenario: Verify search result from entities API
    Given I have the endpoint for "SearchGetResultsFromEntities"
    When I make the "GET" request with the following query parameters
      | entities |
      | dance    |
    Then The Search Get Results from Entities API returns response with status code 200


