Feature: Validating Library APIs

# Background: flow till cookie is received
#    Given user hits UserLoginAPI
#  
#        
  Scenario: Verify user library for new user

 
     Given Add payload with get library endpoint "LibraryGetAllAPI" and account credentials for cookie
     When User calls method with below params
       | method | n  | p |
       | GET    | 10 | 1 |
     Then The Library API returns success with status code "OK"
     And Validate the library data for new user
 
    
    
    
    
	Scenario Outline:: Verify user library when a music is added to library
	
	Given Add payload with add library endpoint "LibraryAddAPI" with the same account credentials
	When User calls "<method>" method with below param with "<entity_ids>" and entity_type as "<entity_type>"
	Then The Library API returns success with status code "OK"
	Given User calls social.follow API "SocialFollowAPI" for the same account
	When User calls method with below params for social.follow API
	|method|type|entity_id|
	|GET|playlist|411972074|
	Then The Library API returns success with status code "OK"	
	And Validate the library data by calling endpoint "LibraryGetAllAPI" using same cookie
	When User calls method with below params
       | method | n  | p |
       | GET    | 10 | 1 |
    Then The Library API returns success with status code "OK" 
    And Verify if the added song is present in the response
    
    Examples: 
	|method|entity_ids|entity_type|
	|GET|cd7s24ys|song|
	|GET|3118021|album|
      