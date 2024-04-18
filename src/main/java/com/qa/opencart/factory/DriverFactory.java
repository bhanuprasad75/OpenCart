package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.exception.BrowserExecption;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OperationsManager om;

	public WebDriver launchBrowser(Properties prop) {
		String browserName = prop.getProperty("browser");
		browserName = browserName.toLowerCase().trim();
		System.out.println("Browser Name :" + browserName);
		om = new OperationsManager(prop);
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver(om.getChromeOptions());
			break;
		case "edge":
			driver = new EdgeDriver(om.getEdgeOptions());
			break;
		case "safari":
			driver = new FirefoxDriver(om.getFirefoxOptions());
			break;
		default:
			System.out.println("pls pass the right browser name....");
			throw new BrowserExecption("Browser not found");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

		return driver;
	}

	public Properties initProperties() {
		prop = new Properties();
		FileInputStream ip = null;
		String env = System.getProperty("env");
		try {

			if (env == null) {
				ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			} else {
				switch (env) {
				case "qa":
					ip = new FileInputStream(".\\src\\test\\resources\\config\\config_qa.properties");
					break;
				case "stg":
					ip = new FileInputStream(".\\src\\test\\resources\\config\\config_stg.properties");
					break;
				default:
					ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("plz pass the right file path " + env);
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
