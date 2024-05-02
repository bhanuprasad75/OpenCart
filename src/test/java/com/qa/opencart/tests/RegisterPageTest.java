package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.Base;


public class RegisterPageTest extends Base {
	
	@BeforeClass
	public void registerPageSetup() {
		rp = lp.doClickRegisterlink();
	}
	
	
	@DataProvider
	public Object[][] getRegistartionData() {
		return new  Object[][] {{"Bhanu","prasad","91234567890","test@123","test@123"},
			{"Sam","prasad","91234567890","test@123","test@123"}
		
		};	
		
	}
	@Test(dataProvider="getRegistartionData",priority=2,groups={"smoke"})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void doRegister(String fname,String laname,String telephone,String password,String cnfPassword) {
		rp.doRegistration(fname, laname, eu.randomemail(), telephone, password, cnfPassword);
	}
	
	@Test(priority=1)
	public void getTitle() {
		String Title = rp.doGetTitle();
		Assert.assertEquals(Title, "Register Account");
	}

}
