package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class Release extends Webdriver{
	public Release(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	By NewRelease = By.cssSelector(".ml-3");
	public WebElement NewRelease(){
		return getDriver().findElement(NewRelease);
	}
	By Search = By.cssSelector(".input-box .ng-valid");
	public WebElement Search() {
		return getDriver().findElement(Search);
	}
	By Releases = By.cssSelector(".list:nth-child(2)");
	public WebElement Releases() {
		return getDriver().findElement(Releases);
	}
}
