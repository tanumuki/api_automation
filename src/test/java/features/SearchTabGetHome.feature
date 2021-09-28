# new feature
# Tags: optional

Feature: search_tab.getsearchhomepage

  Scenario Outline: Get Search grid Home page
    Given I have the endpoint for "SearchTabHomePage"
    When I make the "GET" request with the following query parameters
      |page | next_sign|
      | <pages> | <next>|
    Then I validate status code with "OK"
    And Search grid home page api response must be validated successfully

    Examples:
    | pages  | next |
    |   1   |     1     |