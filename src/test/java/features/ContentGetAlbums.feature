Feature: content.getAlbums

  Scenario: Get all top albums
    Given I have the endpoint for "ContentGetAlbums"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Get albums api response must be validated successfully
