Feature: app.getLaunchDataJioPhone

  Background:
    Given I login with randomly generated user credentials
  Scenario: Verify Get Launch Data Api response for Jio Phone
    Given I have the endpoint for JioPhone API "AppGetLaunchDataJioPhone"
    When I make the "GET" request for JioPhone API
    Then The JioPhone Get Launch API returns response with status code 200

