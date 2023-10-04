package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class manualTest extends Webdriver {
	public manualTest(WebDriver driver) {
		PageFactory.initElements(getDriver(), this);
	}

	By testCases = By.cssSelector(".textBold:nth-child(1)");
	public WebElement testCases() {
		return getDriver().findElement(testCases);
	}
	
	By testRuns = By.cssSelector(".textBold:nth-child(2)");
	public WebElement testRuns() {
		return getDriver().findElement(testRuns);
	}

	By tableheader_w = By.cssSelector("th:nth-child(1)>p");
	public WebElement tableheader_w() {
		return getDriver().findElement(tableheader_w);
	}
	By loader = By.cssSelector("#style-1>div>div>span");
	public WebElement loader() {
		return getDriver().findElement(loader);
	}
	
	By testRun_w = By.cssSelector(".select_dropdown");
	public WebElement testRun_w() {
		return getDriver().findElement(testRun_w);
	}
	
	By issues = By.cssSelector(".textBold:nth-child(3)");
	public WebElement issues() {
		return getDriver().findElement(issues);
	}
	
	By issues_w = By.cssSelector(".custom-table>thead");
	public WebElement issues_w() {
		return getDriver().findElement(issues_w);
	}
	
	By addNewBtndropdown = By.cssSelector(".show>li");
	public By addNewBtndropdown() {
		return addNewBtndropdown;
	}
	
	By createTc = By.cssSelector(".show>li:nth-child(1)");
	public WebElement createTc() {
		return getDriver().findElement(createTc);
	}
	
	By azureTc = By.cssSelector(".show>li:nth-child(2)");
	public WebElement azureTc() {
		return getDriver().findElement(azureTc);
	}
	
	By csvTc = By.cssSelector(".show>li:nth-child(3)");
	public WebElement csvTc() {
		return getDriver().findElement(csvTc);
	}
	
	By headers= By.xpath("//th/p[not(self::p/button)]");
	public By headers() {
		return headers;
	}
	// Locators regarding new Test case fields
	By tcName = By.cssSelector(".input_div>input");
	public WebElement tcName() {
		return getDriver().findElement(tcName);
	}
	By tcDesc = By.xpath("//textarea[@placeholder=\"Enter Description\"]");
	public WebElement tcDesc() {
		return getDriver().findElement(tcDesc);
	}
	By tcRepro = By.xpath("//textarea[@placeholder=\"Enter Repro Steps\"]");
	public WebElement tcRepro() {
		return getDriver().findElement(tcRepro);
	}
}