package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import configurations.Webdriver;

public class labSession_locators extends Webdriver {
	public labSession_locators(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	By ext = By.cssSelector(".button-txt");

	public WebElement ext() {
		return getDriver().findElement(ext);
	}

	By manualt = By.cssSelector("h4>a");

	public WebElement manualt() {
		return getDriver().findElement(manualt);
	}

	By rec = By.xpath("//div[contains(text(),'Recording')]");

	public WebElement rec() {
		return getDriver().findElement(rec);
	}

	By reco = By.cssSelector(".ng-star-inserted .pulse");

	public WebElement reco() {
		return getDriver().findElement(reco);
	}

	By recording = By.xpath("//span[contains(text(),'Recording')]");

	public WebElement recording() {
		return getDriver().findElement(recording);
	}

	By dvcard = By.cssSelector(".deviceStatus");

	public WebElement dvcard() {
		return getDriver().findElement(dvcard);
	}

	By acquire = By.xpath("(//div[@class='device_status online']/following::span[text()='Acquire'])[1]");

	public WebElement acquire() {
		return getDriver().findElement(acquire);
	}

	By dvname = By.xpath("(//div[@class='device_status online']/following::h5[@class='device_name'])[1]");

	public WebElement dvname() {
		return getDriver().findElement(dvname);
	}

	By dvInfo = By.cssSelector(".info_dropdown");

	public WebElement dvInfo() {
		return getDriver().findElement(dvInfo);
	}

	By lab_dvname = By.cssSelector(".info:nth-child(1)>p");

	public WebElement lab_dvname() {
		return getDriver().findElement(lab_dvname);
	}

	By lab_appname = By.cssSelector(".breadcrumb:nth-child(2)>li");

	public WebElement lab_appname() {
		return getDriver().findElement(lab_appname);
	}

	By lab_dversion = By.cssSelector(".breadcrumb:nth-child(3)>li");

	public WebElement lab_dversion() {
		return getDriver().findElement(lab_dversion);
	}

	By lab_dv = By.cssSelector("#canv-container>canvas");

	public WebElement lab_dv() {
		return getDriver().findElement(lab_dv);
	}

	By lab_active = By.cssSelector(".breadcrumb-item");

	public WebElement lab_active() {
		return getDriver().findElement(lab_active);
	}

	By manTest = By.cssSelector(".mat-tab-label:nth-child(1)>div");

	public WebElement manTest() {
		return getDriver().findElement(manTest);
	}

	By manTest_w = By.cssSelector(".logo_div");

	public By manTest_w() {
		return manTest_w;
	}

	By autTest = By.cssSelector(".mat-tab-label:nth-child(2)>div");

	public WebElement autTest() {
		return getDriver().findElement(autTest);
	}

	By record = By.cssSelector(".mat-tab-label:nth-child(3)>div");

	public WebElement labrecord() {
		return getDriver().findElement(record);
	}

	By result = By.cssSelector(".mat-tab-label:nth-child(4)>div");

	public WebElement result() {
		return getDriver().findElement(result);
	}

	By log = By.cssSelector(".mat-tab-label:nth-child(5)>div");

	public WebElement log() {
		return getDriver().findElement(log);
	}

	By menubar = By.cssSelector(".action-icons-bar:nth-child(2)");

	public WebElement menubar() {
		return getDriver().findElement(menubar);
	}

	By orientation = By.cssSelector(".action_btn:nth-child(8)");

	public WebElement orientation() {
		return getDriver().findElement(orientation);
	}

	By home = By.xpath("//*[@id=\"actions-menu\"]/div[2]/div[4]");

	public WebElement home() {
		return getDriver().findElement(home);
	}

	By clearT = By.xpath("//*[@id=\"actions-menu\"]/div[2]/div[5]");

	public WebElement clearT() {
		return getDriver().findElement(clearT);
	}

	By end = By.cssSelector(".end-btn");

	public WebElement end() {
		return getDriver().findElement(end);
	}

	By lab_loader = By.cssSelector(".circular");

	public WebElement lab_loader() {
		return getDriver().findElement(lab_loader);
	}
	By endYes = By.xpath("//span[text()='Yes']");

	public WebElement endYes() {
		return getDriver().findElement(endYes);
	}
	By endSkip = By.xpath("//button[text()=' Skip ']");

	public WebElement endSkip() {
		return getDriver().findElement(endSkip);
	}
	By end_session = By.xpath("//h4[text()='Session Expired']");

	public WebElement end_session() {
		return getDriver().findElement(end_session);
	}


}