package test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import configurations.Webdriver;
import helpers.*;
import page_Object.*;

public class appManager extends Webdriver {
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	app_manager am = new app_manager(getDriver());

	@Test(priority = 6, testName = "2663")
	public void TC2993_Verify_that_the_Add_Application_button_is_present_and_functional() throws IOException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click App Manager
		hm.AppManag().click();
		// Wait for the general tab to appear
		sf.wait_until_element_clickable(getDriver(), am.general());
	}
}