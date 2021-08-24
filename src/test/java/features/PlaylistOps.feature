Feature: playlist.create, playlist.delete
#  Verifying playlist.create and playlist.delete with the same playlist listid and
#  finally checking if the playlist is deleted using playlist.geDetails

  Background:
    Given I have the cookie for the following user
      | username              | password   |
      | paypaltest7@saavn.com | Saavn@1234 |
    
  Scenario: Verify playlist creation for a new user
     Given I have the endpoint for "PlaylistCreate"
     When User calls method with below params for playlistOps
       | method | contents | share |
       | GET    | cd7s24ys | true  |
     Then User validates the status code "OK"
     And User validates the response of the newly created playlist

     Given I have the endpoint for "PlaylistDelete"
     When User calls "GET" method with param "listID" of the created playlist
     Then Playlist Delete API returns success with status code "OK" and response is validated

     Given I have the endpoint for "GetPlaylistDetailsAPI"
     When I make the "GET" request with the following query parameters with deleted listID
     Then I verify that there is no such playlist after deletion and status code is "OK"

