package com.qa.opencart.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.Base;

public class SearchInfoPageTest extends Base {

	@BeforeClass
	public void accountsPageSetup() {
		ap = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductSearch() {
		return new Object[][] { { "mac", "MacBook Pro" },
			{ "samsung", "Samsung Galaxy Tab 10.1" },
				{ "Canon", "Canon EOS 5D" }
		};
	}

	@Test(dataProvider = "getProductSearch")
	public void selectProductTest(String product, String SelectProduct) {
		searchInfo = ap.doSearchProduct(product);
		searchInfo.doSelectProduct(SelectProduct);
	}

	@Test
	public void getproductInfoMap() {
		searchInfo = ap.doSearchProduct("Mac");
		searchInfo.doSelectProduct("MacBook Pro");
		Map<String, String> productInfoMap = searchInfo.productInfoMap();
		sa.assertEquals(productInfoMap.get("Brand"), "Apple");
		sa.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		sa.assertEquals(productInfoMap.get("Reward Points"), "800");
		sa.assertEquals(productInfoMap.get("Availability"), "In Stock");
		sa.assertEquals(productInfoMap.get("Product Name"), searchInfo.headerText());
		sa.assertEquals(productInfoMap.get("Product Price"), "$2,000.00");

	}

}
