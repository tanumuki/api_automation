Feature: user.login

  Scenario: Verify if user is able to login with valid credentials
    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password   |
      | GET    | UserLoginAPI | testdemo12@saavn.com | Saavn@1234 |
    Then The Login API returns success with status code "OK"
    Then I request log out API for the uid
    |  uid |
    | 9a411e4d5e896ab1915b1313db735aad |


  Scenario: Verify if user is able to login with invalid credentials

    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password    |
      | GET    | UserLoginAPI | paypaltest7@saavn.com | Saavn@12344 |
    Then The Login API returns an error message with status code "OK" for invalid credentials


  Scenario: Verify that the user is not able to login more than 3 times in 30 minutes period
    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password   |
      | GET    | UserLoginAPI | testdemo12@saavn.com | Saavn@1234 |

    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password   |
      | GET    | UserLoginAPI | testdemo12@saavn.com | Saavn@1234 |

    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password   |
      | GET    | UserLoginAPI | testdemo12@saavn.com | Saavn@1234 |

    Given Add payload with login endpoint "UserLoginAPI"
    When User calls with method with below params
      | method | endPoint     | username              | password   |
      | GET    | UserLoginAPI | testdemo12@saavn.com | Saavn@1234 |
    Then the user should not be able to login
