# new feature
# Tags: optional

Feature: show.getEpisodeDetails

  Scenario Outline: Get Episode details of the given episode id
    Given I have the endpoint for "ShowGetEpisodeDetails"
    When I make the "GET" request with the following query parameters
      |episode_id|
      | <eps>    |
    Then I validate status code with "OK"
    And Get episode details api response is validated successfully

    Examples:
    | eps |
    | UpNGpJ_0 |
