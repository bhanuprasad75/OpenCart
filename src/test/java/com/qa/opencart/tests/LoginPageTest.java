package com.qa.opencart.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.Base;


public class LoginPageTest extends Base {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.getTitle();
		
		Assert.assertEquals(title,"Account Login");
	}
	@Test(priority = 2)
	public void loginPageURLTest() {
		String URL = lp.getURL();
		Assert.assertTrue(URL.contains("login"));
	}
	@Test(priority = 3)
	public void isForgetPwdPresentTest() {
		 Boolean elementPresent = lp.isElementPresent();
		Assert.assertTrue(elementPresent);
	}
	@Test(priority = 4)
	public void doLoginTest() throws InterruptedException {
		ap = lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		 Assert.assertEquals(ap.doGetTitle(), "My Account");		 
	}
	

}
