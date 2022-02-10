# new feature
# Tags: Optional


Feature: Get details of the socialFollowing for the given uid

  Scenario Outline: Get details of the Followings for the given uid
    Given Payload with Following get details api "SocialGetFollowing"
    When User calls the Following details with given "<uid>"
    Then Following get details api must respond with status "OK"
    And Following get details api response must be validated successfully
    Examples:
      | uid  |
      | vinsforever5577723 |
      ##| ea910735b42f9eb30994a6dddf1ec365 |

