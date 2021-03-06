Feature: user.changePassword

  Background:
    Given I login with randomly generated user credentials

  Scenario: Verify user is able to change account password
    Given I have the endpoint for "UserChangePasswordApi"
    When I make the "GET" request with the following query parameters
      | oldpassword | password  |
      | Saavn@1234  | Saavn@123 |
    Then The User Change Password API returns "success" with status code 200 and response message as "Your password has been changed."

#    to change password back to original password
    And I have the endpoint for "UserChangePasswordApi"
    And I make the "GET" request with the following query parameters
      | oldpassword | password   |
      | Saavn@123   | Saavn@1234 |

  Scenario: Verify user gets an error message when it enters an incorrect current password
    Given I have the endpoint for "UserChangePasswordApi"
    When I make the "GET" request with the following query parameters
      | oldpassword | password  |
      | Saavn!123   | Saavn@123 |
    Then The User Change Password API returns "failure" with status code 200 and response message as "Incorrect current password. Please try again."

  Scenario: Verify user gets an error message when it enters an same current and new password
    Given I have the endpoint for "UserChangePasswordApi"
    When I make the "GET" request with the following query parameters
      | oldpassword | password   |
      | Saavn@1234  | Saavn@1234 |
    Then The User Change Password API returns "failure" with status code 200 and response message as "Current password and new password are same"
