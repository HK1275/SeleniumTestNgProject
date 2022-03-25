package com.project.selenium.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	static DateFormat dateFormat;
	static Date date;

	public static final long PAGE_LOAD_TIMEOUT = 1000;

	public static final long IMPLICIT_WAIT = 10;

	// provide path of workspace from your local machine
	public static final String WORKSAPCE_PATH = "C://projects//Automation//Maven-Selenium-TestNG//src";



	/**
	 * Wait for element to appear on the webpage
	 * @param driver
	 * @param locatorObject
	 */
	public static void waitForElementToBeVisible(WebDriver driver, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}


	/**
	 * Waits for element to become interactive/clickable
	 * @param driver
	 * @param locatorObject
	 */
	public static void waitForElementToBeClickable(WebDriver driver, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
/*
	public static void waitForElementDisappear(WebDriver driver, WebElement webElement){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(webElement));
	}
	*/
}
