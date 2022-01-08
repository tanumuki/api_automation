# new feature
# Tags: optional

Feature: show.getHomePage

  Scenario Outline: Gets the homepage of a show with the given id
    Given I have the endpoint for "ShowGetHomePage"
    When I make the "GET" request with the following query parameters
      |show_id|
      | <id>  |
    Then I validate status code with "OK"
    And shows get homepage API response is validated

    Examples:
    | id |
    | 25      |

