package commands;

import org.openqa.selenium.WebDriver;

import configs.Base;

public class Browser extends Base {
	
	/**
	 * used to navigate to any application
	 * 
	 * @param URL- url of application
	 */
	public static void openurl(WebDriver driver,String URL) {

		try {
			driver.get(URL);
			Base.childTest.pass("successfully opened the " + URL);

		} catch (Exception e) {

			Base.childTest.fail("unable to open the " + URL);
		}
	}
	
	public static void back(WebDriver driver) {
		try {
			driver.navigate().back();
			Base.childTest.pass("browser navigated to previous page");

		} catch (Exception e) {

			Base.childTest.fail("unable to navigate to previous page");
		}
	}
	
	public static void forward(WebDriver driver) {
		try {
			driver.navigate().forward();
			Base.childTest.pass("browser navigated to next page");

		} catch (Exception e) {

			Base.childTest.fail("unable to navigate to next page");
		}
	}
	
	public static void navigate(WebDriver driver,String url) {
		try {
			driver.navigate().to(url);
			Base.childTest.pass("browser navigated to "+url);

		} catch (Exception e) {

			Base.childTest.fail("unable to navigate to url "+url);
		}
	}
	
	public static void matchurl(WebDriver driver,String expected) {
		try {
			String actual=driver.getCurrentUrl();
			Base.childTest.info(actual);
			if(actual.equals(expected))
				Base.childTest.pass("url  matched with expected");

		} catch (Exception e) {

			Base.childTest.fail("url not matched");
		}
	}
	//Close Browser
	public static void closeBrowser(WebDriver driver) {
		try {
			driver.close();
			Base.childTest.info("Window Closed");
			
		} catch (Exception e) {

			Base.childTest.fail(e);
		}
	}
	//Quit browser
	public static void quitBrowser(WebDriver driver) {
		try {
			driver.quit();
			Base.childTest.info("Browser Closed");
			
		} catch (Exception e) {

			Base.childTest.fail(e);
		}
	}
}
