package com.qa.opencart.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	public WebDriver driver;
	private OptionsManager optionsManager;
	Properties prop;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * This method is used to initialize the ThreadLocal driver on the basis of the
	 * given browser
	 * 
	 * @param browser
	 * @param prop
	 * @param prop
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser, Properties prop) {
		this.prop = prop;
		optionsManager = new OptionsManager(prop);
		System.out.println("The Browser value is :" + browser);
		if (browser.equals("chrome")) {

			if (Boolean.parseBoolean(prop.getProperty("Remote"))) {
				init_remoteBrowser(browser);

			} else {
				System.out.println("Running tests on Local with :::" + browser);
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
			
		} else if (browser.equals("firefox")) {

			if (Boolean.parseBoolean(prop.getProperty("Remote"))) {
				init_remoteBrowser(browser);

			} else {
				System.out.println("Running tests on Local with :::" + browser);
				//tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			
				tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}

		} else if (browser.equals("edge")) {

			if (Boolean.parseBoolean(prop.getProperty("Remote"))) {
				init_remoteBrowser(browser);
			} else {
				System.out.println("Running tests on Local with :::" + browser);
				tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			}
		} else {
			System.out.println("Please Pass the correct browser value :" + browser);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}

	/**
	 * This is get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method initialize the remote WebDriver which means if we run in Selenium
	 * grid / docker container.
	 * 
	 * @param browser
	 * @param huburl  (From properties file)
	 */
	public void init_remoteBrowser(String browser) {

		System.out.println("Running tests on grid server:::" + browser);

		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
				break;
			case "firefox":
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
				break;
			case "edge":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getEdgeOptions()));
				break;
			default:
				System.out.println("plz pass the right browser for remote execution..." + browser);

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
