Feature: playlist.makePrivate , playlist.makePublic

  Background:
    Given I have the cookie for the following user
      | username              | password   |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario: Verify playlist creation for a new user
    Given I have the endpoint for "PlaylistCreate"
    When User calls method with below params for playlistOps
      | method | contents | share |
      | GET    | cd7s24ys | true  |
    And User validates the response of the newly created playlist

    Given I have the endpoint for "MakePrivatePlaylist"
    When I make thr "GET" request with param listID of the created playlist
    Then I validate the status code "OK" and validate the response
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |




