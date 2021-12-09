Feature: playlist.makePrivate , playlist.makePublic

  Background:
    Given I login with randomly generated user credentials

  Scenario: Verify playlist creation for a new user
    Given I have the endpoint for "PlaylistCreate"
    When User calls method with below params for playlistOps
      | method | contents | share |
      | GET    | cd7s24ys | true  |
    And User validates the response of the newly created playlist

    Given I have the endpoint for "MakePrivatePlaylist"
    When I make thr "GET" request with param listID of the created playlist
    Then I validate the status code "OK" and validate the response




