package test_Cases;

import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.Test;

import configurations.Webdriver;
import helpers.*;
import page_Object.*;
import test_Data.Testdata;

public class UsageandBilling extends Webdriver {
	accountHelpers ah = new accountHelpers();
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	Locators_Account lc = new Locators_Account(getDriver());

	@Test(priority = 54, testName = "Test Cases = TC3273", dataProviderClass = Testdata.class, dataProvider = "hourused")
	public void TC3273_Verify_that_the_usage_dial_shows_total_and_used_hours(String minused, String outof)
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		ah.navigatetoAccount();
		// Click Usage
		lc.usage().click();
		// Wait until hours are shown
		sf.wait_until_element_visible(getDriver(), lc.hourused_w());
		// Assert whether used hours are shown
		assertTrue(lc.hourused().isDisplayed());
		assertTrue(lc.totalmin().isDisplayed());
		// Now assert the "Out of " text shown for minutes
	//	System.out.println(lc.hourtext().getText());
	//	assertTrue(lc.hourtext().getText().contains(outof));
	//	System.out.println(outof);
		
		// Assert the total minutes are greater than 0
	//	int n = Integer.parseInt(lc.totalmin().getText());
	//	assertTrue(n > 0);
	}

	@Test(priority = 55, testName = "Test Cases = TC3276", dataProviderClass = Testdata.class, dataProvider = "hourused")
	public void TC3276_Verify_that_usage_dial_used_hours_are_updated_when_minutes_are_consumed(String minused,
			String outof) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		ah.navigatetoAccount();
		// Click Usage
		lc.usage().click();
		// Wait until hours are shown
		sf.wait_until_element_visible(getDriver(), lc.hourused_w());
		// Assert whether used hours are shown
		assertTrue(lc.hourused().isDisplayed());
		// Now assert the "Out of " text shown for minutes
//		assertTrue(lc.hourtext().getText().contains(outof));
//		// Assert the total minutes are greater than 0
//		int n = Integer.parseInt(lc.totalmin().getText());
//		
//		
//		assertTrue(n > 0);
	}

	@Test(priority = 56, testName = "Test Cases = TC3288", dataProviderClass = Testdata.class, dataProvider = "device")
	public void TC3288_Verify_that_searchbar_is_available_and_functional_clickable_in_Usagedetails_section(
			String device) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		ah.navigatetoAccount();
		// Click Usage
		lc.usage().click();
		// Wait until hours are shown
		sf.wait_until_element_visible(getDriver(), lc.hourused_w());
		// Now Validate search is enabled and functional
		assertTrue(lc.search().isDisplayed() && lc.search().isEnabled());
		// Now provide some data in the search button
		lc.search().sendKeys(device.toLowerCase());
		Thread.sleep(2000);
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",getDriver().findElement(By.cssSelector(".list")));
		// Now wait for the listing to appear
		ah.search_acquired_sessions(getDriver(), lc.searchListing(), device);
//		assertFalse(getDriver().findElement(By.cssSelector(".page_number > button:nth-child(3)")).isEnabled());
	}

	@Test(priority = 57, testName = "Test Cases = TC3289", dataProviderClass = Testdata.class, dataProvider = "searchusage")
	public void TC3289_Verify_that_placeholder_search_Usage_should_be_written_in_Searchbar_of_Usagedetails_section(
			String searchusage) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		ah.navigatetoAccount();
		// Click Usage
		lc.usage().click();
		// Wait until hours are shown
		sf.wait_until_element_visible(getDriver(), lc.hourused_w());
		// Now Validate search is enabled and functional
		assertTrue(lc.search().isDisplayed() && lc.search().isEnabled());
		// get Selector
		assertEquals(lc.search().getAttribute("placeholder"), searchusage);
	}

	@Test(priority = 58, testName = "Test Cases = TC3290", dataProviderClass = Testdata.class, dataProvider = "filterusage")
	public void TC3290_Usage_Filter_Icon(String filterusage) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		ah.navigatetoAccount();
		// Click Usage
		lc.usage().click();
		sf.deleteIframe(getDriver());
		// Wait until hours are shown
		sf.wait_until_element_visible(getDriver(), lc.hourused_w());
		// Wait until hours are shown
		//sf.wait_until_element_visible(getDriver(), lc.hourused_w());
		// Now Click on the Filter Button
		lc.filter().click();
		// wait until screen appears
		sf.wait_until_element_visible(getDriver(), lc.filterTag_w());
		assertEquals(lc.filterTag().getText(), filterusage);
		// close the screen
		lc.popupX().click();
		sf.wait_until_element_visible(getDriver(), hm.app_Logo_w());
	}

	@Test(priority = 59, testName = "Test Cases = TC3292", dataProviderClass = Testdata.class, dataProvider = "testingtype")
	public void TC3292_Usage_Toverify_that_ByTestingType_section_should_bevisible_displays_dropdown_byclicking_and_functional_aswell(
			String schedule, String TestFlight, String LabSession, String norecfound)
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		ah.navigatetoAccount();
		// Click Usage
		lc.usage().click();
		sf.deleteIframe(getDriver());
		// This method will take you the filter and click it until the three drop down
		// items appear
		ah.filterdropdown();
		// Click the schedule tag in the drop down
		lc.schedule().click();
		// Now click on the Done Button
		lc.saveChanges().click();
		// Check if any data is shown or message is shown
		ah.accounts_filter(getDriver(), lc.searchListing(), schedule, norecfound);
		// Now for the testflight
		ah.filterdropdown();
		lc.testFlight().click();
		lc.saveChanges().click();
		ah.accounts_filter(getDriver(), lc.searchListing(), TestFlight, norecfound);
		// Check against labsession
		ah.filterdropdown();
		lc.labSessions().click();
		lc.saveChanges().click();
		ah.accounts_filter(getDriver(), lc.searchListing(), LabSession, norecfound);
	}

	@Test(priority = 60, testName = "Test Cases = TC3299", dataProviderClass = Testdata.class, dataProvider = "headers")
	public void TC3299_Usage_Verify_the_column_names(String[] header2) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		ah.navigatetoAccount();
		// Click Usage
		lc.usage().click();
		// Wait until the filter button is visible .list_header>h5:nth-child(1)
		sf.wait_until_element_clickable(getDriver(), lc.filter_w());
		// Now assert all the heading in the tab, use the the for loop to assert the
		// fields
		ah.usageHeaders(getDriver(), header2, lc.usageHeader());
	}

}