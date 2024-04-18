package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.Base;

public class AccountsPageTest extends Base {

	@BeforeClass
	public void accountsPageSetup() {
		ap = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void doGetTitle() {
		String title = ap.doGetTitle();
		Assert.assertEquals(title, "My Account");
	}

	@Test(priority=2)
	public void getMyAccountHeaders() {
		List<String> myAccountHeaders = ap.getMyAccountHeaders();
		System.out.println(myAccountHeaders);
	}

	@Test(priority=3)
	public void doLoginLinkExists() {
		Assert.assertTrue(ap.doLoginLinkExists());
	}

	@Test(priority=4)
	public void doPasswordLinkExists() {
		Assert.assertTrue(ap.doPasswordLinkExists());
	}

	@Test(priority=5)
	public void doSearch() {
		ap.doSearchProduct("macbook");
	}

}
