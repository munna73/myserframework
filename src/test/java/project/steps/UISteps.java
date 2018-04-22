package project.steps;

import jline.internal.Log;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pages.AVEquipmentPage;
import project.pages.ConferenceRoomPage;
import project.pages.LandingPage;
import project.pages.ReservationsPage;
import project.pages.SamplePage;
import project.utils.HelperMethods;

/**
 * Scenario steps, can use across multiple scenarios (test cases)
 * @author FDEEXJD
 *
 */
@SuppressWarnings("serial")
public class UISteps extends ScenarioSteps {
	
	SamplePage samplePage;
	LandingPage landingPage;
	ConferenceRoomPage confPage;
	AVEquipmentPage avPage;
	ReservationsPage reservationpage;
	HelperMethods helper;

	@Step
	public void user_navigate_to(String url) {
		getDriver().get(url);
		Log.info("User navigated to the URL = " + url);
		
    	getDriver().manage().window().maximize();
    	Log.info("Browser window has been Maximized");
	}

	@Step
	public void user_logged_in_using_userid_and_password(String userid, String password) {
		landingPage.enterUseridAndPassword(userid, password);
		landingPage.clickonSignIn();
	}

	@Step
	public void user_click_on_Log_in_Button() {
		landingPage.clickOnLogin();
	}

	@Step
	public void user_log_out_from_the_app() {
		landingPage.logout();
	}

	@Step
	public void add_user_information_With_firstName_as(String firstName) {
		landingPage.addNewUserWithFirstName(firstName);
	}
	
	@Step
	public void add_user_information_With_lastName_as(String lastName) {
		landingPage.addNewUserWithLastName(lastName);
	}

	@Step
	public void add_user_information_With_email_as(String email) {
		landingPage.addNewUserWithEmail(email);
	}

	@Step
	public void add_user_information_With_Eqiupment_as(String eqiup) {
		landingPage.selectNewUserWithEquipment(eqiup);
	}

	@Step
	public void add_user_information_With_Building_Room_as(String building, String room) {
		landingPage.selectNewUserWithbuildingRoom(building, room);
	}

	@Step
	public void add_user_information_With_Date_Time_as(String date, String time) {
		landingPage.selectNewUserWithDateTime(date, time);
	}

	@Step
	public void verify_new_users_has_been_added_successfully() {
		landingPage.verifyNewUserIsAdded();
	}

	@Step
	public void user_information_table_header_displays_as(String hdr1, String hdr2, String hdr3, String hdr4) {
		
		landingPage.verifyUserTableHeader(hdr1, hdr2, hdr3, hdr4);
	}

	@Step
	public void verify_application_header_as(String value) {
		landingPage.verifyApplicationHeader(value);
		
	}

	@Step
	public void user_goes_to_admin_page() {
		landingPage.goToManageResourcesAdminPage();
	}

	@Step
	public void add_user_information_With_role_as(String role) {
		landingPage.addNewUserWithRole(role);
		
	}

	@Step
	public void modify_existing_users() {
		landingPage.modifyExistingUsers();
	}

	@Step
	public void delete_existing_users() {
		landingPage.deleteExistingUsers();
	}

	@Step
	public void go_to_add_user_page() {
		landingPage.goToAddUserPage();
	}

	@Step
	public void go_To_Conference_Rooms() {
		confPage.clickOnConferenceRooms();
	}

	@Step
	public void user_can_add_conf_with_title_capacity_comment(String title, String capacity, String comment) {
		confPage.addNewConfRoom(title, capacity, comment);
	}

	@Step
	public void user_edit_exsiting_conference_room() {
		confPage.editExistingConfRoom();
	}

	@Step
	public void user_delete_exsiting_conference_room() {
		confPage.deleteExistingConfRoom();
	}
	
	@Step
	public void user_goes_to_users_page() {
		landingPage.goToUsersPage();
	}

	@Step
	public void user_go_to_av_equipment_page() {
		avPage.goToAVEquipmentPage();
	}

	@Step
	public void add_new_AV_equipment_with_title_description(String title, String desc) {
		avPage.addAVEqipment(title, desc);
	}

	@Step
	public void edit_existing_av_equipment() {
		avPage.editAVEquipment();
	}

	@Step
	public void delete_existing_av_equipment() {
		avPage.deleteAVEquipment();
	}

	@Step
	public void navigatetoreservations() {
		landingPage.navigateToReservationsPage();
		
	}

	@Step
	public void bookconferenceroom(String room, String avequip, String bldg, String stimehrs,
			String stimemins, String duration) {
		reservationpage.bookconferenceroom( room,  avequip,  bldg,  stimehrs,
				 stimemins,  duration);
		
	}
	@Step
	public void navigatetodisplayaroom() {
		
		reservationpage.navigatetodisplayaroom();
	
		
	}

	@Step
	public void generatereport(String room) {
		reservationpage.generatereport(room);
		
		
	}

}
