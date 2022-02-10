# new feature
# Tags: Optional


Feature: Get details of the socialFollowers for the given uid

	Scenario Outline: Get details of the Followers for the given uid
		Given Payload with Followers get details api "SocialGetFollowers"
		When User calls the Followers details with given "<uid>"
		Then Followers get details api must respond with status "OK"
		And Followers get details api response must be validated successfully
		Examples:
			| uid  |
			| vinsforever5577723 |
		##	| ea910735b42f9eb30994a6dddf1ec365 |


