package pv_admin;

public class Patrollings_repository {

	static final String menu_patrolling="//span[contains(text(),'Patrollings')]";
	static final String menu_item_beat_bandobast="//span[contains(text(),'Beat and Bandobast')]";
	static final String menu_item_dutytypes="//span[contains(text(),'Duty Types')]";
	static final String menu_item_vehicles="//span[contains(text(),'Vehicles')]";
	static final String menu_item_vehicletypes="//span[contains(text(),'Vehicle Types')]";
	static final String menu_item_resources="//span[contains(text(),'Resources')]";
	static final String menu_item_resourcetypes="//span[contains(text(),'Resource Types')]";
	static final String menu_item_3dmodel="//span[contains(text(),'3D Models')]";
	
	static final String style_exp_coll="//ul[@id='MenuItem_Patrollings']";
	static final String title_header="//li[@class='breadcrumb-item active']";
	static final String btn_next="(//a[text()='Next'])[1]";
	static final String btn_previous="(//a[text()='Previous'])[1]";
	static final String title_window="//h5[@class='modal-title']";
	static final String btn_close="//button[@class='close']";
	static final String btn_cancel="(//button[text()='Cancel'])[1]";
	static final String btn_save="(//span[text()='Save'])[1]";
	static final String btn_save1="(//button[contains(text(),'Save')])[1]";
	static final String btn_save_registercrime="//button[@value='Save']";
	static final String btn_save_continue_registercrime="//button[@value='SaveContinue']";
	static final String validation_1stline="//div[@class='swal-modal']/div[2]";
	static final String validation_2ndline="//div[@class='swal-modal']/div[3]";
	static final String validation_btn_cancel="//button[@class='swal-button swal-button--cancel']";
	static final String validation_btn_yes="//button[@class='swal-button swal-button--confirm']";
	static final String text_showing_entries="(//div[contains(text(),'Showing')])[1]";
	static final String lnk_pageno_2="//a[text()='2']";
	static final String lnk_pageno_1="//a[text()='1']";
	static final String lnk_pageno_3="//a[text()='3']";
	static final String entries_25="//option[text()='25']";
	static final String entries_10="//option[text()='10']";
	static final String entries_100="//option[text()='100']";
	static final String lnk_Home="//a/i[@class='fa fa-home']";
	static final String dd_entries="(//div[@class='dataTables_length']/label/select)[1]";
	static final String raw_datatable="//div[@class='dataTables_scrollBody']/table/tbody/tr";
	static final String textbox_search="//input[@class='form-control form-control-sm']";
	static final String btn_OK="//button[text()='OK']";
	
	static final String col_lbl_actions="//th[text()='Actions']";
	static final String searchbox="//input[@class='form-control form-control-sm']";
	static final String verify_first="//div[@class='dataTables_scrollBody']/table/tbody/tr[1]/td[2]";
	static final String btn_actions_first="(//button[text()='Actions'])[1]";
	static final String lnk_discard_first="(//li/a[contains(text(),'Discard')])[1]";
	static final String lnk_edit_first="(//a[text()='Edit'])[1]";
	static final String toast_msg="//div[@class='toast-message']";
	
	//-----------Vehicle Types------------
	
	
	static final String col_lbl_type="//th[text()='Type']";
	static final String col_lbl_description="//th[text()='Description']";
	static final String col_lbl_isactive="//th[text()='Is Active ?']";
	static final String btn_newvehicletype="//button[@id='NewVehicleTypesButton']";
	static final String txtbox_type="//input[@id='VehicleTypes_Type']";
	static final String txtbox_des_vehtype_win="//input[@id='VehicleTypes_Description']";
	static final String chbox_isactive="//label[text()='Is Active ?']";
	
	static final String val_type_vehtype_win="//span[@id='VehicleTypes_Type-error']";
	static final String txtbox_type_editvehtype_win="//input[@id='VehicleType_Type']";
	static final String txtbox_des_editvehtype_win="//input[@id='VehicleType_Description']";
	
	//-----------Vehicles--------------
	static final String btn_newvehicle="//button[@id='NewVehicleButton']";
	static final String col_lbl_vehicleno="//th[text()='Vehicle Number']";
	static final String col_lbl_vehicletype="//th[text()='Vehicle Type']";
	static final String col_lbl_regdate="//th[text()='Registration Date (MM/DD/YYYY)']";
	static final String col_lbl_chassisno="//th[text()='Chassis Number']";
	static final String col_lbl_seatingcapacity="//th[text()='Seating Capacity']";
	static final String col_lbl_ownershiptype="//th[text()='Ownership Type']";
	static final String col_lbl_fueltype="//th[text()='Fuel Type']";
	static final String txtbox_vehicleno="//input[@id='Vehicle_VehicleNumber']";
	static final String txtbox_registrationdate="//input[@id='registrationDate']";
	static final String txtbox_chassisno="//input[@id='Vehicle_ChassisNumber']";
	static final String txtbox_seatingcapacity="//input[@id='Vehicle_SeatingCapacity']";
	static final String dd_vehicletype="//select[@id='Vehicle_VehicleType']";
	static final String dd_ownershiptype="//select[@id='Vehicle_OwnershipType']";
	static final String dd_fueltype="//select[@id='Vehicle_FuelType']";
	static final String val_vehicleno_newveh_win="//span[@id='Vehicle_VehicleNumber-error']";
	static final String val_seatingcap_newveh_win="//span[@id='Vehicle_SeatingCapacity-error']";
	static final String verify_firstrow_2ndcol="//div[@class='dataTables_scrollBody']/table/tbody/tr[1]/td[3]";
	
	//-----------Resource Types-----------
	static final String btn_newrestype="//button[@id='NewResourceTypeButton']";
	static final String col_lbl_restypename="//th[text()='Resource Type Name']";
	static final String col_lbl_rescategorytype="//th[text()='Resource Category Type']";
	static final String txtbox_restypename="//input[@id='ResourceType_ResourceTypeName']";
	static final String dd_rescategoryname="//select[@id='ResourceType_ResourceCategoryType']";
	static final String txtarea_des_newrestype_win="//textarea[@id='ResourceType_Description']";
	static final String val_restypename="//span[@id='ResourceType_ResourceTypeName-error']";
	
}
