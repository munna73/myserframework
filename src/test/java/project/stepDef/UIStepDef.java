package project.stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.steps.UISteps;
import project.utils.HelperMethods;

public class UIStepDef {
	
	@Steps

	UISteps uiSteps;
	HelperMethods helper;
	

//	@Then("^Verify Landing Page has been loaded$")
//	public void verify_Landing_Page_has_been_loaded() throws Exception {
//		uiSteps.verify_page_is_loaded();
//	}
	
	@Given("^User \"([^\"]*)\" logs in to the application \"([^\"]*)\"$")
	public void user_logs_in_to_the_application(String user, String url) throws Exception {
		uiSteps.user_navigate_to(url);
		uiSteps.verify_application_header_as("The Conference Room");
	
		uiSteps.user_click_on_Log_in_Button();
		
		String userid = null;
		String password = null;
		
		if (user.equalsIgnoreCase("Administrator")){
			userid =  "admin1@unisys.com";
			password = "(Password1)";
			} else if (user.equalsIgnoreCase("Requestor")){
				userid = "requestor1@unisys.com";
				password = "(Password1)";
			} else if (user.equalsIgnoreCase("Manager")){
				userid = "manager1@unisys.com";
				password = "(Password1)";
		}
		uiSteps.user_logged_in_using_userid_and_password(userid, password);
	}
	
	@Then("^Verify Administrator can add new user as FirstName \"([^\"]*)\" , LastName \"([^\"]*)\" , Email \"([^\"]*)\" and Role \"([^\"]*)\"$")
	public void verify_Administrator_can_add_new_user_as_FirstName_LastName_Email_and_Role(String firstName, String lastName, String email, String role) throws Exception {
	    uiSteps.go_to_add_user_page();
		uiSteps.add_user_information_With_firstName_as(firstName);
	    uiSteps.add_user_information_With_lastName_as(lastName);
	    uiSteps.add_user_information_With_email_as(email);
	    uiSteps.add_user_information_With_role_as(role);
	}

	@Given("^Go to the Manage Resource Information Page$")
	public void go_to_the_manage_resource_Information_Page() throws Exception {
		uiSteps.user_goes_to_admin_page();
	}
	
	@When("^User goes to Users page$")
	public void user_goes_to_users_page() throws Exception {
		uiSteps.user_goes_to_users_page();
	}

	@When("^User Information table header displays as \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Information_table_header_displays_as_and(String hdr1, String hdr2, String hdr3, String hdr4) throws Exception {
		uiSteps.user_information_table_header_displays_as(hdr1, hdr2, hdr3 , hdr4);
	}
	
	@Given("^User log out from the App$")
	public void user_log_out_from_the_App() throws Exception {
		uiSteps.user_log_out_from_the_app();
	}
	
	@Then("^Administrator is able to modify exisitng users$")
	public void administrator_is_able_to_modify_exisitng_users() throws Exception {
	    uiSteps.modify_existing_users();
	}
	
	@Then("^Administrator is able to delete existing users$")
	public void administrator_is_able_to_delete_exisitng_users() throws Exception {
	    uiSteps.delete_existing_users();
	}
	
//	Conference Room *********************************************************************
	
	@Given("^User go to Conference Rooms$")
	public void user_go_to_Conference_Rooms() throws Exception {
		uiSteps.go_To_Conference_Rooms();
	}


	@Then("^Verify User can add new conf rooms with title \"([^\"]*)\" Capacity \"([^\"]*)\" Comments \"([^\"]*)\"$")
	public void verify_User_can_add_new_conf_rooms_with_title_Capacity_Comments(String title, String capacity, String comment) throws Exception {
	    uiSteps.user_can_add_conf_with_title_capacity_comment(title, capacity, comment);
	}

	@Then("^Verify Administrator can edit existing conference rooms$")
	public void verify_Administrator_can_edit_existing_conference_rooms() throws Exception {
		uiSteps.user_edit_exsiting_conference_room();
	}

	@Then("^Verify Administrator can delete existing conference rooms$")
	public void verify_Administrator_can_delete_existing_conference_rooms() throws Exception {
		uiSteps.user_delete_exsiting_conference_room();
	}

//	AV Equipment Page ********************************************************************
	@Given("^User go to AV equipment page$")
	public void user_go_to_AV_equipment_page() throws Exception {
		uiSteps.user_go_to_av_equipment_page();
	}


	@Then("^Verify User can add new AV equipment with title \"([^\"]*)\" Description \"([^\"]*)\"$")
	public void verify_User_can_add_new_AV_equipment_with_title_Description(String title, String desc) throws Exception {
		uiSteps.add_new_AV_equipment_with_title_description(title , desc);
	}

	@Then("^Verify Administrator can edit existing AV equipment info$")
	public void verify_Administrator_can_edit_existing_AV_equipment_info() throws Exception {
		uiSteps.edit_existing_av_equipment();
	}

	@Then("^Verify Administrator can delete existing AV equipment info$")
	public void verify_Administrator_can_delete_existing_AV_equipment_info() throws Exception {
		uiSteps.delete_existing_av_equipment();
	}
	
	@When("^Requestor navigates to Reservations$")
	public void requestor_navigates_to_Reservations() throws Exception {
	  uiSteps.navigatetoreservations();
	}


	
	@Then("^Requestor can select Room \"([^\"]*)\" ,AV Equipment \"([^\"]*)\" , Building \"([^\"]*)\" , Date startime \"([^\"]*)\" \"([^\"]*)\" and duration \"([^\"]*)\" to request room$")
	public void requestor_can_select_Room_AV_Equipment_Building_Date_startime_and_duration_to_request_room(
			String room, String avequip, String bldg, String stimehrs,
			String stimemins, String duration) throws Exception {
		uiSteps.bookconferenceroom( room,  avequip,  bldg,  stimehrs,
				 stimemins,  duration);
	}
	
	@When("^Manager clicks on Display a Room Get Started$")
	public void manager_clicks_on_Display_a_Room_Get_Started() throws Exception {
		uiSteps.navigatetodisplayaroom();
	}

	
	@When("^Manager selects a Room \"([^\"]*)\" from the list, report is displayed$")
	public void manager_selects_a_Room_from_the_list_report_is_displayed(String room) throws Exception {
	 uiSteps.generatereport( room);
	}
	
	

}

