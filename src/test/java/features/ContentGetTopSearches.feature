Feature: Validation of Content Get Top searches API

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | Saavn123 |

  Scenario: Verify content get top searches API
    Given I have the endpoint for "ContentGetTopSearches"
    When I make the "GET" request
    Then The Content Get Top Searches API returns response with status code 200


