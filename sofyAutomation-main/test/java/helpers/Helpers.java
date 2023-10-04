package helpers;

import static org.testng.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import configurations.ExcelSheet;
import configurations.Webdriver;
import page_Object.HomePage;
import page_Object.SignIn;
import page_Object.dashBoard;
import page_Object.testData_locators;

public class Helpers extends Webdriver {
	ExcelSheet ec = new ExcelSheet();
	public Properties prop;
	SignIn sg = new SignIn(getDriver());
	HomePage hm = new HomePage(getDriver());
	public String Email;
	dashBoard db = new dashBoard(getDriver());
	testData_locators tl = new testData_locators(getDriver());

	/*
	 * Methods that are being used for every webpage
	 */

	// Depreceted method
	public String getBrowserName(WebDriver wd) {
		String qw = "";
		if (wd.toString().contains("Chrome")) {
			qw = "Chrome";
		} else if (getDriver().toString().contains("Edge")) {
			qw = "Edge";
		} else if (getDriver().toString().contains("firefox")) {
			qw = "Firefox";
		}
		return qw;
	}

	// Method to sort
	public String get_Url(String url) throws IOException {
		baseurl = assign_url(url);
		if (baseurl.contains("devtest") || baseurl.equals(null)) {
			baseurl = assign_url("loginUrl");
		}
		manage_driver();
		return baseurl;
	}

	// Get Credential
	public String getcred(String cred) throws IOException {
		return assign_url(cred);
	}

	public String assign_url(String url) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		prop.load(fis);
		baseurl = prop.getProperty(url);
		fis.close();
		prop.clear();
		return baseurl;
	}

	public String return_email() {
		String key = get_Driver_name() + "_new_mail";
		try {
			key = getcred(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}

//	Method that will initialize the variable in the data.properties file
	public void initialize_value(String mail) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		prop.load(fis);
		String driver_name = get_Driver_name() + "_new_mail";
		prop.setProperty(driver_name, mail);
		prop.store(new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties"),
				null);
	}

	// Method that will maximize the window and apply implicit wait
	public void manage_driver() {
		getDriver().get(baseurl);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	// Method to get browser name from the driver object
	public String get_Driver_name() {
		String qw = null;
		if (getDriver().toString().contains("Chrome")) {
			qw = getDriver().toString().substring(0, 6);
		} else if (getDriver().toString().contains("Edge")) {
			qw = getDriver().toString().substring(0, 4);
		} else if (getDriver().toString().contains("Fire")) {
			qw = getDriver().toString().substring(0, 7);
		}
		return qw;
	}

	// Screenshot Method
	public String get_Screenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest_File = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(dest_File));
		return dest_File;
	}
	//to delete iframe
		public void deleteIframe(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("return document.getElementsByClassName('widget-align-right')[0].remove();");
		}

	// Get failed screenshot method
	public String getFailed_Screenshot(String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest_File = System.getProperty("user.dir") + "\\Failed_testcases\\" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(dest_File));
		return dest_File;
	}

	// Method that clicks an element, Only useful in some cases
	public void Click_element(String s) throws InterruptedException {
		getDriver().findElement(By.cssSelector(s)).click();
	}

	public void wait_until_element_clickable(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void wait_until_element_clickable(WebDriver webDriver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void wait_until_element_attribute_changes(WebDriver webDriver, WebElement locator, String tagname,
			String Expected) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.attributeContains(locator, tagname, Expected));
	}

	public void wait_until_element_orientation_changes(WebDriver webDriver, WebElement locator, String height,
			String widht) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.attributeContains(locator, "width", height));
		wait.until(ExpectedConditions.attributeContains(locator, "height", widht));
	}

	public void wait_until_element_invisible(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void wait_until_element_invisible(WebDriver webDriver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(400));
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}

	public void wait_until_element_visible(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void wait_until_element_visible(WebDriver webDriver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public void wait_until_element_visible_and_clickable(WebDriver webDriver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOf(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void wait_until_appupload_visible(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(300));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void wait_until_text_visible(WebDriver webDriver, By locator, String text) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.textToBe(locator, text));
	}

	public void wait_until_text_visible(WebDriver webDriver, WebElement locator, String text) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
	}

	public void wait_until_text_visible_appupload(WebDriver webDriver, WebElement locator, String text) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(400));
		wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
	}

	public void wait_until_text_changes(WebDriver webDriver, By locator, String text) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}

	public void wait_until_all_elements_visible(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	// Method that returns the number of element
	public int return_number_of_elements(WebDriver webDriver, By locator) {
		int total = getDriver().findElements(locator).size();
		return total;
	}

	// Wait until all elements visible
	public void wait_until_all_elements_visible(WebDriver webDriver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(locator));
	}

	// Method that will sign-in to Sofy
	public void getUrl() throws IOException {
		// Navigate to the login page
		get_Url("loginUrl");
		// Wait until element Visible
		wait_until_element_visible(getDriver(), sg.a_login());
		// specify mail and password
		sg.email().sendKeys(return_email());
		sg.pass().sendKeys(getcred("Pass"));
		// click sigin button
		sg.signin().click();
		// Wait until user is redirected to Dashboard
		wait_until_element_clickable(getDriver(), db.appType_w());
	}

	// Generates random mails with hardcoded prefix and postfix
	public String mail() {
		int index = (int) (2000 * Math.random());
		// String email
		String email = "mueed+" + index + "@sofy.ai";
		Email = email;
		System.out.println(Email);
		return email;
	}

	// Generates random text
	public String randomText() {
		int index = (int) (200 * Math.random());
		// String email
		String email = "var" + index;
		Email = email;
		System.out.println(Email);
		return email;
	}

	// Returns a random full name
	public String fullName() {
		String fullName = RandomStringUtils.randomAlphabetic(5);
		fullName = RandomStringUtils.randomAlphabetic(4) + " " + fullName;
		return fullName;
	}

	// Method to check that * is present on signup screen for mandatory fields
	public void asterisks(WebDriver d, By wb, String text) {
		List<WebElement> qwerty = d.findElements(wb);
		for (int i = 0; i < qwerty.size(); i++) {
			List<WebElement> q = d.findElements(wb);
			//assertTrue(q.get(i).getText().contains(text));
			Assert.assertEquals(q.get(i), q.get(i).getText().contains(text));
			
		}
	}	

	// Method to assert all the Error messages that appear on sign up screen
	public void signupErrors(WebDriver d, By wb, String Expected) {
		int size = d.findElements(wb).size();
		for (int i = 0; i < size; i++) {
			List<WebElement> q = d.findElements(wb);
			Assert.assertEquals(q.get(i).getText(), Expected);
		}
	}

	// Static Method to be removed, API should be imlemented instead of this
	public void getverifiedmail() throws InterruptedException {

		wait_until_element_clickable(getDriver(), sg.zoho_w());
		sg.zoho_login().sendKeys("mueed@sofy.ai");
		sg.zoho_nextbtn().click();
		wait_until_element_clickable(getDriver(), sg.zoho_pass_w());
		sg.zoho_pass().sendKeys("id@10787");
		sg.zoho_nextbtn().click();
		Thread.sleep(4000);
		wait_until_element_visible(getDriver(), sg.zohow2());
		wait_until_text_visible(getDriver(), sg.zohow3(), "Sofy - Verify your email");
	}

	// returns random string, lenght based on the param provided
	public String TextLimit(int bn) {
		return RandomStringUtils.randomAlphabetic(bn);
	}

	// Scroll an element into view
	public void scrollIntoView(WebDriver driver, WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", el);
	}

	// Scroll to the page End
	public void scrollToEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Assert values from a drop-down
	public void dropdownvaluescheck(WebDriver d, By wb, String... args) {
		int a = 0;
		for (String arg : args) {
			List<WebElement> q = d.findElements(wb);
			if (q.get(a).getText().contains(arg)) {
				Assert.assertEquals(q.get(a).getText(), arg);
				System.out.println(q.get(a).getText());
			} else {
				fail();
			}
		}
	}

	// hard-coded method to be removed
	public void editAddedValue(WebDriver d, By wb, String... args) {
		int a = 0;
		List<WebElement> w = d.findElements(wb);
		for (int i = 0; i < w.size(); i++) {
			System.out.println("Number of Characters passed to this method " + args.length);
			List<WebElement> q = d.findElements(wb);
			q.get(a).getText().contains(args[i]);
			String s = "//*[@class=\"tr-listing\"][" + a + 1 + "]/td/p[1]";
			getDriver().findElement(By.xpath(s)).getText();
			Assert.assertEquals(q.get(a).getText(), args[i]);
			System.out.println("Test got by the selected item" + q.get(a).getText());
			// Delete the added test data
			s = "//*[@class='tr-listing'][" + (a + 1) + "]/td/div/button[2]";
			getDriver().findElement(By.xpath(s)).click();
			wait_until_element_clickable(getDriver(), tl.successm());
		}
	}

	// Method that takes url as a parameter and then asserts the status code
	public void checkBrokenLink(String url) {
		try {
			HttpURLConnection huc = null;
			huc = (HttpURLConnection) (new URL(url).openConnection());
			int respCode = 200;
			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();

			if (respCode >= 400) {
				System.out.println(url + " is a broken link");
			} else {
				System.out.println(url + " is a valid link");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO: handle exception
	}

	// Method to assert element text
	public void ElementText(String expected, WebElement... args) {
		for (WebElement arg : args) {
			Assert.assertEquals(arg.getText(), expected);
		}
	}

	// Method that navigates back
	public void navigateBack() {
		getDriver().navigate().back();
	}

	// Method that Closes the current window
	public void closeCurrentWindow() {
		getDriver().close();
		switchtab(0);
	}

	// Validate that the WebElement is displayed and enabled
	public void ElementStateCheck(WebElement... args) {
		for (WebElement arg : args) {
			Assert.assertTrue(arg.isDisplayed());
			Assert.assertTrue(arg.isEnabled());
		}
	}

	// Mthod that takes a list of WebElements then assert each one of their text
	public void usageHeaders(WebDriver d, By qw, String[] ags, boolean n) {
		List<WebElement> w = d.findElements(qw);
		for (int i = 0; i < w.size(); i++) {
			List<WebElement> wq = d.findElements(qw);
			WebElement q = wq.get(i);
			String Expected = ags[i];
			Assert.assertEquals(q.getText(), Expected);
			if (n) {
				q.click();
			}
		}
	}

	// Method that will assert the given text with the dropdown text available
	public void filterDropdown(WebDriver d, By qw, String Expected) {
		List<WebElement> w = d.findElements(qw);
		System.out.println(w.size());
		for (int i = 0; i < w.size(); i++) {
			List<WebElement> wq = d.findElements(qw);
			WebElement q = wq.get(i);
			ElementStateCheck(q);
			if (q.getText().contains(Expected)) {
				q.click();
				// Now wait until the dropdown is invisible
				break;
			}
		}
	}

	// Wait for the new window to load
	public boolean waitForNewWindow(WebDriver driver, int timeout) {
		boolean flag = false;
		int counter = 0;
		while (!flag) {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
				Set<String> winId = driver.getWindowHandles();
				if (winId.size() > 1) {
					flag = true;
					return flag;
				}
				Thread.sleep(1000);
				counter++;
				if (counter > timeout) {
					return flag;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		return flag;
	}

	// Method that will only hover over an element
	public void hover(WebDriver d, WebElement we) {
		Actions ac = new Actions(d);
		ac.moveToElement(we);
		ac.build().perform();
	}

	// Method to hover over an element then click it
	public void hover_and_click(WebDriver d, WebElement we) {
		Actions ac = new Actions(d);
		ac.moveToElement(we);
		ac.build().perform();
	}

	// Method that will switch the tab using the provided index number
	public void switchtab(int a) {
		ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(a));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
	}

	// Method that will take number of webelement and will clear the text againt
	// their fields
	public void clearText(WebElement... args) {
		for (WebElement arg : args) {
			arg.clear();
		}
	}
}