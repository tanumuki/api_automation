Feature: webradio.createFeaturedStation + webradio.getSong

Scenario: Verify if title is generated from getFeaturedStation API

			Given Get the featured station with endpoint "WebRadioGetFeaturedStation"
			When User calls GET method with language param
			|method|language|
			|GET|hindi|
			Then The Radio API returns station ID with status "OK"
			Then Parse the title
			
Scenario: Verify if featured station is getting created from the saved featured stations

	        Given Create feature station with endPoint  "WebRadioCreateFeaturedStation"
	        When User calls GET mehtod with param language
	        |method|language|
			|GET|hindi|
			Then The Radio API returns station ID with status "OK"
			And Parse the featuredStationId 
			When Create GET station with endPoint "WebRadioGetSong"
			When User calls GET method with params next=1 and featured stationId "stationid"
			|method|next|
	          |GET|1|
			Then The Radio API returns station ID with status "OK"
			