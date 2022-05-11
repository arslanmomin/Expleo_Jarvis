package commands;

import org.openqa.selenium.Alert;
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
	 * used to perform click using actions class and javascript executor operation
	 * 
	 * @param ele--get      it from pageFactory
	 * @param eleName--name of the element
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
	 * used to type text in textbox after clearing it
	 * 
	 * @param ele--       get it from pageFactory
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
	 * @param ele     can get it pageFactory
	 * @param eleName -name of element
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
	 * @param label  webelement from pageFactory
	 * @param elemnt -element name
	 */
	public static void getText(WebDriver driver, WebElement ele, String eleName) {
		try {
			String text = ele.getText();
			Base.childTest.pass("successfully feteched text :" + text + " from element :" + eleName);
		} catch (Exception e) {
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}

	public static void verifyeleclickable(WebElement ele, String eleName) {
		try {
			WebDriverWait wt = new WebDriverWait(getDriver(), 5);
			wt.until(ExpectedConditions.elementToBeClickable(ele));
			Base.childTest.pass("element is clickable  :" + eleName);

		} catch (Exception e) {
			Base.childTest.fail("element is not clickable :" + eleName);
			Base.childTest.info(e);
			throw e;
		}

	}

	public static void isDisplayed(WebElement ele, String eleName) {
		try {
			boolean t = ele.isDisplayed();
			if (t)
				Base.childTest.pass("element is visible  :" + eleName);
			else
				Base.childTest.fail("element is not visible :" + eleName);
		} catch (Exception e) {
			Base.childTest.info(e);
			throw e;
		}
	}

	public static void isSelected(WebElement ele, String eleName) {
		try {
			boolean t = ele.isSelected();
			if (t)
				Base.childTest.pass("element is selected  :" + eleName);
			else
				Base.childTest.fail("element is not selected :" + eleName);
		} catch (Exception e) {
			Base.childTest.info(e);
			throw e;
		}
	}

	public static void isEnabled(WebElement ele, String eleName) {
		try {
			boolean t = ele.isEnabled();
			if (t)
				Base.childTest.pass("element is enabled  :" + eleName);
			else
				Base.childTest.fail("element is not enabled :" + eleName);
		} catch (Exception e) {
			Base.childTest.info(e);
			throw e;
		}
	}

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele, String eleName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			Base.childTest.pass("scrolled to element :" + eleName);
		} catch (Exception e) {
			Base.childTest.fail("not able to scroll into element :" + eleName);
			Base.childTest.info(e);
			throw e;
		}
	}

	public void selectByIndex(WebElement ele, int index) {
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
			Base.childTest.pass("selected value from dropbox using index at :" + index);
		} catch (Exception e) {
			Base.childTest.fail("can not value from dropbox using index at :" + index);
			Base.childTest.info(e);
			throw e;
		}
	}

	public void selectByValue(WebElement ele, String value) {
		try {
			Select s = new Select(ele);
			s.deselectByValue(value);
			Base.childTest.pass("selected value from dropbox using value at :" + value);
		} catch (Exception e) {
			Base.childTest.fail("can not value from dropbox using value at :" + value);
			Base.childTest.info(e);
			throw e;
		}
	}

	public void selectByVisibleText(WebElement ele, String VisibleText) {
		try {
			Select s = new Select(ele
					);
			s.selectByVisibleText(VisibleText);
			Base.childTest.pass("selected value from dropbox using VisibleText at :" + VisibleText);
		} catch (Exception e) {
			Base.childTest.fail("can not value from dropbox using VisibleText at :" + VisibleText);
			Base.childTest.info(e);
			throw e;
		}
	}
	public void check(WebElement ele,String eleName) throws Exception {
		try {
			
			if(ele.isSelected()==true) {
				
				Base.childTest.pass("element already checked");
			}
			else {
				ele.click();
				Base.childTest.pass("performed check on :"+eleName);
			}
		} catch (Exception e) {
			Base.childTest.pass("can not perform check operation on :"+eleName);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	
	
	public void uncheck(WebElement ele,String eleName) throws Exception {
		try {
			
			if(ele.isSelected()==false) {
				
				Base.childTest.pass("element already unchecked");
			}
			else {
				ele.click();
				Base.childTest.pass("performed uncheck on :"+eleName);
			}
		} catch (Exception e) {
			Base.childTest.pass("can not perform check operation on :"+eleName);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public void acceptAlert(WebDriver driver)
	{
		try {
			driver.switchTo().alert().accept();
			Base.childTest.pass("alert accept successfully");
		}
		catch(Exception e)
		{
			Base.childTest.fail("can jnot alert accept");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public void cancelAlert(WebDriver driver)
	{
		try {
			driver.switchTo().alert().dismiss();
			Base.childTest.pass("cancel alert");
		}
		catch(Exception e){
			Base.childTest.fail(" alert accept");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
			
		}
	}

	
	public void getAlertText(WebDriver driver)
	{
		try {
			driver.switchTo().alert().getText();
			Base.childTest.pass("alert text capture successfully");
		}
		catch(Exception e) {
			Base.childTest.fail("alert text is not present there.");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public void setAlertText(WebDriver driver,String text)
	{
		try {
			driver.switchTo().alert().sendKeys(text);
			Base.childTest.pass("send  data to alert box successfully");
		}
		catch(Exception e) {
			Base.childTest.fail("enter the text in alert box");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	public void verifyAlertMsg(WebDriver driver)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			Base.childTest.pass("alert is Present");
			driver.switchTo().alert().accept();
		}
		catch(Exception e) {
			Base.childTest.fail("alert message is not Present");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	//get Attribute
	public static void getAttribute( WebElement ele,String Attributename, String eleName) {
		try {
			String AtTrValue = ele.getAttribute(Attributename);
			Base.childTest.pass("successfully feteched value :" + AtTrValue + " from Attribute :" + Attributename);
		} catch (Exception e) {
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	public static void uploadFile( WebElement path,WebElement uploadButton,String FilePath, String eleName) {
		try {
			
		path.sendKeys(FilePath);
		uploadButton.click();
			Base.childTest.pass("File uploaded Successfully"+ eleName);
		} catch (Exception e) {
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;
		}
	}
	
	
	
	
	
	

	public static String screenshot() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);

		// goto url

	}

}
