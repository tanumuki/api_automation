Feature: Validating Library APIs

  Scenario: Verify user library for new user
     Given Add payload with get library endpoint "LibraryGetAllAPI" and account credentials for cookie
     When User calls method with below params
       | method | n  | p |
       | GET    | 10 | 1 |
     Then The Library API returns success with status code "OK"
     And Validate the library data for new user



  Scenario: Verify get album details for the user
     Given Add payload with get library endpoint "ContentGetAlbumDetails"
     When User calls method with album id as param
       | method |albumid|
       | GET    |3118021|
     Then The Library API returns success with status code "OK"



	Scenario Outline: Verify user library when a music is added to library

	Given Add payload with add library endpoint "LibraryAddAPI" with the same account credentials
	When User calls "<method>" method with below param with "<entity_ids>" and entity_type as "<entity_type>"
	Then The Library API returns success with status code "OK"

    Examples:
	|method|entity_ids|entity_type|
	|GET|cd7s24ys|song|
	|GET|3118021|album|

	Scenario: Verify the response by calling library get all method

	Given Validate the library data by calling endpoint "LibraryGetAllAPI" using same cookie
	When User calls method with below params
       | method | n  | p |
       | GET    | 10 | 1 |
    Then The Library API returns success with status code "OK"
    And Verify if the added song is present in the response

    Scenario Outline: Verify the response afte deleting the objects by calling library.delete API

    Given Validate the library data by calling library delete endpoint "LibraryDelete" using same cookie
	When User calls "<method>" method with below param with "<entity_ids>" and entity_type as "<entity_type>"
	Then The Library API returns success with status code "OK"

    Examples:
	|method|entity_ids|entity_type|
	|GET|cd7s24ys|song|
	|GET|3118021|album|

	Scenario: Verify the response by calling library get all method after deleting the song and album

	Given Validate the library data by calling endpoint "LibraryGetAllAPI" using same cookie
	When User calls method with below params
       | method | n  | p |
       | GET    | 10 | 1 |
    Then The Library API returns success with status code "OK"
    And Verify if the song and album are not present in the response

  Scenario Outline: Verify the response of the library get details by passing the params

    Given I have the cookie for the following user
      | username              | password   |
      | paypaltest7@saavn.com | Saavn@1234 |
    Given I have the endpoint for "LibraryGetDetails"
    When User calls the method "<method>" below params "<entity_ids>", "<entity_type>", "<n>" and "<p>"
    Then User validates "OK" status code
    And Validate the library details for the user against the params

    Examples:
    |method | entity_ids        | entity_type | n  | p |
    | GET   | 3118021           | album       | 10 | 1 |
    | GET   | 455142            | artist      | 10 | 1 |
    | GET   | 74816             | show        | 5  | 1 |
    | GET   | 3eMvTzCO,90_xiy44 | song        | 10 | 1 |
#    | GET   | 158826102  | playlist    | playlist |
#    | GET   | JemPuqKI   | video       | video  |

#  TODO: Snigdha to handle the other two entities for library.getDetails()





      