Feature: Validation of Album Video List

  Scenario: Verify user is able to view album video list
    Given I have the endpoint for "GetAlbumVideoList"
    When I make the "GET" request with the following query parameters
            |albumid|
            |3118021|
    Then The AlbumVideoList API returns "success" with status code 200
    And Validate the videoList response


