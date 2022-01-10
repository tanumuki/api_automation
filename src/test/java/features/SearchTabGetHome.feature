# new feature
# Tags: optional

Feature: search_tab.getsearchhomepage

  Scenario Outline: Get Search grid Home page
    Given Payload with search grid home page endpoint "SearchTabHomePage"
    When User call search grid get home page api with "<page>" and "<next_sign>"
    Then Search grid home page api must respond with status code "OK"
    And Search grid home page api response must be validated successfully

    Examples:
    | page  | next_sign |
    |   1   |     1     |