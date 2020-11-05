# new feature
# Tags: optional

Feature: Gets similar songs for the given song id

  Scenario Outline: Gets similar songs for the given song id
    Given Payload with endPoint get song reco API "GetSongReco"
    When User calls get song reco request with  "<song_id>"
    Then get song reco API returns a status code "OK"
    And get song reco API response is validated

    Examples:
    | song_id |
    | ww6RMeK4  |