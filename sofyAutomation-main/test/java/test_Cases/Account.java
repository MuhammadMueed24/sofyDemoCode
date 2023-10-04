package test_Cases;

import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.Test;

import configurations.Webdriver;
import helpers.Helpers;
import page_Object.*;
import test_Data.Testdata;

public class Account extends Webdriver {
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	Locators_Account lc = new Locators_Account(getDriver());

	@Test(priority = 25, testName = "Test Cases = TC2691/TC2692", dataProvider = "autofilled", dataProviderClass = Testdata.class)
	public void TC2691_TC2692_Account_Verify_that_firstname_and_lastname_isautofilled(String[] field)
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		// Validate full name label and value
		sf.wait_until_element_visible(getDriver(), lc.NameField());
		assertEquals(lc.NameFieldLabel().getText(), field[0]);
		assertEquals(lc.NameField().getAttribute("value").toUpperCase(), sf.getcred("FullName").toUpperCase());
		// Validate Email field is disabled and validate that lebel is displayed
		assertEquals(lc.emailFieldLabel().getText(), field[1]);
		assertEquals(lc.emailField().getAttribute("value").toUpperCase(), sf.return_email().toUpperCase());
		assertFalse(lc.emailField().isEnabled());
	}

	@Test(priority = 26, testName = "Test Cases = TC2691/TC2692", dataProvider = "verifySave", dataProviderClass = Testdata.class)
	public void TC2693_TC3311_Account_Verify_fullName_iseditable_and_saved_uponedit(String verify[])
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Buttonlc.account().click();
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		// Clear the text and Specify full namesf.clearText(lc.firstField());
		sf.clearText(lc.NameField());
		String name = sf.TextLimit(8);
		lc.NameField().sendKeys(name);
		// Click save 
		lc.saveChanges().click();
		// Now Assert the success message and provided inputs
		sf.wait_until_element_visible(getDriver(), lc.success_w());
		assertEquals(lc.success().getText(), verify[0]);
		// Validate whether the changes for first and last name were saved or not
		assertEquals(lc.NameField().getAttribute("value").toUpperCase(), name.toUpperCase());
		// Now Revert back the changes
		sf.clearText(lc.NameField());
		lc.NameField().sendKeys(sf.getcred("FullName"));
		lc.saveChanges().click();
		Thread.sleep(1000);
	}

	@Test(priority = 27, testName = "Test Cases = TC2712/TC3316", dataProvider = "apiKey", dataProviderClass = Testdata.class)
	public void TC2712_TC3316_Verifythat_APIKey_canbe_viewedand_canbe_regeneratedby_clicking_Regenerate_key(
			String label, String popup) throws IOException, InterruptedException {
		sf.getUrl();
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		lc.apikey().click();
		// wait for the tabs to download
		sf.wait_until_element_clickable(getDriver(), lc.regenerateKey_w());
		// Assert the label name above the api key
		assertEquals(lc.keyLabel().getText(), label);
		// Assert whether API key is visible
		assertTrue(lc.key().isDisplayed());
		// Validate that the lenght of the generated guid is 36 characters including 4
		// hyphens
		String a = lc.key().getText();
		assertTrue(a.length() == 36);
		// Now generate a new key and assert whether its displayed or not
		lc.regenerateKey().click();
		// wait for the popup to appear
		sf.wait_until_element_visible(getDriver(), lc.apiModal());
		lc.popupYes().click();
		// Now wait until the GUID is changed
		sf.wait_until_text_changes(getDriver(), lc.key_w(), a);
		// Validate that the key has changed
		assertFalse(lc.key().getText() == a);
		// Perform the validations as performed above
		assertTrue(lc.key().isDisplayed());
		// Validate that the lenght of the generated guid is 36 characters including 4
		// hyphens
		String b = lc.key().getText();
		assertTrue(b.length() == 36);
	}

	@Test(priority = 28, testName = "Test Cases = TC2695/TC3421", dataProvider = "password", dataProviderClass = Testdata.class)
	public void TC2695_TC3421_Password_Verify_that_current_password_newpassword_and_retypenewpasswordfields_cantbe_leftempty_whenSaveChanges_buttonispressed(
			String Expected, String savebtnTet) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		sf.wait_until_element_visible(getDriver(), lc.password());
		// Click on the Password button
		lc.password().click();
		Thread.sleep(2000);
		sf.wait_until_element_visible(getDriver(),lc.passHeading());
		lc.savePass().click();
		System.out.println(lc.errorText());
		// Now 3 warnings will be shown
		sf.wait_until_element_visible(getDriver(), lc.errorText());
		//sf.asterisks(getDriver(), lc.errorText(), Expected);
		// Assert that save button is visible and functional
		//assertEquals(lc.saveChanges().getText(), savebtnTet);
		//assertTrue(lc.saveChanges().isDisplayed() && lc.saveChanges().isEnabled());
	}

	@Test(priority = 29, testName = "Test Cases = TC3312", dataProvider = "passinvalid", dataProviderClass = Testdata.class)
	public void TC3312_Account_verifythat_message_displayswhen_usertriesto_entercurrentpassword_inall3fields(
			String pass, String message) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		// Click on the Password Tab
		lc.password().click();
		// Provide all current passwords in the 3 fields
		lc.firstField().sendKeys(pass);
		lc.secondField().sendKeys(pass);
		lc.thirdField().sendKeys(pass);
		lc.saveChanges().click();
		sf.wait_until_text_visible(getDriver(), lc.error_w(), message);
	}

	@Test(priority = 30, testName = "Test Cases = TC3313", dataProvider = "mismatch", dataProviderClass = Testdata.class)
	public void TC3313_Account_verifythat_message_displayswhen_usertries_differentpass_inNewPassword_and_retypefield(
			String pass, String newpass, String mispass, String message) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		// Click on the Password Tab
		lc.password().click();
		// Provide all current passwords in the 3 fields
		lc.firstField().sendKeys(pass);
		lc.secondField().sendKeys(newpass);
		lc.thirdField().sendKeys(mispass);
		lc.savePass().click();
		sf.wait_until_text_visible(getDriver(), lc.error_w(), message);
	}

	@Test(priority = 31, testName = "Test Cases = TC2696", dataProvider = "changepass", dataProviderClass = Testdata.class)
	public void TC2696_Account_verify_that_user_is_able_to_change_password(String pass, String newpass, String message)
			throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		// Click on the Password Tab
		lc.password().click();
		// Provide all current passwords in the 3 fields
		lc.firstField().sendKeys(pass);
		lc.secondField().sendKeys(newpass);
		lc.thirdField().sendKeys(newpass);
		lc.savePass().click();
		sf.wait_until_element_clickable(getDriver(), lc.savePass());
		// Now change the pass back to the previous one
		lc.firstField().sendKeys(newpass);
		lc.secondField().sendKeys(pass);
		lc.thirdField().sendKeys(pass);
		lc.savePass().click();
		sf.wait_until_element_visible(getDriver(), lc.savePass());
	}

	@Test(priority = 32, testName = "Test Cases = TC3273", dataProvider = "checkmail", dataProviderClass = Testdata.class)
	public void TC2698_Account_Verify_that_user_isableto_add_newusers_through_AddnewUser_button(String mail1,
			String mail2) throws IOException, InterruptedException {
		// The getUrl method will signin the website
		sf.getUrl();
		// Click the Account Button
		lc.account().click();
		// Wait for the popup to appear then click it
		sf.wait_until_element_clickable(getDriver(), lc.accSettings_w());
		lc.accSettings().click();
		// Click the Usage and billing section
		lc.users().click();
		// Click on the add users button
		lc.add_users().click();
		// Wait until sidebar shown
		sf.wait_until_element_clickable(getDriver(), lc.ad_w());
		// Now send temporary mail to the text box
		lc.textField().sendKeys(mail1);
		lc.user().click();
		Thread.sleep(3000);
	}
}