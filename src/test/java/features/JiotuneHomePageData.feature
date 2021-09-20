# new feature
# Tags: optional

Feature: jiotunepage.getHomepageData

  Scenario: Get Jiotune Homepage data
    Given Payload with jiotune home page data endpoint "JiotuneGetHomepageData"
    When User calls jiotune home page data api
    Then jiotune home page data api should respond with status code "OK"
    And jiotune home page data api response must be validated successfully