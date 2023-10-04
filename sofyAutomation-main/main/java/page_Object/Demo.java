package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class Demo extends Webdriver{
	public Demo(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	By ready = By.id("pendo-button-d2fcc360");
	public WebElement lets_get_started(){
		return getDriver().findElement(ready);
	}
	By ready_close = By.id("pendo-close-guide-079eac0f");
	public WebElement lets_get_started_close(){
		return getDriver().findElement(ready_close);
	}
	By welcome = By.id("pendo-text-14fea3d0");
	public WebElement welcome() {
		return getDriver().findElement(welcome);
	}
	By close = By.id("pendo-close-guide-9de9a120");
	public WebElement close() {
		return getDriver().findElement(close);
	}
	By nocode = By.id("pendo-text-f048f16f");
	public WebElement withSofy() {
		return getDriver().findElement(nocode);
	}
	By usesofy = By.id("pendo-text-eabc5f9d");
	public WebElement preload() {
		return getDriver().findElement(usesofy);
	}
	By sample = By.id("pendo-text-25afcf21");
	public WebElement clicko() {
		return getDriver().findElement(sample);
	}
	By start = By.id("pendo-text-959f2d36");
	public WebElement start() {
		return getDriver().findElement(start);
	}
	
	// Tool Tip Locators
	By Tooltip1 = By.id("pendo-button-f03603bb");
	public WebElement Tooltip1(){
		return getDriver().findElement(Tooltip1);
	}
	By toolTip1head = By.id("pendo-text-d8c87e87");
	public WebElement toolTip1head() {
		return getDriver().findElement(toolTip1head);
	}
	
	
	// Schedule a call button and chat functionality visibility
	By schedulecall = By.cssSelector(".scheduleACallBtn");
	public WebElement schedulecall() {
		return getDriver().findElement(schedulecall);
	}
	By chat = By.id("hubspot-messages-iframe-container");
	public WebElement chat() {
		return getDriver().findElement(chat);
	}
	
	By ready_w = By.id("pendo-button-d2fcc360");
	public By lets_get_started_w(){
		return ready_w;
	}
}