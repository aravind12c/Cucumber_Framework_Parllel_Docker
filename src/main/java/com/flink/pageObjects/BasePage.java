package com.flink.pageObjects;

import java.util.List;

import com.flink.driverInit.DriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {

	/**
	 * All common functions are associated here
	 */

	private static String waitstrategyvisible = "Visible";
	private static String waitstrategyclickable = "Clickable";

	/**
	 * this method to click on any element
	 */
	protected static void clickOn(By by) {
		WebElement element = performExplicitWait(waitstrategyclickable, by);
		element.click();
	}

	/**
	 * this method to verify whether the element is displayed and returns boolean
	 * value
	 */
	protected static boolean isElementDisplayed(By by) {
		boolean flag = false;
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		if (element.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * this method to get the text of element using locater and passing as element
	 * and return as string
	 */
	protected static String getTextOn(By by) {
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		return element.getText();
	}

	/**
	 * this method to get the text of element and return as string
	 */
	protected static String getTextOnEle(WebElement element) {
		return element.getText();
	}

	/**
	 * this method get any attribute of the element and returns String value
	 */
	protected static String getAttributeOn(By by, String key) {
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		return element.getAttribute(key);
	}

	/**
	 * this method used to input values using SendKeys
	 */
	protected static void sendKeysOn(By by, String value) {
		WebElement element = performExplicitWait(waitstrategyclickable, by);
		element.sendKeys(value);
	}

	/**
	 * this method is used to send inputs using JSExecuter
	 */
	protected static void sendKeysOnJS(By by, String value) {
		WebElement element = performExplicitWait(waitstrategyclickable, by);
		JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
		jse.executeScript("arguments[0].value='" + value + "';", element);
	}

	/**
	 * this method is used to switch into frame using frame element
	 */
	protected static void switchToFrame(By by) {
		WebElement element = performExplicitWait(waitstrategyclickable, by);
		DriverManager.getDriver().switchTo().frame(element);
	}

	/**
	 * this method is for to switch back to default frame or ancestor frame if we
	 * went into the frames
	 */
	protected static void switchToDefault() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	/**
	 * this method is used as static wait where it stops execution for given period
	 * of time
	 */
	protected static void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	/**
	 * this method gets the List of WebElements and returns as List
	 */
	protected static List<WebElement> listOfElements(By by) {
		List<WebElement> ele = DriverManager.getDriver().findElements(by);
		return ele;
	}

	/**
	 * this method waits for 50 Seconds to load the Element to be displayed before
	 * throwing the NoSuchElementException
	 */
	protected static WebElement performExplicitWait(String waitstrategy, By by) {
		WebElement element = null;
		if (waitstrategy.equalsIgnoreCase("Clickable")) {
			element = new WebDriverWait(DriverManager.getDriver(), 30)
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitstrategy.equalsIgnoreCase("Visible")) {
			element = new WebDriverWait(DriverManager.getDriver(), 30)
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitstrategy.equalsIgnoreCase("None")) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

	/**
	 * this method refresh/reloads the current web page in the existing browser
	 * window.
	 */
	protected static void refreshPage() {
		DriverManager.getDriver().navigate().refresh();
	}

	/**
	 * this method accepts the alerts
	 */
	protected static void acceptAlert() {
		DriverManager.getDriver().switchTo().alert().accept();
	}

	/**
	 * this method checks whether alert is available
	 */
	protected static boolean isAlertDisplayed() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 7);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException e) {
			foundAlert = false;
		}
		return foundAlert;
	}

	/**
	 * this method returns the browsername in form of String
	 */
	protected static String getBrowserName() {
		return ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities().getBrowserName();
	}

}
