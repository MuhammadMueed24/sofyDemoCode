package helpers;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configurations.Webdriver;
import page_Object.SignIn;

public class signupHelpers extends Webdriver {
	Helpers sf = new Helpers();
	SignIn sg = new SignIn(getDriver());

	// Navigate to Signup Page
	public void navigateToSignUp() throws IOException {
		// Navigate to the site url
		String url = sf.get_Url("url");
		if (url.contains("dev")) {
			// wait for the login Page to appear
			sf.wait_until_element_visible(getDriver(), sg.a_login());
		} else {
			// Wait until the element is visible
			sf.wait_until_element_visible(getDriver(), sg.login());
			// Click the login button
			sg.login().click();
			// Wait until element Visible
			sf.wait_until_element_visible(getDriver(), sg.a_login());
		}
		// Click on Create Account
		sf.switchtab(1);
		sg.signup().click();
		// wait for the SignUp Page to appear
		sf.wait_until_element_visible(getDriver(), sg.full_namew());
	}
	// Navigate to login page
	public void navigate_to_login() throws IOException {
		// Navigate to the site url
		String url = sf.get_Url("url");
		if (url.contains("dev")) {
			// wait for the SignUp Page to appear
			sf.wait_until_element_visible(getDriver(), sg.email());
		} else {
			// Wait until the element is visible
			sf.wait_until_element_visible(getDriver(), sg.login());
			// Click the login button
			sg.login().click();
			// Wait until element Visible
			sf.wait_until_element_visible(getDriver(), sg.a_login());
			sf.switchtab(1);
		}
	}

	// Static method
	public void zohomail(WebDriver d, By wb) {
		for (int i = 0; i < 10; i++) {
			List<WebElement> q = d.findElements(wb);
			String s = q.get(i).getText();
			if (s.contains("Sofy - Verify your email")) {
				q.get(i).click();
				System.out.println("Found!!!!!!!!!!!!!");
				break;
			}
		}
	}
	// Method to click Create Account button
	public void click_create_btn() throws InterruptedException {
		sf.scrollToEnd(getDriver());
		Thread.sleep(500);
		sf.wait_until_element_visible(getDriver(), sg.create_account());
		sf.hover(getDriver(), sg.create_account());
		sg.create_account().click();
	}
}