Feature: Validation of video getHomepage API

Background:
  Given I login with randomly generated user credentials

  Scenario:Verify if user is able to view homepage data
    Given I have the endpoint for "VideoGetVideoHomePage"
    When I make the "Get" request
    Then The videoGetHomePage API returns status code 200
    And Validate the videoGetHomePage response
    