Feature: user.getDetails

  Background:
    Given I have the cookie for the following user
      | username              | password   |
      | testdemo11@saavn.com | Saavn@123 |

  Scenario: Verify user is able to get profile information
    Given I have the endpoint for "UserGetProfileAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | de755856f834a5aa4963a8a906afc838 |
    Then The User Get Profile API returns response with status code 200
    Given I have the endpoint for "UserLogoutAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | de755856f834a5aa4963a8a906afc838 |
    Then The User Logout API returns "success" with status code 200


