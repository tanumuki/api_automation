# new feature
# Tags: optional

Feature: subscription.getStatus

  Scenario: Gets the subscription status without include receipt
    Given Payload with endpoint subs get status "SubscriptionGetStatus" with the given credentials
    When User calls subs get status api without include receipt
    Then Subs get status api responds with the status code "OK"
    And Subs get status api response is validated successfully

  Scenario Outline: Gets the subscription status
    Given Payload with endpoint subs get status "SubscriptionGetStatus" with the given credentials
    When User calls subs get status api with the "<include_receipt>" flag
    Then Subs get status api responds with the status code "OK"
    And Subs get status api response is validated successfully

    Examples:
    | include_receipt |
    | true            |
    | false           |


