package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class automation extends Webdriver{
	public automation(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	By tcases = By.cssSelector(".textBold:nth-child(1)");
	public WebElement tcases(){
		return getDriver().findElement(tcases);
	}
	By tcases_w = By.cssSelector(".textBold:nth-child(1)");
	public By tcases_w(){
		return tcases_w;
	}
	By templates = By.cssSelector(".textBold:nth-child(2)");
	public WebElement templates(){
		return getDriver().findElement(templates);
	}
	By test_suite = By.cssSelector(".textBold:nth-child(3)");
	public WebElement test_suite(){
		return getDriver().findElement(test_suite);
	}
	By runs_reports = By.cssSelector(".textBold:nth-child(4)");
	public WebElement runs_reports(){
		return getDriver().findElement(runs_reports);
	}
	By search_bar = By.cssSelector(".input-box>input");
	public WebElement search_bar() {
		return getDriver().findElement(search_bar);
	}
	By search_bar_w = By.cssSelector(".form-control");
	public WebElement search_bar_w() {
		return getDriver().findElement(search_bar_w);
	}
	By nodata = By.cssSelector(".no-listing-data>h6");
	public WebElement nodata() {
		return getDriver().findElement(nodata);
	}
	By nodata_w = By.cssSelector(".no-listing-data>h6");
	public By nodata_w() {
		return nodata_w;
	}
	By tc1 = By.xpath("//p[contains(text(),'Five equals ten')]");
	public By tc1() {
		return tc1;
	}
	By filter = By.cssSelector(".btn-filter");
	public WebElement filter() {
		return getDriver().findElement(filter);
	}
	By donebtn = By.cssSelector(".primary_button>span");
	public WebElement donebtn() {
		return getDriver().findElement(donebtn);
	}
	By clearbtn = By.cssSelector(".primary_border_button");
	public WebElement clearbtn() {
		return getDriver().findElement(clearbtn);
	}
	By filTag = By.cssSelector(".modal_content>h3");
	public WebElement filTag() {
		return getDriver().findElement(filTag);
	}
	By createdBy = By.cssSelector(".ByLabel");
	public WebElement createdBy() {
		return getDriver().findElement(createdBy);
	}
	By priority = By.cssSelector(".ByStatus");
	public WebElement priority() {
		return getDriver().findElement(priority);
	}
	By bet = By.id("createtext");
	public WebElement bet() {
		return getDriver().findElement(bet);
	}
	By creatByList = By.cssSelector(".deviceframedetails_div");
	public By creatByList() {
		return creatByList;
	}
	By loader = By.cssSelector(".loader-span");
	public By loader() {
		return loader;
	}
}