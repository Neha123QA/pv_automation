package pv_admin;

public class UserManagement_repository {
	static final String opt_UserManagement="//span[contains(text(),'User Management')]";
	static final String style_exp_coll="//ul[@id='MenuItem_PVAppUserManagement']";
	static final String menu_item_Appusers="//span[contains(text(),'Application Users')]";
	static final String menu_item_orgunits="//span[contains(text(),'Organization Units')]";
	static final String menu_item_Approles="//span[contains(text(),'Application Roles')]";
	static final String menu_item_offie="//span[contains(text(),'Office')]";
	static final String menu_item_designation="//span[contains(text(),'Designations')]";
	static final String menu_item_PolicePersonnel="//span[contains(text(),'Police Personnel')]";
	static final String searchbox="//input[@class='form-control page-search-filter-text']";
	static final String title_header="//li[@class='breadcrumb-item active']";
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
	static final String entries_25="//option[text()='25']";
	static final String entries_10="//option[text()='10']";
	static final String entries_100="//option[text()='100']";
	static final String lnk_Home="//a/i[@class='fa fa-home']";
	static final String dd_entries="(//div[@class='dataTables_length']/label/select)[1]";
	static final String raw_datatable="//div[@class='dataTables_scrollBody']/table/tbody/tr";
	
	
	//Application Users
	static final String btn_newuser="//button[@id='NewUserButton']";
	
	static final String col_lbl_Actions="//th[contains(text(),'Actions')]";
	static final String col_lbl_Username="//th[contains(text(),'User name')]";
	static final String col_lbl_emailadd="//th[contains(text(),'Email address')]";
	static final String col_lbl_phonenum="//th[contains(text(),'Phone Number')]";
	static final String col_lbl_IDproof="//th[contains(text(),'ID Proof')]";
	static final String col_lbl_firstname="//th[contains(text(),'First Name')]";
	static final String col_lbl_lastname="//th[contains(text(),'Last Name')]";
	static final String col_lbl_DOB="//th[contains(text(),'Date Of Birth')]";
	static final String col_lbl_age="//th[contains(text(),'Age')]";
	static final String col_lbl_usertype="//th[contains(text(),'User Type')]";
	static final String col_lbl_country="//th[contains(text(),'Country')]";
	static final String col_lbl_state="//th[contains(text(),'State')]";
	static final String col_lbl_district="//th[contains(text(),'District')]";
	static final String col_lbl_taluka="//th[contains(text(),'Taluka')]";
	static final String col_lbl_village="//th[contains(text(),'Village')]";
	static final String col_lbl_pincode="//th[contains(text(),'PIN Code')]";
	
	//NewUser
	static final String op_citizen="//label[contains(text(),'Citizen')]";
	static final String op_dep_user="//label[contains(text(),'Department User')]";
	
	static final String txtbox_username="//input[@id='UserInfo_UserName']";
	static final String txtbox_emailid="//input[@id='UserInfo_Email']";
	static final String txtbox_firstname="//input[@id='UserInfo_FirstName']";
	static final String txtbox_middlename="//input[@id='UserInfo_MiddleName']";
	static final String txtbox_lastname="//input[@id='UserInfo_LastName']";
	static final String txtbox_DOB="//input[@id='birthdate']";
	static final String dd_gender="//select[@id='UserInfo_Gender']";
	static final String radio_btn_male="//input[@value='Male']";
	static final String radio_btn_female="//input[@value='Female']";
	static final String radio_btn_other="//input[@value='Other']";
	static final String txtbox_pass="//input[@id='UserInfo_Password']";
	static final String txtbox_confipass="//input[@id='UserInfo_ConfirmPassword']";
	static final String txtbox_add1="//input[@id='UserInfo_AddressLine1']";
	static final String txtbox_add2="//input[@id='UserInfo_AddressLine2']";
	static final String txtbox_PINcode="//input[@id='zipcode']";
	static final String txtbox_phonenum="//input[@id='mobileno']";
	static final String dd_country="//select[@id='countryVal']";
	static final String dd_state="//select[@id='stateVal']";
	static final String dd_city="//select[@id='districtVal']";
	static final String dd_taluka="//select[@id='talukaVal']";
	static final String dd_village="//select[@id='villageVal']";
	static final String op_state_Gujarat="//option[contains(text(),'Gujarat')]";
	static final String op_city_ahmedabad="//option[contains(text(),'Ahmedabad')]";
	static final String dd_IDprooftype="//select[@id='UserInfo_TypeId']";
	static final String dd_IDprooftype_edit="//select[@id='UserInfo_IdProofType']";
	static final String op_idtype_identity="//option[contains(text(),'Identity')]";
	static final String btn_fileupload="//input[@id='file']";
	static final String val_citizen_selected="//div[@class='form-group']/input[@value='Citizen']";
	static final String val_depuser_selected="//div[@class='form-group']/input[@value='DepartmentUser']";
	static final String tab_roles="//a[contains(text(),'Roles')]";
	static final String tab_policepersonnel="//a[contains(text(),'Police Personnel')]";
	static final String list_roles="//div[@id='create-user-modal-tabs_1']/div";
	static final String list_roles_approles_page="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]/span[1]";
	static final String txtbox_badgeNo="//input[@id='badgeNO']";
	static final String dd_reportmanager="//select[@id='reportId']";
	static final String dd_office="//select[@id='office']";
	static final String dd_designation="//select[@id='designation']";
	static final String btn_search="//button[@type='submit']";
	static final String verify_username="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]";
	static final String verify_usertype="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[10]";
	static final String icon_btn_visibility="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[5]/a";
	
	
	static final String validation_username="//span[@id='UserInfo_UserName-error']";
	static final String validation_email="//span[@id='UserInfo_Email-error']";
	static final String validation_firstname="//span[@id='UserInfo_FirstName-error']";
	static final String validation_lastname="//span[@id='UserInfo_LastName-error']";
	static final String validation_pass="//span[@id='UserInfo_Password-error']";
	static final String validation_confipass="//span[@id='UserInfo_ConfirmPassword-error']";
	static final String validation_DOB="//span[@id='birthdateError']";
	static final String validation_add1="//span[@id='UserInfo_AddressLine1-error']";
	static final String validation_PINcode="//span[@id='zipcode-error']";
	static final String validation_phonenum="//span[@id='mobileno-error']";
	static final String validation_fileupload="//span[@id='fileerror']";
	
	
	static final String btn_actions="//button[text()='Actions']";
	static final String lnk_savepolicepersonnel="//li/a[text()='Save As PolicePersonnel']";
	static final String lnk_savecitizen="//li/a[text()='Save As Citizen']";
	static final String lnk_edit="(//li/a[text()='Edit'])[1]";
	static final String lnk_claims="//li/a[text()='Claims']";
	static final String lnk_lock="//li/a[text()='Lock']";
	static final String lnk_permissions="//li/a[text()='Permissions']";
	static final String lnk_setpassword="//li/a[text()='Set Password']";
	static final String lnk_changehistory="//li/a[text()='Change History']";
	static final String lnk_delete="(//li/a[text()='Delete'])[1]";
	static final String lnk_discard="(//li/a[text()='Discard'])[1]";
	static final String txtbox_badgeno_savepolicepersonnel="//input[@id='PolicePersonnel_BadgeNo']";
	static final String dd_reportmanager_savepolicepersonnel="//select[@id='PolicePersonnel_ReportingToId']";
	static final String dd_office_savepolicepersonnel="//select[@id='PolicePersonnel_OfficeId']";
	static final String dd_designation_savepolicepersonnel="//select[@id='PolicePersonnel_DesignationId']";
	static final String toast_msg="//div[@class='toast-message']";
	static final String val_badgeno_policepersonnel="//span[contains(text(),'The Badge Number')]";
	static final String val_office_policepersonnel="//span[contains(text(),'The Office field')]";
	static final String val_designation_policepersonnel="//span[contains(text(),'The Designation field')]";
	static final String lnk_existing_idproof="//a[contains(text(),'Existing IdProof')]";
	static final String txtbox_lockoutduration="//input[@id='LockInput_LockoutDuration']";
	static final String dd_lockoutdurationtype="//select[@id='LockInput_LockDurationType']";
	static final String val_lockoutduration="//span[@id='LockInput_LockoutDuration-error']";
	
	static final String account_permissions="//a[@id='v-pills-tab-AbpAccount-tab']";
	static final String auditlog_permissions="//a[@id='v-pills-tab-AuditLogging-tab']";
	static final String cms_permissions="//a[@id='v-pills-tab-CmsKit-tab']";
	static final String crimemapp_permissions="//a[@id='v-pills-tab-CrimeMapping-tab']";
	static final String databasconfi_permissions="//a[@id='v-pills-tab-DbConfig-tab']";
	static final String featuremanage_permissions="//a[@id='v-pills-tab-FeatureManagement-tab']";
	static final String filemanage_permissions="//a[@id='v-pills-tab-FileManagement-tab']";
	static final String forms_permissions="//a[@id='v-pills-tab-Forms-tab']";
	static final String identityserver_permissions="//a[@id='v-pills-tab-IdentityServer-tab']";
	static final String langmanage_permissions="//a[@id='v-pills-tab-LanguageManagement-tab']";
	static final String leptontheam_permissions="//a[@id='v-pills-tab-LeptonThemeManagement-tab']";
	static final String saas_permissions="//a[@id='v-pills-tab-Saas-tab']";
	static final String settingmanage_permissions="//a[@id='v-pills-tab-SettingManagement-tab']";
	static final String sglmapcom_permissions="//a[@id='v-pills-tab-SGLMapComponent-tab']";
	static final String sglpv_permissions="//a[@id='v-pills-tab-SGLPV-tab']";
	static final String txttemplate_permissions="//a[@id='v-pills-tab-TextTemplateManagement-tab']";
	static final String usermanage_permisions="//a[@id='v-pills-tab-UserManagement-tab']";
	static final String chbox_grantallpermissions="//label[contains(text(),'Grant all')]";
	
	static final String txtbox_newpass="//input[@id='NewPasswordInput']";
	static final String val_pass_setpassword="//span[contains(text(),'The set password field')]";
	static final String btn_generate_randompass="//button[@id='GenerateRandomPasswordButton']";
	
	//Application Roles
	static final String btn_newrole="//button[@name='CreateRole']";
	static final String col_lbl_rolename="//th[contains(text(),'Role name')]";
	static final String txtbox_rolename="//input[@id='Role_Name']";
	static final String chbox_defalut_role="//label[text()='Default']";
	static final String chbox_public_role="//label[text()='Public']";
	static final String verify_rolename="//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]";
	static final String val_rolename="//span[@id='Role_Name-error']";
	static final String menu_permissions="//div[@class='custom-scroll-container row']/div/ul/li";
	
	//Designations
	static final String btn_newdesignation="//button[@id='NewDesignationButton']";
	static final String col_lbl_designationname="//th[contains(text(),'Designation Name')]";
	static final String col_lbl_code="//th[contains(text(),'Code')]";
	static final String col_lbl_description="//th[contains(text(),'Description')]";
	static final String txtbox_designationname="//input[@id='Designation_Name']";
	static final String txtbox_code="//input[@id='Designation_Code']";
	static final String txtbox_description_newdesignation="//input[@id='Designation_Desc']";
	static final String verify_designation="//div[@class='dataTables_scrollBody']/table/tbody/tr[1]/td[2]";
	static final String val_designationname="//span[@id='Designation_Name-error']";
	static final String val_code="//span[@id='Designation_Code-error']";
	static final String btn_actions_first="(//button[text()='Actions'])[1]";
	static final String lnk_discard_first="(//li/a[contains(text(),'Discard')])[1]";
	
	//Police Personnel
	static final String col_lbl_username_policepersonnel="//th[contains(text(),'Username')]";
	static final String col_lbl_badgeno="//th[contains(text(),'Badge Number')]";
	static final String col_lbl_designation="//th[contains(text(),'Designation')]";
	static final String col_lbl_reportingmanager="//th[contains(text(),'Reporting Manager')]";
	static final String col_lbl_office="//th[contains(text(),'Office')]";
	static final String col_lbl_officetype="//th[contains(text(),'Office Type')]";
	static final String col_lbl_disctrictname="//th[contains(text(),'DistrictName')]";
	static final String depuser_entries_appusers="//td[contains(text(),'Department User')]";
	static final String txtbox_policepersonnel_username="//input[@id='PolicePersonnel_UserName']";
	static final String txtbox_policepersonnel_badgeno="//input[@id='PolicePersonnel_BadgeNo']";
	static final String dd_policepersonnel_reportingmana="//select[@id='PolicePersonnel_ReportingToId']";
	static final String dd_policepersonnel_office="//select[@id='PolicePersonnel_OfficeId']";
	static final String dd_policepersonnel_designation="//select[@id='PolicePersonnel_DesignationId']";
	
	//Organization Units
	static final String sec_orgtree="//div[@class='card-body']";
	static final String btn_addrootunit="//button[@name='CreateOrganizationUnit']";
	static final String tab_members_orgunits="//a[@id='Members-tab']";
	static final String tab_roles_orgunits="//a[@id='Roles-tab']";
	static final String tab_office_orgunits="//a[@id='Offices-tab']";
	static final String orguser_mememptyinfo="//div[@id='OuMembersEmptyInfo']";
	static final String txtbox_dispname_orgunit="//input[@id='OrganizationUnit_DisplayName']";
	static final String added_orgunit="//span[contains(text(),'Test Organization unit')]";
	static final String val_dispname_orgunit="//span[@class='text-danger field-validation-error']";
	static final String btn_OK="//button[text()='OK']";
	static final String lnk_addsubunit="(//a[text()='Add sub-unit'])[1]";
	static final String lnk_addmember="(//a[text()='Add member'])[1]";
	static final String lnk_addrole="(//a[text()='Add role'])[1]";
	static final String lnk_addoffice="(//li/a[text()='Add Office'])[1]";
	static final String edited_orgunit="//span[contains(text(),'Test Edit orgunit')]";
	static final String added_subunit="//span[contains(text(),'Test subunit')]";
	static final String orgunit_gujarat="//span[contains(text(),'Gujarat')]";
	static final String txtbox_search="(//input[@class='form-control form-control-sm'])[1]";
	static final String chbox_user_admin="//td[text()='admin']";
	static final String chbox_user_depuser1="//td[text()='dep_user_1']";
	static final String chbox_user_depadm1="//td[text()='dep_admin_1']";
	
	static final String btn_save1="//button[text()='Save']";
	static final String btn_cancel1="//button[text()='Cancel']";
	static final String chbox_role_depuser="//*[contains(text(),'Departmental User')]";
	static final String chbox_role_orguser="//*[contains(text(),'Organization User')]";
	static final String verify_role_rolesec="//div[@class='dataTables_scrollBody']/table[@id='DataTables_Table_1']/tbody/tr/td[2]";
	static final String btn_addmember="//button[@name='AddMember']";
	static final String btn_addrole="//button[@name='AddRole']";
	static final String btn_icon_delete="//button[@title='Delete']";
	static final String chbox_selectall="(//input[@id='select_all'])[1]";
	static final String btn_next_rolesec="(//a[text()='Next'])[2]";
	static final String btn_pre_rolesec="(//a[text()='Previous'])[2]";
	static final String dd_entries_rolsec="(//div[@class='dataTables_length']/label/select)[2]";
	static final String btn_icon_delete_rolesec="//table[@id='DataTables_Table_1']//button[@title='Delete']";
	static final String text_muted="//*[contains(text(),'Departmental User')]/span";
	static final String chbox_member_window="//table[@id='OrgPolicePersonnelTable']/tbody/tr";
	
	
	//Office
	static final String btn_newoffice="//button/span[contains(text(),'New Office')]";
	static final String btn_next_officesec="(//a[text()='Next'])[3]";
	static final String btn_pre_officesec="(//a[text()='Previous'])[3]";
	static final String dd_entries_officesec="(//div[@class='dataTables_length']/label/select)[3]";
	static final String txtbox_search_officesec="//div[@id='OfficesTable_wrapper']//input[@class='form-control form-control-sm']";
	static final String col_lbl_Name="//th[text()='Office']";
	static final String col_lbl_add1="//th[text()='Address Line 1']";
	static final String col_lbl_add2="//th[text()='Address Line 2']";
	static final String btn_icon_delete_officesec="//table[@id='DataTables_Table_2']//button[@title='Delete']";
	static final String txtbox_name_office="//input[@id='Office_Name']";
	static final String txtbox_add1_office="//input[@id='Office_AddressLine1']";
	static final String txtbox_add2_office="//input[@id='Office_AddressLine2']";
	static final String txtbox_phone1_office="//input[@id='Office_Phone1']";
	static final String txtbox_phone2_office="//input[@id='Office_Phone2']";
	static final String txtbox_emailid_office="//input[@id='Office_EmailId']";
	static final String dd_type_office="//select[@id='Office_Type']";
	static final String txtbox_desc_office="//input[@id='Office_Desc']";
	static final String txtbox_PIN_office="//input[@id='Office_PinCode']";
	static final String txtbox_ogcfid_office="//input[@id='Office_OgcfId']";
	static final String preselected_dep_office="//select[@id='Office_OrgUnitId']/option";
	static final String verify_office_officesec="//div[@id='OuOfficesTable']//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2]";
	static final String val_officename="//span[@id='Office_Name-error']";
	static final String val_add1_office="//span[@id='Office_AddressLine1-error']";
	static final String val_pincode_office="//span[@id='Office_PinCode-error']";
	static final String val_phone1_office="//span[@id='Office_Phone1-error']";
	static final String val_emailid_office="//span[@id='Office_EmailId-error']";
	static final String btn_action_office="(//button[text()='Actions'])[1]";
	static final String text_showing_entries_office="//div[@id='Offices']//div[contains(text(),'Showing')]";
	
	
	static final String col_lbl_dep="//th[text()='Department']";
	static final String col_lbl_ogcfid="//th[text()='OGC fId']";
	static final String col_lbl_phone1="//th[text()='Phone Number 1']";
	static final String col_lbl_phone2="//th[text()='Phone Number 2']";
	static final String dd_dep_office="//select[@id='Office_OrgUnitId']";
	static final String verify_office="(//div[@class='dataTables_scrollBody']/table/tbody/tr/td[2])[1]";
	static final String col_lbl_emailid="//th[contains(text(),'Email Id')]";
	static final String scroll_to_hori="(//div[@class='dataTables_scrollBody']/table/tbody/tr/td[18])[1]";
}
