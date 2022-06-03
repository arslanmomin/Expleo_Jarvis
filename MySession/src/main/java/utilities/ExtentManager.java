package utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import configs.Base;

public class ExtentManager extends Base {
	
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	static ExtentSparkReporter sparkReporter;
	
	public static void generateReport() {

		String dateName = new SimpleDateFormat("yyyy_MM_dd hh_mm_ss").format(new Date());
		String date = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\"+date +"\\ExtentReports\\" + dateName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Name", "Jarvis");
		
	}
	public static void endReport() {
		extent.flush();
}
}
