Feature: Validating user Radio APIs

  Scenario: Verify if station ID is generated

    Given Create the artist station with endpoint "CreateArtistStation"
    When User calls GET method with below params name and query
      | method | name       | query      | language |
      | GET    | a r rahman | a r rahman | hindi    |
    Then The Radio API returns station ID with status code "OK"
    And Parse the stationId

  Scenario: Verify if radio is playable after passing the station id along with get song parameter

    Given Fetch the song by adding payload of "WebRadioGetSong"
    When User calls GET method with below param with next =1 and stationid "stationid"
      | method | next |
      | GET    | 1    |
    Then The Radio API returns station ID with status code "OK"
    And Validate the station response
    When User calls GET method with below param with next =1 and stationid "stationid"
      | method | next |
      | GET    | 1    |
    Then The Radio API returns station ID with status code "OK"
    And Validate the artist in radio station response


  Scenario: Verify song radio is created
    Given I have the endpoint for "WebRadioCreateStation"
      | username | password |
      | sun@s.in | saavn123 |
    When I make the "GET" request with the following query parameters
      | query         | mode     | pid      |
      | Meri Aashiqui | discover | 56BDZXY- |
    Then The create station returns status code 200
    And I parse the stationId

  Scenario: Verify song radio is playable
    Given I have the endpoint for "WebRadioGetSong"
      | username | password |
      | sun@s.in | saavn123 |
    When I make the "GET" request with the following query parameters and the station Id
      | k | type    |
      | 5 | scratch |
    Then The Web Radio Get Song API returns response with status code 200

  Scenario: Verify playlist radio is created
    Given I have the endpoint for "WebRadioCreateEntityStation"
      | username | password |
      | sun@s.in | saavn123 |
    When I make the "GET" request with the following query parameters
      | mode     | entity_type | entity_id                                                                                                                                                                                                          |
      | discover | queue       | ["MWk8kfwt","vX2v9Orm","eseCEtC8","aknAX8Fr","ktEA5hKT","bQbXpPby","iprLqckr","zxVrHL0j","DTCtgv78","wdCdmeKl","ERfYw4Ay","t6PdrExF","1rV4UY9B","ixFkIAmP","fVOmobci","zfYRn6l8","c8S4M5w2","ChAXSJ-i","N3GOvNcO"] |
    Then The create entity station returns status code 200
    And I parse the stationId

  Scenario: Verify playlist radio is playable
    Given I have the endpoint for "WebRadioGetSong"
      | username | password |
      | sun@s.in | saavn123 |
    When I make the "GET" request with the following query parameters and the station Id
      | k | type    |
      | 5 | scratch |
    Then The Web Radio Get Song API returns response with status code 200






