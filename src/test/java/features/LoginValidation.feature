Feature: Validating user login APIs

Scenario Outline: Verify if user is able to login

		Given Add login payload with context "<ctx>" and user calls "<endPoint>" with get http request with username as "<username>" and password as "<password>"
		When User calls "GET" https request 
		Then The API returns success with status code "200"
		And "status" in response body is "OK"
		
Examples: 
			|ctx|endPoint|username|password|
			|android|UserLoginAPI|tanu@saavn.com|Tanu1234|


