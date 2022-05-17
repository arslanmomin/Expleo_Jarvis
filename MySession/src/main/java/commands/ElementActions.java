package commands;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.Collections;
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

public class ElementActions extends Base {

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
			ExtentManager.childTest.info("can not perform click operation on :" + eleName);
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
			ExtentManager.childTest.info("can not perform JSclick operation on :" + eleName);

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
			ExtentManager.childTest.pass("success in typing in  :" + eleName + " with testdata ");

		} catch (Exception e) {
			ExtentManager.childTest.info("can not  type in :" + eleName + "with testdata ");

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

	/**
	 * used to build Keyboard Key combinations on WebElement
	 * 
	 * @param ele     WebElement can get from pageFactory
	 * @param keyChar -Keyboard key to be pressed
	 * @param driver  WebDriver Object
	 */
	public static void keyboardCtrlOp(WebDriver driver, String keyChar) {
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.chord(Keys.CONTROL, keyChar)).build().perform();
		ExtentManager.childTest.pass("Key pressed is  :" + Keys.CONTROL + keyChar);
	}
	
	public static void keyboardShiftOp(WebDriver driver, String keyChar) {
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.chord(Keys.SHIFT, keyChar)).build().perform();
		ExtentManager.childTest.pass("Key pressed is  :" + Keys.SHIFT + keyChar);
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
	public static String getText(WebDriver driver, WebElement ele, String eleName) {
		String text = ele.getText();
		ExtentManager.childTest.pass("successfully feteched text :" + text + " from element :" + eleName);
		return text;
	}

	public static void verifyeleclickable(WebElement ele, String eleName) {
		try {
			WebDriverWait wt = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
			wt.until(ExpectedConditions.elementToBeClickable(ele));
			ExtentManager.childTest.pass("element is clickable  :" + eleName);

		} catch (Exception e) {
			ExtentManager.childTest.fail("element is not clickable :" + eleName);
			ExtentManager.childTest.info(e);
			throw e;
		}

	}

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
	
	/**
	 * used to retrieve all options from dropdown using Select class
	 * 
	 * @param ele  webelement from pageFactory
	 */
	public List<WebElement> getAllOptions(WebElement ele) {
			Select s = new Select(ele);
			 // Get the size of the Select element
            List AllOptions = s.getOptions();
            int OptionSize = AllOptions.size();                                   
            
            // Setting up the loop to print all the options
            for(int i =0; i < OptionSize ; i++)
            {
            	// Storing the value of the option
            	String Options = s.getOptions().get(i).getText();
            
            	// Printing the stored value
            	ExtentManager.childTest.pass("All Selected options from dropbox are:"+AllOptions );
            }
				
		return AllOptions;
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

	/**
	 * used to check element is selected
	 * 
	 * @param ele     WebElement from PageFactory
	 * @param eleName name of element
	 */
	public boolean check(WebElement ele, String eleName) throws Exception {

		boolean flag = false;

		if (ele.isSelected() == true) {
			ExtentManager.childTest.pass("element already checked");
			flag = true;

		} else {
			ele.click();
			ExtentManager.childTest.info("performed check on :" + eleName);
			flag = true;
		}
		return flag;
	}

	/**
	 * used to check element is not selected
	 * 
	 * @param ele     WebElement from PageFactory
	 * @param eleName name of element
	 */
	public boolean uncheck(WebElement ele, String eleName) throws Exception {

		boolean flag = false;
		if (ele.isSelected() == false) {

			ExtentManager.childTest.pass("element already unchecked");
			flag = false;

		} else {
			ele.click();
			flag = true;
			ExtentManager.childTest.pass("performed uncheck on :" + eleName);

		}

		return flag;

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

	public String getAlertText(WebDriver driver) {

		String alertText = driver.switchTo().alert().getText();
		ExtentManager.childTest.pass("alert text captured successfully");

		return alertText;

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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			ExtentManager.childTest.pass("alert is Present");
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			ExtentManager.childTest.fail("alert message is not Present");

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	// get Attribute
	public static String getAttribute(WebDriver driver, WebElement ele, String Attributename, String eleName) {

		String AttrValue = ele.getAttribute(Attributename);
		ExtentManager.childTest.pass("successfully feteched value :" + AttrValue + " from Attribute :" + Attributename);
		return AttrValue;
	}

	// get Attribute
	/**
	 * used to get Attribute value
	 * 
	 * @param driver        WebDriver object
	 * @param ele           WebElement from PageFactory
	 * @param AttributeName name of attribute for which value has to be retrieved
	 * @param eleName       name of file
	 */

	/**
	 * used to verify whether file is uploaded or not
	 * 
	 * @param Path         WebElement
	 * @param uploadButton WebElement button to upload
	 * @param FilePath     path to upload file
	 * @param eleName      name of file
	 */

	public static void uploadFile(WebElement path, WebElement uploadButton, String FilePath, String eleName) {
		try {

			path.sendKeys(FilePath);
			uploadButton.click();
			ExtentManager.childTest.pass("File uploaded Successfully" + eleName);
		} catch (Exception e) {

			ExtentManager.childTest.info(e);
			throw e;
		}
	}

	// Element Count
	/**
	 * used to count total number of Elements
	 * 
	 * @param driver    Object of WebDriver
	 * @param attribute attribute name
	 * @param ele       WebElement from Pagefactory
	 */
	public static int ElementsCount(WebDriver driver, WebElement ele, String attribute) {

		int count = 0;
		String AttrValue = ele.getAttribute(attribute);

		List<WebElement> val = driver.findElements(By.xpath(AttrValue));

		for (WebElement value : val) {
			count++;
		}

		ExtentManager.childTest.pass("The Count Is" + count);

		return count;
	}

	// Verify Download
	/**
	 * used to verify whether file is download or not
	 * 
	 * @param downloadPath path from which File is downloaded
	 * @param fileName     name of file
	 */
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
				ExtentManager.childTest.pass("The File Is Not  Downloaded");
		}
		return flag;
	}

	/**
	 * used to compare two Strings if expected substring is present
	 * 
	 * @param actualText   Actual String
	 * @param expectedText the text to be searched
	 */
	public boolean matchSubStringAndVerify(String actualText, String expectedText) {
		ExtentManager.childTest.info("comparing two strings if expected substring is present");
		boolean flag = false;
		if (actualText.contains(expectedText)) {
			ExtentManager.childTest.pass(expectedText + " expected text found");
			flag = true;
		} else
			ExtentManager.childTest.info(expectedText + " expected text not found");
		return flag;

	}

	/**
	 * used to remove before and after white spaces from String
	 * 
	 * @param text Actual String
	 */
	public static String trimText(String text) {
		String trimStr = text.trim();
		ExtentManager.childTest.pass(trimStr + "String is trimmed");
		return trimStr;
	}
	
	/**
	 * used to check whether String is starting with particular String or not
	 * 
	 * @param text Actual String
	 * @param startsStr String to be checked for startsWith
	 */
	public static boolean startsWithText(String text,String startsStr) {
		boolean flag=false;
		if( text.startsWith(startsStr))
		{
			ExtentManager.childTest.pass("String is starts with:"+startsStr);
			flag=true;
		}
		else
			ExtentManager.childTest.pass("String is not starts with:"+startsStr);
		return flag;
	}

	/**
	 * used to replace all Special characters and Digits from String
	 * 
	 * @param text Actual String
	 */
	public static String replaceSpecialSymbol(String text) {
		String alphaOnly = text.replaceAll("[^a-zA-Z]+", "");
		ExtentManager.childTest.pass(alphaOnly + "String containing Only Alphabets");
		return (alphaOnly);
	}

	/**
	 * used to verify expected text is found or not
	 * 
	 * @param ele          webelement from pageFactory
	 * @param expectedText the text to be searched
	 */
	public boolean verifyElementText(WebElement ele, String expectedText) {
		boolean flag = false;
		String actualText = ele.getText();
		if (actualText.equals(expectedText)) {
			ExtentManager.childTest.pass(expectedText + " expected text found");
			flag = true;
		} else {
			ExtentManager.childTest.info(expectedText + " expected text not found");
		}
		return flag;
	}

	/**
	 * used to retrieve column count
	 * 
	 * @param row webelement from pageFactory
	 */
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

	public static List<String> extractText(List<WebElement> elements) {

		List<String> texts = elements.stream().map(element -> element.getText()).collect(Collectors.toList());
		List<String> text = texts.stream().sorted().toList();
		System.out.println(text);
		return text;

	}

	public static boolean comapreLists(List<String> text, List<String> expected) {
		boolean flag = false;
		
		System.out.println(expected);
		if (text.equals(expected)) {
			ExtentManager.childTest.pass("two lists are  equal");
			flag = true;
		} else
			ExtentManager.childTest.info("two lists are not equal");
		return flag;

	}

	/**
	 * used to assign Explicit wait to particular element
	 * 
	 * @param driver  Webdriver object
	 * @param element webelement from pageFactory
	 * @param timeout waiting time
	 */
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * used to assign Implicit wait
	 * 
	 * @param driver  Webdriver object
	 * @param timeout waiting time
	 */
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}

	/**
	 * used to assign Fluent wait to particular element
	 * 
	 * @param driver  Webdriver object
	 * @param element webelement from pageFactory
	 * @param timeout waiting time
	 */
	public static void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
		}
	}

	/**
	 * used to get current System's time
	 * 
	 */
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	public static void DragnDrop(WebDriver driver,WebElement From,WebElement To)					
    {		
         
         Actions ac=new Actions( driver);					
	
         ac.dragAndDrop(From, To).build().perform();	
         ExtentManager.childTest.pass("Object Dragged And Dropped Successfully ");
	}	
	
	public static void WaitForElementClickable(WebDriver driver,WebElement ele)					
    {		
		
		try {	
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable( ele));
			ExtentManager.childTest.pass("Element Clickable");
	    }catch(Exception e) {
	    	
	    	
	    	ExtentManager.childTest.pass("Element Not Clickable");
	    	throw e;
	    }
	}	
	public static void WaitForElementToBeSelected(WebDriver driver,WebElement ele)					
    {		
		try {	
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeSelected( ele));
			ExtentManager.childTest.pass("Element Selectable");
	    }catch(Exception e) {
	    	
	    	
	    	ExtentManager.childTest.pass("Element Not Selectable");
	    	throw e;
	    }
	}
	
	
	
	public static void WaitForElementVisible(WebDriver driver,WebElement ele)					
    {	try {	
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf( ele));
		ExtentManager.childTest.pass("Element Visible");
    }catch(Exception e) {
    	
    	
    	ExtentManager.childTest.pass("Element Not Visible");
    	throw e;
    }
	}	
	
	
	public static void WaitForElementPresent(WebDriver driver,WebElement ele)					
    {	try {	
		WebDriverWait wait = new WebDriverWait(driver, 5);
		By by=toByVal(ele);
		ExtentManager.childTest.pass(by.toString());
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		ExtentManager.childTest.pass("Element Present");
    }catch(Exception e) {
    	
    	
    	ExtentManager.childTest.pass("Element Not Present");
    	throw e;
    }
	}	
	
	public static By toByVal(WebElement we) {
	    // By format = "[foundFrom] -> locator: term"
	    // see RemoteWebElement toString() implementation
	    String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
	    String locator = data[0];
	    String term = data[1];

	    switch (locator) {
	    case "xpath":
	        return By.xpath(term);
	    case "css selector":
	        return By.cssSelector(term);
	    case "id":
	        return By.id(term);
	    case "tag name":
	        return By.tagName(term);
	    case "name":
	        return By.name(term);
	    case "link text":
	        return By.linkText(term);
	    case "class name":
	        return By.className(term);
	    }
	    return (By) we;
	}
	

}
	
	
	


