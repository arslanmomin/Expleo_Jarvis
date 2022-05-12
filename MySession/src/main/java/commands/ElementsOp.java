package commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import configs.Base;
import utilities.ExtentManager;

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
			ExtentManager.childTest.pass("performed click on :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not perform click operation on :" + eleName);
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public static void JSclick(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			ExtentManager.childTest.pass("performed JSclick on :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not perform JSclick operation on :" + eleName);

			ExtentManager.childTest.info(e);
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
			ExtentManager.childTest.pass("success in typing in  :" + eleName + " with testdata :");

		} catch (Exception e) {
			ExtentManager.childTest.fail("can not  type in :" + eleName + "with testdata :");

			ExtentManager.childTest.info(e);
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
			ExtentManager.childTest.pass("success in mouseHover action  :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not  mouseHover in :" + eleName);

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public static void moveToElement(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).build().perform();
			ExtentManager.childTest.pass("success in move to element on  :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not  move to element on :" + eleName);

			ExtentManager.childTest.info(e);
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
			ExtentManager.childTest.pass("successfully feteched text :" + text + " from element :" + eleName);
		} catch (Exception e) {

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public static void verifyeleclickable(WebElement ele, String eleName) {
		try {
			WebDriverWait wt = new WebDriverWait(getDriver(), 5);
			wt.until(ExpectedConditions.elementToBeClickable(ele));
			ExtentManager.childTest.pass("element is clickable  :" + eleName);

		} catch (Exception e) {
			ExtentManager.childTest.fail("element is not clickable :" + eleName);
			ExtentManager.childTest.info(e);
			throw e;
		}

	}

	public static void isDisplayed(WebElement ele, String eleName) {
		try {
			boolean t = ele.isDisplayed();
			if (t)
				ExtentManager.childTest.pass("element is visible  :" + eleName);
			else
				ExtentManager.childTest.fail("element is not visible :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public static void isSelected(WebElement ele, String eleName) {
		try {
			boolean t = ele.isSelected();
			if (t)
				ExtentManager.childTest.pass("element is selected  :" + eleName);
			else
				ExtentManager.childTest.fail("element is not selected :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public static void isEnabled(WebElement ele, String eleName) {
		try {
			boolean t = ele.isEnabled();
			if (t)
				ExtentManager.childTest.pass("element is enabled  :" + eleName);
			else
				ExtentManager.childTest.fail("element is not enabled :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele, String eleName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			ExtentManager.childTest.pass("scrolled to element :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.fail("not able to scroll into element :" + eleName);
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void selectByIndex(WebElement ele, int index) {
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
			ExtentManager.childTest.pass("selected value from dropbox using index at :" + index);
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not value from dropbox using index at :" + index);
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void selectByValue(WebElement ele, String value) {
		try {
			Select s = new Select(ele);
			s.deselectByValue(value);
			ExtentManager.childTest.pass("selected value from dropbox using value at :" + value);
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not value from dropbox using value at :" + value);
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void selectByVisibleText(WebElement ele, String VisibleText) {
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(VisibleText);
			ExtentManager.childTest.pass("selected value from dropbox using VisibleText at :" + VisibleText);
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not value from dropbox using VisibleText at :" + VisibleText);
			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void check(WebElement ele, String eleName) throws Exception {
		try {

			if (ele.isSelected() == true) {

				ExtentManager.childTest.pass("element already checked");
			} else {
				ele.click();
				ExtentManager.childTest.pass("performed check on :" + eleName);
			}
		} catch (Exception e) {
			ExtentManager.childTest.pass("can not perform check operation on :" + eleName);

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void uncheck(WebElement ele, String eleName) throws Exception {
		try {

			if (ele.isSelected() == false) {

				ExtentManager.childTest.pass("element already unchecked");
			} else {
				ele.click();
				ExtentManager.childTest.pass("performed uncheck on :" + eleName);
			}
		} catch (Exception e) {
			ExtentManager.childTest.pass("can not perform check operation on :" + eleName);

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void acceptAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
			ExtentManager.childTest.pass("alert accept successfully");
		} catch (Exception e) {
			ExtentManager.childTest.fail("can jnot alert accept");

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void cancelAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().dismiss();
			ExtentManager.childTest.pass("cancel alert");
		} catch (Exception e) {
			ExtentManager.childTest.fail(" alert accept");

			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void getAlertText(WebDriver driver) {
		try {
			driver.switchTo().alert().getText();
			ExtentManager.childTest.pass("alert text capture successfully");
		} catch (Exception e) {
			ExtentManager.childTest.fail("alert text is not present there.");

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void setAlertText(WebDriver driver, String text) {
		try {
			driver.switchTo().alert().sendKeys(text);
			ExtentManager.childTest.pass("send  data to alert box successfully");
		} catch (Exception e) {
			ExtentManager.childTest.fail("enter the text in alert box");

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	public void verifyAlertMsg(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			ExtentManager.childTest.pass("alert is Present");
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			ExtentManager.childTest.fail("alert message is not Present");

			ExtentManager.childTest.info(e);
			throw e;
		}
	}


	public static void getAttribute(WebDriver driver, WebElement ele,String Attributename, String eleName) {
		try {
			String AtTrValue = ele.getAttribute(Attributename);
			ExtentManager.childTest.pass("successfully feteched value :" + AtTrValue + " from Attribute :" + Attributename);
		} catch (Exception e) {
			ExtentManager.childTest.info(e);
			throw e;
		}
	}
	//get Attribute
	
	public static void uploadFile( WebElement path,WebElement uploadButton,String FilePath, String eleName) {
		try {
			
		path.sendKeys(FilePath);
		uploadButton.click();
			ExtentManager.childTest.pass("File uploaded Successfully"+ eleName);
		} catch (Exception e) {
			
			ExtentManager.childTest.info(e);
			throw e;
		}
	}
	
	public static int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	


}
