package pv_admin;

public class LayerManagement_repository {

	static final String opt_LayerManagement="//span[contains(text(),'Layer Management')]";
	static final String menuitem_layers="//span[contains(text(),'Layers')]";
	static final String dd_sel_ogcservice="//select[@id='sl_OgcService']";
	static final String btn_scanlayer="//button[@id='scanLayer']";
	static final String btn_rescan="//button[@id='rescan']";
	static final String txtbox_search="//input[@type='search']";
	
	static final String searchbox="//input[@class='form-control page-search-filter-text']";
	static final String title_header="//li[@class='breadcrumb-item active']";
	static final String title_pageheader="//h5[@class='card-title']";
	static final String btn_next="(//a[text()='Next'])[1]";
	static final String btn_previous="(//a[text()='Previous'])[1]";
	static final String title_window="//h5[@class='modal-title']";
	static final String btn_close="//button[@class='close']";
	static final String btn_cancel="//button[text()='Cancel']";
	static final String btn_save="//button/span[text()='Save']";
	static final String validation_1stline="//div[@class='swal-modal']/div[2]";
	static final String validation_2ndline="//div[@class='swal-modal']/div[3]";
	static final String validation_btn_cancel="//button[@class='swal-button swal-button--cancel']";
	static final String validation_btn_yes="//button[@class='swal-button swal-button--confirm']";
	static final String text_showing_entries="//div[contains(text(),'Showing')]";
	static final String lnk_pageno_2="//a[text()='2']";
	static final String lnk_pageno_1="//a[text()='1']";
	static final String lnk_pageno_3="//a[text()='3']";
	static final String lnk_pageno_4="//a[text()='4']";
	static final String entries_25="//option[text()='25']";
	static final String entries_10="//option[text()='10']";
	static final String entries_100="//option[text()='100']";
	static final String lnk_Home="//a/i[@class='fa fa-home']";
	static final String dd_entries="(//div[@class='dataTables_length']/label/select)[1]";
	static final String dd_sellayer="//select[@id='sl_LayersList']";
	static final String btn_addlay_crimemapping="//div[@id='_crime_mapping']//div/a[text()='Add Layer']";
	static final String btn_delete_ogcservice="//button[@id='DeleteOgcService']";
	static final String btn_actions="//button[text()='Actions']";
	static final String lnk_edit="//li/a[text()='Edit']";
	static final String lnk_layerfield="//li/a[text()='Layer Field']";
	static final String lnk_discard="//li/a[text()='Discard']";
	static final String toast_msg="//div[@class='toast-message']";
	
	public static final String btn_Login="//a[@class='btn btn-primary']";
	public static final String txtbox_Username="//input[@id='LoginInput_UserNameOrEmailAddress']";
	public 	static final String txtbox_Password="//input[@id='LoginInput_Password']";
	public static final String btn_Login1="//button[text()='Login']";
	public static final String profile_admin="//a[@id='dropdownMenuUser']";
	public	static final String lnk_logout="//a[@id='MenuItem_Account.Logout']";
	
	
	public static final String  ddm_Layer_Management  = "//*[contains(text(),'Layer Management')]";
	public static final String  lnk_Layers  = "//*[contains(text(),'Layers')]";
	public static final String  btn_Add_OGC_Services  = "//button[@id=\"NewOgcService\"]";
	public static final String  btn_Scan_Layers  = "//button[text()=\"Scan Layer\"]";
	public static final String  btn_Edit_OGC_services  = "//button[@id=\"EditOgcService\"]";
	public static final String  btn_Delete_OGC_services  = "//button[@id=\"DeleteOgcService\"]";
	public static final String  ddm_OGC_services  = "//select[@id=\"sl_OgcService\"]";
	public static final String  btn_Action  = "//button[text()=\"Actions\"]";
	public static final String  ddm_Show_Entries = "//select[@name=\"LayerTable_length\"]";
	public static final String  txt_OgcServices_Name= "//input[@name=\"OgcService.Name\"]";
	public static final String  txt_OgcServices_DbName= "//input[@name=\"OgcService.DbName\"]";
	public static final String  txt_OgcServices_URl= "//input[@name=\"OgcService.Url\"]";
	public static final String  txt_OgcServices_DbConnectionString= "//input[@name=\"OgcService.DbConnectionString\"]";
	public static final String  btn_Save = "//span[text()=\"Save\"]";
	public static final String  chk_Active = "//input[@name=\"OgcService.IsActive\"]";
	public static final String  btn_Ok = "//button[text()=\"OK\"]";
	public static final String  btn_Yes = "//button[text()=\"Yes\"]";
	public static final String  btn_Back = "//span[text()=\"Back\"]";
	public static final String  btn_Rescan = "//span[text()=\"Rescan\"]";
	public static final String  lnk_Layer_Error  = "//*[contains(text(),'Layer Error Count')]";
	public static final String  lnk_Layer_Publish  = "//*[contains(text(),'Layer Publish Pending')]";
	public static final String  lnk_Layer_Columns_Issue  = "//*[contains(text(),'Layer With Columns Issue')]";
	public static final String  lnk_Layer_Record_Pending  = "//*[contains(text(),'Layer Recorded Pending')]";
	public static final String  lnk_Layer_Table_NotFound  = "//*[contains(text(),'Layer Table Not Found')]";
	public static final String  lnk_Layer_Sync_Pending  = "//*[contains(text(),'Layer Sync Pending')]";
	public static final String  lnk_Clear  = "//*[contains(text(),'Clear')]";
	public static final String  btn_Add_Layer_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Add Layer\"]";
	public static final String  btn_Activate_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Activate\"]";
	public static final String  btn_Discard_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Discard\"]";
	public static final String  btn_Deactivate_ATM  = "//div[@id=\"_atm\"]//a[text()=\"Deactivate\"]";
	public static final String  btn_Add_Mask_Layer_boundary_ward  = "//div[@id=\"_boundary_ward\"]//a[text()=\"Add Mask-Layer\"]";
	public static final String  btn_Add_Mask_Layer_bank  = "//div[@id=\"_bank\"]//a[text()=\"Add Mask-Layer\"]";
	public static final String  txt_Title_Name= "//input[@id=\"AddLayerScanResultViewModel_Title\"]";
	public static final String  chk_Is_Mask= "//input[@id=\"AddLayerScanResultViewModel_IsMask\"]";

	
	static final String col_lbl_actions="//th[text()='Actions']";
	static final String col_lbl_layfielddispname="//th[text()='Layer Field Display Name']";
	static final String col_lbl_tablename="//th[text()='Table Name']";
	static final String col_lbl_coalesceval="//th[text()='Coalesce Value']";
	static final String col_lbl_datatype="//th[text()='Data Type']";
	static final String col_lbl_allowedit="//th[text()='Allow Edit']";
	static final String col_lbl_creatime="//th[text()='Creation Time']";
	static final String btn_back_layerfield="//button[@id='backLayers']";
	static final String txtbox_coalesceval="//input[@id='LayerFields_CoalesceValue']";
	static final String txtbox_infotooldispindex="//input[@id='LayerFields_InfoToolDisplayIndex']";
	static final String txtbox_reportdispindex="//input[@id='LayerFields_ReportDisplayIndex']";
	static final String txtbox_dispname="//input[@id='LayerFields_Locales_en-IN__DisplayName']";
	static final String chbox_infotooldispindex="//input[@id='LayerFields_InfoToolVisibility']";
	static final String chbox_reportdispindext="//input[@id='LayerFields_ReportVisibility']";
	
	static final String verify_first="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]";
	
	
	static final String col_lbl_laytitle="//th[text()='Layer Title']";
	static final String col_lbl_layname="//th[text()='Layer Name']";
	
	//New Layer Tree
			static final String lnk_layerManagement="//span[contains(text(),'Layer Management')]";
			static final String lnk_layerTreeAndGroup="//span[contains(text(),'Layer Tree & Group')]";
			static final String btn_NewLayerTree="//span[contains(text(),'New Layer Tree')]";
			static final String title_NewLayerTree_popup="//h5[text()='New Layer Tree']";
			static final String text_title_NewLayerTree_popup="//label[text()='Title']";
			static final String text_description_NewLayerTree_popup="//label[text()='Description']";
			static final String textb_title_NewLayerTree_popup="//input[@id='LayerTree_Title']";
			static final String textb_description_NewLayerTree_popup="//input[@id='LayerTree_Description']";
			static final String ddl_layerTree="//select[@id='ddlLayerTree']";
			static final String btn_delete_layerTree="//button[@id='DeleteLayerTree']";
			static final String text_validation_titleField_NewLayerTree_popup="//span[text()='The Title field is required.']";
			static final String validation_btn_ok="//button[text()='OK']";
			
			//Create Group
			static final String lnk_layerTree="//a[text()='Test Drag']/i";
			static final String btn_createGroup="//ul[@class='vakata-context jstree-contextmenu jstree-default-contextmenu']/li/a";
			static final String lnk_enIN="//a[contains(text(),'en-IN')]";
			static final String lnk_hiIN="//a[contains(text(),'hi-IN')]";
			static final String textb_title_enIN_createGroupLAyer="//input[@id='LayerGroup_Locales_en-IN__Title']";
			static final String chkb_active_createGroupLAyer="//input[@id='LayerGroup_IsActive']";
			static final String chkb_isExpanded_createGroupLAyer="//input[@id='LayerGroup_IsExpanded']";
			static final String textb_title_hiIN_createGroupLAyer="//input[@id='LayerGroup_Locales_hi-IN__Title']";
			static final String expand_layerTree="//i[@class='jstree-icon jstree-ocl']";
			static final String text_groupName_layerTree="//ul[@class='jstree-children']/li[1]//a";
			static final String text_validation_titleField_enIN="(//span[text()='The Title field is required.'])[1]";
			static final String text_validation_titleField_hiIN="(//span[text()='The Title field is required.'])[2]";
			
			//Add Layer
		    static final String text_addedPresentLayer="(//ul[@class='jstree-children']//li[1]/a)[2]";
		    static final String expand_layerGroup="//ul[@class='jstree-children']/li/i";
		    static final String layer_atm="(//div[@data-layername='atm'])[last()]";
		  
		    
		  //Edit Layer
		    static final String txtbox_title_lay_win="//input[@id='Layers_Locales_en-IN__Title']";
			static final String txtbox_opacity_lay_win="//input[@id='Layers_Opacity']";
			static final String txtbox_boundX1_lay_win="//input[@id='Layers_BoundX1']";
			static final String txtbox_boundX2_lay_win="//input[@id='Layers_BoundX2']";
			static final String txtbox_boundY1_lay_win="//input[@id='Layers_BoundY1']";
			static final String txtbox_boundY2_lay_win="//input[@id='Layers_BoundY2']";
			static final String chbox_active_lay_win="//input[@id='Layers_IsActive']";
			static final String chbox_isvisible_lay_win="//input[@id='Layers_IsVisible']";
			static final String chbox_isqueryable_lay_win="//input[@id='queryableLayer']";
			static final String chbox_isbaselay_lay_win="//input[@id='baseLayer']";
			static final String val_opacity="//span[@id='Layers_Opacity-error']";
			static final String btn_editLayer="//a[text()='Edit Layer']";
			static final String validation_opacity_editLayer="//span[text()='The field Opacity must be between 0 and 1.']";
			static final String btn_removeMapping="//a[text()='Remove Mapping']";
			
			static final String menuitem_LayertreeAndGroup="//span[contains(text(),'Layer Tree & Group')]";
			static final String dd_LayerTree="//select[@id='ddlLayerTree']";
			
			static final String dd_EditedLayerTree="//option[contains(text(),'Test10')]";
			static final String dd_deletedLayerTree="//option[contains(text(),'Test5')]";
			
			
			//static final String LayerTree="(//a[@class='jstree-anchor'])[1]";
			
			static final String LayerTree="(//*[text()='Demo'])[2]";

			
	/*----------------------------------------------------Layer Group--------------------------------------------------------------*/		
			
			static final String LayerTree_LayerGroup="//div[@id='kt_tree']/ul/li/ul/li[1]/a[1]";
			static final String dd_EditGroup="//*[contains(text(),'Edit Group')]";
			static final String dd_RemoveGroup="//*[contains(text(),'Remove Group')]";
			
			static final String txtbox_Title_EditLayerGroup="//input[@id='LayerGroup_Locales_en-IN__Title']";
			static final String dd_DisplayIndex_EditLayerGroup="//input[@id='LayerGroup_DisplayIndex']";
			static final String chckbox_IsActive_EditLayerGroup="//input[@id='LayerGroup_IsActive']";
			static final String chckbox_IsExpanded_EditLayerGroup="//input[@id='LayerGroup_IsExpanded']";
			
			static final String txt_Title_EditLayerGroup="//*[text()='Edit Layer Group']";
				
			static final String LayerTree_LayerGroups_xpath="//div[@id='kt_tree']/ul/li/ul/li/a";	
			static final String txt_EditedGroup="//*[text()='Edited Group']";
			
	/*----------------------------------------------------Layer Tree--------------------------------------------------------------*/	
			
			static final String btn_EditLayerTree="//button[@id='EditLayerTree']";
			
			static final String btn_DeleteLayerTree="//button[@id='DeleteLayerTree']";
			
			static final String btn_GetConfigFile="//span[text()='Get Config File']";
			
			static final String btn_MapLayerTree="//button[@id='MapLayerTree']";
			
			static final String txt_EditLayerTree_Title="//*[text()='Edit Layer Tree']";
			
			static final String lbl_Title_EditLayerTree="//label[text()='Title']";		
			static final String lbl_Description_EditLayerTree="//label[text()='Description']";
			
			static final String txtbox_Title_EditLayerTree="//input[@id='LayerTreeViewModel_Title']";
			static final String txtbox_Description_EditLayerTree="//input[@id='LayerTreeViewModel_Description']";
			
			static final String txtbox_Title_NewLayerTree="//input[@id='LayerTree_Title']";
			
			
	/*---------------------------------------------------- Map --------------------------------------------------------------*/		
					
			static final String txt_Title_Map="//*[text()='Layer Tree-Department Mapping']";		
			static final String lbl_LayerTree_Map="//*[text()='Layer Tree ']";
			static final String dd_LayerTree_Map="//select[@id='TreeOrgUnitViewModal_LayerTreeId']";
			static final String lbl_Department_Map="//*[text()='Departments ']";
			static final String dd_Department_Map="//span[@class='select2-selection select2-selection--multiple']";
			
			static final String btn_cross_Particular_Map="(//span[text()='×'])[4]";
			static final String btn_cross_All_Map="(//span[text()='×'])[2]";
			static final String validation_Map="//span[text()='The Departments field is required.']";
			
			static final String dd_Division13_Department_Map="//li[text()='Division 13']";
			static final String dd_Division12_Department_Map="//li[text()='Division 12']";
			static final String icon_Home_LayerTreeandGroup="(//i[@class='fa fa-home'])[2]";
			
			static final String txt_Home_Welcome="//p[text()='Welcome to the City Policing application.']";
}
