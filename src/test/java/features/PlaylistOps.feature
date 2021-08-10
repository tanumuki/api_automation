Feature: playlist.create

  Scenario: Verify playlist creation for a new user
     Given Add payload with get playlist endpoint "PlaylistCreate" and account credentials for cookie
     When User calls method with below params for playlistOps
       | method | listname | contents | share|
       | GET    | random |cd7s24ys|true|
     Then The playlist API returns success with status code "OK"