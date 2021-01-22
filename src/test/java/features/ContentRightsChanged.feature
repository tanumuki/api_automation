# new feature
# Tags: optional

Feature: Gets the last changed timestamp of the content rights

  Scenario: Gets the last changed timestamp of the content rights
    Given Payload with endpoint get content rights changed "GetContentRightsChanged"
    When User calls get content rights api
    Then get content rights api must respond with status code "OK"
    And get content rights api response must be validated successfully