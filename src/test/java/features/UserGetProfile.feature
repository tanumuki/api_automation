Feature: user.getDetails

  Background:
    Given I have the cookie for the following user
      | username              | password   |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario: Verify user is able to get profile information
    Given I have the endpoint for "UserGetProfileAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | 175499cbb6cf36cbe9476f0860b1ddf4 |
    Then The User Get Profile API returns response with status code 200
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |


