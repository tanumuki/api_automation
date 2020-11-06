@WIP
Feature: Validation of Benefits list and count API.

  Background:
    Given I have the cookie for the following user
      | username       | password |
      | tanu@saavn.com | Tanu1234 |

  Scenario: Verify user is able to fetch the benefits count
    Given I have the endpoint for "BenefitsCountApi"
    When I make the "GET" request
    Then The Benefits Count API returns response with status code 200


  Scenario: Verify user is able to fetch the benefits list
    Given I have the endpoint for "BenefitsListApi"
    When I make the "GET" request
    Then The Benefits List API returns response with status code 200
