# new feature
# Tags: optional

Feature: Podcasts get all

  Scenario: Podcasts get all
    Given I have the endpoint for "PodcastGetAll"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Podcasts get all response must be validated successfully