# new feature
# Tags: optional

Feature: podcast.getCategory

  Scenario Outline: Podcast get category with given id & type
    Given I have the endpoint for "PodcastGetCategory"
    Given I make the "GET" request with the following query parameters
      |category_id | category_type|
      | <category_id>      | <category_type>      |
    Then I validate status code with "OK"
    And Podcasts get category response must be validated successfully

    Examples:
    |  category_id  |   category_type      |
    |    5  |   static   |
