# new feature
# Tags: optional

Feature: Podcast get more data

  Scenario Outline: Podcast get more data
    Given Payload with podcasts get more data endpoint "PodcastGetMoreData"
    When User calls podcasts get more data api with "<source>"
    Then Podcasts get more data api should return with status code "OK"
    And Podcasts get more data response must be validated successfully

    Examples:
    | source  |
    | base_menu |