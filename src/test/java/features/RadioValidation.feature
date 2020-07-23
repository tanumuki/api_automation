#Feature: Validating user Radio APIs
#
#Scenario: Verify if station ID is generated
#
#		Given Add payload with endpoint "CreateArtistStation"
#		When User calls GET method with below params
#		|method|name|query|
#		|GET|sonu|sonu|
#		Then The Radio API returns station ID with status code "OK"
#
#Scenario: Verify if radio is playable after passing the station id along with get song parameter
#
#          Given Add payload with endpoint "WebRadioGetSong"
#      	  When User calls GET method with below params
#          |method|next|
#          |GET|1|
#		 Then The Radio API returns station ID with status code "OK"
