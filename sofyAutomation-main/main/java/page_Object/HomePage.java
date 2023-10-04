package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class HomePage extends Webdriver{
	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	By logo = By.id("logo");
	public WebElement app_Logo(){
		return getDriver().findElement(logo);
	}
	By AnimeLogo = By.cssSelector(".logo_div");
	public WebElement AnimeLogo(){
		return getDriver().findElement(AnimeLogo);
	}
	
	By Home = By.cssSelector("ul[class=\"sidenav-list\"]>li:nth-child(1)");
	public WebElement Home(){
		return getDriver().findElement(Home);
	}
	
	By Release = By.cssSelector("ul[class=\"sidenav-list\"]>li:nth-child(2)");
	public WebElement Release(){
		return getDriver().findElement(Release);
	}
	
	By Device_Lab = By.cssSelector("ul[class=\"sidenav-list\"]>li:nth-child(3)");
	public WebElement Device_Lab(){
		return getDriver().findElement(Device_Lab);
	}
	
	By Automation = By.cssSelector("li:nth-child(4)>a");
	public WebElement Automation(){
		return getDriver().findElement(Automation);
	}
	
	By TestData = By.xpath("//span[text()='Testing Data']");
	public WebElement TestData(){
		return getDriver().findElement(TestData);
	}
	
	By ManualTests = By.xpath("//span[text()='Manual Tests']");
	public WebElement ManualTests(){
		return getDriver().findElement(ManualTests);
	}
	
	By AddApp = By.cssSelector(".add_application:nth-child(1)");
	public WebElement AddApp(){
		return getDriver().findElement(AddApp);
	}
	By AddApp_w = By.cssSelector(".add_application:nth-child(1)");
	public By AddApp_w(){
		return AddApp_w;
	}
	By addApp_popup_w = By.cssSelector(".modal-body");
	public By addApp_popup_w() {
		return addApp_popup_w;
	}
	By only_apk_t= By.cssSelector(".text>p>b");
	public WebElement only_apk_t() {
		return getDriver().findElement(only_apk_t);
	}
	By only_apk_file= By.cssSelector(".text>p>b");
	public By only_apk_file() {
		return only_apk_file;
	}
	By DragApp = By.xpath("//h5[contains(text(),'Drag and Drop')]");
	public WebElement DragApp() {
		return getDriver().findElement(DragApp);
	}
	By or = By.cssSelector(".or_div");
	public WebElement or() {
		return getDriver().findElement(or);
	}
	By BrowseFiles = By.cssSelector(".primary_button_files");
	public WebElement BrowseFiles() {
		return getDriver().findElement(BrowseFiles);
	}
	By uploadApk = By.cssSelector(".drop_div>input");
	public WebElement uploadApk() {
		return getDriver().findElement(uploadApk);
	}
	By ClosePop = By.cssSelector(".close svg");
	public WebElement ClosePop() {
		return getDriver().findElement(ClosePop);
	}
	By TestFlight = By.xpath("//span[contains(text(),'Use TestFlight')]");
	public WebElement TestFlight() {
		return getDriver().findElement(TestFlight);
	}
	
	By Alerts = By.cssSelector(".img-reponsive");
	public WebElement Alerts() {
		return getDriver().findElement(Alerts);
	}
	
	By Help = By.cssSelector(".nav_list>ul>li:nth-child(3)");
	public WebElement Help() {
		return getDriver().findElement(Help);
	}
	
	By Account = By.id("dropdownMenu1");
	public WebElement Account() {
		return getDriver().findElement(Account);
	}
	
	By AppManag = By.cssSelector(".second-ul>li:nth-child(2)");
	public WebElement AppManag() {
		return getDriver().findElement(AppManag);
	}
	
	By logo_w = By.id("logo");
	public By app_Logo_w(){
		return logo_w;
	}
}