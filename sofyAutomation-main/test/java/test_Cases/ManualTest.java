package test_Cases;

import static org.testng.Assert.*;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import configurations.Webdriver;
import helpers.Helpers;
import page_Object.*;
import test_Data.Testdata;

public class ManualTest extends Webdriver {
	manualTest mt = new manualTest(getDriver());
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	Locators_Account lc = new Locators_Account(getDriver());
	testData_locators tl = new testData_locators(getDriver());

	@Test(priority = 48, testName = "Test Cases = TC2939/TC2940")
	public void TC2939_TC2940_ManualTest_Verify_that_the_Manual_Tests_option_is_present_in_the_side_navigation_bar_on_the_Sofy_Portal()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Assert whether the manual test tab is shown and then click it
		Assert.assertTrue(hm.ManualTests().isDisplayed());
		hm.ManualTests().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), mt.testCases());
		// assert that user lands on test cases page
		sf.ElementStateCheck(mt.testCases());
		// Validate that test cases is selected by default
		assertTrue(mt.testCases().getAttribute("class").contains("selected"));
	}

	@Test(priority = 49, testName = "Test Cases = TC2942/TC2943", dataProviderClass = Testdata.class, dataProvider = "dropdown")
	public void TC2942_TC2943_ManualTest_Verify_that_the_Addnew_button_is_present_in_the_top_right_section(
			String create, String importazure, String importcsv) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Manual Test tab
		hm.ManualTests().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), mt.testCases());
		// Assert the Add new button
		sf.ElementStateCheck(lc.add_users());
		// Click the add new button
		lc.add_users().click();
		// Wait for the 3 items to appear
		sf.wait_until_all_elements_visible(getDriver(), mt.addNewBtndropdown());
		// Assert the text againt these
		sf.ElementText(create, mt.createTc());
		sf.ElementText(importazure, mt.azureTc());
		sf.ElementText(importcsv, mt.csvTc());
	}

	@Test(priority = 50, testName = "Test Cases = TC2944")
	public void TC2944_ManualTest_Verify_that_Testcases_Testruns_and_Issues_options_are_visible_tothe_user_and_that_when_clicked_the_user_lands_onthat_respective_tab()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Manual Test tab
		hm.ManualTests().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), mt.tableheader_w());
		// Click on Test runs and wait for the page to load
		mt.testRuns().click();
		sf.wait_until_element_visible(getDriver(), mt.testRun_w());
		// Click on the Issues and wait for page to load
		mt.issues().click();
		sf.wait_until_element_visible(getDriver(), mt.tableheader_w());
	}

	@Test(priority = 51, testName = "Test Cases = TC3319", dataProviderClass = Testdata.class, dataProvider = "header")
	public void TC3319_ManualTest_Toverify_that_details_should_display_in_Title_Created_on_Modified_on_Assigned_to_Imported_and_Actions_columns(
			String[] header) throws IOException, InterruptedException {

		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Manual Test tab
		hm.ManualTests().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), mt.tableheader_w());
		// Assert the headers text the last false value is sent as a token to not click
		// the item
		sf.usageHeaders(getDriver(), mt.headers(), header, false);
	}

	@Test(priority = 53, testName = "Test Cases = TC2946", dataProviderClass = Testdata.class, dataProvider = "header")
	public void TC2946_ManualTest_Verify_that_the_headers_are_present(String[] header)
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Manual Test tab
		hm.ManualTests().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), mt.tableheader_w());
		// Assert the headers text
		sf.usageHeaders(getDriver(), mt.headers(), header, false);
	}
}