# new feature
# Tags: optional

Feature: receipt.list

  Scenario: List all receipts for a given user
    Given I login with randomly generated user credentials
    And I have the endpoint for "ReceiptList"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Receipt list response must be validated successfully