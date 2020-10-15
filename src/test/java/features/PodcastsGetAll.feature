# new feature
# Tags: optional

Feature: Podcasts get all

  Scenario: Podcasts get all
    Given Payload with podcasts get all endpoint "PodcastGetAll"
    When User calls podcasts get all api
    Then Podcasts get all api should return with status code "OK"
    And Podcasts get all response must be validated successfully