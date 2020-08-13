Feature: Validating Artist More Albums details

	Scenario Outline: Get Artist More Albums for an Artist

		Given Payload with artist more albums endpoint "GetArtistMoreAlbums"
		When User calls Get Artist More Albums api with "<artistid>"
		Then Get Artist More Albums API must respond with status code "OK"
		And User should see the artist more albums response validated

		Examples:
			| artistid |
			| 459320   |
			| 565534   |
			| 458135   |


