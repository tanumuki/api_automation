Feature: Validation of user profile update API.

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | saavn123 |

  Scenario: Verify user is able to update profile information
    Given I have the endpoint for "UserProfileUpdateAPI"
    When I make the "GET" request with the following query parameters
      | firstname | lastname | gender | dob        | email    | phonefbid | phonefbtoken | phone_number | idtoken | ct         |
      | Test2     | User2    | f      | 1999-01-01 | sun@s.in |           |              |              |         | 2061221000 |
    Then The User Update API returns "success" with status code 200