package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class dashBoard extends Webdriver{
	public dashBoard(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	By app_name = By.cssSelector(".selectapp-name");
	public WebElement app_name(){
		return getDriver().findElement(app_name);
	}
	By app_dropdown = By.cssSelector(".selectapp-drop");
	public WebElement app_dropdown() {
		return getDriver().findElement(app_dropdown);
	}
	By alertDrawer = By.cssSelector(".sidebrtitle");
	public By alertDrawer() {
		return alertDrawer;
	}
	By alertNotify = By.cssSelector(".articels");
	public By alertNotify() {
		return alertNotify;
	}
	By alertBack = By.cssSelector(".alert-close");
	public WebElement alertBack() {
		return getDriver().findElement(alertBack);
	}
	By carousel = By.cssSelector(".slick-list");
	public WebElement carousel() {
		return getDriver().findElement(carousel);
	}
	By helpInsight = By.cssSelector(".helpInSight");
	public WebElement helpInsight() {
		return getDriver().findElement(helpInsight);
	}
	By clearAll= By.cssSelector(".allignRight");
	public WebElement clearAll() {
		return getDriver().findElement(clearAll);
	}
	By succ_clear= By.cssSelector(".show_message>h4");
	public By succ_clear() {
		return succ_clear;
	}
	By seeAll = By.linkText("See All");
	public WebElement seeAll() {
		return getDriver().findElement(seeAll);
	}
	By devicelab_w = By.cssSelector(".devices_section>app-device-card");
	public By devicelab_w() {
		return devicelab_w;
	}
			
	By appType_w = By.cssSelector(".selectapp-device-icon-img");
	public By appType_w(){
		return appType_w;
	}
	
	By appType = By.cssSelector(".selectapp-device-icon-img");
	public WebElement appType() {
		return getDriver().findElement(appType);
	}
	
	By defaultapp = By.xpath("//span[contains(text(),'com.google.android.calculator')]");
	public By defaultapp() {
		return defaultapp;
	}
	By whathappen = By.cssSelector(".col-8 > p");
	public WebElement whathappen() {
		return getDriver().findElement(whathappen);
	}
	By thisWeek = By.cssSelector(".col-4 .ng-select .ng-has-value .ng-arrow-wrapper");
	public WebElement thisWeek() {
		return getDriver().findElement(thisWeek);
	}
	By selthisWeek= By.cssSelector(".scroll-host .ng-option:nth-child(1)");
	public WebElement selthisWeek() {
		return getDriver().findElement(selthisWeek);
	}
	By selthisWeek_w= By.cssSelector(".scroll-host .ng-option:nth-child(1)");
	public By selthisWeek_w() {
		return selthisWeek_w;
	}
	By testCases = By.cssSelector(".compTabs>span:nth-child(1)");
	public WebElement testCases() {
		return getDriver().findElement(testCases);
	}
	By results = By.cssSelector(".compTabs>span:nth-child(2)");
	public WebElement results() {
		return getDriver().findElement(results);
	}
	By schedule = By.cssSelector(".compTabs>span:nth-child(3)");
	public WebElement schedule() {
		return getDriver().findElement(schedule);
	}
	By todaySch = By.cssSelector("div.main div.right_content div.pages_content:nth-child(2) div.dashboard.dashboard-card div.row:nth-child(2) div.col-7 div.row:nth-child(2) div.col-12 div.mainClassForCanvas div.commonMargin:nth-child(1) div.schedule-filter-drop div.dropdown-holder.no-border ng-select.custom-select-control.ng-select.ng-select-single.ng-untouched.ng-pristine.ng-valid div.ng-select-container.ng-has-value div.ng-value-container > div.ng-value");
	public WebElement todaySch() {
		return getDriver().findElement(todaySch);
	}
	By schdrop = By.cssSelector(".ng-option");
	public By schdrop() {
		return schdrop;
	}
	By selMonth = By.cssSelector(".scroll-host .ng-option:nth-child(2)");
	public WebElement selMonth() {
		return getDriver().findElement(selMonth);
	}
	By selYear = By.cssSelector(".scroll-host .ng-option:nth-child(3)");
	public WebElement selYear() {
		return getDriver().findElement(selYear);
	}
	By whatCard = By.cssSelector(".cardCanvas-head .cards-title");
	public By whatCard() {
		return whatCard;
	}
	By appList = By.cssSelector(".ng-option-label .selectapp-name");
	public By appList() {
		return appList;
	}
	By uploadingBar = By.cssSelector(".upload_status_div");
	public WebElement uploadingBar() {
		return getDriver().findElement(uploadingBar);
	}
	By uploadSuc = By.cssSelector(".text>h5");
	public WebElement uploadSuc() {
		return getDriver().findElement(uploadSuc);
	}
	By nonotify = By.cssSelector(".noRecord");
	public WebElement nonotify() {
		return getDriver().findElement(nonotify);
	}
	By nonotify_w = By.cssSelector(".noRecord");
	public By nonotify_w() {
		return nonotify_w;
	}
	By uploadingBar_w = By.cssSelector(".upload_status_div");
	public By uploadingBar_w() {
		return uploadingBar_w;
	}
	By uploadinghead = By.cssSelector(".text>h5");
	public WebElement uploadinghead() {
		return getDriver().findElement(uploadinghead);
	}
	//.ng-dropdown-panel-items >div>.ng-option
	By releaseVer = By.cssSelector("ng-select:nth-child(2)>div>div");
	public WebElement releaseVer() {
		return getDriver().findElement(releaseVer);
	}
	By releasedropdown = By.cssSelector(".ng-dropdown-panel-items >div>.ng-option");
	public WebElement realeasedropdown() {
		return getDriver().findElement(releasedropdown);
	}
	By releasedropdown_w = By.cssSelector(".ng-dropdown-panel-items >div>.ng-option");
	public By realeasedropdown_w() {
		return releasedropdown_w;
	}
	
	// See all and refresh button againt all the three tabs
	By seall= By.cssSelector(".col-5>a:nth-child(1)");
	public WebElement seall() {
		return getDriver().findElement(seall);
	}
	By refr= By.cssSelector(".col-5>a:nth-child(2)");
	public WebElement refr() {
		return getDriver().findElement(refr);
	}
	By leftArrow = By.cssSelector(".slick-prev.slick-arrow");
	public WebElement leftArrow() {
		return getDriver().findElement(leftArrow);
	}
	By rightArrow = By.cssSelector(".slick-next.slick-arrow");
	public WebElement rightArrow() {
		return getDriver().findElement(rightArrow);
	}
	By visDevice = By.cssSelector(".device-bio");
	public WebElement visDevice() {
		return getDriver().findElement(visDevice);
	}
	By visDevice_w = By.cssSelector(".device-bio");
	public By visDevice_w() {
		return visDevice_w;
	}
	
	// Locators for acquiring device
	By acquire = By.cssSelector(".slide:nth-child(1) .deviceStatus");
	public WebElement acquire() {
		return getDriver().findElement(acquire);
	}
	By emulator = By.cssSelector(".sidebar-content");
	public By emulator() {
		return emulator;
	}
	By automatedTest = By.cssSelector("#mat-tab-label-0-1>div");
	public WebElement automatedTest() {
		return getDriver().findElement(automatedTest);
	}
}