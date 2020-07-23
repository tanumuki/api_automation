Feature: Validating Library APIs

Scenario: Verify user library

		Given Add payload with get library endpoint "LibraryGetAllAPI" and account credentials for cookie
		When User calls method with below params
		|method|n|p|
		|GET   |10|1|		
		Then The Library API returns success with status code "OK"
				
		
			

