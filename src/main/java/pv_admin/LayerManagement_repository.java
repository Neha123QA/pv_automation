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
	
	static final String col_lbl_laytitle="//th[text()='Layer Title']";
	static final String col_lbl_layname="//th[text()='Layer Name']";
}
