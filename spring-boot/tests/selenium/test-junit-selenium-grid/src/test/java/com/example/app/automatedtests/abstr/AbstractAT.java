package com.example.app.automatedtests.abstr;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractAT {

	protected static WebDriver driver;

	@BeforeAll
	public static void setUpClass() throws MalformedURLException {
		setupDriver();
	}

	@BeforeEach
	public void setUp() throws MalformedURLException {
		if (driver == null) {
			setupDriver();
		}
	}

	private static void setupDriver() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setPlatform(Platform.LINUX);
		cap.setVersion("");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterAll
	public static void close() {
		if(driver != null) {
			driver.quit();
		}
	}	

}
