Feature: content.getTopSearches

  Background:
    Given I have the cookie for the following user
      | username | password |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario: Verify content get top searches API
    Given I have the endpoint for "ContentGetTopSearches"
    When I make the "GET" request
    Then The Content Get Top Searches API returns response with status code 200
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |


