# new feature
# Tags: optional

Feature: subscription.getStatus

  Scenario: Gets the subscription status without include receipt
    Given I login with randomly generated user credentials
    And I have the endpoint for "SubscriptionGetStatus"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Subs get status api response is validated successfully
#    Then I request log out API for the uid
#      |  uid |
#      | 175499cbb6cf36cbe9476f0860b1ddf4 |

  Scenario Outline: Gets the subscription status
    Given I login with randomly generated user credentials
    And I have the endpoint for "SubscriptionGetStatus"
    When I make the "GET" request with the following query parameters
    | include_receipt  |
    | <include_receipt> |
    Then I validate status code with "OK"
    And Subs get status api response is validated successfully
#    Then I request log out API for the uid
#      |  uid |
#      | 175499cbb6cf36cbe9476f0860b1ddf4 |

    Examples:
    | include_receipt |
    | true            |
    | false           |


