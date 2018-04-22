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

/**
 * Page Object for Manifest Generator page
 * 
 * @author Saikat Barua
 *
 */

public class ConferenceRoomPage extends PageObject {

	HelperMethods helper = new HelperMethods();
	Utilities util = new Utilities();

	// PAGE OBJECTs are located Here
	
//	Conference Room Page *************************************************
	@FindBy (css = "#header > ul > li:nth-child(4) > a")
	private WebElementFacade fld_Conf;
	
	@FindBy(css= "app-rooms-list button > span")
	private WebElementFacade fld_Conf_Add_Room;
	
	@FindBy (css = "#title")
	private WebElementFacade fld_Conf_NewTitle;
	
	@FindBy (css = "#capacity")
	private WebElementFacade fld_Conf_NewCapacity;
	
	@FindBy (css = "#maxReserveTime")
	private WebElementFacade fld_Conf_NewTime;
	
	@FindBy (css = "#comments")
	private WebElementFacade fld_Conf_NewComments;
	
	@FindBy (css = "[name='available']")
	private WebElementFacade fld_Conf_Available;
	
	@FindBy (css = "form > div:nth-child(8) > button")
	private WebElementFacade fld_Conf_Add_Room_Submit;
	
	@FindBy(css = "[headers='edit'] .btn-default")
	private List<WebElementFacade> btns_Edit_Conf;
	
	@FindBy(css = "[headers='delete'] .btn-default")
	private List<WebElementFacade> btns_Delete_Conf;
	
	@FindBy(css = "#item\2e id")
	private List<WebElementFacade> lnks_AV_Equipment;
	
	@FindBy(css = ".btn-primary")
	private WebElementFacade btn_Update_Conf;
	
	@FindBy(css="ngb-modal-window div.modal-footer > button.btn.btn-primary")
	private WebElementFacade btn_Delete_Conf_Yes;

//	Conference Rooms ************************************************************
	
	public void clickOnConferenceRooms() {
		fld_Conf.waitUntilClickable().click();
//		waitForWithRefresh();
		Log.info("Navigated to Conference rooms");
	}

	public void addNewConfRoom(String title, String capacity, String comment) {
		fld_Conf_Add_Room.waitUntilClickable().click();
		
		fld_Conf_NewTitle.waitUntilClickable().click();
		fld_Conf_NewTitle.sendKeys(title);
		
		fld_Conf_NewCapacity.waitUntilClickable().click();
		fld_Conf_NewCapacity.sendKeys(capacity);
		
//		lnks_AV_Equipment.get(1).waitUntilClickable().click();
		
		fld_Conf_NewComments.waitUntilClickable().click();
		fld_Conf_NewComments.sendKeys(comment);
		
		fld_Conf_Available.click();
		
		fld_Conf_Add_Room_Submit.waitUntilClickable().click();
	}

	public void editExistingConfRoom() {
		btns_Edit_Conf.get(0).waitUntilClickable().click();
		btn_Update_Conf.waitUntilClickable();
		
		String ranVal = helper.getRandomNumber_Str(10);
		String updatedTitle = fld_Conf_NewTitle.getValue();
		String updatedComment = fld_Conf_NewComments.getValue();
		
		fld_Conf_NewTitle.waitUntilClickable().clear();
		fld_Conf_NewTitle.waitUntilClickable().sendKeys(updatedTitle+"_"+ ranVal);
	
		fld_Conf_NewCapacity.waitUntilClickable().clear();
		fld_Conf_NewCapacity.waitUntilClickable().sendKeys(ranVal);
	
		fld_Conf_NewComments.waitUntilClickable().clear();
		fld_Conf_NewComments.waitUntilClickable().sendKeys(updatedComment+"_"+ ranVal);
		Log.info("User Info has been updated");
		
		btn_Update_Conf.waitUntilClickable().click();
	}

	public void deleteExistingConfRoom() {
		btns_Delete_Conf.get(0).waitUntilClickable().click();
		helper.waitInSeconds(1);
		btn_Delete_Conf_Yes.waitUntilPresent().click();
	}
}
