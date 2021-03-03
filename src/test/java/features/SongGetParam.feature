Feature: Validation of song get param API.

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | Saavn123 |


  Scenario Outline: Verify user is able to get song param values
    Given I have the endpoint for "SongGetParamsApi"
    When I make the "GET" request with the following query parameters
      | pids   | fields   |
      | <pids> | <fields> |
    Then Song Get Param API returns response with status code 200 and pid as "<pids>" and field as "<fields>"
    Examples:
      | pids     | fields                    |
      | S3dGvXSb | more_info.vcode           |
      | S3dGvXSb | more_info.vlink           |
      | PIzj75J8 | more_info.shortie         |
      | PIzj75J8 | more_info.video_available |
#      for future implementation
#      | PIzj75J8 | more_info.videos          |
