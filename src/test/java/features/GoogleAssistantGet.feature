Feature: google_assistant.get

  Scenario Outline: Starts station with Get Google Assistant
    Given Payload with the GoogleAssistantGet endPoint "GoogleAssistantGet"
    When User calls the given request with "<query>"
    Then User should get response with "OK" status code
    And GoogleAssistantGet response should be validated against the query
    And User calls "WebRadioGetSong" API
    And User calls the WebRadioGetSong request with stationID
    And WebRadioGetSong response should be validated and return "OK" status code

    Examples:
    | query                       |
    | mujhe kaise pata na chala   |
    | blinding lights             |
    | neha kakkar                 |

