Feature: playlist.getDetails

  Scenario Outline: Get playlist details of the given playlist id
    Given Playlist API with endpoint "GetPlaylistDetailsAPI"
    When User calls PlaylistGetDetails api with "<playlistid>"
    Then PlaylistGetDetails api must respond with status code "OK"
    And User should see the PlaylistGetDetails response validated

    Examples:
      | playlistid |
      | 81853229 |
      | 82859880 |
      | 802204672 |
      | 802204674 |
      | 802204675 |
      | 802204668 |
#  |   802204672 | Sample Video Playlist  |
#  |   802204673 | Another Video Playlist |
#  |   802204674 | Audio Video Playlist   |
#  |   802204675 | Test Pro Playlist      |
#  |   802204668 | Test Video Playlist
