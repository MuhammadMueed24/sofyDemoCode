package test_Cases;

import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.Test;

import configurations.Webdriver;
import helpers.*;
import page_Object.*;

public class TestData extends Webdriver {
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	testData_locators tl = new testData_locators(getDriver());
	dashboardHelpers dh = new dashboardHelpers();
	tdHeplers th = new tdHeplers();

	@Test(priority = 33, testName = "Test Cases = TC2064")
	public void TC2064_TestData_Verify_that_Add_Test_btn_is_functional() throws IOException, InterruptedException {

		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		hm.TestData().click();
		// Wait until the tab is selected
		sf.wait_until_element_clickable(getDriver(), tl.addtestData());
		dh.ElementStateCheck(tl.addtestData());
	}

	@Test(priority = 34, testName = "Test Cases = TC2074")
	public void TC2074_TestData_Verify_that_delete_btn_is_functional() throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Method that will upload a csv sheet containing only variable
		th.uploadCsvSheet();
		// Wait for the success popup to disappear
		sf.wait_until_element_invisible(getDriver(), tl.succesm());
		// Now try deleting the added test data
		sf.wait_until_element_visible(getDriver(), tl.alph_del());
		// Now click the delete button
		tl.alph_del().click();
		Thread.sleep(1000);
		// wait for the success message to appear
		sf.wait_until_element_visible(getDriver(), tl.succesm());
		sf.wait_until_text_visible(getDriver(), tl.succesm(), "Test Data deleted successfully");
	}

	@Test(priority = 35, testName = "Test Cases = TC2075")
	public void TC2075_TestData_Verify_that_the_search_bar_is_functional() throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Click the Test data
		hm.TestData().click();
		// Wait until the tab is selected
		sf.wait_until_element_clickable(getDriver(), tl.addtestData());
		// Method that will upload a csv sheet containing only variable
		th.uploadCsvSheet();
		sf.wait_until_element_visible(getDriver(), tl.var_list_w());
		String temp = tl.var_list().getText();
		tl.search_btn().sendKeys(temp);
		// wait for the list to reload
		sf.wait_until_element_visible(getDriver(), tl.loader());
		sf.wait_until_element_clickable(getDriver(), tl.var_list_w());
		Thread.sleep(1000);
		sf.asterisks(getDriver(), tl.var_list_w(), temp);
	}

	@Test(priority = 36, testName = "Test Cases = TC2074")
	public void TC2074_TestData_Verify_Delete_button_is_functional() throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Click the Test data
		hm.TestData().click();
		// Wait until the tab is selected
		sf.wait_until_element_clickable(getDriver(), tl.addtestData());
		// Method that will upload a csv sheet containing only variable
		th.uploadCsvSheet();
		sf.wait_until_element_invisible(getDriver(), tl.succesm());
		sf.wait_until_element_visible(getDriver(), tl.var_list_w());
		// Get variable with the name "One"
		tl.search_btn().sendKeys("Alpha");
		// wait for the list to reload
		sf.wait_until_element_clickable(getDriver(), tl.var_list_w());
		tl.delete_entry().click();
		// wait until the deletion message is shown
		sf.wait_until_all_elements_visible(getDriver(), tl.succesm());
		assertEquals(tl.succesm().getText(), "Test Data deleted successfully.");
//		sf.wait_until_text_visible(getDriver(), tl.successm(), "Test Data deleted successfully.");
	}

	@Test(priority = 35, testName = "Test Cases = TC3043")
	public void TC3043_TestData_Verify_that_the_user_is_able_to_create_a_secret_type_variable()
			throws IOException, InterruptedException {

		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		sf.deleteIframe(getDriver());
		// Click the Test data
		hm.TestData().click();
		// Wait until the tab is selected
		sf.wait_until_element_clickable(getDriver(), tl.addtestData());
		// Click the add test button
		tl.addtestData().click();
		// wait until success token shown
		sf.wait_until_element_clickable(getDriver(), tl.csvdata2());
		tl.testdatalink().click();
		sf.wait_until_element_clickable(getDriver(), tl.active_select());
		// CLick on the active variable type
		tl.active_select().click();
		// wait for the dropdown
		sf.wait_until_element_clickable(getDriver(), tl.secret());
		// Click the Secret selection
		tl.secret().click();
		String[] sa = new String[3];
		// Send variable name
		sa[0] = sf.randomText();
		tl.var_name().sendKeys(sa[0]);
		// Send Value
		sa[1] = sf.randomText();
		tl.var_value().sendKeys(sa[1]);
		// Send Description
		sa[2] = sf.randomText();
		tl.var_desc().sendKeys(sa[2]);
		// Click the Create btn
		tl.create_btn().click();
		// wait for the invisiblity of the dropdown item
		sf.wait_until_all_elements_visible(getDriver(), tl.all_var());
		sf.editAddedValue(getDriver(), tl.all_var(), sa[0], sa[1], sa[2]);

	}

	@Test(priority = 37, testName = "Test Cases = TC2686")
	public void TC2686_TestData_Verify_that_a_sample_csv_for_test_data_can_be_downloaded_from_the_ImportfromCSV_side_menu()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// wait until app button is visible
		sf.wait_until_element_clickable(getDriver(), hm.AddApp_w());
		// Click the Test data
		hm.TestData().click();
		// Wait until the tab is selected
		sf.wait_until_element_clickable(getDriver(), tl.addtestData());
		// check the url of the sample sheet
		th.downloadCsvSheet();
		// Assert url
		assertTrue(
				tl.sample().getAttribute("href").contains(".sofy.ai/assets/files/Sofy_Sample_CSV_Import_TestData.csv"));
//		assertEquals(tl.sample().getAttribute("href"),
//				".sofy.ai/assets/files/Sofy_Sample_CSV_Import_TestData.csv");
		// Check response code of th url
		sf.checkBrokenLink(tl.sample().getAttribute("href"));
	}
}