@content
Feature: content.getAlbumDetails

  Scenario Outline: Get Album details for given albumId
    Given I have the endpoint for "GetAlbumDetailsAPI"
    When I make the "GET" request with the following query parameters
    | albumid   |
    | <albumid> |
    Then I validate status code with "OK"
    And User should see the response validated

    Examples: 
      | albumid |
      | 3118021 |
      | 3128021 |
      | 3138021 |
