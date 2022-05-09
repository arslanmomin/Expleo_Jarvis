package commands;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.MediaEntityBuilder;

import configs.Base;

public class ElementsOp extends Base {
	

	/**
	 * used to perform click operation
	 * @param locator --get it from object repository
	 * @param elementName--name of the element
	 * @throws Exception 
	 */

	public static void click(WebDriver driver,WebElement ele) throws Exception {
		try {
			ele.click();
			Base.childTest.pass("performed click on :"+ ele);
		} catch (Exception e) {
			Base.childTest.pass("can not perform click operation on :"+ele);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	/**
	 * 
	 * used to type text in textbox, search
	 * @param locator-- get it from object repository
	 * @param testData -- the data which have to passed, can get from external file
	 * @param elementName
	 */
	public static void type(WebDriver driver,WebElement ele, String testData) {
		try {
			ele.sendKeys(testData);
			Base.childTest.pass("success in typing in  :"+ele+" with testdata :"+testData);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
		} catch (Exception e) {
			Base.childTest.fail("can not  type in :"+ele+"with testdata :"+testData);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	/**
	 * used to build mouseHover action on WebElement
	 * @param locator can get it from object repository
	 * @param elementname -name of element
	 */
	public static void mouseover(By locator, String elementname) throws Exception {
		try {
			WebElement wx=driver.findElement(locator);
			Actions ac=new Actions(driver);
			ac.moveToElement(wx).build().perform();
			Base.childTest.pass("success in mouseHover action  :"+ elementname);
		} catch (Exception e) {
			Base.childTest.fail("can not  mouseHover in :"+elementname);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	/**
	 * used to retrieve text from WebElement
	 * @param label webelement from object repository
	 * @param elemnt -element name
	 */
	public static void getText(WebElement label) {
		try {
			String text=driver.findElement((By) label).getText();
			Base.childTest.pass(text);
		} catch (Exception e) {
			
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public static void verifyeleclickable(By locator, String elementname) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 6);
			wt.until(ExpectedConditions.elementToBeClickable(locator));
			Base.childTest.pass("element is clickable  :" + elementname);

		} catch (Exception e) {
			Base.childTest.fail("element is not clickable :" + elementname);
			Base.childTest.info(e);
			throw e;
		}

	}

	public static void verifyelevisible(By locator, String elementname) {
		try {
			boolean t = driver.findElement(locator).isDisplayed();
			if (t)
				Base.childTest.pass("element is visible  :" + elementname);
			else
				Base.childTest.fail("element is not visible :" + elementname);
		} catch (Exception e) {
			Base.childTest.info(e);
			throw e;
		}
	}

	public static String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
        //goto url
 
		
	}
	
	
	
	

}
