package test_Cases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import configurations.Webdriver;
import helpers.Helpers;
import helpers.signupHelpers;
import page_Object.*;
import test_Data.Testdata;

public class Signup extends Webdriver {
	signupHelpers sh = new signupHelpers();
	HomePage hm = new HomePage(getDriver());
	Helpers sf = new Helpers();
	SignIn sg = new SignIn(getDriver());

	@Test(priority = 1, testName = "TC2639", dataProviderClass = Testdata.class, dataProvider = "signup")
	public void TC2639_Verify_that_mandatory_fields_are_marked_with_asterik_or_displays_an_error_message_when_clicked(
			String Expected) throws IOException, InterruptedException {
		// Method that triggers the webbrowser and navigate to the signup page
		sh.navigateToSignUp();
		// Scroll into view the create account button, Wait for the element visiblity,
		// Hover over it, then click it
		sh.click_create_btn();
		// Wait for the error messages to appear
		sf.wait_until_all_elements_visible(getDriver(), sg.errorTextsignup());
		// Now Error messages will for 3 mandatory fields assert them all
		sf.signupErrors(getDriver(), sg.errorTextsignup(), Expected);
	}

	@Test(priority = 2, testName = "TC2639/TC2640", dataProviderClass = Testdata.class, dataProvider = "passcheck")
	public void TC2640_TC2641_Verify_that_error_messages_appear_on_specifying_weak_passwords(String Pass, String Popup1)
			throws IOException, InterruptedException {
		// Method that triggers the webbrowser and navigate to the signup page
		sh.navigateToSignUp();
		// Populate Full name and Email Field
		sg.fullname().sendKeys(sf.fullName());
		sg.emailAddress().sendKeys(sf.mail());
		// Send Keys to Password Field
		sg.newpass().sendKeys(Pass);
		sg.confpass().sendKeys(Pass);
		// Scroll into view the create account button, Wait for the element visiblity,
		// Hover over it, then click it
		sh.click_create_btn();
		// wait
		sf.wait_until_element_visible(getDriver(), sg.pasValue());
		Assert.assertEquals(sg.confpassError().getText(), Popup1);
		// wait for the element to appear and then assert it
		Assert.assertEquals(sg.confpassError().getText(), Popup1);
	}

	@Test(priority = 3, testName = "2663", dataProviderClass = Testdata.class)
	public void TC2654_Verify_that_it_successfully_redirects_user_to_privacy_policy_and_TOS_Page_if_clicked()
			throws IOException, InterruptedException {
		// Method that triggers the webbrowser and navigate to the signup page
		sh.navigateToSignUp();
		// wait until element clickable
		sf.scrollToEnd(getDriver());
		sf.wait_until_element_clickable(getDriver(), sg.privacyPol());
		// Now click the terms and condition tab
		sg.privacyPol().click();
		sf.waitForNewWindow(getDriver(), 1);
		sf.switchtab(2);
		// Wait for the header to appear and then assert the heading
		sf.wait_until_element_visible(getDriver(), sg.privacyAssert());
		sf.ElementText("Privacy Policy", sg.privacyAssert());
		// Now navigate back to the signup form
		sf.closeCurrentWindow();
		sf.switchtab(1);
		// Click the terms and condition tab and perform assertion of heading there
		sf.wait_until_element_clickable(getDriver(), sg.termC());
		// Click the term and condition
		sg.termC().click();
		// Switch to the newly opened tab
		sf.waitForNewWindow(getDriver(), 1);
		sf.switchtab(2);
		// Wait for the element on the new tab
		sf.wait_until_element_visible(getDriver(), sg.termAssert());
		sf.ElementText("Sofy Testing Service Terms of Service", sg.termAssert());
	}

	@Test(priority = 4, testName = "2663", dataProviderClass = Testdata.class, dataProvider = "validCred")
	public void TC2636_Verify_that_user_is_able_to_signup_using_company_emailID(String valid[])
			throws IOException, InterruptedException {
		// Method that triggers the webbrowser and navigate to the signup page
		sh.navigateToSignUp();
		// Populate Full name and Email Field
//		sg.fullname().sendKeys(sf.fullName());
		sg.fullname().sendKeys(sf.getcred("FullName"));
		String mail = sf.mail();
		sg.emailAddress().sendKeys(mail);
		sf.initialize_value(mail);
		// Send Keys to Password Field
		sg.newpass().sendKeys(valid[0]);
		sg.confpass().sendKeys(valid[0]);
		// Send Phone number and Company name
		sg.phoneNumber().sendKeys("+923222222222");
		sg.companyName().sendKeys("Test Com");
		// Scroll down to the bottom of page
		sf.scrollToEnd(getDriver());
		// Click the Signup Button
		sg.create_account().click();
		// wait until the user is redirected to the next page
		sf.wait_until_element_visible(getDriver(), sg.great_w());
		// Now Assert all the shown text
		Assert.assertEquals(sg.great().getText(), valid[1]);
		Assert.assertEquals(sg.meanTime().getText(), valid[2]);
		Assert.assertEquals(sg.see().getText(), valid[3]);
		Assert.assertEquals(sg.team().getText(), valid[4]);
		Assert.assertTrue(sg.resend_btn().isEnabled());
		Thread.sleep(3000);
	}

	@Test(priority = 5, testName = "2663", dataProviderClass = Testdata.class)
	public void TC2645_TC2646_Verify_Confirmation_mail_inzohomail() throws IOException, InterruptedException {
		// Method that triggers the webbrowser and navigate to the signup page
		sf.get_Url("zohoMail");
		// wait until the signin button is visible
		sf.wait_until_element_visible_and_clickable(getDriver(), sg.outlook_sign());
		// Click the button
		sg.outlook_sign().click();
		sf.getverifiedmail();
		// Click the mail from sofy
		Thread.sleep(1500);
		sh.zohomail(getDriver(), sg.zohow3());
		Thread.sleep(1500);
		sf.wait_until_element_clickable(getDriver(), sg.zoho_confirm_w());
		Thread.sleep(1500);
		sf.scrollIntoView(getDriver(), sg.zoho_confirm());
		Thread.sleep(3000);
		sg.zoho_confirm().click();
		sf.waitForNewWindow(getDriver(), 1);
		sf.switchtab(1);
		sf.wait_until_element_clickable(getDriver(), sg.acc_verified());
		Thread.sleep(2000);
		System.out.println(getDriver().getTitle());
	}
}