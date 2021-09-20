# new feature
# Tags: optional

Feature: show.getAllEpisodes

  Scenario Outline: Get all episodes of a show with the given show_id and season number
    Given I have the endpoint for "ShowGetAllEpisodes"
    When I make the "GET" request with the following query parameters
      |show_id| season_number|
      | <id>    | <season>      |
    Then I validate status code with "OK"
    And Get all episodes api response must be valided successfully

    Examples:
    | id | season |
    |    25   |       1       |
