# new feature
# Tags: optional

Feature: show.getEpisodeDetails

  Scenario Outline: Get Episode details of the given episode id
    Given Payload with endpoint get episode details "ShowGetEpisodeDetails"
    When User calls the get episode details api with "<episode_id>"
    Then Get episode details api should return response with status code "OK"
    And Get episode details api response is validated successfully

    Examples:
    | episode_id |
    | UpNGpJ_0 |
