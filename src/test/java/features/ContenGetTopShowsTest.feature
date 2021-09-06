Feature: content.getTopShows

  Scenario: Get all top shows
    Given Payload with endpoint content get top shows "ContentGetTopShows"
    When User calls get top shows api
    Then Get top shows must respond with status code "OK"
    And Get top shows api response must be validated successfully

  Scenario Outline: Test Pagination for top shows
    Given Payload with endpoint content get top shows "ContentGetTopShows"
    When User calls get top shows api with "<page_no>" and "<items_per_page>"
    Then Get top shows must respond with status code "OK"
    And Get top shows api response must be validated successfully

    Examples:
    | page_no | items_per_page |
    |   11    |       10       |