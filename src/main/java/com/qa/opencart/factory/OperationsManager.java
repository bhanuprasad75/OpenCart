package com.qa.opencart.factory;

import java.util.Properties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OperationsManager {

	private Properties prop;
	ChromeOptions cp;
	EdgeOptions ep;
	FirefoxOptions fp;
	
	public OperationsManager(Properties prop) {
		this.prop=prop;
	}

	public ChromeOptions getChromeOptions() {
		cp = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			cp.addArguments("--incognito");
			return cp;
		}
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			cp.addArguments("--headless");
			return cp;
		}
		return cp;

	}
	public EdgeOptions getEdgeOptions() {
		ep = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			ep.addArguments("--incognito");
			return ep;
		}
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			ep.addArguments("--headless");
			return ep;
		}
		return ep;

	}
	public FirefoxOptions getFirefoxOptions() {
		fp = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			fp.addArguments("--incognito");
			return fp;
		}
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			ep.addArguments("--headless");
			return fp;
		}
		return fp;

	}
}
