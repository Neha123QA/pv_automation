package pv_admin;

public class PV_Settings_repository {
	
	static final String op_aroundme_config="//span[contains(text(),'Around Me Configuration')]";
	static final String expand_style="//li[@class='active-page has-drop']//ul[@id='MenuItem_PVAppSettings']";
	static final String op_pv_settings="//span[contains(text(),'Police Vertical Settings')]";
	static final String op_bookmarks="//span[contains(text(),'Bookmarks')]";
	static final String op_NamedQuery="//span[contains(text(),'Named Queries')]";
	static final String header_pvSettings="//li[@class='breadcrumb-item active']";
	static final String btn_add_pvSettings="";
	static final String btn_previous="(//a[text()='Previous'])[1]";
	static final String btn_next="(//a[text()='Next'])[1]";
	static final String lnk_pageno_2="//a[text()='2']";
	static final String lnk_pageno_1="//a[text()='1']";
	static final String lnk_pageno_3="//a[text()='3']";
	static final String dd_entries="(//div[@class='dataTables_length']/label/select)[1]";
	static final String btn_actions="//button[text()='Actions']";
	static final String col_lbl_Actions="//th[contains(text(),'Actions')]";
	static final String col_lbl_SettingName="//th[contains(text(),'Setting Name')]";
	static final String col_lbl_SettingValue="//th[contains(text(),'Setting Value')]";
	static final String col_lbl_Module="//th[contains(text(),'Module')]";
	static final String col_lbl_Description="//th[contains(text(),'Description')]";
	static final String txtbox_search="//input[@type='search']";
	static final String verify_settingname="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]";
	static final String text_entries="//div[contains(text(),'Showing')]";
	static final String lnk_Home="//a/i[@class='fa fa-home']";
	static final String title_window="//h5[@class='modal-title']";
	static final String btn_close="//button[@class='close']";
	static final String btn_cancel="//button[text()='Cancel']";
	static final String btn_save="//button/span[text()='Save']";
	static final String validation_1stline="//div[@class='swal-modal']/div[2]";
	static final String validation_2ndline="//div[@class='swal-modal']/div[3]";
	static final String validation_btn_cancel="//button[@class='swal-button swal-button--cancel']";
	static final String validation_btn_yes="//button[@class='swal-button swal-button--confirm']";
	static final String txtbox_Module_pvsetting="//input[@id='PVSettings_Module']";
	static final String txtbox_SettingVal_pvsetting="//textarea[@id='PVSettings_SettingValue']";
	static final String txtbox_Description_pvsetting="//input[@id='PVSettings_Desc']";
	static final String txtbox_SettingName_pvsetting="//input[@id='PVSettings_SettingName']";
	static final String lbl_Module_win_add_pvsetting="//label[text()='Module']";
	static final String lbl_SettingName_win_add_pvsetting="//label[text()='Setting Name']";
	static final String lbl_SettingVal_win_add_pvsetting="//label[@for='PVSettings_SettingValue']";
	static final String lbl_Description_win_add_pvsetting="//label[text()='Description']";
	static final String validation_module="//span[@id='PVSettings_Module-error']";
	static final String validation_SettingName="//span[@id='PVSettings_SettingName-error']";
	static final String validation_SettingValue="//span[@id='PVSettings_SettingValue-error']";
	static final String lnk_edit="//li/a[text()='Edit']";
	static final String lnk_discard="//li/a[text()='Discard']";
	static final String toast_msg="//div[@class='toast-message']";
	
	
	
	
}
