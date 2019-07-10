package com.crmAutomation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crmAutomation.base.TestBase;

public class AssertionHelper extends TestBase {
	public boolean validateURL(WebDriver driver, String expURL) {
		boolean result = false;
		if (driver.getCurrentUrl().equalsIgnoreCase(expURL)) {
			result = true;
		}
		return result;
	}

	public static boolean validatePageTitle(WebDriver driver, String expTitle) {
		boolean result = false;
		if (driver.getTitle().equalsIgnoreCase(expTitle))
			;
		{
			result = true;
		}
		return result;
	}

	public static boolean validateElementExists(WebDriver driver, String xpath) {
		boolean result = false;
		try {
			driver.findElement(By.xpath(xpath));
			result = true;

		} catch (Exception e) {
		}
		return result;
	}

	public static boolean validateElementExistsSelectLocator(WebDriver driver, String locType, String locValue) {
		boolean result = false;
		try {
			if (locType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locValue));
			} else if (locType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locValue));
			} else if (locType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locValue));
			}
			result = true;
		} catch (Exception e) {
		}
		return result;
	}

	public static boolean validateTextPresentOnElement(WebDriver driver, String locType, String locValue,
			String expText) {
		boolean result = false;
		String ActualValue = "";
		try {
			if (locType.equalsIgnoreCase("xpath")) {
				ActualValue = driver.findElement(By.xpath(locValue)).getText();
			} else if (locType.equalsIgnoreCase("id")) {
				ActualValue = driver.findElement(By.id(locValue)).getText();
			} else if (locType.equalsIgnoreCase("name")) {
				ActualValue = driver.findElement(By.name(locValue)).getText();
			}
			if (ActualValue.equals(expText)) {
				result = true;
			}

		} catch (Exception e) {
		}
		return result;
	}

	public static String  validateTextPresentOnElement(WebDriver driver, String locType, String locValue) {
		String ActualValue = "";
		try {
			if (locType.equalsIgnoreCase("xpath")) {
				ActualValue = driver.findElement(By.xpath(locValue)).getText();
			} else if (locType.equalsIgnoreCase("id")) {
				ActualValue = driver.findElement(By.id(locValue)).getText();
			} else if (locType.equalsIgnoreCase("name")) {
				ActualValue = driver.findElement(By.name(locValue)).getText();
			}

		} catch (Exception e) {
		}
		return ActualValue;
	}

	
	
	public void b() {

	}

}