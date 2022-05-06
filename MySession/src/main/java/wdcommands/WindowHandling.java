package wdcommands;

import org.openqa.selenium.Dimension;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wdcommands.*;
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
			String sizz=driver.manage().window().getSize().toString();
			StartBrowser.childTest.pass("success in typing in   with testdata" +sizz);
			System.out.println("My Window"+sizz);
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
	public void WindowHandle() {
		try {
			String wh=driver.getWindowHandle();
			StartBrowser.childTest.pass("Window Handle :" +wh);
		
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not handle Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	public void WindowHandles() {
		try {
			Set<String> wh=driver.getWindowHandles();
			StartBrowser.childTest.pass("Window handles :"
			
					+wh);
		
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not handle Window ");
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
	public void getSize() {
		try {
		Dimension winSize=driver.manage().window().getSize();
				StartBrowser.childTest.pass("***Full Size Values for Current Window***\n");
				StartBrowser.childTest.pass("Screen Width: " + winSize.getWidth() + "\n");
				StartBrowser.childTest.pass("Screen Height: " + winSize.getHeight() + "\n");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not get Window Size");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void setSize(Dimension a) {
		try {
			driver.manage().window().setSize(a);
				StartBrowser.childTest.pass("Size set");
				
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not set Window Size ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	public void getPosition() {
		try {
		Point winPos=driver.manage().window().getPosition();
				StartBrowser.childTest.pass("***Full Size Values for Current Window***\n");
				StartBrowser.childTest.pass("X cordinate: " + winPos.getX() + "\n");
				StartBrowser.childTest.pass("Y cordinate: " + winPos.getY() + "\n");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not get Window Position ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void setPosition(int x, int y ) {
		try {
			Point winPos=driver.manage().window().getPosition();
			Point NewWinPos=winPos.moveBy(x,y);
	        driver.manage().window().setPosition(NewWinPos);
				StartBrowser.childTest.pass("Position set");
				
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("can not set Window Position ");
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
