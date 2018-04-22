package project.pages;

import java.util.List;

import jline.internal.Log;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import project.utils.HelperMethods;
import project.utils.Utilities;

/**
 * Page Object for Manifest Generator page
 * 
 * @author Saikat Barua
 *
 */

public class AVEquipmentPage extends PageObject {

	HelperMethods helper = new HelperMethods();
	Utilities util = new Utilities();


	// PAGE OBJECTs are located Here

	@FindBy (css = "#header > ul > li:nth-child(5) > a")
	private WebElementFacade fld_AV;
	
	@FindBy(css= "app-equipment-list ul > button > span")
	private WebElementFacade fld_AV_Add;
	
	@FindBy (css = "#title")
	private WebElementFacade fld_AV_NewTitle;
	
	@FindBy (css = "#description")
	private WebElementFacade fld_AV_Desc;
	
	@FindBy (css = "app-equipment-list-add-edit form > div:nth-child(4) > button")
	private WebElementFacade fld_AV_Submit_Add;
	
	@FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(3) > button")
	private WebElementFacade btn_Edit_AV;
	
	@FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(4) > button")
	private WebElementFacade btn_Delete_AV;
	
	@FindBy(css = ".btn-primary")
	private WebElementFacade btn_Update_AV;
	
	@FindBy(css="ngb-modal-window div.modal-footer > button.btn.btn-primary")
	private WebElementFacade btn_Delete_AV_Yes;

	
	public void goToAVEquipmentPage() {
		fld_AV.waitUntilClickable().click();
	}


	public void editAVEquipment() {
		btn_Edit_AV.waitUntilClickable().click();
		btn_Update_AV.waitUntilClickable();
		
		String ranVal = helper.getRandomNumber_Str(10);
		String updatedTitle = fld_AV_NewTitle.getValue();
		String updatedDesc = fld_AV_Desc.getValue();
		
		fld_AV_NewTitle.waitUntilClickable().clear();
		fld_AV_NewTitle.waitUntilClickable().sendKeys(updatedTitle+"_"+ ranVal);
	
		fld_AV_Desc.waitUntilClickable().clear();
		fld_AV_Desc.waitUntilClickable().sendKeys(updatedDesc+"_"+ranVal);
	
		Log.info("AV Info has been updated");
		btn_Update_AV.waitUntilClickable().click();
	}


	public void deleteAVEquipment() {
		btn_Delete_AV.waitUntilClickable().click();
		helper.waitInSeconds(1);
		btn_Delete_AV_Yes.waitUntilPresent().click();
	}


	public void addAVEqipment(String title, String desc) {
		helper.waitInSeconds(2);
		fld_AV_Add.waitUntilClickable().click();
		
		fld_AV_NewTitle.waitUntilClickable().click();
		fld_AV_NewTitle.sendKeys(title);
		
		fld_AV_Desc.waitUntilClickable().click();
		fld_AV_Desc.sendKeys(desc);

		fld_AV_Submit_Add.waitUntilClickable().click();
	
	}
}
