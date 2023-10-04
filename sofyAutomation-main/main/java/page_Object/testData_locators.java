package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configurations.Webdriver;

public class testData_locators extends Webdriver{
	public testData_locators(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	By addtestData = By.cssSelector("div>#dropdownMenu1");
	public WebElement addtestData(){
		return getDriver().findElement(addtestData);
	}
	By testdatalink= By.linkText("Add Test Data");
	public WebElement testdatalink() {
		return getDriver().findElement(testdatalink);
	}
	By csvdata2 = By.linkText("Import from CSV");
	public WebElement csvdata2() {
		return getDriver().findElement(csvdata2);
	}
	By upload_btn = By.xpath("//div[@class=\"file_upload_div\"]/label[2]");
	public WebElement upload_btn() {
		return getDriver().findElement(upload_btn);
	}
	
	By upload_btn2 = By.xpath("//div[@class=\"file_upload_div\"]/input");
	public WebElement upload_btn2() {
		return getDriver().findElement(upload_btn2);
	}
	By var_list = By.cssSelector(".tr-listing>td:nth-child(1)>p");
	public WebElement var_list() {
		return getDriver().findElement(var_list);
	}
	By loader = By.cssSelector(".listing-loader");
	public By loader() {
		return loader;
	}
	By all_var = By.xpath("//*[@class=\"tr-listing\"][1]/td[1]/p");
	public By all_var() {
		return all_var;
	}
	By var_list_w = By.cssSelector(".tr-listing>td:nth-child(1)>p");
	public By var_list_w() {
		return var_list_w;
	}
	By edit_entry = By.cssSelector(".actions_div button:nth-child(1)");
	public WebElement edit_entry() {
		return getDriver().findElement(edit_entry);
	}
	By delete_entry = By.cssSelector(".actions_div button:nth-child(2)");
	public WebElement delete_entry() {
		return getDriver().findElement(delete_entry);
	}
	By search_btn = By.cssSelector(".form-control");
	public WebElement search_btn() {
		return getDriver().findElement(search_btn);
	}
	By active_select = By.cssSelector(".selected_value_div");
	public WebElement active_select() {
		return getDriver().findElement(active_select);
	}
	By secret = By.cssSelector("li:nth-child(3) .dropdown_list_div");
	public WebElement secret() {
		return getDriver().findElement(secret);
	}
	By var_name = By.cssSelector("app-input:nth-child(2) .ng-untouched");
	public WebElement var_name() {
		return getDriver().findElement(var_name);
	}
	By var_value = By.cssSelector("app-input:nth-child(3) .ng-untouched");
	public WebElement var_value() {
		return getDriver().findElement(var_value);
	}
	By var_desc = By.cssSelector("app-input:nth-child(4) > div > textarea");
	public WebElement var_desc() {
		return getDriver().findElement(var_desc);
	}
	By create_btn = By.cssSelector(".text_right>button");
	public WebElement create_btn() {
		return getDriver().findElement(create_btn);
	}
	By successm = By.cssSelector(".toaster>h4");
	public By successm() {
		return successm;
	}
	By succesm = By.cssSelector(".toaster>h4");
	public WebElement succesm() {
		return getDriver().findElement(succesm);
	}
	By sample= By.cssSelector(".content>p>a");
	public WebElement sample() {
		return getDriver().findElement(sample);
	}
	By alph_del = By.xpath("//p[@class=\"bold-title\"]/../../td[6]/div/button[2]");
	public WebElement alph_del() {
		return getDriver().findElement(alph_del);
	}
	By alph_del_w = By.xpath("//p[@class=\"bold-title\"]/../../td[6]/div/button[2]");
	public By alph_del_w() {
		return alph_del_w;
	}
}