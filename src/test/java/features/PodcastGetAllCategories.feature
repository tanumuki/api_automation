# new feature
# Tags: optional

Feature: Podcasts get all categories

  Scenario: Podcasts get all categories
    Given I have the endpoint for "PodcastGetAllCategories"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Podcasts get all categories response must be validated successfully