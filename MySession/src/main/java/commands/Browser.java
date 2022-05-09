package commands;

import org.openqa.selenium.WebDriver;

import configs.BrowserSetup;

public class Browser {
	public WebDriver driver;

	public Browser(WebDriver driver) {
		this.driver = BrowserSetup.driver;
	}

	/**
	 * used to navigate to any application
	 * 
	 * @param URL- url of application
	 */
	public void openurl(String URL) {

		try {
			driver.get(URL);
			BrowserSetup.childTest.pass("successfully opened the " + URL);

		} catch (Exception e) {

			BrowserSetup.childTest.fail("unable to open the " + URL);
		}
	}
	
	public void back() {
		try {
			driver.navigate().back();
			BrowserSetup.childTest.pass("browser navigated to previous page");

		} catch (Exception e) {

			BrowserSetup.childTest.fail("unable to navigate to previous page");
		}
	}
	
	public void forward() {
		try {
			driver.navigate().forward();
			BrowserSetup.childTest.pass("browser navigated to next page");

		} catch (Exception e) {

			BrowserSetup.childTest.fail("unable to navigate to next page");
		}
	}
	
	public void navigate(String url) {
		try {
			driver.navigate().to(url);
			BrowserSetup.childTest.pass("browser navigated to "+url);

		} catch (Exception e) {

			BrowserSetup.childTest.fail("unable to navigate to url "+url);
		}
	}
	
	public void matchurl(String expected) {
		try {
			String actual=driver.getCurrentUrl();
			BrowserSetup.childTest.info(actual);
			if(actual.equals(expected))
				BrowserSetup.childTest.pass("url  matched with expected");

		} catch (Exception e) {

			BrowserSetup.childTest.fail("url not matched");
		}
	}
}
