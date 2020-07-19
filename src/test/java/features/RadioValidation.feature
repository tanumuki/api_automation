Feature: Validating user Radio APIs

Scenario: Verify if user is able to play artist radio

		Given Add payload with get create station endpoint "CreateArtistStation" and language "hindi"
		When User calls endpoint "GetSong" with the stationId and next=1	
		Then The API returns success with status code "200"
		And "status" in response body is "OK"
