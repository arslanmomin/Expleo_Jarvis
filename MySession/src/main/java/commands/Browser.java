package commands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import configs.Base;
import utilities.ExtentManager;

public class Browser extends Base {

	/**
	 * used to navigate to any application
	 * 
	 * @param URL- url of application
	 */
	public static void openurl(WebDriver driver, String URL) {

		try {
			driver.get(URL);
			ExtentManager.childTest.pass("successfully opened the " + URL);

		} catch (Exception e) {

			ExtentManager.childTest.fail("unable to open the " + URL);
		}
	}

	public static String getUrl(WebDriver driver) {

		String url = driver.getCurrentUrl();
		ExtentManager.childTest.pass("fetched current url i.e.,"+url);
		return url;
	}

	public static String getWindowTitle(WebDriver driver) {

		String title = driver.getTitle();
		ExtentManager.childTest.pass(" current window title i.e.,"+title);
		return title;
	}

	public static void back(WebDriver driver) {
		try {
			driver.navigate().back();
			ExtentManager.childTest.pass("browser navigated to previous page");

		} catch (Exception e) {

			ExtentManager.childTest.fail("unable to navigate to previous page");
		}
	}

	public static void forward(WebDriver driver) {
		try {
			driver.navigate().forward();
			ExtentManager.childTest.pass("browser navigated to next page");

		} catch (Exception e) {

			ExtentManager.childTest.fail("unable to navigate to next page");
		}
	}

	public static void navigate(WebDriver driver, String url) {
		try {
			driver.navigate().to(url);
			ExtentManager.childTest.pass("browser navigated to " + url);

		} catch (Exception e) {

			ExtentManager.childTest.fail("unable to navigate to url " + url);
		}
	}

	public static void refreshPage(WebDriver driver) {
		try {
			driver.navigate().refresh();
			ExtentManager.childTest.pass("page refreshed");

		} catch (Exception e) {

			ExtentManager.childTest.fail("not able to refresh webpage");
		}
	}

	public static void matchurl(WebDriver driver, String expected) {
		try {
			String actual = driver.getCurrentUrl();
			ExtentManager.childTest.info(actual);
			if (actual.equals(expected))
				ExtentManager.childTest.pass("url  matched with expected");

		} catch (Exception e) {

			ExtentManager.childTest.fail("url not matched");
		}
	}

	public static void closeBrowser(WebDriver driver) {
		try {
			driver.close();
			ExtentManager.childTest.info("Window Closed");

		} catch (Exception e) {

			ExtentManager.childTest.fail(e);
		}
	}

	// Quit browser
	public static void quitBrowser(WebDriver driver) {
		try {
			driver.quit();
			ExtentManager.childTest.info("Browser quit done");

		} catch (Exception e) {

			ExtentManager.childTest.fail(e);
		}
	}

	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}

}
