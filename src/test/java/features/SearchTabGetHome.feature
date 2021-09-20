# new feature
# Tags: optional

Feature: search_tab.getsearchhomepage

  Scenario Outline: Get Search grid Home page
#    Given Payload with search grid home page endpoint "SearchTabHomePage"
    Given I have the endpoint for "SearchTabHomePage"
#    When User call search grid get home page api with "<page>" and "<next_sign>"
    When I make the "GET" request with the following query parameters
      |page | next_sign|
      | <pages> | <next>|
    Then I validate status code with "OK"
    And Search grid home page api response must be validated successfully

    Examples:
    | pages  | next |
    |   1   |     1     |