# new feature
# Tags: optional

Feature: Gets the homepage of a show

  Scenario Outline: Gets the homepage of a show with the given id
    Given Payload with endPoint shows get homepage API "ShowGetHomePage"
    When User calls shows get homepage request with  "<show_id>"
    Then shows get homepage API returns a status code "OK"
    And shows get homepage API response is validated

    Examples:
    | show_id |
    | 25      |

