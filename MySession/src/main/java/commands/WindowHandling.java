package commands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.MediaEntityBuilder;

import configs.Base;

public class WindowHandling extends Base{

	public void SwitchToChild(WebDriver driver) {
		try {
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> iterator = allWindowHandles.iterator();

			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					Base.childTest.pass("Switched To Child Window");
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
				}
			}
		} catch (Exception e) {
			Base.childTest.fail("can not switch to child window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}

	public void SwitchBack(WebDriver driver) {
		try {
			String mainwindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String ChildWindow = i1.next();
				if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					driver.close();
					System.out.println("Child window closed");
					Base.childTest.pass("Switched To Main  Window");
				}
			}
			driver.switchTo().window(mainwindow);
		} catch (Exception e) {
			Base.childTest.fail("Cannot Switch Back to Main Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}


	public void WindowHandle(WebDriver driver) {
		try {
			String wh = driver.getWindowHandle();
			Base.childTest.pass("Window Handle :" + wh);

			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			Base.childTest.fail("can not handle Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}

	public void WindowHandles(WebDriver driver) {
		try {
			Set<String> wh = driver.getWindowHandles();
			Base.childTest.pass("Window handles :"

					+ wh);

			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			Base.childTest.fail("can not handle Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}


	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);


	}

}