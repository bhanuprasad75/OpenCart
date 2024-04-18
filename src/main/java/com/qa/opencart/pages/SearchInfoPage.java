package com.qa.opencart.pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchInfoPage {
	
	WebDriver driver;
	private ElementUtil eu;
	Map<String ,String> productInfo=new HashMap<String ,String>();

	
	private By productHeader=By.tagName("h1");
	private By productInfoData=By.xpath("(//ul[@class='list-unstyled'])[8]/li");
	private By productPrice=By.xpath("(//ul[@class='list-unstyled'])[9]/li");
	private By productImages=By.cssSelector("a.thumbnail img");
	


	public SearchInfoPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}
	
	public void doSelectProduct(String productName) {
		eu.waitForElementVisible(By.linkText(productName), 5).click();
	}
	
	public String headerText() {
		String produtName = eu.waitForElementVisible(productHeader, 5).getText();
		System.out.println(produtName);
		return produtName;
	}
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
	public void getProductInfoData() {
		List<WebElement> productInfoList = eu.waitForElementsVisible(productInfoData, 5);
		for (WebElement e : productInfoList) {
			String text = e.getText();
			String metaDataKey = text.split(":")[0].trim();
			String metaDataValue = text.split(":")[1].trim();
			productInfo.put(metaDataKey, metaDataValue);
		}
	}
	public void getProductPrice() {
		List<WebElement> productPriceList = eu.waitForElementsVisible(productPrice, 5);
		String productPrice = productPriceList.get(0).getText();
		productInfo.put("Product Price", productPrice);
		String productExtPrice = productPriceList.get(1).getText().split(":")[1];
		productInfo.put("Product ExtPrice", productExtPrice);
		
	}
	public Map<String ,String> productInfoMap() {
		getProductInfoData();
		getProductPrice();
		productInfo.put("Product Name", headerText());
		return productInfo;
	}
	public int productImagesCount() {
		return  eu.waitForElementsVisible(productImages, 5).size();
	}

}
