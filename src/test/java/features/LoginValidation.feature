Feature: Validating  login APIs

Scenario: Verify if user is able to login

		Given Add payload with login endpoint "UserLoginAPI"
		When User calls with method with below params
		|method|endPoint|username|password|
		|GET|UserLoginAPI|tanu@saavn.com|Tanu1234|
		Then The Login API returns success with status code "OK"




