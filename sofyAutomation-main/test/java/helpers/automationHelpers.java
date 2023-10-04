package helpers;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import configurations.Webdriver;
import page_Object.HomePage;
import page_Object.Locators_Account;
import page_Object.automation;
import page_Object.dashBoard;

public class automationHelpers extends Webdriver {
	Helpers sf = new Helpers();
	Locators_Account lc = new Locators_Account(getDriver());
	dashBoard db = new dashBoard(getDriver());
	dashboardHelpers dh = new dashboardHelpers();
	automation at = new automation(getDriver());
	HomePage hm = new HomePage(getDriver());

	public String changeapp() {
		if (getDriver().findElement(db.schdrop()).isDisplayed()) {
			List<WebElement> wq;
			String s = db.app_name().getText();
			int a = getDriver().findElements(db.appList()).size();
			for (int i = 0; i < a; i++) {
				boolean q = true;
				sf.wait_until_element_clickable(getDriver(), db.appList());
				wq = getDriver().findElements(db.appList());
				if (q != wq.get(i).getText().contains(s)) {
					wq.get(i).click();
					return s;
				}
			}
		}
		return null;
	}

	public void clicker(String a1, String a2) throws IOException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Choose the app Calculator as there are some test cases against that app
		dh.checkDefaultapp(a1, a2);
		// wait until automation tab is clickable
		sf.wait_until_element_visible_and_clickable(getDriver(), hm.Automation());
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Click the Automation Button
		hm.Automation().click();
		// wait for the search bar to appear
		sf.wait_until_element_visible_and_clickable(getDriver(), at.search_bar_w());
	}

}