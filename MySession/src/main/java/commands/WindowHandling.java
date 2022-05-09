package commands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.MediaEntityBuilder;

import configs.BrowserSetup;

public class WindowHandling {
	public WebDriver driver;

	public WindowHandling() {
		driver = BrowserSetup.driver;
	}

	public void SwitchToChild() {
		try {
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> iterator = allWindowHandles.iterator();

			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					BrowserSetup.childTest.pass("Switched To Child Window");
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
				}
			}
		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not switch to child window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}

	public void SwitchBack() {
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
					BrowserSetup.childTest.pass("Switched To Main  Window");
				}
			}
			driver.switchTo().window(mainwindow);
		} catch (Exception e) {
			BrowserSetup.childTest.fail("Cannot Switch Back to Main Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}


	public void WindowHandle() {
		try {
			String wh = driver.getWindowHandle();
			BrowserSetup.childTest.pass("Window Handle :" + wh);

			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not handle Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}

	public void WindowHandles() {
		try {
			Set<String> wh = driver.getWindowHandles();
			BrowserSetup.childTest.pass("Window handles :"

					+ wh);

			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not handle Window ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}

	public void getSize() {
		try {
			Dimension winSize = driver.manage().window().getSize();
			BrowserSetup.childTest.pass("***Full Size Values for Current Window***\n");
			BrowserSetup.childTest.pass("Screen Width: " + winSize.getWidth() + "\n");
			BrowserSetup.childTest.pass("Screen Height: " + winSize.getHeight() + "\n");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not get Window Size");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}

	public void setSize(Dimension a) {
		try {
			driver.manage().window().setSize(a);
			BrowserSetup.childTest.pass("Size set");

			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not set Window Size ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}

	public void getPosition() {
		try {
			Point winPos = driver.manage().window().getPosition();
			BrowserSetup.childTest.pass("***Full Size Values for Current Window***\n");
			BrowserSetup.childTest.pass("X cordinate: " + winPos.getX() + "\n");
			BrowserSetup.childTest.pass("Y cordinate: " + winPos.getY() + "\n");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not get Window Position ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}

	public void setPosition(int x, int y) {
		try {
			Point winPos = driver.manage().window().getPosition();
			Point NewWinPos = winPos.moveBy(x, y);
			driver.manage().window().setPosition(NewWinPos);
			BrowserSetup.childTest.pass("Position set");

			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();

		} catch (Exception e) {
			BrowserSetup.childTest.fail("can not set Window Position ");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			BrowserSetup.childTest.info(e);
			throw e;

		}
	}

	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);


	}

}
