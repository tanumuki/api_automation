# new feature
# Tags: optional

Feature: Jiotunes get more songs

  Scenario Outline: Jiotunes get more songs
    Given Payload with endpoint jiotunes get more songs "JTGetMoreSongs"
    When User calls jiotunes get more songs api with "<query>", "<n>" and "<p>"
    Then jiotunes get more songs api must respond with status "OK"
    And jiotunes get more songs response must be validated successfully

    Examples:
    | query | n | p |
    | Rajinikanth | 100 | 12  |