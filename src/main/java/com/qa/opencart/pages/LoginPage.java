package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private ElementUtil eu;
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}

	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By ForgottenPassword = By.linkText("Forgotten Password");
	private By lgnBtn = By.xpath("//input[@value='Login']");
	private By regitserLink = By.linkText("Register");

	public String getTitle() {
		String titleIs = eu.waitForTheTitle(5, "Account Login");
		System.out.println(titleIs);
		return titleIs;
	}

	public String getURL() {
		String URL = eu.waitForTheURL(5, "login");
		System.out.println(URL);
		return URL;
	}

	public boolean isElementPresent() {
		boolean elementPresent = eu.waitForElementDisplayed(ForgottenPassword, 5);
		return elementPresent;
	}

	public AccountsPage doLogin(String username, String password) {
		eu.doSendkeys(this.username, username);
		eu.doSendkeys(this.password, password);
		eu.doClick(lgnBtn);
		return new AccountsPage(driver);
	}

	public RegisterPage doClickRegisterlink() {
		eu.doClick(regitserLink);
		return new RegisterPage(driver);
	}
}
