# new feature
# Tags: optional

Feature: Podcasts get all categories

  Scenario: Podcasts get all categories
    Given Payload with podcasts get all categories endpoint "PodcastGetAllCategories"
    When User calls podcasts get all categories api
    Then Podcasts get all categories api should return with status code "OK"
    And Podcasts get all categories response must be validated successfully