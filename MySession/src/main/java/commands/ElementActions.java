package commands;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import utilities.Log;

public class ElementActions extends Base {

//used to perform click using actions class and javascript executor operation
	public static void click(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {

			Actions act = new Actions(driver);
			act.moveToElement(ele).click().build().perform();
			ExtentManager.childTest.pass("performed click on :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info("can not perform click operation on :" + eleName);
			Log.exception(" not able to click due to exception : ", e);
			throw e;
		}
	}

	public static void JSclick(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			ExtentManager.childTest.pass("performed JSclick on :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info("can not perform JSclick operation on :" + eleName);
			Log.exception(" not able to JSclick due to exception : ", e);
			throw e;
		}
	}

//used to type text in textbox after clearing it
	public static void type(WebElement ele, String testData, String eleName) {
		try {
			ele.clear();
			ele.sendKeys(testData);
			ExtentManager.childTest.pass("success in typing in  :" + eleName + " with testdata ");

		} catch (Exception e) {
			ExtentManager.childTest.info("can not  type in :" + eleName + "with testdata ");
			Log.exception(" not able to type due to exception : ", e);
			throw e;
		}
	}

//used to build mouseHover action on WebElement
	public static void mouseover(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(ele).build().perform();
			ExtentManager.childTest.pass("success in mouseHover action  :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info("can not  mouseHover in :" + eleName);
			Log.exception(" not able to mouseover due to exception : ", e);
			throw e;
		}
	}

//used to build Keyboard Key combinations on WebElement
	public static void keyboardCtrlOp(WebDriver driver, String keyChar) {
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.chord(Keys.CONTROL, keyChar)).build().perform();
		ExtentManager.childTest.pass("Key pressed is  :" + Keys.CONTROL + keyChar);
		// check
	}

	public static void keyboardShiftOp(WebDriver driver, String keyChar) {
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.chord(Keys.SHIFT, keyChar)).build().perform();
		ExtentManager.childTest.pass("Key pressed is  :" + Keys.SHIFT + keyChar);
	}

//move to element using javascript exceutor
	public static void moveToElement(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).build().perform();
			ExtentManager.childTest.pass("success in move to element on  :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info("can not  move to element on :" + eleName);
			Log.exception(" not able to move to element due to exception : ", e);
			throw e;
		}
	}

//used to retrieve text from WebElement
	public static String getText(WebDriver driver, WebElement ele, String eleName) {
		String text = ele.getText();
		ExtentManager.childTest.pass("successfully feteched text :" + text + " from element :" + eleName);
		return text;
	}

//checks weather element is visible or not
	public static boolean isDisplayed(WebElement ele, String eleName) {

		boolean t = ele.isDisplayed();
		if (t)
			ExtentManager.childTest.pass("element is visible  :" + eleName);

		else
			ExtentManager.childTest.info("element is not visible :" + eleName);

		return t;
	}

	public static boolean isSelected(WebElement ele, String eleName) {

		boolean t = ele.isSelected();
		if (t)
			ExtentManager.childTest.pass("element is selected  :" + eleName);
		else
			ExtentManager.childTest.info("element is not selected :" + eleName);
		return t;

	}

	public static boolean isEnabled(WebElement ele, String eleName) {

		boolean t = ele.isEnabled();
		if (t)
			ExtentManager.childTest.pass("element is enabled  :" + eleName);
		else
			ExtentManager.childTest.info("element is not enabled :" + eleName);

		return t;

	}

	// scrolls control to given webelement
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele, String eleName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			ExtentManager.childTest.pass("scrolled to element :" + eleName);
		} catch (Exception e) {
			ExtentManager.childTest.info("not able to scroll into element :" + eleName);
			Log.exception("not able to scroll due to exception : ", e);
			throw e;
		}
	}

	public void selectByIndex(WebElement ele, int index) {
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
			ExtentManager.childTest.pass("selected value from dropbox using index at :" + index);
		} catch (Exception e) {
			ExtentManager.childTest.info("can not value from dropbox using index at :" + index);
			Log.exception("not able to select by index due to exception : ", e);
			throw e;
		}
	}

	public void selectByValue(WebElement ele, String value) {
		try {
			Select s = new Select(ele);
			s.deselectByValue(value);
			ExtentManager.childTest.pass("selected value from dropbox using value at :" + value);
		} catch (Exception e) {
			ExtentManager.childTest.info("can not value from dropbox using value at :" + value);
			Log.exception("not able to select by value due to exception : ", e);
			throw e;
		}
	}

//used to retrieve all options from dropdown using Select class
	public List<WebElement> getAllOptions(WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> AllOptions = s.getOptions();
		for (int i = 0; i < AllOptions.size(); i++) {
			System.out.println(s.getOptions().get(i).getText());
			ExtentManager.childTest.pass("got all options from dropdown");
		}

		return AllOptions;
	}

	public void selectByVisibleText(WebElement ele, String VisibleText) {
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(VisibleText);
			ExtentManager.childTest.pass("selected value from dropbox using VisibleText at :" + VisibleText);
		} catch (Exception e) {
			ExtentManager.childTest.info("can not value from dropbox using VisibleText at :" + VisibleText);
			Log.exception("not able to select by text due to exception : ", e);

			throw e;
		}
	}

//used to check on webelement
	public boolean check(WebElement ele, String eleName) throws Exception {

		boolean flag = false;

		if (ele.isSelected() == true) {
			ExtentManager.childTest.info("element already checked");

		} else {
			ele.click();
			ExtentManager.childTest.pass("performed check on :" + eleName);
			flag = true;
		}
		return flag;
	}

//used to uncheck element
	public boolean uncheck(WebElement ele, String eleName) throws Exception {

		boolean flag = false;
		if (!ele.isSelected()) {
			ExtentManager.childTest.info("element already unchecked");
		} else {
			ele.click();
			flag = true;
			ExtentManager.childTest.pass("performed uncheck on :" + eleName);
		}
		return flag;
	}

	public static void acceptAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();
			ExtentManager.childTest.pass("alert accept successfully");
		} catch (Exception e) {
			ExtentManager.childTest.info("can not alert accept");
			Log.exception(e.getMessage());
			throw e;
		}
	}

	public static void cancelAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().dismiss();
			ExtentManager.childTest.pass("cancel alert");
		} catch (Exception e) {
			ExtentManager.childTest.info(" not able to dismiss alert");
			Log.exception("not able to dismiss alert due to exception : ", e);
			throw e;

		}
	}

	public String getAlertText(WebDriver driver) {

		String alertText = driver.switchTo().alert().getText();
		ExtentManager.childTest.pass("alert text captured : " + alertText);

		return alertText;

	}

	public void setAlertText(WebDriver driver, String text) {
		try {
			driver.switchTo().alert().sendKeys(text);
			ExtentManager.childTest.pass("send  data to alert box successfully");
		} catch (Exception e) {
			ExtentManager.childTest.info("enter the text in alert box");
			Log.exception(e.getMessage());
			throw e;
		}
	}

	public void verifyAlertMsg(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			ExtentManager.childTest.pass("alert is Present");
		} catch (Exception e) {
			ExtentManager.childTest.info("alert message is not Present");
			Log.exception("not able to check if alert is present due to  : ", e);
			throw e;
		}
	}

	// get Attribute//check
	public static String getAttribute(WebDriver driver, WebElement ele, String Attributename, String eleName) {

		String AttrValue = ele.getAttribute(Attributename).toString();
		ExtentManager.childTest.pass("successfully feteched value :" + AttrValue + " from Attribute :" + Attributename);
		return AttrValue;
	}

	public static void uploadFile(WebElement path, WebElement uploadButton, String FilePath) {
		try {

			path.sendKeys(FilePath);
			uploadButton.click();
			ExtentManager.childTest.pass("File uploaded Successfully");
		} catch (Exception e) {
			Log.exception("not able to upload file due to exception : ", e);
			throw e;
		}
	}

	// Element Count
	public static int ElementsCount(List<WebElement> elements) {

		int count = elements.size();
		ExtentManager.childTest.pass("The webelement Count Is" + count);

		return count;
	}

	// Verify Download

	public boolean isFileDownloaded(String downloadPath, String fileName) {

		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				ExtentManager.childTest.pass("The File Is Downloaded");
				flag = true;

			} else
				ExtentManager.childTest.info("The File Is Not  Downloaded");
		}
		return flag;
	}

// verify weather substring present
	public boolean matchSubStringAndVerify(String actualText, String expectedText) {

		boolean flag = false;
		if (actualText.contains(expectedText)) {
			ExtentManager.childTest.pass(expectedText + "  text found");
			flag = true;
		} else
			ExtentManager.childTest.info(expectedText + "  text not found");
		return flag;

	}

//used to remove before and after white spaces from String
	public static String trimText(String text) {
		String trimStr = text.trim();
		ExtentManager.childTest.pass(trimStr + "String is trimmed");
		return trimStr;
	}

//used to check whether String is starting with particular String or not
	public static boolean startsWithText(String text, String startsStr) {
		boolean flag = false;
		if (text.startsWith(startsStr)) {
			ExtentManager.childTest.pass("String is starts with:" + startsStr);
			flag = true;
		} else
			ExtentManager.childTest.info("String is not starts with:" + startsStr);
		return flag;
	}

//used to replace all Special characters and Digits from String
	public static String replaceSpecialSymbol(String text) {
		String alphaOnly = text.replaceAll("[^a-zA-Z]+", "");
		ExtentManager.childTest.pass(alphaOnly + "String containing Only Alphabets");
		return alphaOnly;
	}

//used to verify expected text is found or not
	public boolean verifyElementText(WebElement ele, String expectedText) {
		boolean flag = false;
		String actualText = ele.getText();
		if (actualText.equals(expectedText)) {
			ExtentManager.childTest.pass("both the strings are equal ");
			flag = true;
		} else {
			ExtentManager.childTest.info("both the strings are not equal ");
		}
		return flag;
	}

//check
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

	// extracts text from list of webelements into another list
	public static List<String> extractText(List<WebElement> elements) {

		List<String> texts = elements.stream().map(element -> element.getText()).collect(Collectors.toList());
		List<String> text = texts.stream().sorted().toList();
		System.out.println("extracted list is " + text);
		return text;

	}

	// comparing two lists by size and content
	public static boolean comapreLists(List<String> text, List<String> expected) {
		boolean flag = false;
		System.out.println("expected list is:" + expected);
		List<String> sorted = expected.stream().sorted().toList();
		System.out.println("sorted list is:" + sorted);
		if (text.equals(sorted)) {
			ExtentManager.childTest.pass("two lists are  equal");
			flag = true;
		} else
			ExtentManager.childTest.info("two lists are not equal");
		return flag;

	}

//explicit wait method
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

//implicit wait method
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}

//fluent wait method//check
	public void fluentWaitforelementvisibility(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
		}
	}

//used to get current System's time
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

//drag and drop
	public static void DragAndDrop(WebDriver driver, WebElement From, WebElement To) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(From, To).build().perform();
			ExtentManager.childTest.pass("Object Dragged And Dropped Successfully ");
		} catch (Exception e) {
			Log.exception("not able to drag abd drop  due to exception : ", e);
			throw e;
		}
	}

	// verify element clickable//check
	public static boolean verifyeleclickable(WebElement ele, String eleName) {

		try {
			WebDriverWait wt = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
			wt.until(ExpectedConditions.elementToBeClickable(ele));
			ExtentManager.childTest.pass("element is clickable  :" + eleName);
			return true;

		} catch (Exception e) {
			ExtentManager.childTest.info("element is not clickable :" + eleName);
			Log.exception("not able to check element clickable due to :", e);
			return false;
		}

	}

	public static void WaitForElementToBeSelected(WebDriver driver, WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeSelected(ele));
			ExtentManager.childTest.pass("Element Selectable");
		} catch (Exception e) {

			ExtentManager.childTest.info("Element Not Selectable");
			Log.exception("not able to check element selcted due to :", e);
			throw e;
		}
	}

	public static void WaitForElementVisible(WebDriver driver, WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(ele));
			ExtentManager.childTest.pass("Element Visible");
		} catch (Exception e) {

			ExtentManager.childTest.info("Element Not Visible");
			Log.exception("not able to check element visible due to :", e);
			throw e;
		}
	}

//returns number of characters present in given string
	public static int inputLength(String testData) {
		int countOfChars = 0;
		countOfChars = testData.length();
		ExtentManager.childTest.pass("Number of characters present in " + testData + " data are: " + countOfChars);
		return countOfChars;

	}

//returns true if there are special characters present in given string
	public static boolean specialChar(String testData) {
		boolean flag = false;
		// The pattern() method of Matcher Class is used to get the pattern to be
		// matched by this matcher
		// The compile(String) method of the Pattern class in Java is used to create a
		// pattern from the regular expression
		// It is passed as parameter to method.
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(testData);
		boolean b = m.find();

		if (b) {
			ExtentManager.childTest.pass("special character present ");
			flag = true;
		} else {
			ExtentManager.childTest.info("no special character present");
			flag = false;
		}
		return flag;
	}

// Method to get file size
	public static long getFileSizeinBytes(String filepath) {
		File file = new File(filepath);
		if (!file.exists() || !file.isFile()) {
			ExtentManager.childTest.info("File doesn't exist");
			return -1;
		}
		System.out.println("file size in MB: " + file.length() / 1048576);
		return file.length();

	}
	
//returns last four characters of any String
	public static String last4Char(String data) {
		String lastFour = data.substring(data.length() - 4);
		ExtentManager.childTest.pass("last 4 characters of input are :"+lastFour);
		return lastFour;

	}
}
