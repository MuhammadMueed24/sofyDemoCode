package helpers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import configurations.Webdriver;
import page_Object.Locators_Account;

public class accountHelpers extends Webdriver {
	Helpers sf = new Helpers();
	Locators_Account lc = new Locators_Account(getDriver());

	public void navigatetoAccount() {
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		// wait until account page is loaded
		sf.wait_until_element_visible(getDriver(), lc.account_w());
	}

	public void filterdropdown() {
		sf.wait_until_element_clickable(getDriver(), lc.filter_w());
		// Now Click on the Filter Button
		lc.filter().click();
		// wait until screen appears
		sf.wait_until_element_visible(getDriver(), lc.filterTag_w());
		// Click the Testing type
		lc.testtype().click();
		// wait for the dropdown to appear
		sf.wait_until_element_clickable(getDriver(), lc.schedule_w());
	}

	public void search_acquired_sessions(WebDriver d, By locator, String text) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(lc.account_w()));
		List<WebElement> a = getDriver().findElements(locator);
		int b = a.size();
		if (b > 0) {
			for (int i = 1; i < b; i++) {
				String x = ".tr-listing:nth-child(" + i + ")>td:nth-child(8)";
				WebElement q = d.findElement(By.cssSelector(x));
				Assert.assertEquals(q.getText(), text);
			}
		}
//		wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
	}

	public void accounts_filter(WebDriver d, By locator, String labsession, String notfound)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		Thread.sleep(2000);
		List<WebElement> a = getDriver().findElements(locator);
		int b = a.size();
		System.out.println(b);
		if (b > 0) {
			for (int i = 1; i < b; i++) {
				
				String x = ".tr-listing:nth-child(" + i + ")>td:nth-child(7)";
				WebElement q = d.findElement(By.cssSelector(x));
				sf.scrollIntoView(d, q);
				Assert.assertEquals(q.getText(), labsession);
				System.out.println(q.getText());
			}
		} else {
			sf.scrollIntoView(d, lc.nodata());
			System.out.println(lc.nodata().getText());
			wait.until(ExpectedConditions.textToBePresentInElement(lc.nodata(), notfound));
			Assert.assertEquals(lc.nodata().getText(), notfound);
//				Assert.assertEquals(false, false);
		}

	}

	public void usageHeaders(WebDriver d, String[] header, List<WebElement> list) {
		for (int i = 0; i < 8; i++) {
			String Actual = list.get(i).getText();
			System.out.println(Actual);
			Assert.assertEquals(Actual, header[i]);
		}
	}
}
