Feature: Validation of video get details API


  Scenario: Verify user is able to view videos 
    Given I have the endpoint for "VideoGetDetails"
    When I make the "GET" request with the following query parameters
            |video_pid|
            |JemPuqKI |
    Then The video API returns "success" with status code 200
    And Validate the video response




