Feature: Validation of video getHomepage API

Background:
  Given I have the cookie for the following user
      |username|password|
      |paypaltest7@saavn.com|Saavn@1234|

  Scenario:Verify if user is able to view homepage data
    Given I have the endpoint for "VideoGetVideoHomePage"
    When I make the "Get" request
    Then The videoGetHomePage API returns status code 200
    And Validate the videoGetHomePage response
    