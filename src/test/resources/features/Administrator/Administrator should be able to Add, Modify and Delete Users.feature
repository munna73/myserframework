@regressiontest
Feature:  Administrator should able to Add/Modify/Delete conference room users

@smoketest
Scenario: Administrator is able to log in and log out succesfully 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com" 
	Then User log out from the App 

@smoketest
Scenario: Administrator is able to add users 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User goes to Users page
	And User Information table header displays as "First Name" , "Last Name" , "Role" and "Email"
	Then Verify Administrator can add new user as FirstName "sampleFN" , LastName "sampleLN" , Email "sample@sample.com" and Role "Manager"  
	
Scenario: Administrator is able to modify users 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User goes to Users page
	Then Administrator is able to modify exisitng users 
	
Scenario: Adminsitrator is able to delete users 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Go to the Manage Resource Information Page
	And User goes to Users page
	Then Administrator is able to delete existing users 
	