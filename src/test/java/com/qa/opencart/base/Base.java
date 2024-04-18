package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchInfoPage;
import com.qa.opencart.utils.ElementUtil;

public class Base {

	WebDriver driver;
	DriverFactory df;
	protected LoginPage lp;
	protected AccountsPage ap;
	protected RegisterPage rp;
	protected Properties prop;
	protected ElementUtil eu;
	protected SearchInfoPage searchInfo;
	protected SoftAssert sa;

	@BeforeTest
	public void setUp() {
		eu = new ElementUtil(driver);
		df = new DriverFactory();
		prop = df.initProperties();
		driver = df.launchBrowser(prop);
		sa=new SoftAssert();
		lp = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
