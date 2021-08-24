@content
Feature: content.getAlbumDetails

  Scenario Outline: Get Album details for given albumId
    Given Payload with endPoint "GetAlbumDetailsAPI"
    When User calls https request with "<albumid>"
    Then User should get response with status code "OK"
    And User should see the response validated

    Examples: 
      | albumid |
      | 3118021 |
      | 3128021 |
      | 3138021 |
