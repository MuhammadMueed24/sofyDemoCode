package configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriver {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public Properties prop;
	public static String baseurl;
	public WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(@Optional("Chrome") String browser) throws IOException {
		/*
		 * The reader function reads the browser name from the data.properties file and
		 * then decision is made by the below given blocks.
		 */
		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
//			options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
			options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
//			options.addArguments("--headless"); // only if you are ACTUALLY running headless
			options.addArguments("--no-sandbox"); // https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-dev-shm-usage"); // https://stackoverflow.com/a/50725918/1689770
			options.addArguments("--disable-browser-side-navigation"); // https://stackoverflow.com/a/49123152/1689770
			options.addArguments("--disable-gpu");
			options.addArguments("--remote-allow-origins=*");
			// Instantiate the chrome driver
			driver.set(new ChromeDriver(options));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		} else if (browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			getDriver().manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		} else if (browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			getDriver().manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() throws IOException {
		getDriver().quit();
	}

	public String reader() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		prop.load(fis);
		return prop.getProperty("browser").toLowerCase();
	}
}