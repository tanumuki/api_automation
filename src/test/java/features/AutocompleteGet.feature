Feature: Search queries using autocompleteGet
  
Scenario Outline: Search for album and verify the results

  Given Add payload with search endpoint "<endpoint>"    
  When User calls "GET" https request for queries in file "<queryFilePath>"
  Then Api should return response with status code "200"    
  Then I should see response with JSON validation
  And "status" in response body is "OK"

Examples: 
  |endpoint|queryFilePath|
  |AutocompleteGet|SearchQueries.txt|
    
