Feature: Get Artist Similar Artists

	Scenario Outline: Get Similar artists for an Artist

		Given Payload with similar artists endpoint "GetArtistSimilarArtists"
		When User calls Get Similar Artists api with "<artistid>"
		Then Get Similar Artists API must respond with status code "OK"
		And User should see the similar artists response validated

		Examples:
			| artistid |
			| 459320   |
#			| 565534   |
#			| 458135   |


