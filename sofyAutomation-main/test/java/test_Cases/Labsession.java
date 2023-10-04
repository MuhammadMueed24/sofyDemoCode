package test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;
import configurations.Webdriver;
import helpers.Helpers;
import page_Object.*;

public class Labsession extends Webdriver {
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	labSession_locators ls = new labSession_locators(getDriver());
	dashBoard db = new dashBoard(getDriver());

	@Test(priority = 61, testName = "Test Cases = TC2151/TC2262/TC2162/TC2167/TC2174/TC2175")
	public void TC2151_TC2262_TC2162_TC2167_TC2174_TC2175_Labsession_Acquire_a_Session() throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Device Lab Button
		hm.Device_Lab().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), ls.acquire());
		// Scroll into view the acquire button
		sf.scrollIntoView(getDriver(), ls.acquire());
		// store the app and devicename in vars
		String acq_device = ls.dvname().getText();
		String appname = db.app_name().getText();
		System.out.println(acq_device +"acq"+ "appname"+appname);
		// Click the aquire button
		ls.acquire().click();
		// Wait for the new window to load
		sf.waitForNewWindow(getDriver(), 60);
		// switch to a new tab
		sf.switchtab(1);
		// wait for the page to load
		sf.wait_until_element_visible(getDriver(), ls.dvInfo());
		// Hover over the device info button
		sf.hover(getDriver(), ls.dvInfo());
		// Now assert the values against the two text we previously stored
		sf.wait_until_text_visible_appupload(getDriver(), ls.lab_dvname(), acq_device);
		sf.wait_until_text_visible_appupload(getDriver(), ls.lab_appname(), appname);
		sf.wait_until_element_visible(getDriver(), ls.lab_dversion());
		// Now assert the Text status
		sf.ElementText("Status", ls.lab_dversion());
		sf.ElementStateCheck(ls.lab_dv());
		Thread.sleep(3000);
		// Click the end button
		sf.wait_until_element_clickable(getDriver(), ls.end());
		ls.end().click();
		sf.wait_until_element_visible(getDriver(), ls.endYes());
		ls.endYes().click();
		sf.wait_until_element_visible(getDriver(), ls.endSkip());
		ls.endSkip().click();
	}
	

	@Test(priority = 62, testName = "Test Cases = TC2181/TC2187/TC2197/TC2208")
	public void TC2181_TC2187_TC2197_TC2208_Labsession_Verify_the_Status_heading_is_visible_on_top_right_of_the_page()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Device Lab Button
		hm.Device_Lab().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), ls.acquire());
		// Scroll into view the acquire button
		sf.scrollIntoView(getDriver(), ls.acquire());
		// Click the aquire button
		ls.acquire().click();
		// Wait for the new tab to appear
		sf.waitForNewWindow(getDriver(), 60);
		sf.switchtab(1);
		// wait for the loader icon to appear and then disappear
		sf.wait_until_element_visible(getDriver(), ls.lab_loader());
		sf.wait_until_element_invisible(getDriver(), ls.lab_loader());
		// Assert the elements on the lab
		sf.wait_until_element_visible(getDriver(), ls.manTest());
		sf.ElementStateCheck(ls.manTest(), ls.autTest(), ls.labrecord(), ls.result(), ls.log());
		Thread.sleep(3000);
		sf.wait_until_element_clickable(getDriver(), ls.end());
		ls.end().click();
		sf.wait_until_element_visible(getDriver(), ls.endYes());
		ls.endYes().click();
		sf.wait_until_element_visible(getDriver(), ls.endSkip());
		ls.endSkip().click();
	}

	@Test(priority = 63, testName = "Test Cases = TC2212/TC2267/TC2272/TC2273")
	public void TC2212_TC2267_TC2272_TC2273_Labsession_Verify_the_Status_heading_is_visible_on_top_right_of_the_page()
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Device Lab Button
		hm.Device_Lab().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), ls.acquire());
		// Scroll into view the acquire button
		sf.scrollIntoView(getDriver(), ls.acquire());
		// Click the aquire button
		ls.acquire().click();
		// Wait for the new tab to appear
		sf.waitForNewWindow(getDriver(), 60);
		sf.switchtab(1);
		// wait for the loader icon to appear and then disappear
		sf.wait_until_element_visible(getDriver(), ls.lab_loader());
		sf.wait_until_element_invisible(getDriver(), ls.lab_loader());
		// Assert the elements on the lab also wait for some elements
		sf.wait_until_element_visible(getDriver(), ls.menubar());
		sf.ElementStateCheck(ls.menubar(), ls.orientation(), ls.home(), ls.clearT());
		Thread.sleep(3000);
		sf.wait_until_element_clickable(getDriver(), ls.end());
		ls.end().click();
		sf.wait_until_element_visible(getDriver(), ls.endYes());
		ls.endYes().click();
		sf.wait_until_element_visible(getDriver(), ls.endSkip());
		ls.endSkip().click();
	}

	@Test(priority = 64, testName = "Test Cases = TC2305")
	public void TC2305_Labsession_Verify_Orientation_button_is_functioning() throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Device Lab Button
		hm.Device_Lab().click();
		// wait for the page to load
		sf.wait_until_element_clickable(getDriver(), ls.acquire());
		// Scroll into view the acquire button
		sf.scrollIntoView(getDriver(), ls.acquire());
		// Click the aquire button
		ls.acquire().click();
		// Wait for the new tab to appear
		sf.waitForNewWindow(getDriver(), 60);
		sf.switchtab(1);
		// wait for the loader icon to appear and then disappear
		sf.wait_until_element_visible(getDriver(), ls.lab_loader());
		sf.wait_until_element_invisible(getDriver(), ls.lab_loader());
		sf.wait_until_element_visible(getDriver(), ls.orientation());
	//	String height = ls.lab_dv().getAttribute("height");
	//	String width = ls.lab_dv().getAttribute("width");
		sf.wait_until_element_clickable(getDriver(),ls.orientation());
		Thread.sleep(5000);
		ls.orientation().click();
	//	System.out.println("Height is "+ height + " Width is "+ width);
	//	Thread.sleep(9000);
	//	sf.wait_until_element_orientation_changes(getDriver(), ls.orientation(), height, width);
		Thread.sleep(3000);
		sf.wait_until_element_clickable(getDriver(), ls.end());
		ls.end().click();
		sf.wait_until_element_visible(getDriver(), ls.endYes());
		ls.endYes().click();
		sf.wait_until_element_visible(getDriver(), ls.endSkip());
		ls.endSkip().click();
	}
}