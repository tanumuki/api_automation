# new feature
# Tags: optional
  #Ignoring this suite as jiotunepage.getMoreSongs is run on websocket arch and not on the http arch.
  #This scenario will be covered when we create test suites for websocket APIs
@ignore
Feature: Jiotunes get more songs

  #failure: failing cuz of 500
  Scenario Outline: Jiotunes get more songs
    Given Payload with endpoint jiotunes get more songs "JTGetMoreSongs"
    When User calls jiotunes get more songs api with "<query>", "<n>" and "<p>"
    Then jiotunes get more songs api must respond with status "OK"
    And jiotunes get more songs response must be validated successfully

    Examples:
      | query  | n  | p |
      | arijit | 10 | 1 |