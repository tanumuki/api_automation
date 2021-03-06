Feature: user.getUpdatedlink()

  Background:
    Given I have the cookie for the following user
      | username | password |
      | paypaltest7@saavn.com | Saavn@1234 |

# The url+userid in the example is sent for the resource and encrypted static userid
# which gets validated with the url from response in its Validator class
  Scenario Outline: User gets the updated link given through the parameter (deeplink support)
    Given I have the endpoint for "UserGetUpdatedLink"
    When I make the "GET" request with the following query parameters
    | url   |
    | <url> |
    Then I validate status code with "OK"
    And I validate the response against the passed query parameter "<url>" and userId "<url_userid>"
    Given I have the endpoint for "UserLogoutAPI"
    When I make the "GET" request with the following query parameters
      | uid                              |
      | 175499cbb6cf36cbe9476f0860b1ddf4 |
    Then The User Logout API returns "success" with status code 200

    Examples:
    | url                                                                 | url_userid                                               |
    | jiosaavn://openLogUBrowser/url=https://www.jiosaavn.com/stream2win/ | stream2win/9GCrq81nsnNkjM1.hbzqgbgKKtt3FVAtQ-0wNAKBrvc_  |
    | https://www.jiosaavn.com/stream2win/                                | stream2win/9GCrq81nsnNkjM1.hbzqgbgKKtt3FVAtQ-0wNAKBrvc_  |

