package com.AdactinPom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver browserLaunch(String type) {
		if (type.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (type.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		return driver;

	}
	public static void clickonElement(WebElement login) {
		login.click();
	}
	public static void inputValue(WebElement element , String value) {
		element.sendKeys(value);
	}
	private static Select dropDownsObject(WebElement element) {
		Select s = new Select(element);
		return s;
	}

// select by value
	public static void selectbyValue(WebElement element, String ind) {
		dropDownsObject(element).selectByValue(ind);
	}

// select by index
	public static void selectbyIndex(WebElement element, int input) {
		dropDownsObject(element).selectByIndex(input);
	}

// select by visible text
	public static void selectbyVisibletext(WebElement element, String sec) {
		dropDownsObject(element).selectByVisibleText(sec);
	}
//Actions
	public static Actions actionsObj() {
		Actions as = new Actions(driver);
		return as;
	}
//	Actions context click
	public static void contextclick(WebElement element) {
		actionsObj().contextClick(element).perform();
	}
	private static Robot robotObj() throws AWTException {
		Robot rt = new Robot();
		return rt;
	}

// robots down key press & release
	public static void downkey() throws AWTException {
		robotObj().keyPress(KeyEvent.VK_DOWN);
		robotObj().keyRelease(KeyEvent.VK_DOWN);
	}
//enter key
	public static void enterkey() throws AWTException {
		robotObj().keyPress(KeyEvent.VK_ENTER);
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}



}
