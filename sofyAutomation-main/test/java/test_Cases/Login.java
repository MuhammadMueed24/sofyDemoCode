package test_Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import configurations.*;
import helpers.*;
import page_Object.*;

public class Login extends Webdriver {
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	SignIn sg = new SignIn(getDriver());
	signupHelpers sh = new signupHelpers();

	@Test(priority = 6, testName = "2663")
	public void TC2663_Verify_that_user_is_able_to_login_old_account_using_valid_credentials() throws IOException {
		sh.navigate_to_login();
		// specify mail and password
		sg.email().sendKeys(sf.return_email());
		sg.pass().sendKeys(sf.getcred("Pass"));
		// click sigin button
		sg.signin().click();
		// Wait until user is redirected to Dashboard
		sf.wait_until_element_visible(getDriver(), hm.app_Logo_w());
	}

	@Test(priority = 7, testName = "2667")
	public void TC2667_Verify_mandatoryfields_markedwith_Asterisk_when_userleaves_anyfield_empty() throws IOException {
		// Navigate to the site url
		sh.navigate_to_login();
		// wait until element clickable
		sf.wait_until_element_clickable(getDriver(), sg.signup());
		// Click the login button
		sg.signin().click();
		// Now wait for the error messages to appear
		sf.wait_until_all_elements_visible(getDriver(), sg.login_pass_error());
		// Perform Assertion
		Assert.assertEquals(sg.login_mail_error().getText(), "Please enter your Email Address");
		Assert.assertEquals(sg.login_pass_error().getText(), "Please enter your password");
	}

	@Test(priority = 8, testName = "2668")
	public void TC2668_Verify_correct_errormessage_shownif_userenters_wrongpasswordemail_combinations()
			throws IOException, InterruptedException {
		// Navigate to the site url
		sh.navigate_to_login();
		// Wait until element Visible
		sf.wait_until_element_visible(getDriver(), sg.a_login());
		// specify mail and password
		sg.email().sendKeys("ssha");
		sg.pass().sendKeys("Franky123@");
		// click sigin button
		sg.signin().click();
		sf.wait_until_element_visible(getDriver(), sg.inv());
		// Assert error message is shown
		Assert.assertEquals(sg.inv().getText(), "No Sofy account exists for this user. Please try again with a different email and password or create an account.");
		// Clear both the fields and this time provide valid email and invalid password
		sg.email().clear();
		sg.email().sendKeys(sf.return_email());
		sg.pass().clear();
		sg.pass().sendKeys("Dev12");
		sg.signin().click();
		// Wait until visibility of element located
		sf.wait_until_text_visible(getDriver(), sg.inv(), "Your password is incorrect.");
	}

	@Test(priority = 9, testName = "2663")
	public void TC2669_Verify_that_user_can_access_resetpassword_screen() throws IOException, InterruptedException {
		// Navigate to the site url
		sh.navigate_to_login();
		// Wait until element Visible
		sf.wait_until_element_visible(getDriver(), sg.a_login());
		// specify mail and password
		sg.email().sendKeys(sf.return_email());
		sg.pass().sendKeys(sf.getcred("Pass"));
		// click sigin button
		sg.signin().click();
		// Wait until user is redirected to Dashboard
		sf.wait_until_element_clickable(getDriver(), hm.app_Logo_w());
	}
}