Feature: Validating Playlist APIs

       
  Scenario: Verify playlist creation for a new user
     Given Add payload with get playlist endpoint "PlaylistCreate" and account credentials for cookie
     When User calls method with below params
       | method | listname | contents | share|
       | GET    | 10 | random |cd7s24ys|true|
     Then The playlist API returns success with status code "OK"
     And Validate the playlist data for new user