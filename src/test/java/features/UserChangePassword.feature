Feature: Validation of User Change Password API

  Background:
    Given I have the cookie for the following user
      | username        | password |
      | user1@saavn.com | Saavn123 |

  Scenario: Verify user is able to change account password
    Given I have the endpoint for "UserChangePasswordApi"
    When I make the "GET" request with the following query parameters
      | oldpassword | password  |
      | Saavn123    | Saavn@123 |
    Then The User Change Password API returns "success" with status code 200 and response message as "Your password has been changed."
#    to change password back to original password
    And I have the cookie for the following user
      | username        | password  |
      | user1@saavn.com | Saavn@123 |
    And I have the endpoint for "UserChangePasswordApi"
    And I make the "GET" request with the following query parameters
      | oldpassword | password |
      | Saavn@123   | Saavn123 |

  Scenario: Verify user gets an error message when it enters an incorrect current password
    Given I have the endpoint for "UserChangePasswordApi"
    When I make the "GET" request with the following query parameters
      | oldpassword | password  |
      | Saavn!123   | Saavn@123 |
    Then The User Change Password API returns "failure" with status code 200 and response message as "Incorrect current password. Please try again."

  Scenario: Verify user gets an error message when it enters an same current and new password
    Given I have the endpoint for "UserChangePasswordApi"
    When I make the "GET" request with the following query parameters
      | oldpassword | password |
      | Saavn123    | Saavn123 |
    Then The User Change Password API returns "failure" with status code 200 and response message as "Current password and new password are same"