package wdcommands;

import org.openqa.selenium.WebDriver;

import configs.StartBrowser;

public class Browser {
	public WebDriver driver;

	public Browser() {
		driver = StartBrowser.driver;
	}

	/**
	 * used to navigate to any application
	 * 
	 * @param URL- url of application
	 */
	public void openurl(String URL) {

		try {
			driver.get(URL);
			StartBrowser.childTest.pass("successfully opened the " + URL);

		} catch (Exception e) {

			StartBrowser.childTest.fail("unable to open the " + URL);
		}
	}
	
	public void back() {
		try {
			driver.navigate().back();
			StartBrowser.childTest.pass("browser navigated to previous page");

		} catch (Exception e) {

			StartBrowser.childTest.fail("unable to navigate to previous page");
		}
	}
	
	public void forward() {
		try {
			driver.navigate().forward();
			StartBrowser.childTest.pass("browser navigated to next page");

		} catch (Exception e) {

			StartBrowser.childTest.fail("unable to navigate to next page");
		}
	}
	
	public void navigate(String url) {
		try {
			driver.navigate().to(url);
			StartBrowser.childTest.pass("browser navigated to "+url);

		} catch (Exception e) {

			StartBrowser.childTest.fail("unable to navigate to url "+url);
		}
	}
	
	public void matchurl(String expected) {
		try {
			String actual=driver.getCurrentUrl();
			StartBrowser.childTest.info(actual);
			if(actual.equals(expected))
				StartBrowser.childTest.pass("url  matched with expected");

		} catch (Exception e) {

			StartBrowser.childTest.fail("url not matched");
		}
	}
}
