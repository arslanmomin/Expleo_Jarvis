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

import configs.BrowserSetup;

public class ElementsOp {
	public WebDriver driver;

	public ElementsOp(WebDriver driver) {
		this.driver = BrowserSetup.driver;
	}
	


	/**
	 * used to perform click operation
	 * @param locator --get it from object repository
	 * @param elementName--name of the element
	 * @throws Exception 
	 */

	public void click(By locator,String elementName) throws Exception {
		try {
			driver.findElement(locator).click();
			BrowserSetup.childTest.pass("performed click on :"+elementName);
		} catch (Exception e) {
			BrowserSetup.childTest.pass("can not perform click operation on :"+elementName);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
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
	public void type(By locator, String testData, String elementName) {
		try {
			driver.findElement(locator).sendKeys(testData);
			BrowserSetup.childTest.pass("success in typing in  :"+elementName+" with testdata :"+testData);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not  type in :"+elementName+"with testdata :"+testData);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;
		}
	}
	/**
	 * used to build mouseHover action on WebElement
	 * @param locator can get it from object repository
	 * @param elementname -name of element
	 */
	public void mouseover(By locator, String elementname) throws Exception {
		try {
			WebElement wx=driver.findElement(locator);
			Actions ac=new Actions(driver);
			ac.moveToElement(wx).build().perform();
			BrowserSetup.childTest.pass("success in mouseHover action  :"+ elementname);
		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not  mouseHover in :"+elementname);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;
		}
	}
	/**
	 * used to retrieve text from WebElement
	 * @param label webelement from object repository
	 * @param elemnt -element name
	 */
	public void getText(WebElement label) {
		try {
			String text=driver.findElement((By) label).getText();
			BrowserSetup.childTest.pass(text);
		} catch (Exception e) {
			
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;
		}
	}
	
	public void verifyeleclickable(By locator, String elementname) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 6);
			wt.until(ExpectedConditions.elementToBeClickable(locator));
			BrowserSetup.childTest.pass("element is clickable  :" + elementname);

		} catch (Exception e) {
			BrowserSetup.childTest.fail("element is not clickable :" + elementname);
			BrowserSetup.childTest.info(e);
			throw e;
		}

	}

	public void verifyelevisible(By locator, String elementname) {
		try {
			boolean t = driver.findElement(locator).isDisplayed();
			if (t)
				BrowserSetup.childTest.pass("element is visible  :" + elementname);
			else
				BrowserSetup.childTest.fail("element is not visible :" + elementname);
		} catch (Exception e) {
			BrowserSetup.childTest.info(e);
			throw e;
		}
	}

	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
        //goto url
 
		
	}
	
	
	
	

}
