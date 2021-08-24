Feature: to  make playlist as private of given playlistId

  Scenario Outline: make playlist as private for given playlistId
    Given MakePrivatePlaylist API with endpoint "MakePrivatePlaylist"
    When User calls MakePrivatePlaylist api with "<playlist_id>"
    Then MakePrivatePlaylist api must respond with status code "OK"
    And User should see the MakePrivatePlaylist response validated

    Examples:
      | playlist_id |
      | 935666472 |