# new feature
# Tags: optional

Feature: receipt.list

  Scenario: List all receipts for a given user
    Given Payload with receipt list endpoint "ReceiptList" along with given credentials
    When User calls receipt list api
    Then Receipt list api must respond with code "OK"
    And Receipt list response must be validated successfully
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |