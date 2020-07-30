Feature: Get playlist details of the given playlist id

  Scenario Outline: Get playlist details of the given playlist id
    Given Playlist API with endpoint "GetPlaylistDetailsAPI"
    When User calls PlaylistGetDetails api with "<playlistid>"
    Then PlaylistGetDetails api must respond with status code "OK"
    And User should see the PlaylistGetDetails response validated

    Examples: 
      | playlistid |
      |    81853229 |
      |    82859880 |
