Feature: Validation of Content Decode Token and Fetch Results API

  Background:
    Given I have the cookie for the following user
      | username | password |
      | sun@s.in | Saavn123 |

  Scenario Outline: Verify Content Decode Token and Fetch Results API for shorties
    Given I have the endpoint for "ContentDecodeTokenAndFetchResults"
    And I make the "GET" request with the following query parameters
      | type    | token    |
      | <types> | <tokens> |
    Then The Content Decode and Fetch Token API returns response with status code 200 for entity type "<entity_type>"
    Examples:
      | types    | tokens         | entity_type    |
      | channel  | 0iLyYIH5zO8_    | Shorties    |
      | artist   | LlRWpHzy3Hk_    | Artists     |
      | song     | QSFZZBUAREE     | Songs       |
      | album    | kLG-OKbVmvM_    | Albums      |
      | playlist | AARQCUcEAQNWTVA | Playlists   |
      | show     | LT7jKx2kHgw_    | Shows       |
      | channel  | SqI6f167Uoo_    | Channels    |
      | episode  | lGDDkbquims_    | Episodes    |
      | playlist | AARQAEYBBgtYRg | User Playslist |

