package helpers;

import configurations.Webdriver;
import page_Object.HomePage;
import page_Object.testData_locators;

public class tdHeplers extends Webdriver {
	testData_locators tl = new testData_locators(getDriver());
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();

	// Method that will add upload csv sheet
	public void uploadCsvSheet() {
		hm.TestData().click();
		// Wait until the tab is selected
		sf.wait_until_element_clickable(getDriver(), tl.addtestData());
		// Click the add Test data
		tl.addtestData().click();
		// wait until success token shown
		sf.wait_until_element_clickable(getDriver(), tl.csvdata2());
		// Click the csv file option
		tl.csvdata2().click();
		// wait for the navigation drawer to open
		sf.wait_until_element_clickable(getDriver(), tl.upload_btn());
		// Send the csv file using the upload btn
		tl.upload_btn2().sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\Sample.csv");
		// Wait for the success message
		sf.wait_until_text_visible(getDriver(), tl.successm(), "Test Data records imported successfully");
	}

	// Method that will download csv sheet
	public void downloadCsvSheet() {
		hm.TestData().click();
		// Wait until the tab is selected
		sf.wait_until_element_clickable(getDriver(), tl.addtestData());
		// Click the add Test data
		tl.addtestData().click();
		// wait until success token shown
		sf.wait_until_element_clickable(getDriver(), tl.csvdata2());
		// Click the csv file option
		tl.csvdata2().click();
		// wait for the navigation drawer to open
		sf.wait_until_element_clickable(getDriver(), tl.upload_btn());
	}
}
