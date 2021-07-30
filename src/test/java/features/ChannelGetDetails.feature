# new feature
# Tags: Optional

Feature: Get details of the channel for the given channel id

  Scenario Outline: Get details of the channel for the given channel id
    Given Payload with Channel get details api "ChannelGetDetailsAPI"
    When User calls the channel get details with given "<channel_id>"
    Then Channel get details api must respond with status "OK"
    And Channel get details api response must be validated successfully

    Examples:
    | channel_id  |
    |     27      |
    |     29      |