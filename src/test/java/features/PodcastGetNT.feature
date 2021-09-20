# new feature
# Tags: optional

Feature: Podcast get New & Trending

  Scenario: Podcast get New & Trending
    Given I have the endpoint for "PodcastGetNT"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Podcasts get new and trending response must be validated successfully