Feature: content.getTopShows

  Scenario: Get all top shows
    Given I have the endpoint for "ContentGetTopShows"
    When I make the "GET" request
    Then I validate status code with "OK"
    And Get top shows api response must be validated successfully

  Scenario Outline: Test Pagination for top shows
    Given I have the endpoint for "ContentGetTopShows"
    When I make the "GET" request with the following query parameters
    | page_no  | items_per_page   |
    |<page_no> | <items_per_page> |
    Then I validate status code with "OK"
    And Get top shows api response must be validated successfully

    Examples:
    | page_no | items_per_page |
    |   11    |       10       |