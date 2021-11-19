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
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
    
    