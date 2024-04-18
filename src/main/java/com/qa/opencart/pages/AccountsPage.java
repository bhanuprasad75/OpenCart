package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	WebDriver driver;
	private ElementUtil eu;

	By myAccountHeaders = By.cssSelector("div h2");
	By logoutLink = By.linkText("Logout");
	By passwordLink = By.linkText("Password");
	By searchBox = By.name("search");
	By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}

	public String doGetTitle() {
		return eu.waitForTheTitle(5, "My Account");
	}

	public List<String> getMyAccountHeaders() {
		List<WebElement> AccountHeaders = eu.waitForElementsVisible(myAccountHeaders, 5);
		List<String> accountHeadersText = new ArrayList<String>();
		for (WebElement e : AccountHeaders) {
			accountHeadersText.add(e.getText());
		}
		return accountHeadersText;
	}

	public boolean doLoginLinkExists() {
		return eu.waitForElementVisible(logoutLink, 5).isDisplayed();
	}

	public boolean doPasswordLinkExists() {
		return eu.waitForElementVisible(passwordLink, 5).isDisplayed();
	}

	public SearchInfoPage doSearchProduct(String key) {
		eu.doSendkeys(searchBox, key);
		eu.doClick(searchButton);
		return new SearchInfoPage(driver);
	}

}
