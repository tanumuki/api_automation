Feature: content.decodeTokenAndFetchResults

  Background:
    Given I have the cookie for the following user
      | username              | password   |
      | paypaltest7@saavn.com | Saavn@1234 |

  Scenario Outline: Verify response of Content Decode Token and Fetch Results API
    Given I have the endpoint for "ContentDecodeTokenAndFetchResults"
    And I make the "GET" request with the following query parameters
      | type    | token    |
      | <types> | <tokens> |
    Then The Content Decode and Fetch Token API returns response with status code 200 for entity type "<entity_type>"
    Then I request log out API for the uid
      | uid                              |
      | 44daa4ad2573f45bedff9665c28bb453 |
    Examples:
      | types    | tokens          | entity_type   |
      | channel  | 0iLyYIH5zO8_    | Shorties      |
      | artist   | LlRWpHzy3Hk_    | Artists       |
      | song     | QSFZZBUAREE     | Songs         |
      | album    | kLG-OKbVmvM_    | Albums        |
      | playlist | AARQCUcEAQNWTVA | Playlists     |
      | show     | LT7jKx2kHgw_    | Shows         |
      | channel  | SqI6f167Uoo_    | Channels      |
      | episode  | lGDDkbquims_    | Episodes      |
      | playlist | AARQAEYBBgtYRg  | User Playlist |

