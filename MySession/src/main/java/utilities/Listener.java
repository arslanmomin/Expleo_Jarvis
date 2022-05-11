package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import configs.Base;



public class Listener extends ExtentManager implements ITestListener {

	//Action action= new Action();
	
	public void onTestStart(ITestResult result) {
		//parentTest = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			parentTest.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			parentTest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			parentTest.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String imgPath = screenShot(Base.getDriver(), result.getName());

			parentTest.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
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


		
	}

