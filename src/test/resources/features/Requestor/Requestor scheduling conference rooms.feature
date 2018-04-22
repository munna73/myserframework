@regressiontest
Feature: Requestor can book a conference room ,Requestor isnot allowed to book a conference room if the conference times exceeds more than 3 hours

@pending
Scenario: Requestor should be able displayed a message when the conferenece room is scheduled for more than 3 hours
	Given User "Requestor" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Requestor can select building, room number and AV equipment
	And Requestor schedules conference room time for more than 3 hours 
	And System displays message as "reservation exceeds more than 3 hours"
	And Requestor corrects the conference room time to less than 3 hors
	Then System allows Requestor to book the conference room

Scenario: Requestor should be able to book a conference room
   Given User "Requestor" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
   When Requestor navigates to Reservations
   Then Requestor can select Room "WORKING" ,AV Equipment "Test" , Building "Bldg1" , Date startime "12" "15" and duration "3 hours 0 minutes" to request room
   	