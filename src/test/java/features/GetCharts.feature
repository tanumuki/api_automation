# new feature
# Tags: optional

Feature: Get all the charts

  Scenario: Get All the charts
    Given Payload with get all contents endPoint "GetAllChartsAPI"
    When User calls Get All contents api
    Then Get All contents must respond with status code "OK"
    And User should successfully validate the Get All contents response