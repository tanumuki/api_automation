# new feature
# Tags: optional

Feature: Get all the channels

  Scenario: Get all the channels
    Given Payload with get all Channels endPoint "GetAllChannelsAPI"
    When User calls Get All channels api
    Then Get All Channels must respond with status code "OK"
    And User should see the channel response validated