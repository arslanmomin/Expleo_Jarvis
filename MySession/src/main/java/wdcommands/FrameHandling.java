package wdcommands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import configs.StartBrowser;

public class FrameHandling {

	public WebDriver driver;

	public FrameHandling() {
		driver = StartBrowser.driver;
	}
	
	public void SwitchToFrameByIndex(int index)  {
		try {
			driver.switchTo().frame(index);
			StartBrowser.childTest.pass("Focus moved to Frame with Index"+index);
		} 
	                catch (Exception e) {
			StartBrowser.childTest.fail("Focus can not  move to Frame with Index"+index);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void SwitchToFrameByName(String name)  {
		try {
			driver.switchTo().frame(name);
			StartBrowser.childTest.pass("Focus moved to Frame with name"+name);
		} 
	                catch (Exception e) {
			StartBrowser.childTest.fail("Focus can not  move to Frame with name"+name);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void SwitchToFrameById(String id)  {
		try {
			driver.switchTo().frame(id);
			StartBrowser.childTest.pass("Focus moved to Frame with id"+id);
		} 
	                catch (Exception e) {
			StartBrowser.childTest.fail("Focus can not  move to Frame with id"+id);
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	public void SwitchToDefaultContent()  {
		try {
			driver.switchTo().defaultContent();
			StartBrowser.childTest.pass("Focus moved to Default Content");
		} 
	                catch (Exception e) {
			StartBrowser.childTest.fail("Focus can not  move to Default Content");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	public void SwitchToParentFrame()  {
		try {
			driver.switchTo().parentFrame();
			StartBrowser.childTest.pass("Focus moved to Parent Frame");
		} 
	                catch (Exception e) {
			StartBrowser.childTest.fail("Focus can not  move toParent Frame");
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build();
			StartBrowser.childTest.info(e);
			throw e;
			
		}
	}
	
	
	
	
	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
        //goto url
 
		
	}

}
