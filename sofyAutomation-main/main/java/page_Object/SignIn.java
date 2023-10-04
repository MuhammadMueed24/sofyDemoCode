package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class SignIn extends Webdriver{
	public SignIn(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	By firstPageLogin= By.xpath("//a[contains(text(),'Log in')]");
	public WebElement firstPageLogin(){
		return getDriver().findElement(firstPageLogin);
	}

	By logo = By.cssSelector(".flex>a:nth-child(1)");
	public WebElement app_Logo(){
		return getDriver().findElement(logo);
	}
	
	By login = By.linkText("Log in");
	public WebElement login(){
		return getDriver().findElement(login);
	}
	
	By assert_login = By.tagName("b");
	public WebElement assert_login(){
		return getDriver().findElement(assert_login);
	}
	
	By email= By.id("signInName");
	public WebElement email(){
		return getDriver().findElement(email);
	}
	
	By pass= By.id("password");
	public WebElement pass(){
		return getDriver().findElement(pass);
	}
	By newpass = By.id("newPassword");
	public WebElement newpass() {
		return getDriver().findElement(newpass);
	}
	By confpass= By.id("reenterPassword");
	public WebElement confpass(){
		return getDriver().findElement(confpass);
	}
	By signin= By.id("next");
	public WebElement signin(){
		return getDriver().findElement(signin);
	}
	
	
	By signup= By.xpath("//a[contains(text(),'Sign up')]");
	public WebElement signup(){
		return getDriver().findElement(signup);
	}
	By create_account = By.id("continue");
	public WebElement create_account(){
		return getDriver().findElement(create_account);
	}
	By testcheck = By.xpath("//form[@id=\"attributeVerification\"]/div[@class=\"buttons\"]");
	public WebElement testcheck() {
		return getDriver().findElement(testcheck);
	}
	By compulsoryFullName = By.cssSelector("app-input:nth-child(1) .input_required");
	public WebElement compulsoryFullName(){
		return getDriver().findElement(compulsoryFullName);
	}
	By compulsoryEmail = By.cssSelector("app-input:nth-child(1) .input_required");
	public WebElement compulsoryEmail(){
		return getDriver().findElement(compulsoryEmail);
	}
	By compulsoryPass= By.cssSelector("app-input:nth-child(1) .input_required");
	public WebElement compulsoryPass(){
		return getDriver().findElement(compulsoryPass);
	}
	
	By fullName = By.id("displayName");
	public WebElement fullname() {
		return getDriver().findElement(fullName);
	}
	By emailAddress = By.id("email");
	public WebElement emailAddress() {
		return getDriver().findElement(emailAddress);
	}
	By companyName = By.id("extension_CompanyName");
	public WebElement companyName() {
		return getDriver().findElement(companyName);
	}
	By phoneNumber = By.id("extension_PhoneNumber");
	public WebElement phoneNumber() {
		return getDriver().findElement(phoneNumber);
	}
	By error = By.xpath("//div[1]/div[@class=\"error itemLevel\"]");
	public WebElement login_mail_error() {
		return getDriver().findElement(error);
	}
	By error1 = By.xpath("//div[2]/div[@class=\"error itemLevel\"]");
	public WebElement login_pass_error() {
		return getDriver().findElement(error1);
	}
	By inv = By.cssSelector(".pageLevel>p");
	public WebElement inv() {
		return getDriver().findElement(inv);
	}
	// Error message when password is less than 6 character
	By passValue = By.cssSelector(".error_text > p");
	public WebElement passValue() {
		return getDriver().findElement(passValue);
	}
	// Weak password pop-up before clicking signup
	By pasValue = By.cssSelector("li:nth-child(2) .error");
	public WebElement pasValue() {
		return getDriver().findElement(pasValue);
	}
	By pasvalue = By.cssSelector("li:nth-child(3) .error");
	public WebElement confpassError() {
		return getDriver().findElement(pasvalue);
	}
	// After Sign up user redirected to confirm page
	By great = By.cssSelector("b");
	public WebElement great() {
		return getDriver().findElement(great);
	}
	By meanTime = By.cssSelector(".auth_content_div>p:first-of-type");
	public WebElement meanTime() {
		return getDriver().findElement(meanTime);
	}
	By see = By.cssSelector(".see-soon");
	public WebElement see() {
		return getDriver().findElement(see);
	}
	By team = By.cssSelector(".signature-text");
	public WebElement team() {
		return getDriver().findElement(team);
	}
	By resend_btn = By.id("continue");
	public WebElement resend_btn() {
		return getDriver().findElement(resend_btn);
	}
	// ZOHO SIGN IN LOCATORS TMP
	By zoho_login = By.id("i0116");
	public WebElement zoho_login() {
		return getDriver().findElement(zoho_login);
	}
	By zoho_nextbtn = By.id("idSIButton9");
	public WebElement zoho_nextbtn() {
		return getDriver().findElement(zoho_nextbtn);
	}
	By zoho_pass = By.id("i0118");
	public WebElement zoho_pass() {
		return getDriver().findElement(zoho_pass);
	}
	By zoho_confirm = By.linkText("Confirm my email");
	public WebElement zoho_confirm() {
		return getDriver().findElement(zoho_confirm);
	}
	By message = By.cssSelector(".zmLSender");
	public By message(){
		return message;
	}
	
	By outlook_signin = By.cssSelector(".auxiliary-actions>ul>li:last-of-type");
	public WebElement outlook_sign() {
		return getDriver().findElement(outlook_signin);
	}
	By zoho_pass_w = By.id("i0118");
	public By zoho_pass_w() {
		return zoho_pass;
	}
	By zoho_w = By.id("i0116");
	public By zoho_w() {
		return zoho_w;
	} 
	By zohow2 = By.xpath("//span[starts-with(text(),\"Sofy\")]");
	public By zohow2() {
		return zohow2;
	}
	By zohow3 = By.xpath("//span[starts-with(text(),\"Sofy\")]");
	public By zohow3() {
		return zohow3;
	}
	By zoho_confirm_w = By.linkText("Confirm my email");
	public By zoho_confirm_w() {
		return zoho_confirm_w;
	}
	// Zoho signin locators
	By acc_verified = By.xpath("//p[contains(text(),\"Your Sofy account is now verified. Please login to continue.\")]");
	public WebElement acc_verified() {
		return getDriver().findElement(acc_verified);
	}
	By great_w = By.xpath("//b[contains(text(),\"Great, we’re getting things set up\")]");
	public By great_w() {
		return great_w;
	}
	By logo1 = By.cssSelector(".flex>a:nth-child(1)");
	public By app_Logo_w(){
		return logo1;
	}
	By a_login = By.tagName("b");
	public By a_login(){
		return a_login;
	}
	By inv_w = By.cssSelector("p>b");
	public By inv_w() {
		return inv_w;
	}
	By full_namew = By.id("displayName");
	public By full_namew() {
		return full_namew;
	}
	By signup_head = By.cssSelector(".form_title>h3");
	public By signup_head() {
		return signup_head;
	}
	// asterisks that are posted against mandatory fields
	By ast = By.cssSelector(".input_required");
	public By ast() {
		return ast;
	}
	// Locator to assert the error messages that appear when user keeps field empty
	By errorTextsignup = By.cssSelector(".itemLevel");
	public By errorTextsignup() {
		return errorTextsignup;
	}
	By privacyPol = By.xpath("//a[contains(text(),'Privacy Policy')]");
	public WebElement privacyPol() {
		return getDriver().findElement(privacyPol);
	}
	By privacyAssert = By.xpath("//h2[contains(text(),'Privacy Policy')]");
	public WebElement privacyAssert() {
		return getDriver().findElement(privacyAssert);
	}
	By termC = By.xpath("//a[contains(text(),'TOS')]");
	public WebElement termC() {
		return getDriver().findElement(termC);
	}
	By termAssert = By.xpath("//h2[contains(text(),\"Terms of Service\")]");
	public WebElement termAssert() {
		return getDriver().findElement(termAssert);
	}
}