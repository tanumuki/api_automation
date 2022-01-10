# new feature
# Tags: optional

Feature: podcast.getNewandTrending

  Scenario: Podcast get New & Trending
    Given Payload with podcasts get new and trending endpoint "PodcastGetNT"
    When User calls podcasts get new and trending api
    Then Podcasts get new and trending api should return with status code "OK"
    And Podcasts get new and trending response must be validated successfully