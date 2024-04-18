package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	JavascriptUtil js;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		js = new JavascriptUtil(driver);
	}

	public void doSwitchToNewTab(String URL) {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(URL);
	}

	public void doQuit() {
		driver.quit();
	}

	public void doSwitchToChildWindow() {
		String currentWindow = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		for (String e : all) {
			if (!e.equals(currentWindow)) {
				driver.switchTo().window(e);
			}
		}
	}

	public void doHighlightElement(WebElement element) {
		if (element.isDisplayed()) {
			js.drawBorder(element);
		}
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		doHighlightElement(element);
		return element;
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doSendkeys(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public Boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public Boolean isImageDisplayed(By locator) {
		List<WebElement> img = getElements(locator);
		if (img.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isMultipleImagesDisplayed(By locator) {
		List<WebElement> img = getElements(locator);
		if (img.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> textList = new ArrayList<String>();
		for (WebElement x : eleList) {
			String text = x.getText();
			if (text.length() != 0) {
				textList.add(x.getText());
			}
		}
		return textList;
	}

	public String randomemail() {
		return "Test" + System.currentTimeMillis() + "@ymail.com";
	}

	public void doSelectByIndex(By Locator, int index) {
		WebElement element = getElement(Locator);
		Select sc = new Select(element);
		sc.selectByIndex(index);
	}

	public void doSelectByValue(By Locator, String value) {
		WebElement element = getElement(Locator);
		Select sc = new Select(element);
		sc.selectByValue(value);
	}

	public void doSelectByVisibleText(By Locator, String text) {
		WebElement element = getElement(Locator);
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}

	public void doSelectOptions(By Locator, By OptionsLocator, String... text) {
		doClick(Locator);
		List<WebElement> Optionslist = getElements(OptionsLocator);
		if (text[0] != "all") {
			for (WebElement e : Optionslist) {
				for (String x : text) {
					if (e.getText().equals(x)) {
						e.click();
					}
				}
			}
		} else {
			for (WebElement e : Optionslist) {
				System.out.println(e.getText());
			}
		}
	}

	public void getSearchOptions(By locator, String input, By Listlocator) throws InterruptedException {
		doSendkeys(locator, input);
		Thread.sleep(1000);
		List<WebElement> listele = getElements(Listlocator);
		System.out.println(listele.size());
		for (WebElement e : listele) {
			String Suggestion = e.getText();
			System.out.println(Suggestion);

		}

	}

	public String waitForTheTitle(int timeout, String title) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wt.until(ExpectedConditions.titleIs(title));
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("Title not found");
			return driver.getTitle();
		}
	}

	public String waitForTheURL(int timeout, String url) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wt.until(ExpectedConditions.urlContains(url));
			return driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println("URL not found");
			return driver.getCurrentUrl();
		}
	}

	public Alert waitForAlert(int timeout) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		Alert alert = wt.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public boolean waitForElementDisplayed(By Locator, int timeout) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			boolean isDisplayed = wt.until(ExpectedConditions.visibilityOfElementLocated(Locator)).isDisplayed();
			return isDisplayed;
		} catch (Exception e) {
			System.out.println("Element not found " + timeout);
			return false;
		}
	}

	public WebElement waitForElementVisible(By Locator, int timeout) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wt.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public List<WebElement> waitForElementsVisible(By Locator, int timeout) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
	}
}
