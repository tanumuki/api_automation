Feature: webradio.createEntityStation

  Scenario Outline: Starts any entity station with entity_id and entity_type
    Given I have the endpoint for "WebRadioCreateEntityStation"
    When I make the "GET" request with the following query parameters
    | entity_type   | entity_id   |
    | <entity_type> | <entity_id> |
    Then I validate status code with "OK"
    Then CreateEntityStation response should be validated against the query
    When I have the endpoint for "WebRadioGetSong"
    And User calls the WebRadioGetSong request with received stationID
    And WebRadioGetSong response should be validated with statuscode "OK"

    Examples:
    | entity_type | entity_id |
    | album       | 3118021   |
    | playlist    | 82859880  |

