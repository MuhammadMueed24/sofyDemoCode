package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class app_manager extends Webdriver{
	public app_manager(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	By search = By.cssSelector(".input-box>input");
	public WebElement search(){
		return getDriver().findElement(search);
	}
	By general = By.cssSelector(".compTabs>span:nth-child(1)");
	public WebElement general() {
		return getDriver().findElement(general);
	}
	By heading = By.cssSelector(".title_h3");
	public WebElement heading() {
		return getDriver().findElement(heading);
	}
	By name = By.cssSelector(".input_div>input");
	public WebElement name() {
		return getDriver().findElement(name);
	}
	By desc = By.cssSelector(".input_div>textarea");
	public WebElement desc() {
		return getDriver().findElement(desc);
	}
	By builds = By.cssSelector(".compTabs>span:nth-child(2)");
	public WebElement builds() {
		return getDriver().findElement(builds);
	}
	By cicd = By.cssSelector(".compTabs>span:nth-child(3)");
	public WebElement cicd() {
		return getDriver().findElement(cicd);
	}
	By issueTrack = By.cssSelector(".compTabs>span:nth-child(4)");
	public WebElement issueTrack() {
		return getDriver().findElement(issueTrack);
	}
	By notification = By.cssSelector(".compTabs>span:nth-child(5)");
	public WebElement notification() {
		return getDriver().findElement(notification);
	}
	By addApp = By.xpath("//span[contains(text(),'Add Application')]");
	public WebElement addApp() {
		return getDriver().findElement(addApp);
	}
	By testFlight = By.cssSelector(".col-6>div>.add_application>span");
	public WebElement testFlight() {
		return getDriver().findElement(testFlight);
	}
}