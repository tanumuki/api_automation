Feature: user.login

  Scenario: Verify if user is able to login with valid credentials
    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password   |
      | GET    | UserLoginAPI | paypaltest7@saavn.com | Saavn@1234 |
    Then The Login API returns success with status code "OK"

  Scenario: Verify if user is able to login with invalid credentials

    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password    |
      | GET    | UserLoginAPI | paypaltest7@saavn.com | Saavn@12344 |
    Then The Login API returns an error message with status code "OK" for invalid credentials


