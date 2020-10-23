# new feature
# Tags: optional

Feature: List all the receipts for a given user

  Scenario: List all receipts for a given user
    Given Payload with receipt list endpoint "ReceiptList" along with given credentials
    When User calls receipt list api
    Then Receipt list api must respond with code "OK"
    And Receipt list response must be validated successfully