package pv_admin;

public class Dashboard_repository {

	static final String title_header="//li[@class='breadcrumb-item active']";
	static final String menu_dashboard="//span[contains(text(),'Dashboard')]";
	static final String txtbox_startdate="//input[@id='txtStartDate']";
	static final String txtbox_enddate="//input[@id='txtEndDate']";
	static final String btn_GO="//button[@id='btnGo']";
	static final String lnk_totalcrimes="//span[@id='divTotalCrimes']";
	static final String lnk_highseveritycrimes="//span[@id='divHSeverity']";
	static final String lnk_moderateseveritycrimes="//span[@id='divMSeverity']";
	static final String lnk_lowseveritycrimes="//span[@id='divLSeverity']";
	static final String sec_map="//div[@class='dashboard-map']";
	static final String chart1_crimesinAhmCity="(//div[@class='count-section custom-minHeight chart-overflow'])[1]";
	static final String chart2_statusofcrimes="(//div[@class='count-section custom-minHeight chart-overflow'])[2]";
	static final String countsec_totalbeatbandobast="//div[@class='bandobast-section']//div[@class='count-section']";
	static final String chart_beatbandobast="(//div[@class='bandobast-section']//div[@class='count-section chart-overflow'])[1]";
	static final String chart_top5crimes="(//div[@class='bandobast-section']//div[@class='count-section chart-overflow'])[2]";
	static final String chart_top5highestcrimesward="(//div[@class='ward-section']//div[@class='count-section chart-overflow'])[2]";
	static final String chart_top5highestcrimesjurisdiction="(//div[@class='ward-section']//div[@class='count-section chart-overflow'])[1]";
}
