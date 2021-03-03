Feature: Validation of Content Decode Token and Fetch Results API

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | Saavn123 |

  Scenario: Verify Content Decode Token and Fetch Results API for shorties
    Given I have the endpoint for "AppGetLaunchData"
    And I make the "GET" request with the following query parameters
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
    And I fetch token for module "Shorties"
    And I have the endpoint for "ContentDecodeTokenAndFetchResults"
    When I make the GET request with token
    Then The Content Decode and Fetch Token API returns response with status code 200

  Scenario: Verify Content Decode Token and Fetch Results API for Artists
    Given I have the endpoint for "AppGetLaunchData"
    And I make the "GET" request with the following query parameters
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
    And I fetch token for module "Artist"
    And I have the endpoint for "ContentDecodeTokenAndFetchResults"
    When I make the GET request with token
    Then The Content Decode and Fetch Token API returns response with status code 200


