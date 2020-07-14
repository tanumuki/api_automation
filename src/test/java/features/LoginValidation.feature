Feature: Validating user login APIs

Scenario Outline: Verify if user is able to login

		Given Add payload with login endpoint "<endPoint>" 
		When User calls "GET" https request with username "<username>" and password "<password>"
		Then The API returns success with status code "200"
		Then I should see the response with json validation
		And "status" in response body is "OK"
		
Examples: 
			|endPoint|username|password|
			|UserLoginAPI|tanu@saavn.com|Tanu1234|


