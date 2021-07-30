# new feature
# Tags: optional

@AlbumDetails
Feature: Content Get Albums

  Scenario: Get all top albums
    Given Payload with endpoint content get albums "ContentGetAlbums"
    When User calls content get albums api
    Then Get albums must respond with status code "OK"
    And Get albums api response must be validated successfully
