Feature: Validation of Get Launch Data Api for Jio Phone

  Background:
    Given I have the cookie for the following user
      | username       | password |
      | tanu@saavn.com | Tanu1234 |

  Scenario: Verify Get Launch Data Api response for Jio Phone
    Given I have the endpoint for JioPhone API "AppGetLaunchDataJioPhone"
    When I make the "GET" request for JioPhone API
    Then The JioPhone Get Launch API returns response with status code 200