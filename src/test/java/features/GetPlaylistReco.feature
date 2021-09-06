# new feature
# Tags: optional
Feature: reco.getPlaylistReco

  Scenario Outline: Get playlist recommendations for a given playlist id
    Given Payload with get playlist recommendations endPoint "GetPlaylistRecoAPI"
    When User calls Get playlist recommendations api for the "<playlistid>"
    Then Get playlist recommendations must respond with status code "OK"
    And User should see the playlist recommendations response validated

    Examples:
      | playlistid |
      | 154683470  |