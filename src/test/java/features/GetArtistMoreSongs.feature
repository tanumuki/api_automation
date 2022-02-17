Feature: artist.getArtistMoreSong

	Scenario Outline: Get Artist More Songs for an Artist

		Given Payload with artist more songs endpoint "GetArtistMoreSongs"
		When User calls Get Artist More Songs api with "<artistid>"
		Then Get Artist More Songs API must respond with status code "OK"
		And User should see the artist more songs response validated
		* Pagination for More Songs API should return the requested content with startindex 0, pagesize 10, max pages 5

		Examples:
			| artistid |
			| 459320   |
#			| 565534   |
#			| 458135   |


