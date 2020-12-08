Feature: Content Get Listening History

  Scenario: Get the listening history for a user and validate all song/episode objects

    Given Payload with Content Get Listening History endpoint "ContentGetListeningHistory" along with the credentials
    When User calls Content Get Listening History API
    Then Get Content Get Listening History API must respond with status code "OK"
    And User should see the Content Get Listening History response validated
    * Pagination for Content Get Listening History API should return the requested content with startindex 0, pagesize 8, max pages 4