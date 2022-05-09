package commands;

import configs.Base;

public class Browser extends Base {
	
	/**
	 * used to navigate to any application
	 * 
	 * @param URL- url of application
	 */
	public static void openurl(String URL) {

		try {
			driver.get(URL);
			Base.childTest.pass("successfully opened the " + URL);

		} catch (Exception e) {

			Base.childTest.fail("unable to open the " + URL);
		}
	}
	
	public static void back() {
		try {
			driver.navigate().back();
			Base.childTest.pass("browser navigated to previous page");

		} catch (Exception e) {

			Base.childTest.fail("unable to navigate to previous page");
		}
	}
	
	public static void forward() {
		try {
			driver.navigate().forward();
			Base.childTest.pass("browser navigated to next page");

		} catch (Exception e) {

			Base.childTest.fail("unable to navigate to next page");
		}
	}
	
	public static void navigate(String url) {
		try {
			driver.navigate().to(url);
			Base.childTest.pass("browser navigated to "+url);

		} catch (Exception e) {

			Base.childTest.fail("unable to navigate to url "+url);
		}
	}
	
	public static void matchurl(String expected) {
		try {
			String actual=driver.getCurrentUrl();
			Base.childTest.info(actual);
			if(actual.equals(expected))
				Base.childTest.pass("url  matched with expected");

		} catch (Exception e) {

			Base.childTest.fail("url not matched");
		}
	}
}
