@regressiontest
Feature:  Administrator should able to update AV equipment list  
		
@smoketest 
Scenario: Administrator is able to add AV equipment info 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User go to AV equipment page
	Then Verify User can add new AV equipment with title "Sample Title" Description "This is a Description" 

Scenario: Administrator is able to update AV equipment info
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User go to AV equipment page
	Then Verify Administrator can edit existing AV equipment info

Scenario: Administrator is able to delete AV equipment info
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User go to AV equipment page
	Then Verify Administrator can delete existing AV equipment info