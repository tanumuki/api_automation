Feature: subscription.contentRightsChanged

  Scenario: Gets the last changed timestamp of the content rights
    Given I have the endpoint for "GetContentRightsChanged"
    When I make the "GET" request
    Then I validate status code with "OK"
    And get content rights api response must be validated successfully