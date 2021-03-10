Feature: Validation of Matching Match API

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | Saavn123 |

  Scenario Outline: Verify response of matching matach API
    Given I have the endpoint for "MatchingMatchApi"
    And I make the "GET" request with the following query parameters
      | url   |
      | <url> |
    Then The Matching Match API returns response with status code 200 and the entity type matches with the "<url>"
    Examples:
      | url                                                                                            |
      | https://www.jiosaavn.com/s/playlist/44daa4ad2573f45bedff9665c28bb453/Songs/Po6,Q5ihUrU_        |
      | https://www.saavn.com/s/song/hindi/Rustom/Tere-Sang-Yaara/Gz4saBxBGkE                          |
      | https://www.saavn.com/s/channel/New-Year-Resolutions-2021/Hg90Ec5G-5U_                         |
      | https://www.saavn.com/s/featured/english/hit_factory_-_weekly_jukebox/P1o6qMoHpBnuCJW60TJk1Q__ |
      | https://www.saavn.com/s/artist/arijit-singh-albums/LlRWpHzy3Hk_                                |
      | https://www.saavn.com/s/show/NoFilterNeha/11/Shilpa-Shetty                                     |
      | https://www.saavn.com/s/show/nofilterneha/1/LT7jKx2kHgw_                                       |
      | https://www.saavn.com/p/album/punjabi/desi-jatt-2020/rNflbxPcjQE_                              |
      | https://www.saavn.com/s/radio/english-featured-station/Kiddie-Pop                              |