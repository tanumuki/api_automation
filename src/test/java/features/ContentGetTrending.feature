Feature: Validating Trending API for all types

	Scenario: Get the trending items and validate

		Given Payload with content get trending endpoint "GetTrending"
		When User calls Content Get Trending API
		Then Get Content Get Trending API must respond with status code "OK"
		And User should see the Content Get Trending response validated
		* Pagination for Content Get Trending API should return the requested content with startindex 1, pagesize 10, max pages 3