# new feature
# Tags: optional

Feature: seo.getMetaResponse

  Scenario Outline: Get Meta response for the given input params
    Given Payload with endpoint getMetaResponse "SEOgetMetaResponse"
    When User calls getMetaResponse api with "<type>", "<id>" and "<partner>"
    Then getMetaResponse api must return response code "OK"
#    And getMetaResponse response must be validated successfully

    Examples:
    |   type    |     id    |   partner |
    | playlist  | 41605 | holidify  |
    | album     | 1455069   | holidify  |
    | artist    | 468067    | holidify  |
    | song      | yshGBwsU  | holidify  |