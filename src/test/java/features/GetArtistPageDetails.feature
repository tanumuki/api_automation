Feature: Get Artist Page Details
  @wip
  Scenario Outline: Get Artist page details for an artist

    Given Payload with artist page details endpoint "GetArtistPageDetailsAPI"
    When User calls Get Artist Page api with "<artistid>"
    Then Get Artist Page API must respond with status code "OK"
    And User should see the artist page response validated

    Examples:
      | artistid |
#      | 881158   |
      | 7531422  |
#      | 565534   |
#      | 458135   |


