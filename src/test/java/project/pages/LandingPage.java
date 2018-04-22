package project.pages;

import jline.internal.Log;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import project.utils.HelperMethods;
import project.utils.Utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.ibm.icu.impl.duration.impl.Utils;

/**
 * Page Object for Manifest Generator page
 * 
 * @author Saikat Barua
 *
 */

public class LandingPage extends PageObject {

	HelperMethods helper = new HelperMethods();
	Utilities util = new Utilities();

	// PAGE OBJECTs are located Here
	// *********************************HEADERs*******************************
	@FindBy(css = "table > thead")
	private WebElementFacade hdr_UserInfoTable;

	@FindBy(css = "xxxxxxx")
	private WebElementFacade fld_NewBuilding;

	@FindBy(css = "xxxxxxx")
	private WebElementFacade fld_NewEqipment;

	@FindBy(css = "xxxxxxx")
	private WebElementFacade fld_NewRoom;

	@FindBy(css = "xxxxxxx")
	private WebElementFacade fld_NewDate;

	@FindBy(css = "xxxxxxx")
	private WebElementFacade fld_NewTime;

	@FindBy(css = "xxxxxx")
	private WebElementFacade btn_SubmitNewUser;

	@FindBy(css = "body [type='button']")
	private WebElementFacade btn_AddUserButton;

	//	Landing Page ****************************************************
	@FindBy(css = "a[href$='admin']")
	private WebElementFacade lnk_manage_reources_admin;
	
	@FindBy(css = ".jumbotron.odos-banner h1")
	private WebElementFacade hdr_page_title;
	
	//	Login Page ****************************************************
	@FindBy(css = "#okta-signin-username")
	private WebElementFacade fld_UserName;

	@FindBy(css = "#okta-signin-password")
	private WebElementFacade fld_Password;
	
	@FindBy(css = "[title='login']")
	private WebElementFacade btn_Login;

	@FindBy(css = "#okta-signin-submit")
	private WebElementFacade btn_SignIn;

	@FindBy(css = "[title='logout']")
	private WebElementFacade btn_logout;
	
//	Manage Users Page ****************************************************
	@FindBy(css = "a[href$='admin/users'] ")
	private WebElementFacade lnk_Manageusers;
	
	@FindBy(css = ".btn-primary[type='button']")
	private WebElementFacade btn_Add_User;
	
	@FindBy(css = ".btn-primary")
	private WebElementFacade btn_Update_User;
	
	@FindBy(css = "body div:nth-child(6) > button")
	private WebElementFacade btn_Added_New_User;
	
	@FindBy(css = "[headers='edit'] .btn-default")
	private List<WebElementFacade> btns_Edit_User;
	
	@FindBy(css = "[headers='delete'] .btn-default")
	private List<WebElementFacade> btns_Delete_User;
	
	@FindBy(css="ngb-modal-window div.modal-footer > button.btn.btn-primary")
	private WebElementFacade btn_Delete_User_Conf_Yes;

	@FindBy(css = "#firstName")
	private WebElementFacade fld_NewFirstName;

	@FindBy(css = "#lastName")
	private WebElementFacade fld_NewLastName;

	@FindBy(css = "#email")
	private WebElementFacade fld_NewEmail;
	
	@FindBy(css = "#role")
	private WebElementFacade fld_NewRole;
	
	// Equipment Pgge ****************************************************
	@FindBy(id = "equipment")
	private WebElementFacade fld_equipment;

	@FindBy(xpath = "//*[contains(text(), 'Add Equipment')]")
	private WebElementFacade btn_addequipment;

	// Building Pgge  **************************************************
	@FindBy(id = "building")
	private WebElementFacade fld_building;

	@FindBy(xpath = "//*[contains(text(), 'Add Building')]")
	private WebElementFacade btn_addbuilding;

	@FindBy(linkText = "Reservations")
	private WebElementFacade reservationslink;
	
	public void clickOnLogin() {
		btn_Login.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible();
		btn_Login.click();
		Log.info("Login button has been clicked on");
	}

	public void enterUseridAndPassword(String userid, String password) {
		fld_UserName.waitUntilPresent().sendKeys(userid);
		fld_Password.waitUntilPresent().sendKeys(password);
	}

	public void clickonSignIn() {

		btn_SignIn.waitUntilClickable().click();
		Log.info("SignIn button has been clicked on");
	}

	// Logout of the application
	public void logout() {
		Log.info("Logging out of the Applcation");
		btn_logout.waitUntilClickable().click();
		Assert.assertEquals("Login", btn_Login.getText());
		Log.info("Logged out");
	}

	public void addNewUserWithFirstName(String firstName) {
		
		fld_NewFirstName.waitUntilClickable().click();
		fld_NewFirstName.sendKeys(firstName);
		Log.info("FirstName has been Entered");
	}

	public void addNewUserWithLastName(String lastName) {
		
		fld_NewLastName.waitUntilClickable().click();
		fld_NewLastName.sendKeys(lastName);
		Log.info("LastName has been Entered as " + lastName);
	}

	public void addNewUserWithEmail(String email) {
		fld_NewEmail.waitUntilClickable().click();
		fld_NewEmail.sendKeys(email);
		Log.info("Email has been Entered as " + email);
	}
	
	public void addNewUserWithRole(String role) {
		fld_NewRole.waitUntilClickable().click();
		fld_NewRole.waitUntilVisible().selectByVisibleText(role);

		btn_Added_New_User.waitUntilClickable().click();
	}

	public void selectNewUserWithEquipment(String eqiup) {
		fld_NewEqipment.waitUntilVisible();
		fld_NewEqipment.selectByValue(eqiup);
	}

	public void selectNewUserWithbuildingRoom(String building, String room) {
		fld_NewBuilding.waitUntilVisible();
		fld_NewBuilding.selectByValue(building);
		fld_NewRoom.waitUntilVisible();
		fld_NewRoom.selectByValue(room);
	}

	public void selectNewUserWithDateTime(String date, String time) {
		fld_NewDate.waitUntilVisible();
		fld_NewDate.selectByValue(date);
		fld_NewTime.waitUntilVisible();
		fld_NewTime.sendKeys(time);
	}

	public void verifyNewUserIsAdded() {
		btn_SubmitNewUser.waitUntilClickable().click();
	}

	public void verifyUserTableHeader(String hdr1, String hdr2, String hdr3, String hdr4) {

		hdr_UserInfoTable.withTimeoutOf(15, TimeUnit.SECONDS).waitUntilVisible();
		String[] expectedHdrTitles = { hdr1, hdr2, hdr3, hdr4 };
		boolean actualHdrTitles = helper.stringContainsItemFromList(hdr_UserInfoTable, expectedHdrTitles);
		Assert.assertTrue("Expected Values: " + util.convertArrayToString(expectedHdrTitles), actualHdrTitles);
		Log.info("Header Title has been verified");
	}

	// Equipment Page
	public void setEquipmetId(String equipmentId) {
		helper.inputText(fld_equipment, equipmentId, "Set Equipment Id");

	}

	public void addEquipmet() {
		helper.clickElement(btn_addequipment, "Add Equipment");

	}

	// Building Page
	public void setEBuildingId(String equipmentId) {
		helper.inputText(fld_building, equipmentId, "Set Building Id");

	}

	public void addBuilding() {
		helper.clickElement(btn_addbuilding, "Add Building");

	}

	public void verifyApplicationHeader(String value) {
		hdr_page_title.waitUntilVisible();
		boolean headerValue = hdr_page_title.getText().trim().equalsIgnoreCase(value);
		Log.info("Application header is displays as " + hdr_page_title.getText());
		
		Assert.assertTrue("Title does not match", headerValue);
	}

	public void goToManageResourcesAdminPage() {
		lnk_manage_reources_admin.waitUntilClickable().click();
		helper.waitInSeconds(1);
		Log.info("Resource Admin page is displyed");
	}

	public void modifyExistingUsers() {
		btns_Edit_User.get(0).waitUntilClickable().click();
		btn_Update_User.waitUntilClickable();
		
		String ranVal = helper.getRandomNumber_Str(100);
		String updatedFN = fld_NewFirstName.getValue();
		String updatedLN = fld_NewLastName.getValue();
		String updatedEM = fld_NewEmail.getValue();
		
		fld_NewFirstName.waitUntilClickable().clear();
		fld_NewFirstName.waitUntilClickable().sendKeys(updatedFN+"_"+ ranVal);
	
		fld_NewLastName.waitUntilClickable().clear();
		fld_NewLastName.waitUntilClickable().sendKeys(updatedLN+"_"+ ranVal);
	
		fld_NewEmail.waitUntilClickable().clear();
		fld_NewEmail.waitUntilClickable().sendKeys(updatedEM+"_"+ ranVal);
		Log.info("User Info has been updated");
		
		btn_Update_User.waitUntilClickable().click();
	}

	public void deleteExistingUsers() {
		btns_Delete_User.get(0).waitUntilClickable().click();
		helper.waitInSeconds(1);
		btn_Delete_User_Conf_Yes.waitUntilPresent().click();
	}

	public void goToAddUserPage() {
		btn_Add_User.waitUntilClickable().click();
	}

	public void goToUsersPage() {
		lnk_Manageusers.waitUntilClickable().click();
		Log.info("Users Page has been displayed");
	}
	@FindBy (xpath = "//*/app-my-reservation/h2")
	private WebElementFacade reservationheader;
	
	public void navigateToReservationsPage(){	
		
		Log.info("Navigate to reservations Page");
		reservationslink.waitUntilVisible().click();
//		Assert.assertEquals("Request a Room",reservationheader.getText());
	}
}
