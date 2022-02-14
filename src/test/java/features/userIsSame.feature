Feature: user.isSame

  Scenario:
Given I have the cookie for the following user
      |username|password|
      |vinsforever5577@gmail.com|Testing5577|
Then I request log out API for the uid
|uid|
|vinsforever5577723 |
Given I have the cookie for the following user
|username|password|
| vinstest57@saavn.com  | Testing5577 |
Given I have the endpoint for "UserIsSameAPI"
When I make the "GET" request with the following query parameters
| uid |
| fd135ba8e7777a130625347e063236d5 |
 And Clear Downloads pop up should be validated

