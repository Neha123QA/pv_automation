package pv_admin;

import org.openqa.selenium.By;

public class CrimeMapping_repository {

	static final String menu_crimemapping="//span[contains(text(),'Crime Mapping')]";
	static final String menu_item_crimes="//span[contains(text(),'Crimes')]";
	static final String menu_item_crimetypes="//span[contains(text(),'Crime Types')]";
	static final String menu_item_crimeanalysis="//span[contains(text(),'Crime Analysis')]";
	static final String style_exp_coll="//ul[@id='MenuItem_CrimeMapping']";
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
	static final String col_lbl_Actions="//th[contains(text(),'Actions')]";
	static final String col_lbl_recordno="//th[contains(text(),'Record No')]";
	static final String col_lbl_crimetype="//th[contains(text(),'Crime Type')]";
	static final String col_lbl_summary="//th[contains(text(),'Summary')]";
	static final String col_lbl_jurisdiction="//th[contains(text(),'Jurisdiction')]";
	static final String col_lbl_crimetime="//th[contains(text(),'Crime Time')]";
	static final String col_lbl_reportingtime="//th[contains(text(),'Reporting Time')]";
	static final String col_lbl_severity="//th[contains(text(),'Severity')]";
	static final String col_lbl_creationtime="//th[contains(text(),'Creation Time')]";
	static final String col_lbl_creatorname="//th[contains(text(),'Creator Name (Badge No)')]";
	static final String col_lbl_lastmodificationtime="//th[contains(text(),'Last Modification Time')]";
	static final String col_lbl_lastmodifiername="//th[contains(text(),'Last Modifier Name (Badge No)')]";
	static final String btn_registercrime="//button[@id='NewIncidentButton']";
	static final String verify_first="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]";
	static final String val_summary_regcrime="//span[@id='incidentDto_Summary-error']";
	static final String dd_selLocation="//select[@id='incidentDto_TypeOfLocation']";
	static final String dd_selCrime="//select[@id='crimeType']";
	static final String txtbox_ipc_crime="//input[@id='crimeDto_IPC']";
	static final String dd_severity="//select[@id='crimeSeverity']";
	static final String txtbox_long="//input[@id='incidentDto_GeoX']";
	static final String txtbox_lat="//input[@id='incidentDto_GeoY']";
	static final String startdate_crime="//input[@id='inStartDate']";
	static final String enddate_crime="//input[@id='inEndDate']";
	static final String repoTime_crime="//input[@id='inReportingDate']";
	static final String txtbox_summary="//input[@id='incidentDto_Summary']";
	static final String txtbox_des="//textarea[@id='incidentDto_Description']";
	static final String val_long="//span[@id='incidentDto_GeoX-error']";
	static final String val_lat="//span[@id='incidentDto_GeoY-error']";
	static final String btn_OK="//button[text()='OK']";
	static final String txtbox_FIRno="//input[@id='incidentDto_FIRNo']";
	static final String txtbox_Fileno="//input[@id='incidentDto_FileNo']";
	static final String verify_crime="//td[contains(text(),'Test')]";
	static final String img_map="//canvas[@style='image-rendering: pixelated;']";
	static final String icon_btn_home_map="//button[@title='Reset perspective']";
	static final String title_crimetree="//span[text()=' Crime Tree']";
	static final String verify_crime_crimetree="//div[@id='incidentsTree']/ul/li/a";
	static final String header_crimeinfo="//span[@id='detailsType']";
	static final String tab_map_crimemappings="//a[@id='MapTab-tab']";
	static final String tab_attach_crimemappings="//a[@id='Attachment-tab']";
	static final String tab_person_crimemappings="//a[@id='Person-tab']";
	static final String tab_pp_crimemappings="//a[@id='PolicePerson-tab']";
	static final String btn_tools="//button[@class='btn btn-link toolBarRight-btn dropdown-toggle']";
	static final String icon_btn_zoomin="//div[@id='btn-zommIn']";
	static final String icon_btn_zoomout="//div[@id='btn-ZoomOut']";
	static final String recordno_crimeinfo="//div[@id='detailsTable']/table/tr[1]/th";
	static final String fileno_crimeinfo="//div[@id='detailsTable']/table/tr[2]/th";
	static final String firno_crimeinfo="//div[@id='detailsTable']/table/tr[3]/th";
	static final String crimetime_crimeinfo="//div[@id='detailsTable']/table/tr[4]/th";
	static final String crimeendtime_crimeinfo="//div[@id='detailsTable']/table/tr[5]/th";
	static final String reptime_crimeinfo="//div[@id='detailsTable']/table/tr[6]/th";
	static final String severity_crimeinfo="//div[@id='detailsTable']/table/tr[7]/th";
	static final String summary_crimeinfo="//div[@id='detailsTable']/table/tr[8]/th";
	static final String des_crimeinfo="//div[@id='detailsTable']/table/tr[9]/th";
	static final String investigationstatus_crimeinfo="//div[@id='detailsTable']/table/tr[10]/th";
	static final String jurisdiction_crimeinfo="//div[@id='detailsTable']/table/tr[11]/th";
	static final String creatorname_crimeinfo="//div[@id='detailsTable']/table/tr[12]/th";
	static final String creationtime_crimeinfo="//div[@id='detailsTable']/table/tr[13]/th";
	static final String btn_actions_first="(//button[text()='Actions'])[1]";
	static final String lnk_discard_first="(//li/a[contains(text(),'Discard')])[1]";
	static final String lnk_crimedetails_first="(//a[text()='Crime Details'])[1]";
	static final String lnk_edit_first="(//a[text()='Edit'])[1]";
	static final String toast_msg="//div[@class='toast-message']";
	static final String btn_back="//span[text()=' Back']";
	static final String verify_recno_first="//div[@class='dataTables_scrollBody']/table[@id='IncidentTable']/tbody/tr/td[2]";
	static final String text_nodataavailable="//td[text()='No data available']";
	static final String toggle_swith_crimestatus="//div[@class='toggle-group']";
	static final String lnk_editcrime="//a[text()='Edit Crime']";
	
	static final String lnk_addpp="//a[text()='Add Police Personnel']";
	static final String lnk_editevent="//a[text()='Edit Event']";
	
	static final String lnk_discard="//a[text()='Discard']";
	static final String dd_category_newperson_win="//select[@id='selectByType']";
	static final String searchbox_newperson_win="//input[@id='searchPerson']";
	static final String btn_newperson_win="//button[@id='newPerson']";
	static final String icon_search_newperson_win="//button[@id='searchPersonBtn']";
	static final String dd_associatedtype_newpr_win="//select[@id='personViewModal_AssociatedType']";
	static final String txtbox_firstname_newpr_win="//input[@id='personViewModal_FirstName']";
	static final String txtbox_midname_newpr_win="//input[@id='personViewModal_MiddleName']";
	static final String txtbox_lastname_newpr_win="//input[@id='personViewModal_LastName']";
	static final String txtbox_dob_newpr_win="//input[@id='bDate']";
	static final String txtbox_age_newpr_win="//input[@id='age']";
	static final String txtbox_add1_newpr_win="//input[@id='personViewModal_AddressList_0__AddressLine1']";
	static final String txtbox_pin_newpr_win="//input[@id='personViewModal_AddressList_0__PinCode']";
	static final String txtbox_phoneno_newpr_win="//input[@id='personViewModal_ContactList_0__ContactValue']";
	static final String txtbox_altphoneno_newpr_win="//input[@id='personViewModal_ContactList_1__ContactValue']";
	static final String txtbox_email_newpr_win="//input[@id='personViewModal_ContactList_2__ContactValue']";
	static final String txtbox_phydes_newpr_win="//textarea[@id='personViewModal_PhysicalDescription']";
	static final String dd_gen_newpr_win="//select[@id='personViewModal_Gender']";
	static final String dd_state_newpr_win="//select[@id='stateVal']";
	static final String dd_dist_newpr_win="//select[@id='districtVal']";
	static final String dd_taluka_newpr_win="//select[@id='talukaVal']";
	static final String dd_village_newpr_win="//select[@id='villageVal']";
	static final String btn_browse_newpr_win="//input[@id='personViewModal_SelectImage']";
	static final String btn_searchpr_newpr_win="//span[text()='Search Person']";
	static final String verify_firstname_persec="//table[@id='PersonTable']/tbody/tr[1]/td[3]";
	static final String seach_txtbox_1st="(//input[@type='search'])[1]";
	
	
	static final String searchbox_ppsec="(//input[@class='form-control form-control-sm'])[3]";
	static final String btn_add_first="(//button[text()='Add'])[1]";
	static final String col_lbl_firstname="(//th[text()='First Name'])[1]";
	static final String col_lbl_lastname="(//th[text()='Last Name'])[1]";
	static final String col_lbl_badgeno="(//th[text()='Badge Number'])[1]";
	static final String col_lbl_designation="(//th[text()='Designation'])[1]";
	static final String verify_firstname_pptable="//table[@id='PolicePersonnelTable']/tbody/tr[1]/td[2]";
	static final String verify_firstname_ppsec="//table[@id='PolicePersonTable']/tbody/tr[1]/td[2]";
	static final String dd_atttype_attwin="//select[@id='attachmentDto_AttachmentType']";	
	static final String txtbox_des_attwin="//input[@id='attachmentDto_Description']";
	static final String searchbox_crimemapping="//input[@id='search']";
	
	static final String btn_browse="//input[@id='file']";
	static final String val_fileupload="//span[@id='file-error']";
	
	//-----Add/Edit Crime Event------
	static final String lnk_addevent="//a[text()='Add Event']";
	static final String dd_selelocation_addeventsec="//select[@id='crimeDto_TypeOfLocation']";
	static final String txtbox_long_addeventsec="//input[@id='crimeDto_GeoX']";
	static final String txtbox_lat_addeventsec="//input[@id='crimeDto_GeoY']";
	static final String txtbox_summary_addeventsec="//input[@id='crimeDto_Summary']";
	static final String txtbox_des_addeventsec="//textarea[@id='crimeDto_Description']";
	static final String val_summary_addeventsec="//span[@id='crimeDto_Summary-error']";
	static final String val_ipc_addeventsec="//span[@id='crimeDto_IPC-error']";
	static final String val_long_addeventsec="//span[@id='crimeDto_GeoX-error']";
	static final String val_lat_addeventsec="//span[@id='crimeDto_GeoY-error']";
	static final String txtbox_ipc_editevent=" //input[@id='ipc']";
	static final String txtbox_summary_editevent="//input[@id='summary']";
	static final String verify_crimeevent_ceimetree="//div[@id='incidentsTree']/ul/li/ul/li/a";
	
	
	//-----Add Event Detail-----
	static final String lnk_addeventdetail="//a[text()='Add Event Detail']";
	static final String txtbox_summary_addeventdetail="//input[@id='crimeDetailDto_Summary']";
	static final String txtbox_details_addevebtdetail="//textarea[@id='crimeDetailDto_Details']";
	static final String verify_added_eventdetail="//a[contains(text(),'Test Event detail')]";
	static final String val_summary_addeventdetail="//span[@id='crimeDetailDto_Summary-error']";
	static final String val_details_addeventdetail="//span[@id='crimeDetailDto_Details-error']";
	static final String lnk_editeventdetails="//a[text()='Edit Event Detail']";
	static final String verify_edited_eventdetail="//a[contains(text(),'Edit Event detail')]";
	
	//------Add Attachment------
	static final String lnk_addattachment="//a[text()='Add Attachment']";
	static final String searchbox_attachmentsec="(//input[@class='form-control form-control-sm'])[1]";
	static final String btn_addattachment="//button[@id='AddNewAttachment']";
	static final String col_lbl_attatype_attsec="(//th[text()='Attachment Type'])[1]";
	static final String col_lbl_view_attsec="(//th[text()='View'])[1]";
	static final String col_lbl_desc_attsec="(//th[text()='Description'])[1]";
	static final String col_lbl_type_attsec="(//th[text()='Type'])[1]";
	static final String col_lbl_creatname_attsec="(//th[text()='Creator Name (Badge No)'])[1]";
	static final String col_lbl_creattime_attsec="(//th[text()='Creation Time'])[1]";
	static final String col_lbl_lastmodiname_attsec="(//th[text()='Last Modifier Name (Badge No)'])[1]";
	static final String col_lbl_lastmoditime_attsec="(//th[text()='Last Modification Time'])[1]";
	static final String scroll_to_hori="(//div[@class='dataTables_scrollBody']/table/tbody/tr/td[9])[1]";
	static final String verify_att_attsec="//table[@id='AttachmentTable']/tbody/tr[1]/td[2]";
	static final String verify_viewatta_attsec="//table[@id='AttachmentTable']/tbody/tr[1]/td[3]";
	static final String lnk_viewdetail="(//a[text()='View Detail'])[1]";
	static final String lnk_view_attdetails_win="//a[text()='View']";
	static final String verify_desc_attsec="//table[@id='AttachmentTable']/tbody/tr[1]/td[4]";
	
	//-----Add Person------
	static final String btn_addperson="//button[@id='AddNewPerson']";
	static final String lnk_addperson="//a[text()='Add Person']";
	static final String searchbox_personsec="(//input[@class='form-control form-control-sm'])[2]";
	static final String col_lbl_assotype_persec="(//th[text()='Association Type'])[1]";
	static final String col_lbl_firstname_persec="(//th[text()='First Name'])[1]";
	static final String col_lbl_lastname_persec="(//th[text()='Last Name'])[1]";
	static final String col_lbl_age_persec="(//th[text()='Age'])[1]";
	static final String col_lbl_gender_persec="(//th[text()='Gender'])[1]";
	static final String col_lbl_img_persec="(//th[text()='Image'])[1]";
	static final String col_lbl_assocount_persec="(//th[text()='Association Count'])[1]";
	static final String col_lbl_creatname_persec="(//th[text()='Creator Name (Badge No)'])[2]";
	static final String col_lbl_creatime_persec="(//th[text()='Creation Time'])[2]";
	static final String col_lbl_lastmodiname_persec="(//th[text()='Last Modifier Name (Badge No)'])[2]";
	static final String col_lbl_lastmoditime_persec="(//th[text()='Last Modification Time'])[2]";
	static final String scroll_to_hori1_persec="(//table[@id='PersonTable']/tbody/tr[1]/td[8])[1]";
	static final String scroll_to_hori2_persec="(//table[@id='PersonTable']/tbody/tr[1]/td[12])[1]";
	static final String btn_next_persec="//li[@id='PersonTable_next']/a[text()='Next']";
	static final String btn_pre_persec="//li[@id='PersonTable_previous']/a[text()='Previous']";
	static final String dd_entries_persec="(//div[@class='dataTables_length']/label/select)[2]";
	static final String btn_actions_first_persec="(//table[@id='PersonTable']//button[text()='Actions'])[1]";
	static final String lnk_edit_persec="(//table[@id='PersonTable']//a[text()='Edit'])[1]";
	static final String lnk_discard_persec="(//table[@id='PersonTable']//a[text()='Discard'])[1]";
	static final String lnk_viewdetail_persec="(//table[@id='PersonTable']//a[text()='View Detail'])[1]";
	static final String text_showing_entries_persec="(//div[contains(text(),'Showing')])[2]";
	static final String btn_add_newper_win="//button[text()='Add']";
	static final String lnk_pageno_2_persec="//div[@id='InPersonTable']//a[text()='2']";
	
	//-----Add Police Personnel-----
	static final String btn_add_pp="//button[@id='AddNewPolicePerson']";
	static final String col_lbl_firstname_ppsec="//div[@id='PolicePerson']//th[text()='First Name']";
	static final String col_lbl_lastname_ppsec="//div[@id='PolicePerson']//th[text()='Last Name']";
	static final String col_lbl_badgeno_ppsec="//div[@id='PolicePerson']//th[text()='Badge Number']";
	static final String col_lbl_desig_ppsec="//div[@id='PolicePerson']//th[text()='Designation']";
	static final String col_lbl_asscount_ppsec="//div[@id='PolicePerson']//th[text()='Association Count']";
	static final String btn_next_ppsec="//li[@id='PolicePersonTable_next']/a[text()='Next']";
	static final String btn_pre_ppsec="//li[@id='PolicePersonTable_previous']/a[text()='Previous']";
	static final String dd_entries_ppsec="//div[@id='PolicePersonTable_length']/label/select";
	static final String btn_icon_discard_ppsec="//table[@id='PolicePersonTable']/tbody/tr[1]/td/button";
	static final String text_showing_entries_ppsec="//div[@id='PolicePersonTable_info']";
	static final String chbox_pp_addppwindow="//table[@id='PolicePersonnelTable']/tbody/tr/td[2]";
	static final String lnk_pageno_2_ppsec="//div[@id='PolicePersonTable_paginate']//a[text()='2']";
	
	
	
	//-----x-----Crime Types---------x-------
	static final String btn_addcrimetype="//button[@id='NewCrimeTypeButton']";
	static final String col_lbl_name_crimetypes="//th[text()='Name']";
	static final String col_lbl_code_crimetypes="//th[text()='Code']";
	static final String col_lbl_parentname_crimetypes="//th[text()='Parent Name']";
	static final String col_lbl_symimg_crimetypes="//th[text()='Symbol Image']";
	static final String col_lbl_severity_crimetypes="//th[text()='Severity']";
	static final String col_lbl_visibility_crimetypes="//th[text()='Visibility']";
	static final String verify_crimetype_first="//table[@id='CrimeTypesTable']/tbody/tr[1]/td[2]";
	
	static final String txtbox_name_addcrtypewin="//input[@id='CrimeTypes_Name']";
	static final String txtbox_code_addcrtypewin="//input[@id='CrimeTypes_Code']";
	static final String dd_sev_addcrtypewin="//select[@id='CrimeTypes_Severity']";
	static final String dd_parentcrimetype_addcrtypewin="//select[@id='CrimeTypes_ParentId']";
	static final String chbox_visibility_addcrtypewin="//label[text()='Visibility']";
	static final String verify_name_crimetype="//table[@id='CrimeTypesTable']/tbody/tr[1]/td[2]";
	static final String verify_parenttype_crimetype="//table[@id='CrimeTypesTable']/tbody/tr[1]/td[4]";
	static final String val_name_addcrtypewin="//span[@id='CrimeTypes_Name-error']";
	static final String val_code_addcrtypewin="//span[@id='CrimeTypes_Code-error']";
	
	
	//-----x-------Crime Analysis-------x-------
	static final String dd_selAOI_cranalysis="//select[@id='SelectAOI']";
	static final String dd_selward_cranalysis="//div[@id='WardDiv']//button[@class='multiselect dropdown-toggle custom-select text-center']";
	static final String dd_seljuris_cranalysis="//div[@id='JurisdictionDiv']//button[@class='multiselect dropdown-toggle custom-select text-center']";
	static final String dd_crimetype_cranalysis="(//button[@class='multiselect dropdown-toggle custom-select text-center'])[3]";
	static final String dd_severity_cranalysis="(//button[@class='multiselect dropdown-toggle custom-select text-center'])[4]";
	static final String dd_invstatus_cranalysis="(//button[@class='multiselect dropdown-toggle custom-select text-center'])[5]";
	static final String dd_period_cranalysis="//select[@id='dateRange']";
	static final String btn_apply="//button[@id='go']";
	static final String btn_clear="//button[@id='clear']";
	static final String btn_statistics="//button[@id='statistics']";
	static final String btn_actions_cranalysis="//button[@id='navbarDropdown']";
	static final String icon_btn_heatmap="//div[@id='Heatmap']";
	static final String icon_btn_honeycomb="//div[@id='Honeycomb']";
	static final String icon_btn_honeycombgrid="//div[@id='Honeycombgrid']";
	static final String icon_btn_legend="//div[@id='legendClick']";
	static final String icon_btn_tools="//button[@class='btn btn-link toolBarRight-btn dropdown-toggle']";
	static final String btn_selall_selward="(//button[@title=' Select all'])[1]";
	static final String btn_selall_crimetype="(//button[@title=' Select all'])[3]";
	static final String btn_selall_severity="(//button[@title=' Select all'])[4]";
	static final String chbox_sev_high="//button[@title='High']";
	static final String chbox_invstatus_open="//button[@title='Open']";
	static final String chbox_ward_Ghatlodia="//button[@title='Ghatlodia']";
	static final String chbox_juris_vastrapurpolicestation="//button[@title='Vastrapur Police Station']";
	static final String op_pastyear="//option[@value='Past Year']";
	static final String op_beforedate="//option[@id='beDate']";
	static final String op_customrange="//option[@value='Custom Range']";
	
	static final String op_ward="//option[@value='Ward']";
	static final String op_jurisdiction="//option[@value='Jurisdiction']";
	static final String op_drawtool="//option[@value='DrawTool']";
	static final String op_uploadfile="//option[@value='UploadFile']";
	static final String btn_close_uploadfile="//button[@id='visibleFileClose']";
	static final String btn_close_beforedatemodel="(//div[@id='beforeDateRange']//button[text()='Close'])[2]";
	static final String title_win_beforedate="//div[@id='beforeDateRange']//h5[@class='modal-title']";
	static final String title_win_customrangedate="//div[@id='customDateRange']//h5[@class='modal-title']";
	static final String btn_close_customdaterangemodel="(//div[@id='customDateRange']//button[text()='Close'])[2]";
	static final String btn_drawtool_crimeanalysis="//button[@id='drawTool']";
	static final String title_win_uploadfile="//div[@id='fileUploadModalPopUp']//h5[@id='modalTitle']";
	
	static final String dd_filetype_uploadfilewin="//select[@id='fileSelect']";
	static final String btn_accept="//button[@id='fileSubmit']";
	static final String btn_browse_uploadfile="//input[@id='file_upload_input']";
	static final String btn_accept_beforedatemodel="//button[@id='bdModalSubmit']";
	static final String btn_accept_customrangemodel="//div[@id='customDateRange']//button[@id='modalSubmit']";
	
	static final String title_grid="//div[@class='statistics-title']//h2";
	static final String btn_minimize_grid="//button[@id='minimizeBtn']";
	static final String btn_close_grid="//button[@id='closeBtn']";
	static final String btn_maximize_grid="//button[@id='addBtn']";
	static final String txt_showing_entries_grid="//div[@id='IncidentStatisticsTable_info']";
	static final String dd_entries_grid="//div[@id='IncidentStatisticsTable_length']";
	static final String searchbox_grid="(//input[@class='form-control form-control-sm'])[1]";
	static final String btn_next_grid="//li[@id='IncidentStatisticsTable_next']";
	static final String btn_pre_grid="//li[@id='IncidentStatisticsTable_previous']";
	static final String col_lbl_location="//th[contains(text(),'Location')]";
	static final String pinpoint_loc_first_grid="(//img[@src='/images/marker/redpoint.png'])[1]";
	static final String scale_map="//div[@class='distance-legend-label']";
	static final String op_savefilter="//a[@id='saveFilter']";
	static final String op_loadfilter="//a[@id='loadFilter']";
	static final String txtbox_filtername_newfilter_win="//input[@id='filterDto_FilterName']";
	static final String verify_filtername_win="//div[@id='filteredData']//table/tbody/tr[1]/td[2]";
	static final String searchbox_savedfilter_win="//div[@id='filterDataList_filter']//input[@class='form-control form-control-sm']";
	static final String val_filtername="//span[@id='filterDto_FilterName-error']";
	static final String title_win_savedfilters="//div[@id='filteredData']//h5[@class='modal-title']";
	static final String col_lbl_filtername="//th[text()='Filter Name']";
	static final String col_lbl_apply="//th[text()='Apply']";
	static final String col_lbl_statistics="//th[text()='Statistics']";
	static final String btn_apply_first="(//button[text()='Apply'])[1]";
	static final String btn_statistics_first="(//button[text()='Statistics'])[1]";
	
	static final String title_legend_win="//div[text()='Legend']";
	static final String btn_close_popup_win_map="//div[@class='igis_pruthvi-infoBox igis_pruthvi-infoBox-visible']//button[@class='igis_pruthvi-infoBox-close']";
	static final String verify_legend_box="//iframe[@id='legendInfoBox']";
	
	static final String lnk_layer="//a[text()='Layer']";
	static final String lnk_identify="//a[text()='Identify']";
	static final String lnk_bookmark="//a[text()='Bookmark']";
	static final String lnk_swipe="//a[text()='Swipe']";
	static final String lnk_measure="//a[text()='Measure']";
	static final String lnk_drawtool="//a[text()='Draw Tool']";
	static final String lnk_aroundme="//a[text()='Around me']";
	
	static final String title_win_crime="//div[text()='Crime']";
	static final String recono_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//th[text()='Record No']";
	static final String crimetype_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//th[text()='Crime Type']";
	static final String summary_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//th[text()='Summary']";
	static final String jurisdiction_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//th[text()='Jurisdiction']";
	static final String crimetime_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//th[text()='Crime Time']";
	static final String severity_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//th[text()='Severity']";
	static final String creatorname_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//th[text()='Creator Name (Badge No)']";
	
	//static final String icon_btn_viewmoredetail="//a[@data-original-title='View more details']";
	static final String icon_btn_viewmoredetail="//i[@class='fas fa-map-marked-alt']";
	static final String icon_btn_attachment="//a[@data-original-title='Attachments']";
	static final String icon_btn_person="//a[@data-original-title='Persons']";
	static final String icon_btn_pp="//a[@data-original-title='Police Personnel']";
	
	static final String txt_summary_crime_popup="//table[@class='igis_pruthvi-infoBox-defaultTable']//tr[3]/td";
	
}
