package com.example.app.automatedtests.constant.abstr;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Paths;
import java.util.HashMap;

public class AbstractAT {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	static {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	}
	
	@BeforeClass
	public static void setUpClass() {
		setupDriver();
	}

	@Before
	public void setUp() {
		if (driver == null) {
			setupDriver();
		}
	}

	private static void setupDriver() {
		ChromeOptions options = getChromeOptions();
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 20);
	}

	private static ChromeOptions getChromeOptions() {
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("download.default_directory", Paths.get("src","test","resources", "temporaryDownloads").toAbsolutePath().toString());
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.addArguments("ignore-certificate-errors");
		return options;
	}

	@AfterClass
	public static void close() {
		if(driver != null) {
			driver.quit();
		}
	}	

}
