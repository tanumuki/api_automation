Feature: benefits.count + benefits.list
  Background:
    Given I have the cookie for the following user
      | username | password |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario: Verify user is able to fetch the benefits count
    Given I have the endpoint for "BenefitsCountApi"
    When I make the "GET" request
    Then The Benefits Count API returns response with status code 200
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |

  Scenario: Verify user is able to fetch the benefits list
    Given I have the endpoint for "BenefitsListApi"
    When I make the "GET" request
    Then The Benefits List API returns response with status code 200
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
