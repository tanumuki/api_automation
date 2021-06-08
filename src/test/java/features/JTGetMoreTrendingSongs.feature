# new feature
# Tags: optional
  #Ignoring this suite as jiotunepage.getMoreTrendingSongs is run on websocket arch and not on the http arch.
  #This scenario will be covered when we create test suites for websocket APIs
@ignore
Feature: Jiotunes get more trending songs

  Scenario Outline: Jiotunes get more trending songs
    Given Payload with endpoint jiotunes get more trending songs "JTGetMoreTrendingSongs"
    When User calls jiotunes get more songs api with "<n>" and "<p>"
    Then jiotunes get more trending songs api must respond with status "OK"
    And jiotunes get more trending songs response must be validated successfully

    Examples:
      | n | p |
      | 10 | 10  |