@regressiontest
Feature: Reservation Manager shall be able to access to a report for occupancy and vacancy rate of each conference room which is exportable with data depicted as a histogram.
         
@pending
  Scenario: Reservation Manager can create report of occupancy and vacancy rate of conference rooms
	Given User "Manager" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
    When Reservation Manager is able to create report of occupancy and vacancy rate
    Then Reservation Manager can export data and graphs
    Then Data exported should show occupancy and vacancy rate of the conference rooms
    
@smoketest
 Scenario: Reservation Manager can create report of occupancy and vacancy rate of conference rooms
 	Given User "Manager" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
 	When Manager clicks on Display a Room Get Started 
 	When Manager selects a Room "WORKING" from the list, report is displayed 
         