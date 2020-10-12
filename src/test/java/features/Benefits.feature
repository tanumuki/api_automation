@WIP
Feature: Validation of Benefits list and count API.

  Background:
    Given I have the cookie for the following user
      | username               | password |
      | 09242020test@saavn.com | Saavn123 |

  Scenario: Verify user is able to fetch the benefits count
    Given I have the endpoint for "BenefitsCountApi"
    When I make the "GET" request
#    Then The Social Follow API returns "success" with status code 200


  Scenario: Verify user is able to fetch the benefits list
    Given I have the endpoint for "BenefitsListApi"
    When I make the "GET" request
