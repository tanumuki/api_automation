# new feature
# Tags: optional

Feature: Get Details of a Mix with given Id

  Scenario Outline: Given a mix id, get the details of the mix
    Given Payload with endpoint mixes get details "MixGetDetails"
    When User calls mixes get details api with "<listid>"
    Then Mixes get details api must respond with status code "OK"
    And Mixes get details api response must be validated successfully

    Examples:
      | listid |
#      | 933ba3f82b090689f63440945fe5c463 |
      | 7f2069a7158f3a63203f2f62cb76658b |

  