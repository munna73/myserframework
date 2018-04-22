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

public class ReservationsPage extends PageObject {

	HelperMethods helper = new HelperMethods();
	Utilities util = new Utilities();

	// PAGE OBJECTs are located Here

	// Conference Room Page *************************************************
	@FindBy(css = "#room")
	private WebElementFacade fld_room;

	@FindBy(xpath = "//*[@id='start']/fieldset/div/div[1]/input")
	private WebElementFacade fld_starthrs;

	@FindBy(xpath = "//*[@id='start']/fieldset/div/div[3]/input")
	private WebElementFacade fld_startmins;
	
	@FindBy (id = "duration")
	private WebElementFacade  fld_duration;
	
	@FindBy(css = "app-my-reservation > div > div:nth-child(4) > button > span")
	private WebElementFacade btn_request;
	
	@FindBy(xpath = "//*/div/app-landing/div/div[2]/div/div[1]/p[2]/a")
	private WebElementFacade btn_displayaroom;
	
	@FindBy(xpath = "//*/app-root/div/app-my-rooms/h2")
	private WebElementFacade hdr_displayaroom;
	
	@FindBy(id = "conference room")
	private WebElementFacade fld_confroom;
	
	public void bookconferenceroom (String room, String avequip, String bldg, String stimehrs,
			String stimemins, String duration) {
		helper.waitInSeconds(1);
		
//		helper.selectFromDropdown(fld_room, room);
		
		fld_room.waitUntilClickable().click();
		fld_room.selectByVisibleText(room);
		
		helper.waitInSeconds(1);
		helper.inputText(fld_starthrs, stimehrs, "Input Start time Hrs");
		helper.inputText(fld_startmins, stimemins, "Input Start time Mins");
//		helper.selectFromDropdown(fld_duration, duration);
//		helper.clickElement(btn_request, "Click on request Room");
		
	}

	public void navigatetodisplayaroom() {
		helper.clickElement(btn_displayaroom, "Navigate to Display a Room");
//		Assert.assertEquals("Display a Room",hdr_displayaroom.getText());
		
	}

	public void generatereport(String room) {
//		helper.selectFromDropdown(fld_confroom, room);
//		fld_confroom.waitUntilClickable().click();
//		fld_confroom.selectByVisibleText(room);
	}
}


