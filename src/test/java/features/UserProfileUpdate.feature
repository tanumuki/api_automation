Feature: user.update

  Background:
    Given I have the cookie for the following user
      | username              | password   |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario: Verify user is able to update profile information
    Given I have the endpoint for "UserProfileUpdateAPI"
    When I make the "GET" request with the following query parameters
      | firstname | lastname | gender | dob        | email                 | phonefbid | phonefbtoken | phone_number | idtoken | ct         |
      | Test2     | User2    | f      | 1999-01-01 | paypaltest7@saavn.com |           |              |              |         | 2061221000 |
    Then The User Update API returns "success" with status code 200
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |