# new feature
# Tags: optional

Feature: Get All Episodes of a show

  Scenario Outline: Get all episodes of a show with the given show_id and season number
    Given Payload with get all episodes endpoint "ShowGetAllEpisodes"
    When User calls get all episodes api with "<show_id>" and "<season_number>"
    Then Get all episodes api must respond with status code "OK"
    And Get all episodes api response must be valided successfully

    Examples:
    | show_id | season_number |
    |    25   |       1       |