Feature: channel.getDetails

  Scenario Outline: Get details of the channel for the given channel id
    Given I have the endpoint for "ChannelGetDetailsAPI"
    When I make the "GET" request with the following query parameters
    | channel_id   |
    | <channel_id> |
    Then I validate status code with "OK"
    And Channel get details api response must be validated successfully

    Examples:
    | channel_id  |
    |     27      |
    |     29      |