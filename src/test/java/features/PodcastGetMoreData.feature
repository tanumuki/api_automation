# new feature
# Tags: optional

Feature: podcast.getMoreData

  Scenario Outline: Podcast get more data
    Given I have the endpoint for "PodcastGetMoreData"
    When I make the "GET" request with the following query parameters
    |source|
    |<source>|

    Then I validate status code with "OK"
    And Podcasts get more data response must be validated successfully

    Examples:
    | source  |
    | base_menu |