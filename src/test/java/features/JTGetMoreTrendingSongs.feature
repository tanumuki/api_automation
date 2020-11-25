# new feature
# Tags: optional

Feature: Jiotunes get more trending songs

  Scenario Outline: Jiotunes get more trending songs
    Given Payload with endpoint jiotunes get more trending songs "JTGetMoreTrendingSongs"
    When User calls jiotunes get more songs api with "<n>" and "<p>"
    Then jiotunes get more trending songs api must respond with status "OK"
    And jiotunes get more trending songs response must be validated successfully

    Examples:
      | n | p |
      | 10 | 10  |