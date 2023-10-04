package test_Cases;

import static org.testng.Assert.*;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.Webdriver;
import helpers.Helpers;
import page_Object.Demo;
import page_Object.HomePage;
import page_Object.SignIn;
import test_Data.Testdata;

public class WelcomeDemo extends Webdriver {
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	SignIn sg = new SignIn(getDriver());
	Demo dm = new Demo(getDriver());

	@Test(priority = 10, testName = "Test Cases = 2663/2920/2921/TC2922",dataProvider = "WelcometoSofy", dataProviderClass = Testdata.class)
	public void TC2919_TC2920_TC2921_TC2922_Verify_that_User_is_redirected_to_dashboard_on_Sigin_where_WelCome_Popup_are_working
	(String wel, String withSofy, String preload, String click, String ready)
			throws IOException, InterruptedException {
		// The getUrl method will signin in the website and wait until user is redirected to Dashboard
		sf.getUrl();
		// First wait for the popup and then Assert whether the Message Ready? Lets get
		// started is shown and enabled or not
		sf.wait_until_element_clickable(getDriver(), dm.lets_get_started_w());
		Assert.assertTrue(dm.lets_get_started_close().isEnabled());
		assertEquals(wel, dm.welcome().getText());
		assertEquals(withSofy, dm.withSofy().getText());
		assertEquals(preload, dm.preload().getText());
		assertEquals(click, dm.clicko().getText());
		assertEquals(ready, dm.lets_get_started().getText());
		// Now Click the Ready button
		dm.lets_get_started().click();
		Thread.sleep(1000);
		sf.wait_until_element_clickable(getDriver(), dm.close());
		dm.close().click();
		Thread.sleep(1000);
	}
	/***
	 * Disabled Flow (The three tooltips were disabled by the dev)
	 */
//	@Test(priority = 10, testName = "Test Cases = 2923/2924",dataProvider = "Tooltip1",dataProviderClass = Testdata.class)
//	public void TC2923_TC2924_Verify_that_user_is_prompted_with_popup_displaying(String Tip1h, String Tip1b, String Tip1p, String Tip1n, String Tip2h2
//			,String Tip2b2,String Tip2p2, String Tip3h3, String Tip3b3,String Tip3hp3, String Tip3hp31, String Tip3p3) throws IOException, InterruptedException {
//		// The getUrl method will signin in the website
//		sf.getUrldemo();
//		// All three tooltips will be verified here
//		// First wait until the popup is shown
//		sf.wait_until_element_clickable(getDriver(), dm.Tooltip1_w());
//		// Assert and click the First tooltip1
//		assertTrue(dm.Tooltip1_close().isEnabled());
//		assertEquals(dm.toolTip1head().getText(), Tip1h);
//		assertEquals(dm.toolTip1main().getText(), Tip1b);
//		assertEquals(dm.toolTip1p().getText(), Tip1p);
//		assertEquals(dm.Tooltip1().getText(), Tip1n);
//		dm.Tooltip1().click();
//		// Assert and click the second ToolTip2
//		sf.wait_until_element_clickable(getDriver(), dm.Tooltip2_w());
//		assertTrue(dm.Tooltip2_close().isEnabled());
//		assertEquals(dm.toolTip2head().getText(), Tip2h2);
//		assertEquals(dm.toolTip2main().getText(), Tip2b2);
//		assertEquals(dm.toolTip2p().getText(), Tip2p2);
//		assertEquals(dm.Tooltip2().getText(), Tip1n);
//		dm.Tooltip2().click();
//		// Assert and click the 3rd tooltip
//		sf.wait_until_element_clickable(getDriver(), dm.Tooltip3_w());
//		assertTrue(dm.Tooltip3_close().isEnabled());
//		assertEquals(dm.toolTip3head().getText(),Tip3h3);
//		assertEquals(dm.toolTip3main().getText(), Tip3b3);
//		assertEquals(dm.toolTip3p().getText(),Tip3hp3);
//		assertEquals(dm.toolTip3p2().getText(),Tip3hp31);
//		assertEquals(dm.start().getText(), Tip3p3);
//		Assert.assertTrue(dm.Tooltip3_close().isEnabled());
//		dm.Tooltip3().click();
//		// Assert whether user landed on dashboard
//		sf.wait_until_element_clickable(getDriver(), hm.app_Logo_w());
//		Assert.assertTrue(hm.app_Logo().isDisplayed());
//	}
}