package commands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import configs.Base;
import utilities.ExtentManager;

public class WindowActions extends Base {

	public void SwitchToChild(WebDriver driver) {
		try {
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> iterator = allWindowHandles.iterator();

			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					ExtentManager.childTest.pass("Switched To Child Window");

				}
			}
		} catch (Exception e) {
			ExtentManager.childTest.fail("can not switch to child window ");

			ExtentManager.childTest.info(e);
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
					ExtentManager.childTest.pass("Switched To Main  Window");
				}
			}
			driver.switchTo().window(mainwindow);
		} catch (Exception e) {
			ExtentManager.childTest.fail("Cannot Switch Back to Main Window ");

			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void WindowHandle(WebDriver driver) {
		try {
			String wh = driver.getWindowHandle();
			ExtentManager.childTest.pass("Window Handle :" + wh);

		} catch (Exception e) {
			ExtentManager.childTest.fail("can not handle Window ");

			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void WindowHandles(WebDriver driver) {
		try {
			Set<String> wh = driver.getWindowHandles();
			ExtentManager.childTest.pass("Window handles :"

					+ wh);

		} catch (Exception e) {
			ExtentManager.childTest.fail("can not handle Window ");

			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToFrameByIndex(WebDriver driver, int index) {
		try {
			driver.switchTo().frame(index);
			ExtentManager.childTest.pass("Focus moved to Frame with Index :" + index);
		} catch (Exception e) {
			ExtentManager.childTest.fail("Focus can not  move to Frame with Index" + index);

			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToFrameByName(WebDriver driver, String name) {
		try {
			driver.switchTo().frame(name);
			ExtentManager.childTest.pass("Focus moved to Frame with name" + name);
		} catch (Exception e) {
			ExtentManager.childTest.fail("Focus can not  move to Frame with name" + name);

			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToFrameById(WebDriver driver, String id) {
		try {
			driver.switchTo().frame(id);
			ExtentManager.childTest.pass("Focus moved to Frame with id" + id);
		} catch (Exception e) {
			ExtentManager.childTest.fail("Focus can not  move to Frame with id" + id);

			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToDefaultContent(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
			ExtentManager.childTest.pass("Focus moved to Default Content");
		} catch (Exception e) {
			ExtentManager.childTest.fail("Focus can not  move to Default Content");
			ExtentManager.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToParentFrame(WebDriver driver) {
		try {
			driver.switchTo().parentFrame();
			ExtentManager.childTest.pass("Focus moved to Parent Frame");
		} catch (Exception e) {
			ExtentManager.childTest.fail("Focus can not  move toParent Frame");
			ExtentManager.childTest.info(e);
			throw e;

		}
	}

}
