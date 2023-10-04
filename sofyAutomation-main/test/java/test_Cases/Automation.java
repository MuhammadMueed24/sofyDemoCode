package test_Cases;

import static org.testng.Assert.*;

import java.io.IOException;
import org.testng.annotations.Test;

import configurations.Webdriver;
import helpers.*;
import page_Object.*;
import test_Data.Testdata;

public class Automation extends Webdriver {
	HomePage hm = new HomePage(getDriver());
	dashBoard db = new dashBoard(getDriver());
	Helpers sf = new Helpers();
	automation at = new automation(getDriver());
	manualTest mt = new manualTest(getDriver());
	automationHelpers ah = new automationHelpers();
	dashboardHelpers dh = new dashboardHelpers();

	@Test(priority = 38, testName = "Test Cases = TC3226")
	public void TC3326_Automation_Verify_Appselector_release_selector_dropdownmenu_AddApp_Use_Flightandalerts_button_is_inthe_header()
			throws IOException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Automation Button
		hm.Automation().click();
		// wait for the header to appear
		sf.wait_until_element_clickable(getDriver(), mt.testCases());
		// Now perform the assertions as directed in the test case
		sf.ElementStateCheck(hm.AddApp(), db.app_name(), db.releaseVer(), hm.TestFlight(), hm.Alerts());
	}

	@Test(priority = 39, testName = "Test Cases = TC3333")
	public void TC3333_Automation_Verify_when_User_changes_the_app_then_he_is_taken_to_dashboard_by_default()
			throws IOException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Automation Button
		hm.Automation().click();
		// wait for the header to appear
		sf.wait_until_element_clickable(getDriver(), mt.testCases());
		// Select any other application and wait for dropdown
		db.app_dropdown().click();
		sf.wait_until_all_elements_visible(getDriver(), db.schdrop());
		// Now click on any app other than the selected one and assert user is
		// redirected to the dashboard
		String s = ah.changeapp();
		System.out.println(s);
		// Now wait until the user is redirected to the dashboard
		sf.wait_until_element_clickable(getDriver(), db.appType());
		sf.wait_until_element_invisible(getDriver(), mt.loader());
		// Assert whether the app user selected is active
		assertFalse(db.app_name().getText().contains(s));
	}

	@Test(priority = 40, testName = "Test Cases = TC3335/TC3336")
	public void TC3335_TC3336_Automation_Assert_visiblity_of_different_tabs_in_automation() throws IOException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Automation Button
		hm.Automation().click();
		// wait for the header to appear
		sf.wait_until_element_visible(getDriver(), at.tcases());
		// Now Assert all the tabs present
		sf.ElementStateCheck(at.tcases(), at.templates(), at.test_suite(), at.runs_reports());
		// Check whether test cases section is selected by default
		sf.wait_until_element_attribute_changes(getDriver(), at.tcases(),"class", "selected");
	}

	@Test(priority = 41, testName = "Test Cases = TC2094", dataProviderClass = Testdata.class, dataProvider = "nodata", retryAnalyzer = configurations.Rerun_Testcase.class)
	public void TC2094_Automation_Verify_search_bar_is_functional(String defaultapp, String androidurl, String nodata)
			throws IOException {
		// Method that will login and navigate the user to automation tab
		ah.clicker(defaultapp, androidurl);
		// Now pass a text againt which there is no test case and wait until the nodata
		// text is visible
		at.search_bar().sendKeys("zxcv");
		sf.wait_until_element_visible(getDriver(), at.nodata_w());
		assertTrue(at.nodata().getText().contains(nodata));
		// clear the text in the search bar and enter the test case name
		at.search_bar().clear();
		at.search_bar().sendKeys("Five");
		// Now wait until the user is shown test case is shown
		sf.wait_until_text_visible(getDriver(), at.tc1(), "Five equals ten");
	}

	@Test(priority = 42, testName = "Test Cases = TC3339", dataProviderClass = Testdata.class, dataProvider = "packagename", retryAnalyzer = configurations.Rerun_Testcase.class)
	public void TC3339_Automation_Verify_filterButton_bar_is_functional(String defaultapp, String androidurl)
			throws IOException {
		// Method that will login and navigate the user to automation tab
		ah.clicker(defaultapp, androidurl);
		// Now pass a text againt which there is no test case and wait until the nodata
		// text is visible
		sf.ElementStateCheck(at.filter());
	}

	@Test(priority = 43, testName = "Test Cases = TC3341", dataProviderClass = Testdata.class, dataProvider = "filter")
	public void TC3341_1_Automation_Verify_functionality_of_CreatedBy_filter(String filter[])
			throws InterruptedException, IOException {

		// Method that will login and navigate the user to automation tab
		ah.clicker(filter[0], filter[1]);
		// Now pass a text against which there is no test case and wait until the nodata
		// text is visible
		at.filter().click();
		// Wait until the popup appears
		sf.wait_until_element_clickable(getDriver(), at.createdBy());
		// Assert the header text
		sf.ElementText(filter[2], at.filTag());
		sf.ElementText(filter[3], at.createdBy());
		sf.ElementText(filter[4], at.priority());
		sf.ElementText(filter[5], at.bet());
		sf.ElementText(filter[6], at.clearbtn());
		sf.ElementText(filter[7], at.donebtn());
	}

	@Test(priority = 44, testName = "Test Cases = TC3341", dataProviderClass = Testdata.class, dataProvider = "creatby")
	public void TC3341_2_Automation_Verify_functionality_of_CreatedBy_filter(String defaultapp, String androidurl,
			String mail) throws InterruptedException, IOException {

		// Method that will login and navigate the user to automation tab
		ah.clicker(defaultapp, androidurl);
		// Now pass a text against which there is no test case and wait until the nodata
		// text is visible
		at.filter().click();
		// Wait untilthe popup appears
		sf.wait_until_element_clickable(getDriver(), at.createdBy());
		// Now click on the created By dropdown
		at.createdBy().click();
		// wait until user is shown the dropdown
		sf.wait_until_all_elements_visible(getDriver(), at.creatByList());
		// Method that will find the provided mail and click on it
		sf.filterDropdown(getDriver(), at.creatByList(), mail);
		// wait then click the Done button
		sf.wait_until_element_clickable(getDriver(), at.donebtn());
		// Now click the Done button
		at.donebtn().click();
		// Assert whether the user is shown the test case
		sf.wait_until_text_visible(getDriver(), at.tc1(), "Five equals ten");
	}

	@Test(priority = 45, testName = "Test Cases = TC3341", dataProviderClass = Testdata.class, dataProvider = "priority")
	public void TC3341_3_Automation_Verify_functionality_of_CreatedBy_filter(String priority[])
			throws InterruptedException, IOException {

		// Method that will login and navigate the user to automation tab
		ah.clicker(priority[0], priority[1]);
		// Now pass a text against which there is no test case and wait until the nodata
		// text is visible
		at.filter().click();
		// Wait untilthe popup appears
		sf.wait_until_element_clickable(getDriver(), at.priority());
		// Now click on the created By dropdown
		at.priority().click();
		// wait until user is shown the dropdown
		sf.wait_until_all_elements_visible(getDriver(), at.creatByList());
		// Method that will find the provided mail and click on it
		sf.filterDropdown(getDriver(), at.creatByList(), priority[3]);
		// wait then click the Done button
		sf.wait_until_element_clickable(getDriver(), at.donebtn());
		// Now click the Done button
		at.donebtn().click();
		// Wait for loader icon to appear
		sf.wait_until_element_visible(getDriver(), at.loader());
		// Assert whether the user is shown the test case
		sf.wait_until_text_visible(getDriver(), at.tc1(), "Five equals ten");
	}

	@Test(priority = 46, testName = "Test Cases = TC3335", dataProviderClass = Testdata.class, dataProvider = "tcHead")
	public void TC3335_Automation_Verify_the_testcases_tab_headers(String[] header) throws InterruptedException, IOException {

		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Automation Button
		hm.Automation().click();
		// wait for the header to appear
		sf.wait_until_element_visible(getDriver(), at.tcases());
		// Assert the headings
		// Assert the headers text
		sf.usageHeaders(getDriver(), mt.headers(), header, false);
	}

	@Test(priority = 47, testName = "Test Cases = TC3464", dataProviderClass = Testdata.class, dataProvider = "tsHead")
	public void TC3464_Automation_Verify_the_testsuites_tab_headers(String[] tsHead) throws InterruptedException, IOException {

		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Automation Button
		hm.Automation().click();
		// wait for the header to appear
		sf.wait_until_element_visible(getDriver(), at.tcases());
		// Click the Test Suite Button
		at.test_suite().click();
		// Wait for loader icon to appear
		sf.wait_until_element_visible(getDriver(), at.loader());
		// Assert the headings
		sf.usageHeaders(getDriver(), mt.headers(), tsHead, false);
	}
}