package test_Cases;

import static org.testng.Assert.*;
import java.io.IOException;
import org.testng.annotations.Test;
import configurations.Webdriver;
import helpers.*;
import page_Object.*;
import test_Data.Testdata;

public class Dashboard extends Webdriver {

	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	dashBoard db = new dashBoard(getDriver());
	dashboardHelpers dh = new dashboardHelpers();

	@Test(priority = 11, testName = "Test Cases = TC1952/TC2948", dataProviderClass = Testdata.class, dataProvider = "packagename")
	public void TC1952_TC2948_Dashboard_Verifycorrect_Package_nameand_Applicationtype_isdisplayed_onDashboard(
			String defaultapp, String androidurl) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Assert the package name
		dh.checkDefaultapp(defaultapp, androidurl);
		// Assert the sofy logo
		dh.ElementStateCheck(hm.app_Logo(), hm.AnimeLogo());
		dh.checkRelease();
	}

	@Test(priority = 12, testName = "Test Cases = TC2949/TC2950")
	public void TC2949_TC2950_Dashboard_Verify_that_Home_Release_DeviceLab_Automation_Testdata_and_ManualTests_options_arepresentin_theside_navigationbar()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Assert whether all the sidebar buttons are operational
		dh.ElementStateCheck(hm.Home(), hm.Release(), hm.Device_Lab(), hm.Automation(), hm.TestData(),
				hm.ManualTests());
	}

	@Test(priority = 13, testName = "Test Cases = TC2954/TC2955/TC2956", dataProviderClass = Testdata.class, dataProvider = "drapApp")
	public void TC2954_TC2955_TC2956_Dashboard_Verify_that_the_AddAPP_button_is_present_in_the_header_and_functional(
			String drag, String or, String Browse) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Assert whether the add app button is visible and functional
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		dh.ElementStateCheck(hm.AddApp());
		// Click the AddApp button
		hm.AddApp().click();
		// Wait until the popup appears
		sf.wait_until_element_visible(getDriver(), hm.addApp_popup_w());
		// Assert all the text on the pop-up
		dh.ElementText(drag, hm.DragApp());
		dh.ElementText(Browse, hm.BrowseFiles());
	}

	@Test(priority = 14, testName = "Test Cases = TC2960/TC2961/TC2963/TC2964", dataProviderClass = Testdata.class, dataProvider = "alerts", enabled = false)
	public void TC2960_TC2961_TC2962_TC2963_TC2964_Dashboard_Verify_that_the_Alerts_option_for_notification_is_present_in_the_header_and_is_clickable(
			String clearNotify, String greenUrl, String blankurl, String appname, String appurl)
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		dh.ElementStateCheck(hm.AddApp());
		// Method to check the green dot if already present
		dh.alertsPopUpChecker(clearNotify, greenUrl, blankurl, appname, appurl);
		// Method to assert empty notification drawer
		dh.assertclearedNotifications();
	}

	@Test(priority = 15, testName = "Test Cases = TC2965/TC2966")
	public void TC2965_TC2966_Dashboard_Verify_that_whenthe_arrowicon_inthe_notification_panel_is_clickedit_closes_the_notification_panel()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Click the alert icon
		hm.Alerts().click();
		// Now wait until the drawer is shown
		sf.wait_until_element_visible(getDriver(), db.alertDrawer());
		// Now click the back button
		db.alertBack().click();
		// wait until the element is invisble
		sf.wait_until_element_invisible(getDriver(), db.alertDrawer());
		// Assert whether the carousel is enabled
		dh.ElementStateCheck(db.carousel());
	}

	@Test(priority = 16, testName = "Test Cases = TC2967")
	public void TC2967_Dashboard_Verify_that_the_SeeAll_button_on_the_device_carousel_is_clickable_and_directs_the_user_to_the_Devicelab()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Click the see all button
		dh.ElementStateCheck(db.seeAll());
		db.seeAll().click();
		// Assert whether the user is on device lab
		sf.wait_until_element_visible(getDriver(), db.devicelab_w());
	}

	@Test(priority = 17, testName = "Test Cases = TC2968")
	public void TC2968_Dashboard_Verify_that_the_left_and_right_arrows_onthe_device_carousel_are_functional()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Now Check if the first left button is disabled
		sf.wait_until_element_attribute_changes(getDriver(), db.leftArrow(), "aria-disabled", "true");
		// Click on the next(Right) arrow so next devices appear in the device carousel
		String devName = db.visDevice().getText();
		// Click the Next arow key
		db.rightArrow().click();
		// Wait until the text changes
		sf.wait_until_text_changes(getDriver(), db.visDevice_w(), devName);
		// Click the back arrow again and assert whether the 1st device appears
		db.leftArrow().click();
		// Wait until the 1st element is visible
		sf.wait_until_text_visible_appupload(getDriver(), db.visDevice(), devName);
	}

	@Test(priority = 18, testName = "Test Cases = TC2974/TC2975", dataProviderClass = Testdata.class, dataProvider = "helpin")
	public void TC2974_TC2975_Dashboard_Verify_that_the_HelpInsights_section_is_present_on_the_homedashboard(
			String helpin, String[] head2) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Validate Help button is visible
		dh.ElementStateCheck(db.helpInsight());
		// Assert the text
		assertEquals(db.helpInsight().getText(), helpin);
		// Method that will assert the articles names on the dashboard
		dh.HelpAndInsightArticleAssert(head2);
//		dh.HelpAndInsightArticleAssert(get, upload, test, create, interact, automated);
	}

	// incomplete
	@Test(priority = 19, testName = "Test Cases = TC2977", dataProviderClass = Testdata.class, dataProvider = "helpin")
	public void TC2977_Dashboard_Verify_that_the_AllArticles_optionis_present_in_the_HelpsInsights_section_and_directs_the_userto_theSofy_blog_page_when_clicked(
			String allAtricle, String get, String upload, String test, String create, String interact, String automated)
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
	}

	@Test(priority = 20, testName = "Test Cases = TC2978/TC2979", dataProviderClass = Testdata.class, dataProvider = "whathappen")
	public void TC2978_TC2979_Dashboard_Verify_that_the_What_Happening_section_is_present_on_the_new_home_dashboard(
			String hap[]) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Scroll to what happen
		sf.scrollToEnd(getDriver());
		sf.deleteIframe(getDriver());
		// Assert what happen text
		assertEquals(db.whathappen().getText(), hap[0]);
		// Method that will assert the whats happening heading
		dh.whatHappeningHeading(hap[1], hap[2], hap[3], hap[4]);
	}

	@Test(priority = 21, testName = "Test Cases = TC2980/TC2981", dataProvider = "selectdate", dataProviderClass = Testdata.class)
	public void TC2980_TC2981_Dashboard_Verify_that_the_dropdown_in_the_WhatsHappening_section_shows_ThisWeek_by_default(
			String qwe) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Scroll to what happen
		sf.scrollToEnd(getDriver());
		// Click the drop down
		db.thisWeek().click();
		// wait until dropdown appears
		sf.wait_until_element_visible(getDriver(), db.selthisWeek_w());
		dh.ElementStateCheck(db.selthisWeek(), db.selMonth(), db.selYear());
		assertTrue(db.selthisWeek().getAttribute("class").contains(qwe));
	}

	@Test(priority = 22, testName = "Test Cases = TC2982/TC2983", dataProviderClass = Testdata.class, dataProvider = "threeTabs")
	public void TC2982_TC2983_Dashboard_Verify_that_the_TestCases_tab_is_open_by_default_on_the_new_home_dashoard(
			String tc, String res, String sch, String select) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		dh.ElementStateCheck(db.testCases(), db.results(), db.schedule());
		assertEquals(db.testCases().getText(), tc);
		assertEquals(db.results().getText(), res);
		assertEquals(db.schedule().getText(), sch);
		assertTrue(db.testCases().getAttribute("class").contains(select));
	}

	@Test(priority = 23, testName = "Test Cases = TC2985")
	public void TC2985_Dashboard_Verify_there_are_refresh_and_seeAll_buttons_against_the_three_tabs()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		dh.ElementStateCheck(db.seall(), db.refr());
		db.results().click();
		sf.wait_until_element_attribute_changes(getDriver(), db.results(), "class", "selected");
	}

	@Test(priority = 24, testName = "Test Cases = TC2989", enabled = false, dataProviderClass = Testdata.class, dataProvider = "schType", groups = {
			"Super Admin" })
	public void TC2989_Dashboard_Verify_that_the_dropdown_in_the_Scheduled_tab_shows_Today_by_default(String select,
			String today, String tomm, String week) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		db.schedule().click();
		// Wait until the tab is selected
		sf.wait_until_element_attribute_changes(getDriver(), db.schedule(), "class", select);
		// Now check whether today is selected by default
		assertEquals(db.todaySch().getText(), today);
		// Click the Today dropdown
		db.todaySch().click();
		// Method that will check all the Text listed in the dropdown
		sf.dropdownvaluescheck(getDriver(), db.schdrop(), today, tomm, week);
	}

	@Test(priority = 23, testName = "Test Cases = TC1951", dataProviderClass = Testdata.class, dataProvider = "installedapps")
	public void TC1951_Dashboard_Verify_that_the_application_dropdown_contains_the_list_of_the_applications_that_have_been_uploaded_on_the_Sofy_portal(
			String calc, String pirate, String Hilton) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), db.app_dropdown());
		// Now Click the drop down
		db.app_dropdown().click();
		// Wait for the drop down div
		sf.wait_until_element_visible(getDriver(), db.schdrop());
		// Now assert the 3 uploaded apps
		dh.assert_uploaded_apps(db.appList(), calc, pirate, Hilton);
	}

	@Test(priority = 23, testName = "Test Cases = TC2957/TC2959", dataProviderClass = Testdata.class, dataProvider = "appUpload")
	public void TC2958_TC2959_Dashboard_Verify_that_when_clicking_on_the_BrowseFiles_button_it_allows_the_user_to_upload_an_application_file_from_your_system(
			String appUp, String upsucc, String Hilton) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Assert whether the add app button is visible and functional
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		dh.ElementStateCheck(hm.AddApp());
		// Click the AddApp button
		hm.AddApp().click();
		// Wait until the popup appears
		sf.wait_until_element_visible(getDriver(), hm.addApp_popup_w());
		// Check if the "Only .apk format is visible"
//		if (sf.return_number_of_elements(getDriver(), hm.only_apk_file()) > 0) {
//			assertEquals(hm.only_apk_t().getText(),"Only .apk file formats supported in trial mode.\n"
//					+ "Need to upload iOS files? Contact Sales.");
//		} else {
//		 Send the apk file
		hm.uploadApk().sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\android.apk");
//		getDriver().findElement(By.cssSelector(".file_upload_div>input"))
//				.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\android.apk");
		sf.wait_until_appupload_visible(getDriver(), db.uploadingBar_w());
		assertEquals(db.uploadinghead().getText(), appUp);
		sf.wait_until_text_visible_appupload(getDriver(), db.uploadSuc(), upsucc);
	}
}