Feature: search.getResultsFromEntities

  Background:
    Given I have the cookie for the following user
      | username | password |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario: Verify search result from entities API
    Given I have the endpoint for "SearchGetResultsFromEntities"
    When I make the "GET" request with the following query parameters
      | entities |
      | dance    |
    Then The Search Get Results from Entities API returns response with status code 200
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |


