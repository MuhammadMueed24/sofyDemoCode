package page_Object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class Locators_Account extends Webdriver{
	public Locators_Account(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	// Account button on homepage
	By account = By.id("dropdownMenu1");
	public WebElement account() {
		return getDriver().findElement(account);
	}
	// Account setting in popup
	By accSettings = By.linkText("Account settings");
	public WebElement accSettings() {
		return getDriver().findElement(accSettings);
	}
	By accSettings_w = By.linkText("Account settings");
	public By accSettings_w() {
		return accSettings_w;
	}
	By account_w = By.cssSelector(".compHeader");
	public By account_w() {
		return account_w;
	}
	// Account Settings Page locators
	By profile = By.cssSelector(".compTabs>span:nth-child(1)");
	public WebElement profile() {
		return getDriver().findElement(profile);
	}
	By password = By.xpath("//span[text()='Change password']");
	public WebElement password() {
		return getDriver().findElement(password);
	}
	By users = By.xpath("//span[text()=' Users ']");
	public WebElement users() {
		return getDriver().findElement(users);
	}
	By apikey = By.cssSelector(".compTabs>span:nth-child(3)");
	public WebElement apikey() {
		return getDriver().findElement(apikey);
	}
	By usage = By.xpath("//span[text()=' Usage and Billing ']");
	public WebElement usage() {
		return getDriver().findElement(usage);
	}
	By NameField = By.xpath("//input[@placeholder=\"Name\"]");
	public WebElement NameField() {
		return getDriver().findElement(NameField);
	}
	By NameFieldLabel = By.xpath("(//div[@class='input_div']/label)[1]");
	public WebElement NameFieldLabel() {
		return getDriver().findElement(NameFieldLabel);
	}
	By emailField = By.xpath("//input[@placeholder='syed@sofy.ai']");
	public WebElement emailField() {
		return getDriver().findElement(emailField);
	}
	By emailFieldLabel = By.xpath("(//div[@class='input_div']/label)[2]");
	public WebElement emailFieldLabel() {
		return getDriver().findElement(emailFieldLabel);
	}
	// THESE ARE COMMON IN PROFILE AND PASSWORD Tab
	// Three labels, 3 text fields in the profile page along with a button 
	By firstField = By.id("oldPassword");
	public WebElement firstField() {
		return getDriver().findElement(firstField);
	}
	By firstFieldLabel = By.cssSelector("app-input:nth-child(1)>.input_div>label");
	public WebElement firstFieldLabel() {
		return getDriver().findElement(firstFieldLabel);
	}
	By secondField = By.id("newPassword");
	public WebElement secondField() {
		return getDriver().findElement(secondField);
	}
	By secondFieldLabel = By.cssSelector("app-input:nth-child(2)>.input_div>label");
	public WebElement secondFieldLabel() {
		return getDriver().findElement(secondFieldLabel);
	}
	By thirdField = By.id("reenterPassword");
	public WebElement thirdField() {
		return getDriver().findElement(thirdField);
	}
	By thirdFieldLabel = By.cssSelector("app-input:nth-child(3)>.input_div>label");
	public WebElement thirdFieldLabel() {
		return getDriver().findElement(thirdFieldLabel);
	}
	By saveChanges = By.cssSelector(".primary_button");
	public WebElement saveChanges() {
		return getDriver().findElement(saveChanges);
	}
	By success= By.cssSelector(".success_text>p>b");
	public WebElement success() {
		return getDriver().findElement(success);
	}
	By success_w= By.cssSelector(".success_text>p>b");
	public By success_w() {
		return success_w;
	}
	By error_w= By.id("passwordEntryMismatch");
	public By error_w() {
		return error_w;
	}
	
	// Locators For hide/view buttons and asteriks rest are the same locators given above
	By passHeading = By.tagName("h3");
	public WebElement passHeading() {
		return getDriver().findElement(passHeading);
	}
	By savePass = By.id("continue");
	public WebElement savePass() {
		return getDriver().findElement(savePass);
	}
	By seekpass1 = By.cssSelector("app-input:nth-child(1) .hide_password_btn");
	public WebElement seekpass1() {
		return getDriver().findElement(seekpass1);
	}
	By seekpass2 = By.cssSelector("app-input:nth-child(2) .hide_password_btn");
	public WebElement seekpass2() {
		return getDriver().findElement(seekpass2);
	}
	By seekpass3 = By.cssSelector("app-input:nth-child(3) .hide_password_btn");
	public WebElement seekpass3() {
		return getDriver().findElement(seekpass3);
	}
	By ast1 = By.cssSelector("app-input:nth-child(1) .input_required");
	public WebElement ast1() {
		return getDriver().findElement(ast1);
	}
	By ast2 = By.cssSelector("app-input:nth-child(2) .input_required");
	public WebElement ast2() {
		return getDriver().findElement(ast2);
	}
	By ast3 = By.cssSelector("app-input:nth-child(3) .input_required");
	public WebElement ast3() {
		return getDriver().findElement(ast3);
	}
	
	// API Key section locators
	By regenerateKey = By.cssSelector(".primary_button");
	public WebElement regenerateKey() {
		return getDriver().findElement(regenerateKey);
	}
	By regenerateKey_w = By.cssSelector(".primary_button");
	public By regenerateKey_w() {
		return regenerateKey;
	}
	By key_label = By.cssSelector(".title_h3");
	public WebElement keyLabel() {
		return getDriver().findElement(key_label);
	}
	By key = By.cssSelector(".key_div");
	public WebElement key() {
		return getDriver().findElement(key);
	}
	By key_w = By.cssSelector(".key_div");
	public By key_w() {
		return key_w;
	}
	By popupText = By.cssSelector(".text-center > h4");
	public WebElement popupText() {
		return getDriver().findElement(popupText);
	}
	
	By popupNo = By.cssSelector(".primary_border_button");
	public WebElement popupNo() {
		return getDriver().findElement(popupNo);
	}
	By popupX = By.cssSelector(".close");
	public WebElement popupX() {
		return getDriver().findElement(popupX);
	}
	By popupYes = By.xpath("//button[contains(text(),'Yes')]");
	public WebElement popupYes() {
		return getDriver().findElement(popupYes);
	}
	
	By popupText_w = By.cssSelector(".text-center > h4");
	public By popupText_w() {
		return popupText_w;
	}
	By ApiModal = By.cssSelector(".head-title");
	public By apiModal() {
		return ApiModal;
	}	
	// Users section locators
	By usage_billing = By.cssSelector(".card");
	public By usage_billing() {
		return usage_billing;
	}
	By add_users = By.cssSelector(".dropdown .primary_button");
	public WebElement add_users() {
		return getDriver().findElement(add_users);
	}
	By newUser = By.cssSelector(".sidebar_title");
	public WebElement newUser() {
		return getDriver().findElement(newUser);
	}
	
	By close = By.cssSelector(".closebtn");
	public WebElement close() {
		return getDriver().findElement(close);
	}
	By textField = By.cssSelector(".input_div>input");
	public WebElement textField() {
		return getDriver().findElement(textField);
	}
	By user = By.cssSelector(".padding-left .radio_icon");
	public WebElement user() {
		return getDriver().findElement(user);
	}
	By admin = By.cssSelector(".radio_checkbox_btns > app-input .radio_icon");
	public WebElement admin() {
		return getDriver().findElement(admin);
	}
	By roleText = By.cssSelector("//label[contains(text(),'Role')]");
	public WebElement roleText() {
		return getDriver().findElement(roleText);
	}
	By adminText = By.cssSelector("//label[contains(text(),'Admin')]");
	public WebElement adminText() {
		return getDriver().findElement(adminText);
	}
	By userText = By.cssSelector("//label[contains(text(),'User')]");
	public WebElement userText() {
		return getDriver().findElement(userText);
	}
	By roleLabel = By.cssSelector(".radio_label");
	public WebElement roleLabel() {
		return getDriver().findElement(roleLabel);
	}
	By adbtn = By.cssSelector(".primary_button > span");
	public WebElement adbtn() {
		return getDriver().findElement(adbtn);
	}
	By errorText = By.cssSelector(".show");
	public By errorText() {
		return errorText;
	}
	By ad_w = By.cssSelector(".text_right .primary_button");
	public By ad_w() {
		return adbtn;
	}
	// Usage and billing
	By hourused = By.cssSelector(".usage-count>h4");
	public WebElement hourused() {
		return getDriver().findElement(hourused);
	}
	By hourtext = By .cssSelector(".usage-content>h4");
	public WebElement hourtext() {
		return getDriver().findElement(hourtext);
	}
	By totalmin = By.cssSelector(".usage-content>h4:nth-child(2)");
	public WebElement totalmin() {
		return getDriver().findElement(totalmin);
	}
	By search = By.cssSelector("input[placeholder='Search Usage']");
	public WebElement search() {
		return getDriver().findElement(search);
	}
	By filter = By.id("filter");
	public WebElement filter() {
		return getDriver().findElement(filter);
	}
	By filter_w = By.id("filter");
	public By filter_w() {
		return filter_w;
	}
	By listing = By.cssSelector(".list");
	public WebElement listing() {
		return getDriver().findElement(listing);
	}
	By searchListing = By.cssSelector(".tr-listing");
	public By searchListing() {
		return searchListing;
	}
	By usageHeader = By.xpath("//th/p");
	public List<WebElement> usageHeader() {
		return getDriver().findElements(usageHeader);
	}
	
	
	// Filter Button elements
	By testtype = By.cssSelector("span .selected_value_div");
	public WebElement testtype() {
		return getDriver().findElement(testtype);
	}
	// THREE sub menus under By testing type
	By schedule = By.cssSelector("li:nth-child(1) .dropdown_list_div");
	public WebElement schedule() {
		return getDriver().findElement(schedule);
	}
	By schedule_w = By.cssSelector("li:nth-child(1) .dropdown_list_div");
	public By schedule_w() {
		return schedule_w;
	}
	By testFlight = By.cssSelector("li:nth-child(2) .dropdown_list_div");
	public WebElement testFlight() {
		return getDriver().findElement(testFlight);
	}
	By labSessions = By.cssSelector("li:nth-child(3) .dropdown_list_div");
	public WebElement labSessions() {
		return getDriver().findElement(labSessions);
	}
	
	// If no data found
	By nodata = By.xpath("//div[@class='no-listing-data']/h6");
	public WebElement nodata() {
		return getDriver().findElement(nodata);
	}
	
	By hourused_w = By.cssSelector(".usage-count>h4");
	public By hourused_w() {
		return hourused_w;
	}
	By filterTag = By.cssSelector(".filter_title");
	public WebElement filterTag() {
		return getDriver().findElement(filterTag);
	}
	By filterTag_w = By.cssSelector(".filter_title");
	public By filterTag_w() {
		return filterTag_w;
	}
}