package commands;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import configs.Base;
import utilities.ExtentManager;
import utilities.Log;

public class BrowserActions extends Base {

//opens Url
	public static void openUrl(WebDriver driver, String URL) {

		try {
			driver.get(URL);
			ExtentManager.childTest.pass("successfully opened the " + URL);
		} catch (Exception e) {
			ExtentManager.childTest.fail("unable to open the " + URL);
			Log.exception("unable to open url due to exception: ", e);
		}
	}

//returns current window url
	public static String getUrl(WebDriver driver) {
		String url = driver.getCurrentUrl();
		ExtentManager.childTest.info("fetched current url i.e., " + url);
		return url;
	}

//returns current window title
	public static String getWindowTitle(WebDriver driver) {

		String title = driver.getTitle();
		ExtentManager.childTest.info(" current window title is : " + title);
		return title;
	}

//navigates to last webpage
	public static void previousPage(WebDriver driver) {
		try {
			driver.navigate().back();
			ExtentManager.childTest.pass("browser navigated to previous page");
		} catch (Exception e) {
			ExtentManager.childTest.info("unable to navigate to previous page");
			Log.exception("unable to navigate to back due to exception: ", e);
		}
	}

//navigates to next webpage if available
	public static void nextPage(WebDriver driver) {
		try {
			driver.navigate().forward();
			ExtentManager.childTest.pass("browser navigated to next page");
		} catch (Exception e) {
			ExtentManager.childTest.info("unable to navigate to next page");
			Log.exception("unable to forward nextpage due to exception: ", e);
		}
	}

//opens new url in already opened browser
	public static void navigateToUrl(WebDriver driver, String url) {
		try {
			driver.navigate().to(url);
			ExtentManager.childTest.pass("browser navigated to " + url);
		} catch (Exception e) {
			ExtentManager.childTest.info("unable to navigate to url " + url);
			Log.exception("unable to navigate to url due to exception: ", e);
		}
	}

//refreshes current webpage
	public static void refreshPage(WebDriver driver) {
		try {
			driver.navigate().refresh();
			ExtentManager.childTest.pass("page refreshed");

		} catch (Exception e) {
			ExtentManager.childTest.info("not able to refresh webpage");
			Log.exception("unable to refreshPage due to exception: ", e);
		}
	}

//checks if current matches with expected and returns true if matches
	public static boolean matchUrl(WebDriver driver, String expected) {

		boolean flag = false;
		String actual = driver.getCurrentUrl();
		ExtentManager.childTest.info(actual);
		if (actual.equals(expected)) {
			ExtentManager.childTest.pass("url  matched with expected");
			flag = true;
		} else {
			ExtentManager.childTest.info("url not matched");
		}
		return flag;
	}

//closes browser
	public static void closeBrowser(WebDriver driver) {
		try {
			driver.close();
			ExtentManager.childTest.info("browser Closed");
		} catch (Exception e) {
			ExtentManager.childTest.info("not able to close browser");
		}
	}

// Quits browser
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		ExtentManager.childTest.info("Browser quit done");

	}

//adds cookie to browser site
	public static void addCookie(Cookie cookie) {
		getDriver().manage().addCookie(cookie);
		ExtentManager.childTest.info("cookie add is "+ cookie.getName() +"value "+cookie.getValue());
	}
	
//delete specific cookie from browser	
	public static void deleteCookie(String cookiename) {
		getDriver().manage().deleteCookieNamed(cookiename);
		ExtentManager.childTest.info("cookie deleted is "+ cookiename );
	}
	
//static method to wait till specified time when loading page
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}

}
