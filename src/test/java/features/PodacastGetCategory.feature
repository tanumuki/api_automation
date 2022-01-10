# new feature
# Tags: optional

Feature: podcast.getCategory

  Scenario Outline: Podcast get category with given id & type
    Given Payload with podcasts get category endpoint "PodcastGetCategory"
    When User calls podcasts get category api with "<category_id>" and "`<category_type>"
    Then Podcasts get category api should return with status code "OK"
    And Podcasts get category response must be validated successfully

    Examples:
    | category_id | category_type |
    |      5      |   static      |