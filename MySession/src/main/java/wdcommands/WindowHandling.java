package wdcommands;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.MediaEntityBuilder;

import configs.StartBrowser;

public class WindowHandling {
	public WebDriver driver;

	public WindowHandling() {
		driver = StartBrowser.driver;
	}
	


	/**
	 * used to perform click operation
	 * @param locator --get it from object repository
	 * @param elementName--name of the element
	 * @throws Exception 
	 */

	public void maximizeWindow() throws Exception {
		try {
			driver.manage().window().maximize();
			StartBrowser.childTest.pass("window maximized");
		} catch (Exception e) {
			StartBrowser.childTest.pass("can not maximize window :");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
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
	public void WindowSize() {
		try {
			driver.manage().window().getSize();
			StartBrowser.childTest.pass("success in typing in   with testdata");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not  type in :");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
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
			StartBrowser.childTest.pass("success in mouseHover action  :"+ elementname);
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not  mouseHover in :"+elementname);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
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
			StartBrowser.childTest.pass(text);
		} catch (Exception e) {
			
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public void verifyeleclickable(By locator, String elementname) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, 6);
			wt.until(ExpectedConditions.elementToBeClickable(locator));
			StartBrowser.childTest.pass("element is clickable  :" + elementname);

		} catch (Exception e) {
			StartBrowser.childTest.fail("element is not clickable :" + elementname);
			StartBrowser.childTest.info(e);
			throw e;
		}

	}

	public void verifyelevisible(By locator, String elementname) {
		try {
			boolean t = driver.findElement(locator).isDisplayed();
			if (t)
				StartBrowser.childTest.pass("element is visible  :" + elementname);
			else
				StartBrowser.childTest.fail("element is not visible :" + elementname);
		} catch (Exception e) {
			StartBrowser.childTest.info(e);
			throw e;
		}
	}

	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
        //goto url
 
		
	}
	
	
	
	

}
