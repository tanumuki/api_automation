Feature: content.getListeningHistory

  Scenario: Get the listening history for a user and validate all song/episode objects

    Given I login with randomly generated user credentials
    Given I have the endpoint for "ContentGetListeningHistory"
    When I make the "GET" request
    Then I validate status code with "OK"
    And User should see the Content Get Listening History response validated
#    * Pagination for Content Get Listening History API should return the requested content with startindex 0, pagesize 8, max pages 4