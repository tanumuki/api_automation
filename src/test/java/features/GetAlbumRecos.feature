Feature: reco.getAlbumReco

  Scenario Outline: Get Album recommendations for a given album id
    Given I have the endpoint for "GetAlbumRecoAPI"
    When I make the "GET" request with the following query parameters
    | albumid     |
    | <albumid>   |
    Then I validate status code with "OK"
    And User should see the recommendations response validated

    Examples:
    | albumid   |
    | 23216490  |