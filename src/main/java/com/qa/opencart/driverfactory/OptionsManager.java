package com.qa.opencart.driverfactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.opencart.utilities.ConfigReader;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo; 
	//private ConfigReader configReader;

	public OptionsManager(Properties prop) {
		this.prop = prop;
		//configReader = new ConfigReader();
	}

	public ChromeOptions getChromeOptions() {
		co =new ChromeOptions();
		
		if (Boolean.parseBoolean(prop.getProperty("Headless").trim())) {
			System.out.println("=========Running chrome in headless==========");
			co.addArguments("--headless");

		}
		if (Boolean.parseBoolean(prop.getProperty("Incognito").trim())) {
			System.out.println("=========Running chrome in incognito==========");
			co.addArguments("--incognito");
		}
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();

		if (Boolean.parseBoolean(prop.getProperty("Headless").trim())) {
			System.out.println("=========Running Fire1fox in headless==========");
			fo.addArguments("--headless");

		}
		if (Boolean.parseBoolean(prop.getProperty("Incognito").trim()))
			System.out.println("=========Running FireFox in incognito==========");
			fo.addArguments("--incognito");
		return fo;
	}

	public EdgeOptions getEdgeOptions() {
		
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("Headless").trim())) {
			System.out.println("=========Running Edge in headless==========");
			eo.addArguments("--headless");

		}
		if (Boolean.parseBoolean(prop.getProperty("Incognito").trim()))
			System.out.println("=========Running Edge in incognito==========");
			eo.addArguments("--inprivate");
		return eo;
	}

}
