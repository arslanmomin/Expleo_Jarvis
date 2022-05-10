package commands;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import configs.Base;

public class FrameHandling extends Base {



	public void SwitchToFrameByIndex(WebDriver driver,int index) {
		try {
			driver.switchTo().frame(index);
			Base.childTest.pass("Focus moved to Frame with Index :" + index);
		} catch (Exception e) {
			Base.childTest.fail("Focus can not  move to Frame with Index" + index);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToFrameByName(WebDriver driver,String name) {
		try {
			driver.switchTo().frame(name);
			Base.childTest.pass("Focus moved to Frame with name" + name);
		} catch (Exception e) {
			Base.childTest.fail("Focus can not  move to Frame with name" + name);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToFrameById(WebDriver driver,String id) {
		try {
			driver.switchTo().frame(id);
			Base.childTest.pass("Focus moved to Frame with id" + id);
		} catch (Exception e) {
			Base.childTest.fail("Focus can not  move to Frame with id" + id);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToDefaultContent(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
			Base.childTest.pass("Focus moved to Default Content");
		} catch (Exception e) {
			Base.childTest.fail("Focus can not  move to Default Content");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}

	public void SwitchToParentFrame(WebDriver driver) {
		try {
			driver.switchTo().parentFrame();
			Base.childTest.pass("Focus moved to Parent Frame");
		} catch (Exception e) {
			Base.childTest.fail("Focus can not  move toParent Frame");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			Base.childTest.info(e);
			throw e;

		}
	}

	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		// goto url

	}

}
