Feature: Validation of user logout API.

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | Saavn123 |

    @WIP
  Scenario: Verify user is able to logout
    Given I have the endpoint for "UserLogoutAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
    Then The User Logout API returns "success" with status code 200