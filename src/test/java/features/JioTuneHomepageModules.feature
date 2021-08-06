Feature: JioTune Homepage Modules APIs:
  jiotunepage.getDecades
  jiotunepage.getMoodGenres
  jiotunepage.getArtists
  jiotunepage.getTopJiotune

  Scenario Outline: Verify the API response of Decades page
    Given I have the endpoint for "<endPoints>"
    When I make the "GET" request with the following query parameters
    | n  | p |
    | 25 | 1 |
    And I validate status code with "OK"
    Then I validate the response of API call

    Examples:
    | endPoints                |
    | JiotunepageGetDecades    |
    | JiotunepageGetMoodGenres |
    | JiotunepageGetArtists    |
    | JiotunepageGetTopJiotune |





