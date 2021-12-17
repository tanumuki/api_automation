Feature: benefits.count + benefits.list
  Background:
    Given I login with randomly generated user credentials

  Scenario: Verify user is able to fetch the benefits count
    Given I have the endpoint for "BenefitsCountApi"
    When I make the "GET" request
    Then The Benefits Count API returns response with status code 200

  Scenario: Verify user is able to fetch the benefits list
    Given I have the endpoint for "BenefitsListApi"
    When I make the "GET" request
    Then The Benefits List API returns response with status code 200
