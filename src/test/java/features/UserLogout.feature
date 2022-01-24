Feature: user.logout

  Background:
    Given I have the cookie for the following user
      | username | password |
      | testdemoapi3@saavn.com | Saavn1234 |

  Scenario: Verify user is able to logout
    Given I have the endpoint for "UserLogoutAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | e9e1947cdf8b47a70433acb5ebd19eed |
    Then The User Logout API returns "success" with status code 200
