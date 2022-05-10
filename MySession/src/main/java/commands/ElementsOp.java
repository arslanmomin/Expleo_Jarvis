package commands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;

import configs.Base;

public class ElementsOp extends Base {

	/**
	 * used to perform click operation
	 * 
	 * @param locator           --get it from object repository
	 * @param elementName--name of the element
	 * @throws Exception
	 */

	public static void click(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {

			Actions act = new Actions(driver);
			act.moveToElement(ele).click().build().perform();
			Base.childTest.pass("performed click on :" + eleName);
		} catch (Exception e) {
			Base.childTest.pass("can not perform click operation on :" + eleName);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public static void JSclick(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			Base.childTest.pass("performed JSclick on :" + eleName);
		} catch (Exception e) {
			Base.childTest.pass("can not perform JSclick operation on :" + eleName);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}

	/**
	 * 
	 * used to type text in textbox, search
	 * 
	 * @param locator--   get it from object repository
	 * @param testData    -- the data which have to passed, can get from external
	 *                    file
	 * @param elementName
	 */
	public static void type(WebElement ele, String testData, String eleName) {
		try {
			ele.clear();
			ele.sendKeys(testData);
			Base.childTest.pass("success in typing in  :" + eleName + " with testdata :");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
		} catch (Exception e) {
			Base.childTest.fail("can not  type in :" + eleName + "with testdata :");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}

	/**
	 * used to build mouseHover action on WebElement
	 * 
	 * @param locator     can get it from object repository
	 * @param elementname -name of element
	 */
	public static void mouseover(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(ele).build().perform();
			Base.childTest.pass("success in mouseHover action  :" + eleName);
		} catch (Exception e) {
			Base.childTest.fail("can not  mouseHover in :" + eleName);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public static void moveToElement(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).build().perform();
			Base.childTest.pass("success in move to element on  :" + eleName);
		} catch (Exception e) {
			Base.childTest.fail("can not  move to element on :" + eleName);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}

	/**
	 * used to retrieve text from WebElement
	 * 
	 * @param label  webelement from object repository
	 * @param elemnt -element name
	 */
	public static void getText(WebDriver driver, WebElement label, String eleName) {
		try {
			String text = driver.findElement((By) label).getText();
			Base.childTest.pass(text);
		} catch (Exception e) {

			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}

	public static void verifyeleclickable(WebElement ele, String elementname) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 6);
			wt.until(ExpectedConditions.elementToBeClickable(ele));
			Base.childTest.pass("element is clickable  :" + elementname);

		} catch (Exception e) {
			Base.childTest.fail("element is not clickable :" + elementname);
			Base.childTest.info(e);
			throw e;
		}

	}

	public static void isDisplayed(WebElement ele, String elementname) {
		try {
			boolean t = ele.isDisplayed();
			if (t)
				Base.childTest.pass("element is visible  :" + elementname);
			else
				Base.childTest.fail("element is not visible :" + elementname);
		} catch (Exception e) {
			Base.childTest.info(e);
			throw e;
		}
	}

	public static void isSelected(WebElement ele, String elementname) {
		try {
			boolean t = ele.isSelected();
			if (t)
				Base.childTest.pass("element is selected  :" + elementname);
			else
				Base.childTest.fail("element is not selected :" + elementname);
		} catch (Exception e) {
			Base.childTest.info(e);
			throw e;
		}
	}

	public static void isEnabled(WebElement ele, String elementname) {
		try {
			boolean t = ele.isEnabled();
			if (t)
				Base.childTest.pass("element is enabled  :" + elementname);
			else
				Base.childTest.fail("element is not enabled :" + elementname);
		} catch (Exception e) {
			Base.childTest.info(e);
			throw e;
		}
	}

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele, String elementname) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			Base.childTest.pass("scrolled to element :" + elementname);
		} catch (Exception e) {
			Base.childTest.fail("not able to scroll into element :" + elementname);
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public void selectByIndex(WebElement element, int index) {
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			Base.childTest.pass("selected value from dropbox using index at :" + index);
		} catch (Exception e) {
			Base.childTest.fail("can not value from dropbox using index at :" + index);
			Base.childTest.info(e);
			throw e;
		} 
		}

	public void selectByValue(WebElement element, String value) {
		try {
			Select s = new Select(element);
			s.deselectByValue(value);
			Base.childTest.pass("selected value from dropbox using value at :" + value);
		} catch (Exception e) {
			Base.childTest.fail("can not value from dropbox using value at :" + value);
			Base.childTest.info(e);
			throw e;
		} 
		}
	
	public void selectByVisibleText(WebElement element, String VisibleText) {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(VisibleText);
			Base.childTest.pass("selected value from dropbox using VisibleText at :" + VisibleText);
		} catch (Exception e) {
			Base.childTest.fail("can not value from dropbox using VisibleText at :" + VisibleText);
			Base.childTest.info(e);
			throw e;
		} 
		}
	public static String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		// goto url

	}

}
