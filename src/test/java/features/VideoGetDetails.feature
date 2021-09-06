Feature: video.getDetails


  Scenario: Verify user is able to view videos
    Given I have the endpoint for "VideoGetDetails"
    When I make the "GET" request with the following query parameters
            |video_pid|
            |TjqQ1Hvv |
    Then The video API returns "success" with status code 200
    And Validate the video response




