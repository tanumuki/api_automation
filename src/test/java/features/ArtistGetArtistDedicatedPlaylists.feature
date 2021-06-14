Feature: Artist Get Dedicated Album Playlists of given artistID

  @wip
  Scenario Outline: Get Dedicated Album Playlists of given artistID
    Given Payload with the ArtistDedicatedPlaylists endPoint "ArtistGetArtistDedicatedPlaylists"
    When The user calls https request with "<artistID>"
    Then The user should get response with status code "OK"
    And Response should be validated

    Examples:
      | artistID |
      |  459320  |
      |  743720  |
      |  6024733 |
