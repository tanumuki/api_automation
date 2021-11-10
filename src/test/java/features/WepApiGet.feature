Feature: webapi.get

  Scenario Outline: Get Album details for given albumId
    Given Payload with endPoint "WebApiGet" with given "<ctx>"
    When User calls https request with "<token>", "<type>", "<n>" and "<p>"
    Then The response should be validated with status code "OK"
    And The response should be validated for all the fields

    Examples:
      | ctx      | token        | type     | p | n |
      | web6dot0 | 8MT-LQlP35c_ | playlist | 1 | 5 |
      | wap6dot0 | 8MT-LQlP35c_ | playlist | 1 | 5 |
