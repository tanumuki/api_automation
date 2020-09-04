Feature: Validating user Radio APIs

Scenario: Verify if station ID is generated

			Given Create the artist station with endpoint "CreateArtistStation"
			When User calls GET method with below params name and query
			|method|name|query|language|
			|GET|a r rahman|a r rahman|hindi|
			Then The Radio API returns station ID with status code "OK"
			And Parse the stationId
		 
Scenario: Verify if radio is playable after passing the station id along with get song parameter

	          Given Fetch the song by adding payload of "WebRadioGetSong"
	      	  When User calls GET method with below param with next =1 and stationid "stationid"
	          |method|next|
	          |GET|1|
			  Then The Radio API returns station ID with status code "OK"
			  And Validate the station response
			  When User calls GET method with below param with next =1 and stationid "stationid"
			  |method|next|
	          |GET|1|
				Then The Radio API returns station ID with status code "OK"
			  And Validate the artist in radio station response