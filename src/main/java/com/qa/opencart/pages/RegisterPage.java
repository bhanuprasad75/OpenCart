package com.qa.opencart.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	
	WebDriver driver;
	private ElementUtil eu;

	String subscribe="";
	private By firstName=By.cssSelector("input#input-firstname");
	private By lastName=By.cssSelector("input#input-lastname");
	private By email=By.cssSelector("input#input-email");
	private By telephone=By.cssSelector("input#input-telephone");
	private By password=By.cssSelector("input#input-password");
	private By confirmPassword=By.cssSelector("input#input-confirm");
	private By subscribeBtn=By.xpath("//label[text()[normalize-space()='Yes']]");
	private By agree=By.cssSelector("input[name='agree']");
	private By continueBtn=By.cssSelector("input[value='Continue']");


	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}
	
	public String doGetTitle() {
		return eu.waitForTheTitle(5, "Register Account");
	}
	
	public void doRegistration(String fname,String lname,String email,String telephone,String password,String cnfpassword ) {
		eu.doSendkeys(this.firstName, fname);
		eu.doSendkeys(this.lastName, lname);
		eu.doSendkeys(this.email, email);
		eu.doSendkeys(this.telephone, telephone);
		eu.doSendkeys(this.password,password);
		eu.doSendkeys(this.confirmPassword, cnfpassword);
		eu.doClick(subscribeBtn);
		eu.doClick(agree);
		eu.doClick(continueBtn);
		
	}

}
