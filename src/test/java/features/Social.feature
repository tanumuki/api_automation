Feature: Validation of user profile update API.

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | saavn123 |

  Scenario: Verify user is able to follow an artist
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type   | entity_id |
      | artist | 459320    |
    Then The Social Follow API returns "success" with status code 200

  Scenario: Verify an error is shown when user tries follow an already followed artist
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type   | entity_id |
      | artist | 459320    |
    Then The Social Follow API returns "error" with status code 200
    And An error message "already follows" is returned with error code 5


  Scenario: Verify user is able to unfollow an artist
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type   | entity_id |
      | artist | 459320    |
    Then The Social unfollow API returns "success" with status code 200

  Scenario: Verify an error is shown whe user tries unfollow an artist who is not followed already
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type   | entity_id |
      | artist | 459320    |
    Then The Social Follow API returns "error" with status code 200
    And An error message "does not follow" is returned with error code 4

###########################################################################################

  Scenario: Verify user is able to follow a playlist
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type     | entity_id |
      | playlist | 89579550  |
    Then The Social Follow API returns "success" with status code 200

  Scenario: Verify an error is shown when user tries follow an already followed playlist
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type     | entity_id |
      | playlist | 89579550  |
    Then The Social Follow API returns "error" with status code 200
    And An error message "already follows" is returned with error code 5


  Scenario: Verify user is able to unfollow a playlist
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type     | entity_id |
      | playlist | 89579550  |
    Then The Social unfollow API returns "success" with status code 200

  Scenario: Verify an error is shown whe user tries unfollow a playlist which is not followed already
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type     | entity_id |
      | playlist | 89579550  |
    Then The Social Follow API returns "error" with status code 200
    And An error message "does not follow" is returned with error code 4

###########################################################################################

  Scenario: Verify user is able to follow a channel
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type    | entity_id |
      | channel | 111       |
    Then The Social Follow API returns "success" with status code 200

  Scenario: Verify an error is shown when user tries follow an already followed channel
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type    | entity_id |
      | channel | 111       |
    Then The Social Follow API returns "error" with status code 200
    And An error message "already follows" is returned with error code 5


  Scenario: Verify user is able to unfollow a channel
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type    | entity_id |
      | channel | 111       |
    Then The Social unfollow API returns "success" with status code 200

  Scenario: Verify an error is shown whe user tries unfollow a channel which is not followed already
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type    | entity_id |
      | channel | 111       |
    Then The Social Follow API returns "error" with status code 200
    And An error message "does not follow" is returned with error code 4

###########################################################################################

  Scenario: Verify user is able to follow a show
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type | entity_id |
      | show | 25       |
    Then The Social Follow API returns "success" with status code 200

  Scenario: Verify an error is shown when user tries follow an already followed show
    Given I have the endpoint for "SocialFollow"
    When I make the "GET" request with the following query parameters
      | type | entity_id |
      | show | 25       |
    Then The Social Follow API returns "error" with status code 200
    And An error message "already follows" is returned with error code 5


  Scenario: Verify user is able to unfollow a show
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type | entity_id |
      | show | 25       |
    Then The Social unfollow API returns "success" with status code 200

  Scenario: Verify an error is shown whe user tries unfollow a show which is not followed already
    Given I have the endpoint for "SocialUnfollow"
    When I make the "GET" request with the following query parameters
      | type | entity_id |
      | show | 25       |
    Then The Social Follow API returns "error" with status code 200
    And An error message "does not follow" is returned with error code 4
