Feature: Validating Library APIs




    Background: flow till cookie is received
    Given user hits "UserLoginAPI"
  
        

  Scenario: Verify user library for new user

    Given Add payload with get library endpoint "LibraryGetAllAPI" and account credentials for cookie
    When User calls method with below params
      | method | n  | p |
      | GET    | 10 | 1 |
    Then The Library API returns success with status code "OK"
    And Validate the library data for new user
    
    
	Scenario: Verify user library when a music is added to library
	
	Given Add payload with add library endpoint "LibraryAddAPI" with the same account credentials
	When User calls method with below param
	|method|entity_ids|entity_type|
	|GET|cd7s24ys|song|
	Then The Library API returns success with status code "OK"
	And Validate the library data by calling endpoint "LibraryGetAllAPI"
	
	 		
			

