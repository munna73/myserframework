@regressiontest
Feature:  Administrator should able to add, update and delete available conference rooms
	
@smoketest
Scenario: Administrator is able to add conference room info 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User go to Conference Rooms
	Then Verify User can add new conf rooms with title "Sample Title" Capacity "10" Comments "Sample Comments" 
	
Scenario: Administrator is able to Edit conference room info 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User go to Conference Rooms
	Then Verify Administrator can edit existing conference rooms
	
Scenario: Administrator is able to Delete conference room info 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User go to Conference Rooms
	Then Verify Administrator can delete existing conference rooms