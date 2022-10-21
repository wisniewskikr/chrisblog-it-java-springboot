package com.example.app.automatedtests.abstr;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
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

	@Rule
	public final TestRule watchman = new TestWatcher() {
		@Override
		public Statement apply(Statement base, Description description) {
			return super.apply(base, description);
		}

		@Override
		protected void succeeded(Description description) {
			System.out.println("********** PASSED :" + description.getDisplayName());
		}

		@Override
		protected void failed(Throwable e, Description description) {
			System.out.println("********** FAILED :" + description.getDisplayName());
			driver.quit();
			driver = null;
		}
	};
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
