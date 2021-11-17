# THIS API IS DEPRECATED
#Feature: browse.getAll
#
#  Scenario: Get all channels of browse
#    Given I have the cookie for the following user
#      | username | password |
#      | ai370@saavn.com | Saavn123 |
#    Given I have the endpoint for "BrowseGetAll"
#    When I make the "GET" request
#    Then Browse get all api should return with status code "OK"
#    And Browse get all response must be validated successfully