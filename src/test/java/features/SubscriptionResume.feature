Feature: subscription.resume
  Scenario: User should resume subscription successfully
    Given I have the cookie for the following user
      |username|password|
      |prodads@saavn.com|Saavn123|
    Given I have the endpoint for "SubscriptionUnsubscribeAPI"
    Given I have the endpoint for "SubscriptionResumeAPI"
    Then I make the "GET" request
    And Subscription Resume API response must be validated successfully