Feature: user.update

  Background:
    Given I have the cookie for the following user
      | username              | password   |
      |testdemo10@saavn.com   | Saavn@123 |

  Scenario: Verify user is able to update profile information
    Given I have the endpoint for "UserProfileUpdateAPI"
    When I make the "GET" request with the following query parameters
      | firstname | lastname | gender | dob        | email                 | phonefbid | phonefbtoken | phone_number | idtoken | ct         |
      | Test2     | User2    | f      | 1999-01-01 | testdemo10@saavn.com  |           |              |              |         | 2061221000 |
    Then The User Update API returns "success" with status code 200
    Given I have the endpoint for "UserLogoutAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | 05c9a0601b3425e2af6572ab2d8028df |
    Then The User Logout API returns "success" with status code 200
