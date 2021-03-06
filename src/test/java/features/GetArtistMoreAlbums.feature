Feature: artist.getArtistMoreAlbum


	Scenario Outline: Get Artist More Albums for an Artist

		Given Payload with artist more albums endpoint "GetArtistMoreAlbums"
		When User calls Get Artist More Albums api with "<artistid>"
		Then Get Artist More Albums API must respond with status code "OK"
		And User should see the artist more albums response validated
		* Pagination for More Albums API should return the requested content with startindex 0, pagesize 10, max pages 5

		Examples:
			| artistid |
			| 881158   |
			| 565534   |
			| 458135   |


