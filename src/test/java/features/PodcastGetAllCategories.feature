# new feature
# Tags: optional

Feature: podcast.getAllCategories

  Scenario: Podcasts get all categories
    Given I have the endpoint for "PodcastGetAllCategories"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Podcasts get all categories response must be validated successfully