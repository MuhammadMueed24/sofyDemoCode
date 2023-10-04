package helpers;

import static org.testng.Assert.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import configurations.Webdriver;
import page_Object.HomePage;
import page_Object.SignIn;
import page_Object.dashBoard;

public class dashboardHelpers extends Webdriver {

	Helpers sf = new Helpers();
	dashBoard db = new dashBoard(getDriver());
	SignIn sg = new SignIn(getDriver());
	HomePage hm = new HomePage(getDriver());

	// Method to check the default app
	public void checkDefaultapp(String defaultapp, String androidurl) {

		// First validate that the default application is selected
		if (db.app_name().getText().contains(defaultapp)) {
			Assert.assertEquals(db.app_name().getText(), defaultapp);
			// Now Assert the url
			String logurl = db.appType().getAttribute("src");
			Assert.assertTrue(logurl.equalsIgnoreCase(androidurl) || logurl.equalsIgnoreCase("https://devtest.sofy.ai/assets/icons/android.svg"));
		} else {
			db.app_dropdown().click();
			sf.wait_until_element_clickable(getDriver(), db.defaultapp());
			getDriver().findElement(db.defaultapp()).click();
			Assert.assertEquals(db.app_name().getText(), defaultapp);
			// Now Assert the url
			Assert.assertEquals(db.appType().getAttribute("src"), androidurl);
		}
	}

	// Check element state, Duplicated
	public void ElementStateCheck(WebElement... args) {
		for (WebElement arg : args) {
			Assert.assertTrue(arg.isDisplayed());
			Assert.assertTrue(arg.isEnabled());
		}
	}
	
	// Assert element text
	public void ElementText(String expected, WebElement... args) {
		for (WebElement arg : args) {
			Assert.assertEquals(arg.getText(), expected);
		}
	}
	
	// Click release button
	public void checkRelease() {
		db.releaseVer().click();
		sf.wait_until_element_clickable(getDriver(), db.realeasedropdown_w());
		db.realeasedropdown().click();
	}

	// Clear Notification button
	public void clearNotifications(String clearNotify, String greenUrl) {
		// Click the Alerts button
		hm.Alerts().click();
		// Wait until the drawer opens and notification in the drawer are present
		sf.wait_until_element_visible(getDriver(), db.alertDrawer());
		sf.wait_until_element_visible(getDriver(), db.alertNotify());
		// Click the clear all button
		db.clearAll().click();
		// Wait until the success pop-up is shown
		sf.wait_until_element_visible(getDriver(), db.succ_clear());
//		sf.wait_until_text_visible(getDriver(), db.succ_clear(), clearNotify);
		assertEquals(getDriver().findElement(db.succ_clear()).getText(), clearNotify);
//		assertNotEquals(hm.Alerts().getAttribute("src"), greenUrl);
	}
	// Method that will open the alerts section and check the test shown "No Notifications Exist"
	public void assertclearedNotifications() {
		// Now verify that there is not notification in the notification panel
		sf.wait_until_element_invisible(getDriver(), db.succ_clear());
		sf.wait_until_element_clickable(getDriver(),hm.Alerts());
		hm.Alerts().click();
		sf.wait_until_element_visible(getDriver(), db.nonotify_w());
		// Assert Text
		assertTrue(db.nonotify().getText().contains("No Notifications Exist"));
	}
	
	// Method that will cater notification button and its url
	public void alertsPopUpChecker(String clearNotify, String greenUrl, String blankUrl, String appname,
			String appurl) {
		// TODO Auto-generated method stub
		if (hm.Alerts().getAttribute("src").equals(greenUrl)) {
			// Method that will clear all the notification from alerts
			clearNotifications(clearNotify, greenUrl);
		} else if (hm.Alerts().getAttribute("src").equals(blankUrl)) {
			checkDefaultapp(appname, appurl);
			acquireDevice();
		}

	}
	
	// Static method
	private void acquireDevice() {
		// Click the acquire button of the first device
		db.acquire().click();
		// wait until the emulator is shown on the 2nd screen
		sf.wait_until_appupload_visible(getDriver(), db.emulator());
		// Wait until the automted test  tab is clickable
		sf.wait_until_element_clickable(getDriver(), db.automatedTest());
		db.automatedTest().click();
		
	}

	public void HelpAndInsightArticleAssert(String... args) {
		String v = ".col-11>p:nth-child(1)>a";
		int a = 1;
		for (String arg : args) {
			v = ".col-12 .articals:nth-child("+a+")";
			assertEquals(getDriver().findElement(By.cssSelector(v)).getText(), arg);
			a++;
		}
	}

	public void whatHappeningHeading(String... args) {
		String vb = ".cardCanvas-head .cards-title";
		int a = 0;
		for (String arg : args) {

			sf.wait_until_all_elements_visible(getDriver(), db.whatCard());
			List<WebElement> q = getDriver().findElements(By.cssSelector(vb));
			String s = q.get(a).getText();
			assertEquals(s, arg);
			a++;
		}
	}

	public void assert_uploaded_apps(By bylocator, String calc, String pirate, String Hilton) {
		// .ng-option-label >span
		sf.wait_until_all_elements_visible(getDriver(), bylocator);
		List<WebElement> w = getDriver().findElements(bylocator);
		
		for (int a = 0;a<w.size(); a++) {
			sf.wait_until_all_elements_visible(getDriver(), bylocator);
			List<WebElement> q = getDriver().findElements(bylocator);
			String s = q.get(a).getText();
			if(s.contains(calc) || s.contains(pirate) || s.contains(Hilton)) {
				System.out.println("Found");
			}
			else {
				fail("The Package Name was either empty or not in the test data file Given : "+s);
			}
		}

	}
}