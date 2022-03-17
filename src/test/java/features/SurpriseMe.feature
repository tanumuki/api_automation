Feature: playlist.getDetailsForFeaturedRandom (Surprise Me API)

  Scenario Outline: Surprise Me API for single language
    Given I have the endpoint for "SurpriseMe"
    When I make the "GET" request with the following query parameters
      | listid | count|
      | <listids> | 20 |
    Then I validate status code with "OK"
    And User should see the SurpriseMe response validated

    Examples:
      | listids |
      | 5424 |
#      | 2212321 |
      | 3339593 |
      | 5425 |
      | 1506992 |
      | 1679004 |