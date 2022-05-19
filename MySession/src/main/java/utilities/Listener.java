package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestRunner;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import configs.Base;



public class Listener extends ExtentManager implements ITestListener {

	//Action action= new Action();
	
	public void onTestStart(ITestResult result) {
		parentTest = extent.createTest(result.getName());
		Log.startTestCase(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			parentTest.log(Status.PASS, "Pass Test case is: " + result.getName());
			Log.endTestCase(result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			parentTest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			parentTest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String imgPath = screenShot(Base.getDriver(), result.getName());
			parentTest.addScreenCaptureFromPath(imgPath);
			Log.failTestCase(result.getName());
			
			 //MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build();
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			parentTest.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("hh_mm").format(new Date());
		String date = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Reports\\"+date +"\\ScreenShots\\"+ filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		return destination;
	}
		
	}

